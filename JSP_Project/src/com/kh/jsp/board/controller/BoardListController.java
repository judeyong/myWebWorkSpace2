package com.kh.jsp.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.board.model.service.BoardService;
import com.kh.jsp.board.model.vo.Board;
import com.kh.jsp.common.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/boardList")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 쿼리스트링 -> /jsp/boardList?currentPage=1
		// 		  -> get방식 -> 인코딩
		
		// 2) request 값뽑기
		
		// -- 페이징 처리 --
		// 필요한 변수들
		int listCount;   // 현재 일반게시판의 게시글 총 개수 => BOARD테이블로 부터 COUNT(*)활용해서 조회
		int currentPage; // 현재 페이지(사용자가 요청한 페이지) => request.getParameter("currentPage");
		int pageLimit;   // 페이지 하단에 보여질 페이징바의 최대 개수 => 10개로 고정
		int boardLimit;  // 한 페이지에 보여질 게시글의 최대 개수 => 10개로 고정
		
		int maxPage;   // 가장 마지막 페이지가 몇 번 페이지인지 (총 페이지의 개수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작 수
		int endPage;   // 페이지 하단에 보여질 페이징바의 끝 수
		
		// * listCount : 총 게시글의 수
		listCount = new BoardService().selectListCount();
		
		// * currentPage : 현재 페이지(사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		// System.out.println(listCount);
		// System.out.println(currentPage);
		
		// * pageList : 페이징바 최대 개수
		pageLimit = 10;
		
		// * boardLimit : 한 페이지에 보여질 게시글의 최대 개수
		boardLimit = 10;
		
		// * maxPage : 가장 마지막 페이지가 몇 번 페이지인지(총 페이지 개수)
		
		/*
		 * listCount, boardLimit에 영향을 받음
		 * 단, boardLimit이 10이라는 가정하에 규칙을 찾아보자
		 * 총 개수 (ListCount) / 개시글 개수 (board) == maxPage(마지막페이지)
		 * 100				/  10			  == 10		10 페이지
		 * 107				/  10			  == 10.7	11 페이지
		 * 111 				/  10   		  == 11.1	12 페이지
		 * 
		 * => 나눗셈결과를 소수점을 붙여서 올림처리를 할 경우 maxPage가 됨
		 * 
		 * 스텝
		 * 1. listCount를 double로 변환
		 * 2. listCount / boardLimit
		 * 3. Math.ceil() => 결과를 올림처리
		 * 4. 결과갑을 int로 형변환
		 * 
		 */
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		// System.out.println(maxPage);
		
		// * startPage : 페이지 하단에 보여질 페이징바의 시작 수
		/*
		 * currentPage, pageLimit에 영향을 받음
		 * 
		 * - 공식
		 * 	단, pageLimit이 10이라고 가정
		 * 
		 * startPage : 1, 11, 21, 31, 41 => n * 10 + 1
		 * 
		 * 만약에 pageLimit이 5였다
		 * 
		 * - startPage : 1, 6, 16 ... => n * 5 + 1
		 * 
		 * 즉, startPage = n * pageLimit + 1;
		 * 
		 * pageLimit이 10이라는 가정,
		 * currentPage 	start 
		 * 		1		  1
		 *      5	      1
		 *     10         1
		 *     13	     11 
		 *     15        11
		 *     20        11
		 *     29        21
		 *     
		 * =>  1 ~ 10 : n * 10 + 1 ==> n == 0
		 * => 11 ~ 20 : n * 10 + 1 ==> n == 1
		 * => 21 ~ 30 : n * 10 + 1 ==> n == 2
		 * 
		 *  1 ~ 10 / 10 => 0 ~ 1
		 * 11 ~ 20 / 10 => 1 ~ 2
		 * 21 ~ 30 / 10 => 2 ~ 3 
		 * 
		 * 0 ~ 9 / 10 => 0
		 * 10 ~ 19 / 10 => 1
		 * 20 ~ 29 / 10 => 2 
		 * 
		 * n = (currentPage  - 1) / pageLimit;
		 * 
		 * startPage = (currnetPage -1) / pageLimit * pageLimit + 1;
		 * 
		 */
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		// * endPage : 페이지 하단에 보여질 페이징바의 끝 수
		/*
		 * startPage, pageLimit에 영향을 받음(단, maxPage도 마지막 페이징 바에 대해 영향을 끼침)
		 * 
		 * - 공식
		 * 	단, pageLimit이 10이라고 가정
		 * 
		 * startPage = 1  => endPage : 10
		 * startPage = 11 => endPage : 20
		 * startPage = 21 => endPage : 30
		 * 
		 * => endPage = startPage + pageLimit - 1;
		 * 
		 */
		endPage = startPage + pageLimit - 1;
		
		// * maxPage : 가장 마지막 페이지가 몇 번 페이지인지(총 페이지 개수)
		// * endPage : 페이지 하단에 보여질 페이징바의 끝 수
		
		// startPage가 31이라서 endPage에는 40이 들어갔는데
		// maxPage가 35다?
		// endPage를 maxPage값을 변경
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 여기까지 총 7개의 변수를 만들었음
		// 3) VO로 가공
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
								  maxPage, startPage, endPage);
		// System.out.println(pi);
		
		// 4) Service 호출
		ArrayList<Board> boardList = new BoardService().selectList(pi);
		
		// System.out.println(boardList);
		
		// 5) 응답화면 지정
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageInfo", pi);
		
		// views/board/boardList.jsp
		
		request.getRequestDispatcher("views/board/boardList.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
