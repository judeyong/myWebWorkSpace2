package com.kh.jsp.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTemplate {
	
	public static void requestErrorMsg(HttpServletRequest request,HttpServletResponse response, String msg) {
		
		request.setAttribute("errorMsg", msg);
		RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
		
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void requestDispatcher(HttpServletRequest request,HttpServletResponse response, String path ) {
		
		try {
			request.getRequestDispatcher(path).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
