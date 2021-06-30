package com.pmt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmt.util.Common;

@Controller
@RequestMapping("/SytsemManagement")
public class SystemManagementController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isManager(request))
		{
			mv.setViewName("/views/SystemManagement.jsp");
		}
		else
		{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
}
