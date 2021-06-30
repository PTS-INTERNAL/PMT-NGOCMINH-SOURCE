package com.pmt.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pmt.dao.SystemControlSelectDao;
import com.pmt.dao.SystemControlUpdatetDao;
import com.pmt.util.Common;

@Controller
@RequestMapping("/ChangeInterval")
public class ChangeIntervalController {
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isManager(request))
		{
			
			try {
				SystemControlSelectDao select = new SystemControlSelectDao("INTERVAL_CD");
				String interval_cd = select.excute();
				
				int int_interval = Integer.parseInt(interval_cd.trim());
				
				int minutes = (int_interval/60)/1000;
				if(minutes == 0)
				{
					minutes =1;
				}
				else
				{
					minutes =minutes*2;
				}
				
				mv.addObject("interval_cd", minutes+ " PHÚT");
				
				 select = new SystemControlSelectDao("LOAD_CD");
				 
				String load_cd = select.excute();
				 
				 int int_load = Integer.parseInt(load_cd.trim());
					
				int minutes_load = (int_load/60)/1000;
				if(minutes_load == 0)
				{
					minutes_load =1;
				}
				else
				{
					minutes_load =minutes_load*2;
				}
			
				mv.addObject("load_cd", minutes_load + " PHÚT");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			mv.setViewName("/views/ChangeInterval.jsp");
		}
		else
		{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	
	@RequestMapping(params="save", method=RequestMethod.POST)
	public ModelAndView ChangePin(HttpServletRequest request , RedirectAttributes att)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isManager(request))
		{
			String interval_cd = request.getParameter("interval_cd");
			String load_cd = request.getParameter("load_cd");
			if(Common.isEmpty(interval_cd) && Common.isEmpty(load_cd))
			{
				att.addFlashAttribute(Common.MESSAGE_ERROR, "THỜI GIAN LÀ BẮT BUỘC");	
			}
			else
			{
				if(Common.isNotEmpty(interval_cd))
				{
					if(Integer.parseInt(interval_cd.trim()) <1)
					{
						att.addFlashAttribute(Common.MESSAGE_ERROR, "GIÁ TRỊ KHÔNG ĐƯỢC NHỎ HƠN 1");
					}
					else
					{
						
						int int_inter = Integer.parseInt(interval_cd.trim());
						
						int String_inter = int_inter * 60 * 1000;
						
						SystemControlUpdatetDao up = new SystemControlUpdatetDao("INTERVAL_CD", String_inter/2 + "");
						try {
							up.excute();
							att.addFlashAttribute(Common.MESSAGE_NOTIFICATION, "THAY ĐỔI THỜI GIAN CHUYỂN TRANG THÀNH CÔNG");
	
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(Common.isNotEmpty(load_cd))
				{
					if(Integer.parseInt(load_cd.trim()) < 1)
					{
						att.addFlashAttribute(Common.MESSAGE_ERROR, "GIÁ TRỊ KHÔNG ĐƯỢC NHỎ HƠN 1");
					}
					else
					{
						int int_inter_v = Integer.parseInt(load_cd.trim());
						
						int String_inter_v = int_inter_v * 60 * 1000;
						SystemControlUpdatetDao up = new SystemControlUpdatetDao("LOAD_CD", String_inter_v/2+"");
						try {
							up.excute();
							att.addFlashAttribute(Common.MESSAGE_NOTIFICATION, "THAY ĐỔI THỜI GIAN TẢI TRANG THÀNH CÔNG");
	
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
					
			}
			Common.SetIsUpdate();
			mv.setViewName("redirect:/ChangeInterval");
		}
		else
		{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}

}
