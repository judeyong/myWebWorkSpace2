package com.kh.jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.board.model.service.BoardService;
import com.kh.jsp.board.model.vo.Attachment;
import com.kh.jsp.board.model.vo.Board;
import com.kh.jsp.common.RequestTemplate;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.board")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DB로 부터 조회 후 이동
		
		// 2) 뽑기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		// 3) 가공 x
		
		// 4) 서비스 요청
		BoardService boardService =  new BoardService();
		
		// 4_1) 조회수 증가 -> 4_2) 게시글 조회 -> 4_3) 파일조회
		int result = boardService.increaseCount(boardNo);
		
		String dispatcherPath = "";
		
		// 조회수 증가에 성공했다면
		if(result > 0) {
			
			// 2. BOARD테이블 조회
			Board board = boardService.selectBoard(boardNo);
			
			Attachment at = boardService.selectAttachment(boardNo);
			
			request.setAttribute("board", board);
			request.setAttribute("attachment", at);
			// 포워딩
			dispatcherPath = "views/board/boardDetail.jsp";
			// request.getRequestDispatcher("views/board/boardDetail.jsp")
			//	   .forward(request, response);
			
		} else {
			RequestTemplate.requestErrorMsg(request, response, "게시글 조회 실패..");
		}
			RequestTemplate.requestDispatcher(request, response, dispatcherPath);
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
