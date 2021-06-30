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
@RequestMapping("/ChangePin")
public class ChangePinController {
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isManager(request))
		{
			SystemControlSelectDao select = new SystemControlSelectDao("PIN_CD");
			try {
				String value = select.excute();
				mv.addObject("pin_cd", value);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			mv.setViewName("/views/ChangePin.jsp");
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
			String pin = request.getParameter("pin");
			if(Common.isNotEmpty(pin))
			{
				SystemControlUpdatetDao up = new SystemControlUpdatetDao("PIN_CD", pin.trim());
				try {
					up.excute();
					att.addFlashAttribute(Common.MESSAGE_NOTIFICATION, "THAY ĐỔI PIN THÀNH CÔNG");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				att.addFlashAttribute(Common.MESSAGE_ERROR, "MÃ PIN MỚI LÀ BẮT BUỘC");
			}
			mv.setViewName("redirect:/ChangePin");
		}
		else
		{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}

}
