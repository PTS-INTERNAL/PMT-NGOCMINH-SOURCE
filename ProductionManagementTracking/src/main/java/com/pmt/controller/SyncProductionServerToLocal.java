package com.pmt.controller;

import java.sql.SQLException;
import java.util.List;

import com.pmt.dao.SyncProductionOrderInsertDao;
import com.pmt.dao.LocalProductionOrderUpdatetModeDao;
import com.pmt.dao.ProductionOrderSelectDao;
import com.pmt.dao.ServerProductionOrderSelectDao;
import com.pmt.dao.ServerProductionOrderUpdatetModeDao;
import com.pmt.dao.ServerSyncProductionOrderInsertDao;
import com.pmt.dao.ServerSyncProductionOrderSelectDao;
import com.pmt.dao.ServerSyncProductionOrderUpdatetDao;
import com.pmt.dao.ServerSystemControlAllSelectDao;
import com.pmt.dao.ServerSystemControlUpdatetDao;
import com.pmt.dao.SyncProductionOrderSelectDao;
import com.pmt.dao.SyncProductionOrderUpdatetDao;
import com.pmt.dao.SystemControlAllSelectDao;
import com.pmt.dao.SystemControlUpdatetDao;
import com.pmt.model.ProductionOrderModel;
import com.pmt.model.SystemControlModel;
import com.pmt.util.Common;

public class SyncProductionServerToLocal {
	
	public SyncProductionServerToLocal()
	{
		
	}
	
	public void GetDataSync()
	{
		ServerSyncProductionOrderSelectDao selectSysn = new ServerSyncProductionOrderSelectDao();
		try {
			List<ProductionOrderModel> lstSys = selectSysn.excute();
			if(lstSys.size()>0)
			{
				for(int i=0;i<lstSys.size();i++)
				{
					ProductionOrderModel proTemp = new ProductionOrderModel();
					proTemp.setOrderCd(lstSys.get(i).getOrderCd());
					ProductionOrderSelectDao serverSelect = new ProductionOrderSelectDao(proTemp);
					List<ProductionOrderModel> lstPro =  serverSelect.excute();
					if(lstPro.size()==0)
					{
						ServerSyncProductionOrderInsertDao SyncServer= new ServerSyncProductionOrderInsertDao(lstSys.get(i));
						SyncServer.excute();
					}
					else
					{
						ServerSyncProductionOrderUpdatetDao SyncServer = new ServerSyncProductionOrderUpdatetDao(lstSys.get(i));
						SyncServer.excute();
					}
					
					ServerProductionOrderUpdatetModeDao updateMode = new ServerProductionOrderUpdatetModeDao(lstSys.get(i));
					updateMode.excute();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServerSystemControlAllSelectDao allselect = new ServerSystemControlAllSelectDao("");
		try {
			List<SystemControlModel> lst = allselect.excute();
			if(lst.size()>0)
			{
				for(int i=0;i<lst.size();i++)
				{
					SystemControlUpdatetDao update =new SystemControlUpdatetDao(lst.get(i).getPrammeter_tx(), lst.get(i).getParam_value());
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
