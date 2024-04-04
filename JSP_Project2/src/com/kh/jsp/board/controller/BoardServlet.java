package com.kh.jsp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("*.kh")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(".kh로 끝나면 응답하는 서블릿!");
		
		String uri = request.getRequestURI();
		// 요청한 url 전부 보여줌
		System.out.println(uri);
		
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		System.out.println(mapping);
		
		BoardController bc = new BoardController();
		String view = "";
		boolean flag = true;
		
		request.setCharacterEncoding("UTF-8");
		
		switch(mapping) {
		case "insert" : view = bc.insert(request, response); break;
		case "update" : view = bc.update(request, response); flag = false; break;
		case "select" : view = bc.select(request, response); break;
		
		}
		
		if(flag) {
			request.getRequestDispatcher(view).forward(request, response);
			
		} else {
			response.sendRedirect(view);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
