package com.kh.jsp.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.common.RequestTemplate;
import com.kh.jsp.notice.model.service.NoticeServiceImpl;
import com.kh.jsp.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateController
 */
@WebServlet("/update.notice")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Post
		
		// 1) 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 값뽑기
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		// 3) 가공
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setNoticeNo(noticeNo);
		
		// 4) 서비스 호출
		int result = new NoticeServiceImpl().update(notice);
		// UPDATE NOTICE SET NOTICE_TITLE = ?, NOTICE_CONTENT = ?
		// WHERE NOTICE = ?
		
		// 5) 응답화면 지정
		if(result > 0) { // 성공 => 해당 글 상세 보기 페이지로 이동
			
			// 1. forward 
			
			// 2. redirect => 이미 만들어져 있는 서블릿으로 요청을 보내게끔
			response.sendRedirect(request.getContextPath()+ "/detail.notice?noticeNo=" + noticeNo);
			
		} else {
			RequestTemplate.requestErrorMsg(request, response, "공지사항 수정 실패~");
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
