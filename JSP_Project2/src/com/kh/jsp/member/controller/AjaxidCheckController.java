package com.kh.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.member.model.service.MemberService;

/**
 * Servlet implementation class AjaxidCheckController
 */
@WebServlet("/idCheck.do")
public class AjaxidCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxidCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// GET
		
		// 2) request로 부터 값 뽑기
	 	String checkId =  request.getParameter("checkId");
		
	 	// 3) VO 가공
	 	
	 	// 4) Service 호출
	 	
	 	int count = new MemberService().idCheck(checkId);
	 	// SELECT USER_ID FROM MEMBER WHERE USER_ID = '입력한값'  => ResultSet 0행
	 	// SELECT COUNT(*) FROM MEMBER WHERE USER_ID = '입력한값' => 무조건 무조건 결과가 나옴
		
	 	// 5) 결과에 따른 응답
	 	// ajax는 데이터만 돌려준다.
	 	// => response.getWriter().print()
	 	// 중복값이 있을 때 count == 1 => "NNNNN"
	 	// 중복값이 없을 때 count == 0 => "NNNNY"
	 	response.setContentType("text/html; charset=UTF-8");
	 	response.getWriter().print(count > 0 ? "NNNNN" : "NNNNY");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
