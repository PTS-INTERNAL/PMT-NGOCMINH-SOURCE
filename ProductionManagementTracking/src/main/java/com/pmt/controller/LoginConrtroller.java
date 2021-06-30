package com.pmt.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmt.dao.UserSelectDao;
import com.pmt.model.UserModel;
import com.pmt.util.Common;
import com.pmt.util.SessionConstant;

@Controller
@RequestMapping("/login")
public class LoginConrtroller {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/views/login.jsp");
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView loginAction(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		String usn = request.getParameter("usn");
		String pass = request.getParameter("pass");
		String message="";
		
		if(Common.isEmpty(usn)&&Common.isEmpty(pass))
		{
			mv.addObject(Common.MESSAGE_ERROR, "VUI LÒNG NHẬP TÊN NGƯỜI DÙNG VÀ MẬT KHẨU");
		}
		else
		{
			if(Common.isEmpty(usn))
			{
				mv.addObject(Common.MESSAGE_ERROR, "TÊN NGƯỜI DÙNG LÀ BẮT BUỘC");
			}
			else
			{
				if(Common.isEmpty(pass))
				{
					mv.addObject(Common.MESSAGE_ERROR, "MẬT KHẨU NGƯỜI DÙNG LÀ BẮT BUỘC");
				}
			}
		}
		
		
		if(Common.isNotEmpty(usn)&&Common.isNotEmpty(pass))
		{
			UserModel user = new UserModel();
			user.setUserName(usn);
			user.setPassword(pass);
			
			UserSelectDao userSelect = new UserSelectDao(user);
			try {
				List<UserModel> lstUser = userSelect.excute();
				if(lstUser.size()==1)
				{
					request.getSession().setAttribute(SessionConstant.USER_ID, lstUser.get(0).getUserCd().trim());
					request.getSession().setAttribute(SessionConstant.USER_FULL_NAME, lstUser.get(0).getFullName().trim());
					request.getSession().setAttribute(SessionConstant.USERNAME, lstUser.get(0).getUserName().trim());
					request.getSession().setAttribute(SessionConstant.ROLE, lstUser.get(0).getRole().trim());

					mv.setViewName("redirect:/ProductionManagement");
					return mv;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mv.setViewName("/views/login.jsp");
		return mv;
	}

}
