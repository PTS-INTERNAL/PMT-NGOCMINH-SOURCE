package com.pmt.util;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.pmt.dao.SystemControlUpdatetDao;



public class Common {
	
	public static String YYYYMMddHHmmSS = "YYYYMMddHHmmSS";
	public static String YYYYMMdd = "YYYYMMdd";
	public static String  MESSAGE_NOTIFICATION = "notification";
	public static String MESSAGE_ERROR="message";
	
	
	public static boolean isDateView(String input, String format)
	{
		boolean checkFormat =false;
//		 Date date = null;
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        try {
//			date = sdf.parse(input);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        if (!input.equals(sdf.format(date))) {
//        	checkFormat=true;
//        }
		checkFormat = input.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$");

		return checkFormat;
	}
	
	public static String getDateCurrent(String format)
	{
	     Date date = Calendar.getInstance().getTime();  
	     DateFormat dateFormat = new SimpleDateFormat(format);  
	     String strDate = dateFormat.format(date);  
		 return strDate;
	}
	public static boolean isEmpty(String str) {
		if(str == null) 
		{
			return true;
		}
		if(str.trim().length()==0)
		{
			return true;
		}
		return false;
		
	}
	
	public static boolean isNotEmpty(String str) {
		if(str != null && str.trim().length()>0) 
		{
			return true;
		}
		return false;
		
	}
	public static void setSessionAttribute(HttpServletRequest request, String param, String value)
	{
		request.getSession().setAttribute(param, value);
	}
	
	public static String getSessionValue(HttpServletRequest request, String param)
	{
		return (String)request.getSession().getAttribute(param);
	}
	public static void removeSessionValue(HttpServletRequest request, String param)
	{
		 request.getSession().setAttribute(param,null);
	}
	public static boolean isLogin(HttpServletRequest request)
	{
		String usercd = getSessionValue(request, SessionConstant.USER_ID);
		if(isNotEmpty(usercd))
		{
			return true;
		}
		return false;
	}
	public static boolean isPin(HttpServletRequest request)
	{
		String usercd = getSessionValue(request, SessionConstant.PIN_CD);
		if(isNotEmpty(usercd))
		{
			return true;
		}
		return false;
	}
	
	public static boolean isManager(HttpServletRequest request)
	{
		String role = getSessionValue(request, SessionConstant.ROLE);
		if(isNotEmpty(role) && role.trim().equals(SessionConstant.ROLE_ADMIN))
		{
			return true;
		}
		return false;
	}
	
	public static int DAY1_BIGGER_DAY2 =1;
	public static int DAY1_BEFORE_DAY2 =2;
	public static int DAY1_EQUAL_DAY2 =3;
	
	public static int CompareDate(String date1i, String date2i, String format) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date1 = sdf.parse("date1i");
        Date date2 = sdf.parse("date2i");
        
        int reusult = -1;
        	
        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (date1.compareTo(date2) > 0) {
            System.out.println("Date1 is after Date2");
            reusult =1;
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 is before Date2");
            reusult =2;
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("Date1 is equal to Date2");
            reusult =3;
        } else {
            System.out.println("How to get here?");
        }
        
        return reusult;
	}
	
	public static String ConvertStringToDateStr(String date, String fmt_src, String fmt_des) throws ParseException
	{
		if(Common.isNotEmpty(date))
		{
		    SimpleDateFormat sdf1 = new SimpleDateFormat(fmt_src);
		    SimpleDateFormat sdf2 = new SimpleDateFormat(fmt_des);
		    String ds2 = sdf2.format(sdf1.parse(date));
		    
		    return ds2;
		}
		else
		{
			return "0";
		}
		
	}
	
	public static void SetIsUpdate()
	{
		SystemControlUpdatetDao update = new SystemControlUpdatetDao("IS_UPDATE", "1");
		try {
			update.excute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void SetIsNotUpdate()
	{
		SystemControlUpdatetDao update = new SystemControlUpdatetDao("IS_UPDATE", "0");
		try {
			update.excute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
