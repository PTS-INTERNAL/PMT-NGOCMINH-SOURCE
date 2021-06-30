package com.pmt.controller;

import java.sql.SQLException;
import java.util.List;

import com.pmt.dao.SyncProductionOrderInsertDao;
import com.pmt.dao.LocalProductionOrderUpdatetModeDao;
import com.pmt.dao.ServerProductionOrderSelectDao;
import com.pmt.dao.ServerSystemControlUpdatetDao;
import com.pmt.dao.SyncProductionOrderSelectDao;
import com.pmt.dao.SyncProductionOrderUpdatetDao;
import com.pmt.dao.SystemControlAllSelectDao;
import com.pmt.model.ProductionOrderModel;
import com.pmt.model.SystemControlModel;
import com.pmt.util.Common;

public class SyncProductionLocalToServer {
	
	public SyncProductionLocalToServer()
	{
		
	}
	
	public void GetDataSync()
	{
		SyncProductionOrderSelectDao selectSysn = new SyncProductionOrderSelectDao();
		try {
			List<ProductionOrderModel> lstSys = selectSysn.excute();
			if(lstSys.size()>0)
			{
				for(int i=0;i<lstSys.size();i++)
				{
					ProductionOrderModel proTemp = new ProductionOrderModel();
					proTemp.setOrderCd(lstSys.get(i).getOrderCd());
					ServerProductionOrderSelectDao serverSelect = new ServerProductionOrderSelectDao(proTemp);
					List<ProductionOrderModel> lstPro =  serverSelect.excute();
					if(lstPro.size()==0)
					{
						SyncProductionOrderInsertDao SyncServer= new SyncProductionOrderInsertDao(lstSys.get(i));
						SyncServer.excute();
					}
					else
					{
						SyncProductionOrderUpdatetDao SyncServer = new SyncProductionOrderUpdatetDao(lstSys.get(i));
						SyncServer.excute();
					}
					
					LocalProductionOrderUpdatetModeDao updateMode = new LocalProductionOrderUpdatetModeDao(lstSys.get(i));
					updateMode.excute();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SystemControlAllSelectDao allselect = new SystemControlAllSelectDao("");
		try {
			List<SystemControlModel> lst = allselect.excute();
			if(lst.size()>0)
			{
				for(int i=0;i<lst.size();i++)
				{
					ServerSystemControlUpdatetDao update =new ServerSystemControlUpdatetDao(lst.get(i).getPrammeter_tx(), lst.get(i).getParam_value());
					update.excute();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Common.SetIsUpdate();
	}

}
