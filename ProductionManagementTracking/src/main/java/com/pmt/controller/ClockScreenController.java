package com.pmt.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmt.dao.SystemControlSelectDao;
import com.pmt.util.Common;
import com.pmt.util.SessionConstant;

@Controller
@RequestMapping("/Clock")
public class ClockScreenController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("views/ClockScreen.jsp");
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView clockAction(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		String pin = request.getParameter("pin");
		if(Common.isNotEmpty(pin))
		{
			SystemControlSelectDao select = new SystemControlSelectDao("PIN_CD");
			try {
				String pinValue  = select.excute();
				
				if(pinValue.trim().equals(pin.trim()))
				{
					request.getSession().setAttribute(SessionConstant.PIN_CD, pin);
					mv.setViewName("redirect:/ProductionDisplay");
					return mv;
				}
				else
				{
					mv.addObject(Common.MESSAGE_ERROR, "MÃ PIN KHÔNG ĐÚNG");
					mv.setViewName("/views/ClockScreen.jsp");
					return mv;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			mv.addObject(Common.MESSAGE_ERROR, "VUI LÒNG NHẬP MÃ PIN");
			mv.setViewName("/views/ClockScreen.jsp");
			return mv;
		}
		
		return mv;
	}

}
