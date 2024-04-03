package com.kh.jsp.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.board.model.service.BoardService;
import com.kh.jsp.board.model.vo.Attachment;
import com.kh.jsp.board.model.vo.Board;

/**
 * Servlet implementation class ThumbnailDetailController
 */
@WebServlet("/detail.image")
public class ThumbnailDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 글번호 뽑아오기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		// 서비스 요청
		// 1. 조회수 증가 요청
		int result = new BoardService().increaseCount(boardNo);
		String view = "";
		
		// 2. 1번이 성공했을 경우 => Board에서 조회 요청, Attachment에서도 조회 요청
		if(result > 0) {
			
			// BOARD 테이블 조회 요청
			Board board = new BoardService().selectBoard(boardNo);
			
			// 기존에 만들어 두었던 selectBoard호출 시
			// 일반 게시글의 경우 카테고리 컬럼에 null이 들어간 행이 없었지만
			// 사진 게시글의 경우 카테고리 컬럼의 값이 전부 null이기 때문에 innerJoin으로는 조회가 불가능
			// => Category_No 컬럼을 기준으로 일치하는 컬럼, 그렇지 않은 컬럼을 모두 조회하려고 한다면
			// 기존의 innerJoin을 outerJoin으로 바꿔주어야함!
			
			// Attachment테이블에서도 조회를 해야함
			ArrayList<Attachment> list = new BoardService().selectAttachmentList(boardNo);
			
			// 요청 결과를 Attribute에 담기
			request.setAttribute("board", board);
			request.setAttribute("list", list);
			
			// request.getRequestDispatcher("views/board/thumbnailDetail.jsp").forward(request, response);
			
			view = "views/board/thumbnailDetail.jsp";
		} else {
			request.setAttribute("errorMsg", "게시글 상세 조회 실패");
			// request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			view = "views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
