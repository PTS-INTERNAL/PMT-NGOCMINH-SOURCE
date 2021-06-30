package com.pmt.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pmt.dao.ProductionOrderInsertDao;
import com.pmt.dao.ProductionOrderSelectDao;
import com.pmt.dao.ProductionOrderUpdateDeleteDao;
import com.pmt.dao.ProductionOrderUpdateReleaseDao;
import com.pmt.dao.ProductionOrderUpdatetDao;
import com.pmt.model.ProductionOrderModel;
import com.pmt.util.Common;
import com.pmt.util.OrderProductionStatus;
import com.pmt.util.SessionConstant;

@Controller
@RequestMapping("/ProductionView")
public class ProductionViewController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isLogin(request)){
			String orderCd = (String) request.getSession().getAttribute("orderCd");
			if(Common.isEmpty(orderCd))
			{
				orderCd = request.getParameter("orderCd");
			}
			else
			{
				request.getSession().removeAttribute("orderCd");
			}
			if(Common.isNotEmpty(orderCd))
			{
				ProductionOrderModel pro = new ProductionOrderModel();
				pro.setOrderCd(orderCd);
				ProductionOrderSelectDao seelct  = new ProductionOrderSelectDao(pro);
				List<ProductionOrderModel> lst;
				try {
					lst = seelct.excute();
					if(lst.size()==1)
					{
						mv.addObject("orderCd", orderCd);
						mv.addObject("customer", lst.get(0).getCustomerName());
						mv.addObject("production", lst.get(0).getProduction());
						mv.addObject("hdpo", lst.get(0).getHD_PO());
						mv.addObject("psx", lst.get(0).getPSX());
						mv.addObject("recieveDt", lst.get(0).getRecieveDt());
						mv.addObject("releaseScheDt", lst.get(0).getReleaseScheDt());
						mv.addObject("note", lst.get(0).getNote());
					}
					else
					{
						mv.addObject(Common.MESSAGE_ERROR, "KHÔNG TÌM THẤY ĐƠN HÀNG");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	
				}
			}
			else
			{
				mv.addObject(Common.MESSAGE_ERROR, "KHÔNG TÌM THẤY ĐƠN HÀNG");
			}
			mv.setViewName("/views/ProductionView.jsp");
		}
		else{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	
	@RequestMapping(params="view",method=RequestMethod.POST)
	public ModelAndView view(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isLogin(request)){
			
			String orderCd = request.getParameter("orderCd");
			
			if(Common.isNotEmpty(orderCd))
			{
				ProductionOrderModel pro = new ProductionOrderModel();
				pro.setOrderCd(orderCd);
				ProductionOrderSelectDao seelct  = new ProductionOrderSelectDao(pro);
				List<ProductionOrderModel> lst;
				try {
					lst = seelct.excute();
					if(lst.size()==1)
					{
						mv.addObject("orderCd", orderCd);
						mv.addObject("customer", lst.get(0).getCustomerName());
						mv.addObject("production", lst.get(0).getProduction());
						mv.addObject("hdpo", lst.get(0).getHD_PO());
						mv.addObject("psx", lst.get(0).getPSX());
						mv.addObject("recieveDt", lst.get(0).getRecieveDt());
						mv.addObject("releaseScheDt", lst.get(0).getReleaseScheDt());
						mv.addObject("releaseRealDt", lst.get(0).getReleaseRelDt());
						mv.addObject("note", lst.get(0).getNote());
					}
					else
					{
						mv.addObject(Common.MESSAGE_ERROR, "KHÔNG TÌM THẤY ĐƠN HÀNG");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	
				}
			}
			else
			{
				mv.addObject(Common.MESSAGE_ERROR, "KHÔNG TÌM THẤY ĐƠN HÀNG");
			}
			mv.setViewName("/views/ProductionView.jsp");
		}
		else{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	
	
	@RequestMapping(params="saveUpdate", method=RequestMethod.POST)
	public ModelAndView saveUpdate(HttpServletRequest request, RedirectAttributes arrt)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isLogin(request)){
			
			String orderCd = request.getParameter("orderCd");
			
			if(Common.isNotEmpty(orderCd))
			{
				String customer = request.getParameter("customer");
				String production = request.getParameter("production");
				String hdpo = request.getParameter("hdpo");
				String psx = request.getParameter("psx");
				String recieveDt = request.getParameter("recieveDt");
				String releaseScheDt = request.getParameter("releaseScheDt");
				String note  = request.getParameter("note");
				String isMode = request.getParameter("isMode");
			
				mv.addObject("customer", customer);
				mv.addObject("production", production);
				mv.addObject("hdpo", hdpo);
				mv.addObject("psx", psx);
				mv.addObject("recieveDt", recieveDt);
				mv.addObject("releaseScheDt", releaseScheDt);
				mv.addObject("note", note);
				mv.addObject("orderCd", orderCd);
			
				boolean isError =true;
				String message="";
				if(Common.isEmpty(customer))
				{
					message+="Tên khách hàng là giá trị bắt buộc<br>";
					isError = false;
				}
				if(Common.isEmpty(production))
				{
					message+="Tên sản phẩm đại diện là giá trị bắt buộc<br>";
					isError = false;
				}
//				if(Common.isEmpty(hdpo))
//				{
//					message+="HDPO là giá trị bắt buộc<br>";
//					isError = false;
//				}
				if(Common.isEmpty(psx))
				{
					message+="PSX là giá trị bắt buộc<br>";
					isError = false;
				}
				if(Common.isEmpty(recieveDt))
				{
					message+="Thời gian nhận đơn hàng là giá trị bắt buộc<br>";
					isError = false;
				}
				else
				{
					if(Common.isDateView(recieveDt,"dd/mm/yyyy") == false)
					{
						message+="Vui lòng nhập ngày nhận theo định dạng DD/MM/YYYY<br>";
						isError = false;
					}
				}
				if(Common.isEmpty(releaseScheDt))
				{
					message+="Thời gian giao hàng kết hoạch là giá trị bắt buộc<br>";
					isError = false;
				}
				else
				{
					if(Common.isDateView(releaseScheDt,"dd/mm/yyyy") == false)
					{
						message+="Vui lòng nhập ngày giao hàng kế hoạch theo định dạng DD/MM/YYYY<br>";
						isError = false;
					}
				}
			
				
			
				if(isError)
				{
					ProductionOrderModel pro = new ProductionOrderModel();
					pro.setOrderCd(orderCd);
					ProductionOrderSelectDao seelct  = new ProductionOrderSelectDao(pro);
					List<ProductionOrderModel> lst;
					try {
						lst = seelct.excute();
						if(lst.size()==1)
						{
							String currentStatus=lst.get(0).getStatus();
							
							ProductionOrderModel productionModel = new ProductionOrderModel();
							productionModel.setOrderCd(orderCd);
							productionModel.setCustomerName(customer);
							productionModel.setProduction(production);
							productionModel.setHD_PO(hdpo);
							productionModel.setPSX(psx);
							productionModel.setRecieveDt(recieveDt);
							productionModel.setReleaseScheDt(releaseScheDt);
							productionModel.setNote(note);
							productionModel.setStatus(currentStatus);
							productionModel.setUpdateId(Common.getSessionValue(request, SessionConstant.USER_ID));
							productionModel.setUpdateDt(Common.getDateCurrent(Common.YYYYMMddHHmmSS));
							productionModel.setDeleteFg("0");
							productionModel.setIsMode(isMode);
							ProductionOrderUpdatetDao update = new ProductionOrderUpdatetDao(productionModel);
							try {
								update.excute();
								mv.addObject(Common.MESSAGE_NOTIFICATION, "CẬP NHẬT ĐƠN HÀNG THÀNH CÔNG");
								request.getSession().setAttribute("orderCd", orderCd);
								Common.SetIsUpdate();
								mv.setViewName("/views/ProductionView.jsp");
								return mv;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else
						{
							mv.addObject(Common.MESSAGE_ERROR, "KHÔNG TÌM THẤY ĐƠN HÀNG");
						}
					}
					catch (Exception e) {
						// TODO: handle exception
					}
				}
				else
				{
					mv.addObject(Common.MESSAGE_ERROR, message);
					mv.addObject("isUpdateError", "1");
				}
			
			
				
				mv.setViewName("/views/ProductionView.jsp");
			}
			else
			{
				mv.addObject(Common.MESSAGE_ERROR, "KHÔNG TÌM THẤY ĐƠN HÀNG THÀNH CÔNG");
				mv.setViewName("/views/ProductionView.jsp");
			}
		}
		else{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	
	@RequestMapping(params="delete", method=RequestMethod.POST)
	public ModelAndView delete(HttpServletRequest request, RedirectAttributes arrt)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isLogin(request)){
			
			String orderCd = request.getParameter("orderCd");
			
			if(Common.isNotEmpty(orderCd))
			{
				ProductionOrderModel pro = new ProductionOrderModel();
				pro.setOrderCd(orderCd);
				ProductionOrderUpdateDeleteDao seelct  = new ProductionOrderUpdateDeleteDao(pro);
				try {
					seelct.excute();
					mv.addObject(Common.MESSAGE_NOTIFICATION, "XÓA ĐƠN HÀNG THÀNH CÔNG");
					Common.SetIsUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					mv.addObject(Common.MESSAGE_ERROR, "LỖI KHI XÓA ĐƠN HÀNG");
					e.printStackTrace();
				}
			}
			else
			{
				String customer = request.getParameter("customer");
				String production = request.getParameter("production");
				String hdpo = request.getParameter("hdpo");
				String psx = request.getParameter("psx");
				String recieveDt = request.getParameter("recieveDt");
				String releaseScheDt = request.getParameter("releaseScheDt");
				String note  = request.getParameter("note");
			
				mv.addObject("customer", customer);
				mv.addObject("production", production);
				mv.addObject("hdpo", hdpo);
				mv.addObject("psx", psx);
				mv.addObject("recieveDt", recieveDt);
				mv.addObject("releaseScheDt", releaseScheDt);
				mv.addObject("note", note);
				mv.addObject("orderCd", orderCd);
				mv.addObject(Common.MESSAGE_ERROR, "KHÔNG TÌM THẤY ĐƠN HÀNG");
			}
			mv.setViewName("/views/ProductionView.jsp");
			
		}
		else{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	@RequestMapping(params="status", method=RequestMethod.POST)
	public ModelAndView status(HttpServletRequest request, RedirectAttributes arrt)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isLogin(request)){
			
			String orderCd = request.getParameter("orderCd"); 
			String releaseRealDt = request.getParameter("releaseRealDtPicker");
			if(Common.isNotEmpty(orderCd) && Common.isNotEmpty(releaseRealDt))
			{
				String releaseRealDtStander = releaseRealDt;
				try {
					releaseRealDtStander = Common.ConvertStringToDateStr(releaseRealDt, "yyyy-mm-dd", "dd/mm/yyyy");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ProductionOrderModel pro = new ProductionOrderModel();
				pro.setOrderCd(orderCd);
				pro.setReleaseRelDt(releaseRealDtStander);
				ProductionOrderUpdateReleaseDao seelct  = new ProductionOrderUpdateReleaseDao(pro);
				try {
					seelct.excute();
					arrt.addFlashAttribute(Common.MESSAGE_NOTIFICATION, "CẬP NHẬT GIAO HÀNG THÀNH CÔNG");
					request.getSession().setAttribute("orderCd", orderCd);
					Common.SetIsUpdate();
					mv.setViewName("redirect:/ProductionView");
					return mv;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					mv.addObject(Common.MESSAGE_ERROR, "LỖI KHI CẬP NHẬT GIAO HÀNG ĐƠN HÀNG");
					e.printStackTrace();
				}
			}
			else
			{
				String customer = request.getParameter("customer");
				String production = request.getParameter("production");
				String hdpo = request.getParameter("hdpo");
				String psx = request.getParameter("psx");
				String recieveDt = request.getParameter("recieveDt");
				String releaseScheDt = request.getParameter("releaseScheDt");
				String note  = request.getParameter("note");
			
				mv.addObject("customer", customer);
				mv.addObject("production", production);
				mv.addObject("hdpo", hdpo);
				mv.addObject("psx", psx);
				mv.addObject("recieveDt", recieveDt);
				mv.addObject("releaseScheDt", releaseScheDt);
				mv.addObject("note", note);
				mv.addObject("orderCd", orderCd);
				mv.addObject(Common.MESSAGE_ERROR, "KHÔNG TÌM THẤY ĐƠN HÀNG");
			}
			mv.setViewName("/views/ProductionView.jsp");
			
		}
		else{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}

}
