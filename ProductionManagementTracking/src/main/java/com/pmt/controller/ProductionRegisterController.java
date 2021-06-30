package com.pmt.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pmt.dao.ProductionOrderInsertDao;
import com.pmt.model.ProductionOrderModel;
import com.pmt.util.Common;
import com.pmt.util.OrderProductionStatus;
import com.pmt.util.SessionConstant;

@Controller
@RequestMapping("/ProductionRegister")
public class ProductionRegisterController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isLogin(request)){
			request.getSession().removeAttribute("production");
			mv.setViewName("/views/ProductionRegister.jsp");
		}
		else{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, RedirectAttributes atrr)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isLogin(request)){
			String customer = request.getParameter("customer");
			String production = request.getParameter("production");
			String hdpo = request.getParameter("hdpo");
			String psx = request.getParameter("psx");
			String recieveDt = request.getParameter("recieveDt");
			String releaseScheDt = request.getParameter("releaseScheDt");
			String note  = request.getParameter("note");
			String isMode  = request.getParameter("isMode");
			
			mv.addObject("customer", customer);
			mv.addObject("production", production);
			mv.addObject("hdpo", hdpo);
			mv.addObject("psx", psx);
			mv.addObject("recieveDt", recieveDt);
			mv.addObject("releaseScheDt", releaseScheDt);
			mv.addObject("note", note);
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
//			if(Common.isEmpty(hdpo))
//			{
//				message+="HDPO là giá trị bắt buộc<br>";
//				isError = false;
//			}
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
				if(recieveDt.trim().length() != 10)
				{
					message+="Vui lòng nhập ngày nhận theo định dạng DD/MM/YYYY<br>";
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
			}
			if(Common.isEmpty(releaseScheDt))
			{
				message+="Thời gian giao hàng kết hoạch là giá trị bắt buộc<br>";
				isError = false;
			}
			else
			{
				if(releaseScheDt.trim().length() != 10)
				{
					message+="Vui lòng nhập ngày nhận theo định dạng DD/MM/YYYY<br>";
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
			}
			
			
			
			if(isError)
			{
				ProductionOrderModel productionModel = new ProductionOrderModel();
				productionModel.setCustomerName(customer);
				productionModel.setProduction(production);
				productionModel.setHD_PO(hdpo);
				productionModel.setPSX(psx);
				productionModel.setRecieveDt(recieveDt);
				productionModel.setReleaseScheDt(releaseScheDt);
				productionModel.setNote(note);
				productionModel.setStatus(OrderProductionStatus.NEW);
				productionModel.setInsertId(Common.getSessionValue(request, SessionConstant.USER_ID));
				productionModel.setInsertDt(Common.getDateCurrent(Common.YYYYMMddHHmmSS));
				productionModel.setUpdateId(Common.getSessionValue(request, SessionConstant.USER_ID));
				productionModel.setUpdateDt(Common.getDateCurrent(Common.YYYYMMddHHmmSS));
				productionModel.setDeleteFg("0");
				productionModel.setOrderCd(Common.getDateCurrent("YYYYMMddHHmmSS"));
				productionModel.setIsMode(isMode);
				
				
				ProductionOrderInsertDao insert = new ProductionOrderInsertDao(productionModel);
				try {
					insert.excute();
					atrr.addFlashAttribute(Common.MESSAGE_NOTIFICATION, "ĐĂNG KÝ ĐƠN HÀNG THÀNH CÔNG");
					request.getSession().setAttribute("orderCd", productionModel.getOrderCd());
					mv.setViewName("redirect:/ProductionView");
					Common.SetIsUpdate();
					return mv;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				mv.addObject(Common.MESSAGE_ERROR, message);
			}
			
			
			
			mv.setViewName("/views/ProductionRegister.jsp");
		}
		else{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}

}
