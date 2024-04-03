package com.kh.jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.board.model.service.BoardService;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/delete.board")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int fileNo = 0;
		
		if(request.getParameter("fileNo") != null) {
			fileNo = Integer.parseInt(request.getParameter("fileNo"));
		}
		
		// System.out.println("boardNo : "+ boardNo);
		// System.out.println("fileNo : "+ fileNo);
		
		// 첨부파일이 없다면 borad만 삭제
		// 첨부파일 있다면 board + attachment 삭제
		
		int result = new BoardService().deleteBoard(boardNo, fileNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "게시글 삭제 성공!");
			response.sendRedirect(request.getContextPath() + "/boardList?currentPage=1");
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
