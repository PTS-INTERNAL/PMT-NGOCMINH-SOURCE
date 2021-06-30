package com.pmt.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pmt.dao.ProductionOrderSelectDao;
import com.pmt.dao.SystemControlSelectDao;
import com.pmt.model.ProductionOrderModel;
import com.pmt.util.Common;
import com.pmt.util.OrderProductionStatus;

@Controller
public class AjaxController {
	
	@RequestMapping("/getCount")
	public @ResponseBody String getCountDisplay()
	{
		SystemControlSelectDao selectSystem = new SystemControlSelectDao("IS_UPDATE");
		
		try {
			String isValue = selectSystem.excute();
			
			if(isValue.trim().length()>0)
			{
				if(isValue.trim().equals("1"))
				{
					Common.SetIsNotUpdate();
				}
				return isValue.trim();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "0";
	}

}
