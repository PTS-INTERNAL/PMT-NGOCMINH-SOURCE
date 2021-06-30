package com.pmt.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pmt.dao.UserInsertDao;
import com.pmt.dao.UserSelectDao;
import com.pmt.dao.UserUpdateDeleteDao;
import com.pmt.model.UserModel;
import com.pmt.util.Common;
import com.pmt.util.SessionConstant;

@Controller
@RequestMapping("/UserManagement")
public class UserManagemetController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isManager(request))
		{
			UserModel user = new UserModel();
			UserSelectDao select = new UserSelectDao(user);
			try {
				List<UserModel> lst   = select.excute();
				mv.addObject("lst", lst);
				mv.addObject("role","manager");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mv.setViewName("/views/UserManagement.jsp");
		}
		else
		{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	@RequestMapping(params="register" , method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, RedirectAttributes att)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isManager(request))
		{
			
			String fullname = request.getParameter("fullName");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			
			String message  = "";
			
			if(Common.isEmpty(fullname))
			{
				message+="Họ và tên người dùng là bắt buộc<br>";
			}
			if(Common.isEmpty(username))
			{
				message+="Tên đăng nhập người dùng là bắt buộc<br>";
			}
			if(Common.isEmpty(password))
			{
				message+="Mật khẩu người dùng là bắt buộc<br>";
			}
			
			UserModel user1 = new UserModel();
			user1.setUserName(username);
			
			UserSelectDao select = new UserSelectDao(user1);
			try {
				List<UserModel> lst   = select.excute();
				if(lst.size()>0)
				{
					message+="Tên đăng nhập này đã tồn tại<br>";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Common.isEmpty(message))
			{
				UserModel user2 = new UserModel();
				user2.setUserCd(Common.getDateCurrent("YYYYMMddHHmmSS"));
				user2.setFullName(fullname);
				user2.setUserName(username);
				user2.setPassword(password);
				user2.setRole(role);
				String user = Common.getSessionValue(request, SessionConstant.USER_ID);
				user2.setInsertId(user);
				user2.setInsertDt(Common.getDateCurrent("YYYYMMddHHmmSS"));
				user2.setUpdateId(user);
				user2.setUpdateDt(Common.getDateCurrent("YYYYMMddHHmmSS"));
				
				UserInsertDao isn  = new UserInsertDao(user2);
				try {
					isn.excute();
					mv.addObject(Common.MESSAGE_NOTIFICATION, "THÊM NGƯỜI DÙNG THÀNH CÔNG");
					mv.addObject("role","manager");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					mv.addObject("fullName",fullname);
					mv.addObject("username",username);
					mv.addObject("password",password);
					mv.addObject("role",role);
					
					mv.addObject(Common.MESSAGE_ERROR, e.toString());
				}
			}
			else
			{		
				mv.addObject("fullName",fullname);
				mv.addObject("username",username);
				mv.addObject("password",password);
				mv.addObject("role",role);
				
				mv.addObject(Common.MESSAGE_ERROR, message);
			}
			
			UserModel user = new UserModel();
			select = new UserSelectDao(user);
			try {
				List<UserModel> lst   = select.excute();
				mv.addObject("lst", lst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mv.setViewName("/views/UserManagement.jsp");
		}
		else
		{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	@RequestMapping(params="delete" , method=RequestMethod.POST)
	public ModelAndView delete(HttpServletRequest request, RedirectAttributes att)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isManager(request))
		{
				String userCd = request.getParameter("userCd");
				UserUpdateDeleteDao userDel = new UserUpdateDeleteDao(userCd);
				try {
					userDel.excute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mv.setViewName("redirect:/UserManagement");
		}
		return mv;
	}
}
