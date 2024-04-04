package com.kh.jsp.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxController1
 */
@WebServlet("/jqAjax1.do")
public class AjaxController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// GET 방식 => 인코딩 x
		
		// 값뽑기
		// request.getParameter();
		String responseData = request.getParameter("input");
		// System.out.println("입력한 값 " + responseData);
		
		// 응답
		// 값만 보내줌
		
		// 1) 응답데이터에 한글이 있을 경우 대비해서
		// ******************************** 항상 응답데이터에 대해서 인코딩 설정
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) 응답 : response.getWriter()
		// -> 스트림 연결(Servlet맛보기 할때 사용함)
		
		response.getWriter().print(responseData);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
