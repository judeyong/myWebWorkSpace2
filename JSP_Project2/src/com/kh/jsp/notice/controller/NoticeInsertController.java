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
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.notice")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST 방식
		
		// 1) 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 값뽑기
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		String userNo = request.getParameter("userNo");
		
		// 3) 데이터가공
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setNoticeWriter(userNo);
		
		// NOTICE테이블에 INSERT시점에 NOTICE_WRITER컬럼이 NOT NULL제약조건
		// 추가적으로 공지사항 작성자의 USER_NO가 필요함
		
		// 4) Service단으로 넘겨주기 / INSERT 구문 생각해놓기
		int result = new NoticeServiceImpl().insert(notice);
		// INSERT INTO NOTICE VALUES(시퀀스, 입력제목, 입력내용, 공지사항작성자USERNO,)
		
		// 5) 결과에 따라 응답페이지 지정
		if(result > 0) { // 성공 => 공지사항 목록을 보여줄 것 
			
			// forwarding
			// request.setAttribute("noticeList", new NoticeServiceImpl().selectNoticeList());
			// request.getRequestDispatcher("views/notice/noticeList.jsp").forward(request, response);
			
			// sendRedirect
			response.sendRedirect(request.getContextPath() + "/noticeList");
			
		} else { // 실패 => 에러페이지로 포워딩
			
			// RequestTemplate.requestErrorMsg(request, response, "공지사항등록실패");
			
			request.setAttribute("errorMsg", "공지사항등록실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
