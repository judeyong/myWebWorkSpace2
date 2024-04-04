package com.kh.jsp.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.notice.model.service.NoticeServiceImpl;
import com.kh.jsp.notice.model.vo.Notice;
import static com.kh.jsp.common.RequestTemplate.requestErrorMsg;

/**
 * Servlet implementation class NoticeDetailController
 */
@WebServlet("/detail.notice")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// GET방식 => 인코딩 X
		
		// 2) request로 부터 값 뽑기
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		// 3) VO 가공
		
		// 4) Service호출
		int result = new NoticeServiceImpl().increaseCount(noticeNo);
		
		if(result > 0) {
			
			Notice notice = new NoticeServiceImpl().selectNotice(noticeNo);
			
			if(notice != null) {
				
				request.setAttribute("notice", notice);
				request.getRequestDispatcher("views/notice/noticeDetail.jsp").forward(request, response);
				
			} else {
				requestErrorMsg(request, response, "공지사항 상세 조회 실패");
				//request.setAttribute("errorMsg", "공지사항 상세 조회 실패");
				//RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				//view.forward(request, response);
			}
			
			
		} else { // 실패 => 에러페이지 보내기
			requestErrorMsg(request, response, "공지사항 상세 조회 실패");
			// request.setAttribute("errorMsg", "공지사항 상세 조회 실패");
			// RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			// view.forward(request, response);
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
