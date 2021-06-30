package com.pmt.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmt.dao.ProductionOrderSelectDao;
import com.pmt.dao.SystemControlSelectDao;
import com.pmt.model.ProductionOrderModel;
import com.pmt.util.Common;
import com.pmt.util.OrderProductionStatus;

@Controller
@RequestMapping("/ProductionDisplay")
public class ProductionDisplayController { 
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isPin(request)){
			
			ProductionOrderModel production = new ProductionOrderModel();
			production.setDeleteFg("0");
			production.setStatus(OrderProductionStatus.NEW);
			mv.addObject("pageCurrent", "1");
			SystemControlSelectDao selectSystemControl = new  SystemControlSelectDao("INTERVAL_CD");
			try {
				String interval = selectSystemControl.excute();
				mv.addObject("interval", interval);

				selectSystemControl = new  SystemControlSelectDao("LOAD_CD");
				String load = selectSystemControl.excute();
				mv.addObject("load", load);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			try {
				selectSystemControl.excute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			ProductionOrderSelectDao selectProduction = new ProductionOrderSelectDao(production);
			try {
				List<ProductionOrderModel> lstProduction = selectProduction.excute();
				if(lstProduction.size()==0)
				{
					mv.addObject(Common.MESSAGE_NOTIFICATION, "KHÔNG TÌM THẤY ĐƠN HÀNG NÀO");
				}
				else
				{
					for(int i =0;i<lstProduction.size();i++)
					{
						if(lstProduction.get(i).getStatus().trim().equals(OrderProductionStatus.NEW))
						{
							String currentDate = Common.getDateCurrent("yyyyMMdd");
							try {
								String CompareValue = Common.ConvertStringToDateStr(lstProduction.get(i).getReleaseScheDt(), "dd/mm/yyyy", "yyyymmdd");
//								
									if(Integer.parseInt(currentDate)>Integer.parseInt(CompareValue))
									{
										lstProduction.get(i).setStatus(OrderProductionStatus.BAD_RELESED);
									}
									if(Integer.parseInt(currentDate)==Integer.parseInt(CompareValue))
									{
										lstProduction.get(i).setStatus(OrderProductionStatus.REALESE_COMMING);
									}
									//
									//compareResult == Common.DAY1_BIGGER_DAY2 is OK	
								
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								mv.addObject(Common.MESSAGE_ERROR, "MỘT LỖI HỆ THỐNG ĐÃ XẢY RA");
							}
							
						}
					}
					
					
					
					
					List<ProductionOrderModel> lstDisplay = new ArrayList<ProductionOrderModel>();
					for(int i =0;i<lstProduction.size();i++)
					{
						String status = lstProduction.get(i).getStatus();
						if(status.equals(OrderProductionStatus.NEW)
								||status.equals(OrderProductionStatus.BAD_RELESED)
								||status.equals(OrderProductionStatus.REALESE_COMMING))
						{
							lstDisplay.add(lstProduction.get(i));
						}
					}
					if(lstDisplay.size()==0)
					{
						mv.addObject(Common.MESSAGE_NOTIFICATION, "KHÔNG TÌM THẤY ĐƠN HÀNG NÀO");
					}
					else
					{
						mv.addObject(Common.MESSAGE_NOTIFICATION, "HIỆN TẠI CÓ " +lstDisplay.size()+" ĐƠN HÀNG");
					}

					mv.addObject("lst", lstDisplay);
					mv.addObject("countcurrent", lstDisplay.size());

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mv.addObject(Common.MESSAGE_ERROR, "MỘT LỖI HỆ THỐNG ĐÃ XẢY RA");
			}
			mv.setViewName("views/ProductionDisplay.jsp");
		}
		else{
			mv.setViewName("redirect:/Clock");
		}
		
		return mv;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView post(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isPin(request)){
			
			ProductionOrderModel production = new ProductionOrderModel();
			production.setDeleteFg("0");
			production.setStatus(OrderProductionStatus.NEW);
			String pageCurrent = request.getParameter("pageCurrent");
			mv.addObject("pageCurrent", pageCurrent);
			
			SystemControlSelectDao selectSystemControl = new  SystemControlSelectDao("INTERVAL_CD");
			try {
				String interval = selectSystemControl.excute();
				mv.addObject("interval", interval);
	
				selectSystemControl = new  SystemControlSelectDao("LOAD_CD");
				String load = selectSystemControl.excute();
				mv.addObject("load", load);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			try {
				selectSystemControl.excute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			ProductionOrderSelectDao selectProduction = new ProductionOrderSelectDao(production);
			try {
				List<ProductionOrderModel> lstProduction = selectProduction.excute();
				if(lstProduction.size()==0)
				{
					mv.addObject(Common.MESSAGE_NOTIFICATION, "KHÔNG TÌM THẤY ĐƠN HÀNG NÀO");
				}
				else
				{
					for(int i =0;i<lstProduction.size();i++)
					{
						if(lstProduction.get(i).getStatus().trim().equals(OrderProductionStatus.NEW))
						{
							String currentDate = Common.getDateCurrent("yyyyMMdd");
							try {
								String CompareValue = Common.ConvertStringToDateStr(lstProduction.get(i).getReleaseScheDt(), "dd/mm/yyyy", "yyyymmdd");
	//							
									if(Integer.parseInt(currentDate)>Integer.parseInt(CompareValue))
									{
										lstProduction.get(i).setStatus(OrderProductionStatus.BAD_RELESED);
									}
									if(Integer.parseInt(currentDate)==Integer.parseInt(CompareValue))
									{
										lstProduction.get(i).setStatus(OrderProductionStatus.REALESE_COMMING);
									}
									//
									//compareResult == Common.DAY1_BIGGER_DAY2 is OK	
								
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								mv.addObject(Common.MESSAGE_ERROR, "MỘT LỖI HỆ THỐNG ĐÃ XẢY RA");
							}
							
						}
					}
					
					
					
					
					List<ProductionOrderModel> lstDisplay = new ArrayList<ProductionOrderModel>();
					for(int i =0;i<lstProduction.size();i++)
					{
						String status = lstProduction.get(i).getStatus();
						if(status.equals(OrderProductionStatus.NEW)
								||status.equals(OrderProductionStatus.BAD_RELESED)
								||status.equals(OrderProductionStatus.REALESE_COMMING))
						{
							lstDisplay.add(lstProduction.get(i));
						}
					}
					if(lstDisplay.size()==0)
					{
						mv.addObject(Common.MESSAGE_NOTIFICATION, "KHÔNG TÌM THẤY ĐƠN HÀNG NÀO");
					}
					else
					{
						mv.addObject(Common.MESSAGE_NOTIFICATION, "HIỆN TẠI CÓ " +lstDisplay.size()+" ĐƠN HÀNG");
					}
	
					mv.addObject("lst", lstDisplay);
					mv.addObject("countcurrent", lstDisplay.size());
	
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mv.addObject(Common.MESSAGE_ERROR, "MỘT LỖI HỆ THỐNG ĐÃ XẢY RA");
			}
			mv.setViewName("views/ProductionDisplay.jsp");
		}
		else{
			mv.setViewName("redirect:/Clock");
		}
		
		return mv;
	}
	
	

}
