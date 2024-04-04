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
 * Servlet implementation class NoticeUpdateFormController
 */
@WebServlet("/updateForm.notice")
public class NoticeUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 방식
		
		// 값뽑기
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		//
		
		// 서비스호출
		Notice notice = new NoticeServiceImpl().selectNotice(noticeNo); 
		
		request.setAttribute("notice", notice);
		
		// 템플릿으로 빼내기
		RequestTemplate.requestDispatcher(request, response, "views/notice/noticeUpdateForm.jsp");
		
		// request.getRequestDispatcher("views/notice/noticeUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
