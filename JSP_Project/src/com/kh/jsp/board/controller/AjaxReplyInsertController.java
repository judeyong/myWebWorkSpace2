package com.kh.jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.board.model.service.BoardService;
import com.kh.jsp.board.model.vo.Reply;
import com.kh.jsp.member.model.vo.Member;

/**
 * Servlet implementation class AjaxReplyInsertController
 */
@WebServlet("/replyInsert.do")
public class AjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// request 값뽑기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String replyContent = request.getParameter("content");
		
		// 로그인한 회원정보 
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		System.out.println(boardNo);
		System.out.println(replyContent);
		System.out.println(userNo);
		// VO로 가공 => Reply
		
		Reply reply = new Reply();
		reply.setRefBno(boardNo);
		reply.setReplyContent(replyContent);
		reply.setReplyWriter(String.valueOf(userNo));
		
		// Service호출
		int result = new BoardService().insertReply(reply);
		System.out.println(result);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result > 0 ? "success" : "fail");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
