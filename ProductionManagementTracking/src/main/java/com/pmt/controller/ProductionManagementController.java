package com.pmt.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmt.dao.ProductionOrderSelectDao;
import com.pmt.model.ProductionOrderModel;
import com.pmt.util.Common;
import com.pmt.util.ExcelAssetGeneralListReportView;
import com.pmt.util.OrderProductionStatus;
import com.pmt.util.SessionConstant;

@Controller
@RequestMapping("/ProductionManagement")
public class ProductionManagementController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isLogin(request)){
			
			ProductionOrderModel production = new ProductionOrderModel();
			production.setDeleteFg("0");
			
			ProductionOrderSelectDao selectProduction = new ProductionOrderSelectDao(production);
			try {
				List<ProductionOrderModel> lstProduction = selectProduction.excute();
				if(lstProduction.size()==0)
				{
					mv.addObject(Common.MESSAGE_NOTIFICATION, "KHÔNG TÌM THẤY ĐƠN HÀNG NÀO");
				}
				else
				{
					mv.addObject("status", "-1");
					mv.addObject(Common.MESSAGE_NOTIFICATION, "TÌM THẤY " +lstProduction.size()+" ĐƠN HÀNG");
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
						else
						{
							if(lstProduction.get(i).getStatus().trim().equals(OrderProductionStatus.RELEASE))
							{
								String CompareSche = null;
								try {
									CompareSche = Common.ConvertStringToDateStr(lstProduction.get(i).getReleaseScheDt(), "dd/mm/yyyy", "yyyymmdd");
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								String CompareReal = null;
								try {
									CompareReal = Common.ConvertStringToDateStr(lstProduction.get(i).getReleaseRelDt(), "dd/mm/yyyy", "yyyymmdd");
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

								
								if(Integer.parseInt(CompareReal) > Integer.parseInt(CompareSche))
								{
									lstProduction.get(i).setStatus(OrderProductionStatus.RELEASED_AFTER_TIME);
								}
								else
								{
									lstProduction.get(i).setStatus(OrderProductionStatus.RELEASED_ON_TIME);
								}
							}
						}
					}
					
					
					
					mv.addObject("lst", lstProduction);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mv.addObject(Common.MESSAGE_ERROR, "MỘT LỖI HỆ THỐNG ĐÃ XẢY RA");
			}
			
			mv.addObject("role", Common.getSessionValue(request, SessionConstant.ROLE));
			mv.setViewName("views/ProductionManagement.jsp");
		}
		else{
			mv.setViewName("redirect:/login");
		}
		
		return mv;
	}
	
	@RequestMapping(params="sync" ,method=RequestMethod.POST)
	public ModelAndView syncsearchAction(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isLogin(request)){
			
			SyncProductionLocalToServer sync = new SyncProductionLocalToServer();
			sync.GetDataSync();
			
			SyncProductionServerToLocal sysnServer = new SyncProductionServerToLocal();
			sysnServer.GetDataSync();
	
			String customer = request.getParameter("customer");
			String productions = request.getParameter("production");
			String hdpo = request.getParameter("hdpo");
			String psx = request.getParameter("psx");
			String recieveStart = request.getParameter("recieveStart");
			String recieveEnd = request.getParameter("recieveEnd");
			String realseKHStart = request.getParameter("realseKHStart");
			String realseKHEnd = request.getParameter("realseKHEnd");
			String status = request.getParameter("status");
			
		
			mv.addObject("customer", customer);
			mv.addObject("production", productions);
			mv.addObject("hdpo", hdpo);
			mv.addObject("psx", psx);
			mv.addObject("recieveStart", recieveStart);
			mv.addObject("recieveEnd", recieveEnd);
			mv.addObject("realseKHStart", realseKHStart);
			mv.addObject("realseKHEnd", realseKHEnd);
			mv.addObject("status", status);
			
			String message="";
			
			if(Common.isNotEmpty(recieveStart))
			{
				if(Common.isDateView(recieveStart,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày nhận bắt đầu theo định dạng DD/MM/YYYY<br>";
				}
			}
			if(Common.isNotEmpty(recieveEnd))
			{
				if(Common.isDateView(recieveEnd,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày nhận kết thúc theo định dạng DD/MM/YYYY<br>";
				}
			}
			if(Common.isNotEmpty(realseKHStart))
			{
				if(Common.isDateView(realseKHStart,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày giao bắt đầu theo định dạng DD/MM/YYYY<br>";
				}
			}
			if(Common.isNotEmpty(realseKHEnd))
			{
				if(Common.isDateView(realseKHEnd,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày giao kết thúc theo định dạng DD/MM/YYYY<br>";
				}
			}
			
			if(Common.isEmpty(message))
			{
				ProductionOrderModel production = new ProductionOrderModel();
				production.setCustomerName(customer);
				production.setProduction(productions);
				production.setHD_PO(hdpo);
				production.setPSX(psx);
				production.setRecieveDt(recieveStart);
				production.setRecieveDtEnd(recieveEnd);
				production.setReleaseScheDt(realseKHStart);
				production.setReleaseScheDtEnd(realseKHEnd);
				if("-1".equals(status)==false)
				{
					production.setStatus(status);
				}
				production.setDeleteFg("0");
				
				ProductionOrderSelectDao selectProduction = new ProductionOrderSelectDao(production);
				try {
					List<ProductionOrderModel> lstProduction = selectProduction.excute();
					if(lstProduction.size()==0)
					{
						mv.addObject(Common.MESSAGE_NOTIFICATION, "KHÔNG TÌM THẤY ĐƠN HÀNG NÀO");
					}
					else
					{
						mv.addObject(Common.MESSAGE_NOTIFICATION, "TÌM THẤY " +lstProduction.size()+" ĐƠN HÀNG");
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
							else
							{
								if(lstProduction.get(i).getStatus().trim().equals(OrderProductionStatus.RELEASE))
								{
									String CompareSche = null;
									try {
										CompareSche = Common.ConvertStringToDateStr(lstProduction.get(i).getReleaseScheDt(), "dd/mm/yyyy", "yyyymmdd");
									} catch (ParseException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									String CompareReal = null;
									try {
										CompareReal = Common.ConvertStringToDateStr(lstProduction.get(i).getReleaseRelDt(), "dd/mm/yyyy", "yyyymmdd");
									} catch (ParseException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

									
									if(Integer.parseInt(CompareReal) > Integer.parseInt(CompareSche))
									{
										lstProduction.get(i).setStatus(OrderProductionStatus.RELEASED_AFTER_TIME);
									}
									else
									{
										lstProduction.get(i).setStatus(OrderProductionStatus.RELEASED_ON_TIME);
									}
								}
							}
						}
						
						
						
						mv.addObject("lst", lstProduction);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					mv.addObject(Common.MESSAGE_ERROR, "MỘT LỖI HỆ THỐNG ĐÃ XẢY RA");
				}
			}
			else
			{
				mv.addObject(Common.MESSAGE_ERROR, message);

			}
			mv.addObject("role", Common.getSessionValue(request, SessionConstant.ROLE));
			mv.setViewName("views/ProductionManagement.jsp");
		}
		else{
			mv.setViewName("redirect:/login");
		}
		
		return mv;
	}
	
	@RequestMapping(params="search" ,method=RequestMethod.POST)
	public ModelAndView searchAction(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isLogin(request)){
			
			
			String customer = request.getParameter("customer");
			String productions = request.getParameter("production");
			String hdpo = request.getParameter("hdpo");
			String psx = request.getParameter("psx");
			String recieveStart = request.getParameter("recieveStart");
			String recieveEnd = request.getParameter("recieveEnd");
			String realseKHStart = request.getParameter("realseKHStart");
			String realseKHEnd = request.getParameter("realseKHEnd");
			String status = request.getParameter("status");
			
		
			mv.addObject("customer", customer);
			mv.addObject("production", productions);
			mv.addObject("hdpo", hdpo);
			mv.addObject("psx", psx);
			mv.addObject("recieveStart", recieveStart);
			mv.addObject("recieveEnd", recieveEnd);
			mv.addObject("realseKHStart", realseKHStart);
			mv.addObject("realseKHEnd", realseKHEnd);
			mv.addObject("status", status);
			
			String message="";
			
			if(Common.isNotEmpty(recieveStart))
			{
				if(Common.isDateView(recieveStart,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày nhận bắt đầu theo định dạng DD/MM/YYYY<br>";
				}
			}
			if(Common.isNotEmpty(recieveEnd))
			{
				if(Common.isDateView(recieveEnd,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày nhận kết thúc theo định dạng DD/MM/YYYY<br>";
				}
			}
			if(Common.isNotEmpty(realseKHStart))
			{
				if(Common.isDateView(realseKHStart,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày giao bắt đầu theo định dạng DD/MM/YYYY<br>";
				}
			}
			if(Common.isNotEmpty(realseKHEnd))
			{
				if(Common.isDateView(realseKHEnd,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày giao kết thúc theo định dạng DD/MM/YYYY<br>";
				}
			}
			
			if(Common.isEmpty(message))
			{
				ProductionOrderModel production = new ProductionOrderModel();
				production.setCustomerName(customer);
				production.setProduction(productions);
				production.setHD_PO(hdpo);
				production.setPSX(psx);
				production.setRecieveDt(recieveStart);
				production.setRecieveDtEnd(recieveEnd);
				production.setReleaseScheDt(realseKHStart);
				production.setReleaseScheDtEnd(realseKHEnd);
				if("-1".equals(status)==false)
				{
					production.setStatus(status);
				}
				production.setDeleteFg("0");
				
				ProductionOrderSelectDao selectProduction = new ProductionOrderSelectDao(production);
				try {
					List<ProductionOrderModel> lstProduction = selectProduction.excute();
					if(lstProduction.size()==0)
					{
						mv.addObject(Common.MESSAGE_NOTIFICATION, "KHÔNG TÌM THẤY ĐƠN HÀNG NÀO");
					}
					else
					{
						mv.addObject(Common.MESSAGE_NOTIFICATION, "TÌM THẤY " +lstProduction.size()+" ĐƠN HÀNG");
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
							else
							{
								if(lstProduction.get(i).getStatus().trim().equals(OrderProductionStatus.RELEASE))
								{
									String CompareSche = null;
									try {
										CompareSche = Common.ConvertStringToDateStr(lstProduction.get(i).getReleaseScheDt(), "dd/mm/yyyy", "yyyymmdd");
									} catch (ParseException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									String CompareReal = null;
									try {
										CompareReal = Common.ConvertStringToDateStr(lstProduction.get(i).getReleaseRelDt(), "dd/mm/yyyy", "yyyymmdd");
									} catch (ParseException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

									
									if(Integer.parseInt(CompareReal) > Integer.parseInt(CompareSche))
									{
										lstProduction.get(i).setStatus(OrderProductionStatus.RELEASED_AFTER_TIME);
									}
									else
									{
										lstProduction.get(i).setStatus(OrderProductionStatus.RELEASED_ON_TIME);
									}
								}
							}
						}
						
						
						
						mv.addObject("lst", lstProduction);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					mv.addObject(Common.MESSAGE_ERROR, "MỘT LỖI HỆ THỐNG ĐÃ XẢY RA");
				}
			}
			else
			{
				mv.addObject(Common.MESSAGE_ERROR, message);

			}
			mv.addObject("role", Common.getSessionValue(request, SessionConstant.ROLE));
			mv.setViewName("views/ProductionManagement.jsp");
		}
		else{
			mv.setViewName("redirect:/login");
		}
		
		return mv;
	}
	
	
	@RequestMapping(params="excel" ,method=RequestMethod.POST)
	public ModelAndView excelAction(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isLogin(request)){
			
			
			String customer = request.getParameter("customer");
			String productions = request.getParameter("production");
			String hdpo = request.getParameter("hdpo");
			String psx = request.getParameter("psx");
			String recieveStart = request.getParameter("recieveStart");
			String recieveEnd = request.getParameter("recieveEnd");
			String realseKHStart = request.getParameter("realseKHStart");
			String realseKHEnd = request.getParameter("realseKHEnd");
			String status = request.getParameter("status");
			
		
			mv.addObject("customer", customer);
			mv.addObject("production", productions);
			mv.addObject("hdpo", hdpo);
			mv.addObject("psx", psx);
			mv.addObject("recieveStart", recieveStart);
			mv.addObject("recieveEnd", recieveEnd);
			mv.addObject("realseKHStart", realseKHStart);
			mv.addObject("realseKHEnd", realseKHEnd);
			mv.addObject("status", status);
			
			String message="";
			
			if(Common.isNotEmpty(recieveStart))
			{
				if(Common.isDateView(recieveStart,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày nhận bắt đầu theo định dạng DD/MM/YYYY<br>";
				}
			}
			if(Common.isNotEmpty(recieveEnd))
			{
				if(Common.isDateView(recieveEnd,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày nhận kết thúc theo định dạng DD/MM/YYYY<br>";
				}
			}
			if(Common.isNotEmpty(realseKHStart))
			{
				if(Common.isDateView(realseKHStart,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày giao bắt đầu theo định dạng DD/MM/YYYY<br>";
				}
			}
			if(Common.isNotEmpty(realseKHEnd))
			{
				if(Common.isDateView(realseKHEnd,"dd/mm/yyyy") == false)
				{
					message+="Vui lòng nhập ngày giao kết thúc theo định dạng DD/MM/YYYY<br>";
				}
			}
			
			if(Common.isEmpty(message))
			{
				ProductionOrderModel production = new ProductionOrderModel();
				production.setCustomerName(customer);
				production.setProduction(productions);
				production.setHD_PO(hdpo);
				production.setPSX(psx);
				production.setRecieveDt(recieveStart);
				production.setRecieveDtEnd(recieveEnd);
				production.setReleaseScheDt(realseKHStart);
				production.setReleaseScheDtEnd(realseKHEnd);
				if("-1".equals(status)==false)
				{
					production.setStatus(status);
				}
				production.setDeleteFg("0");
				
				ProductionOrderSelectDao selectProduction = new ProductionOrderSelectDao(production);
				try {
					List<ProductionOrderModel> lstProduction = selectProduction.excute();
					if(lstProduction.size()==0)
					{
						mv.addObject(Common.MESSAGE_NOTIFICATION, "KHÔNG TÌM THẤY ĐƠN HÀNG NÀO");
					}
					else
					{
						mv.addObject(Common.MESSAGE_NOTIFICATION, "TÌM THẤY " +lstProduction.size()+" ĐƠN HÀNG");
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
							else
							{
								if(lstProduction.get(i).getStatus().trim().equals(OrderProductionStatus.RELEASE))
								{
									String CompareSche = null;
									try {
										CompareSche = Common.ConvertStringToDateStr(lstProduction.get(i).getReleaseScheDt(), "dd/mm/yyyy", "yyyymmdd");
									} catch (ParseException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									String CompareReal = null;
									try {
										CompareReal = Common.ConvertStringToDateStr(lstProduction.get(i).getReleaseRelDt(), "dd/mm/yyyy", "yyyymmdd");
									} catch (ParseException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

									
									if(Integer.parseInt(CompareReal) > Integer.parseInt(CompareSche))
									{
										lstProduction.get(i).setStatus(OrderProductionStatus.RELEASED_AFTER_TIME);
									}
									else
									{
										lstProduction.get(i).setStatus(OrderProductionStatus.RELEASED_ON_TIME);
									}
								}
							}
						}
						
						
						
						mv.addObject("lst", lstProduction);
						return new ModelAndView(new ExcelAssetGeneralListReportView(), "lstProduction", lstProduction);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					mv.addObject(Common.MESSAGE_ERROR, "MỘT LỖI HỆ THỐNG ĐÃ XẢY RA");
				}
			}
			else
			{
				mv.addObject(Common.MESSAGE_ERROR, message);

			}
			mv.addObject("role", Common.getSessionValue(request, SessionConstant.ROLE));
			mv.setViewName("views/ProductionManagement.jsp");
		}
		else{
			mv.setViewName("redirect:/login");
		}
		
		return mv;
	}
	@RequestMapping(params="register" ,method=RequestMethod.POST)
	public ModelAndView registerAction(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ProductionRegister");
		return mv;
	}
	@RequestMapping(params="exportPDF" ,method=RequestMethod.POST)
	public ModelAndView exportPDFAction(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ProductionRegister");
		return mv;
	}

}
