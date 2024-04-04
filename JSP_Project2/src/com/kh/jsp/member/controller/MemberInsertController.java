package com.kh.jsp.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.jsp.member.model.service.MemberService;
import com.kh.jsp.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST
		// 1) 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 회원가입
		// 2) request객체로부터 요청 시 전달값 뽑기
		String userId = request.getParameter("userId");     // 필수입력
		String userPwd = request.getParameter("userPwd");   // 필수입력
		String userName = request.getParameter("userName"); // 필수입력
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address"); // "사용자가입력한값" / ""
		String[] interestArr = request.getParameterValues("interest"); // ["요소", "요소"] / null
		
		// 여행, 영화
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr);			
		}
		
		// 3) Member객체에 담기(setter메소드 이용)
		Member memeber = new Member(); // 기본 생성자 가지고 객체생성
		memeber.setUserId(userId);
		memeber.setUserPwd(userPwd);
		memeber.setUserName(userName);
		memeber.setPhone(phone);
		memeber.setEmail(email);
		memeber.setAddress(address);
		memeber.setInterest(interest);
		
		// 4) 요청처리(Service 메소드 호출)
		int result = new MemberService().insertMember(memeber);
		
		// 5) 처리결과를 가지고 사용자가 보게 될 응답화면 지정
		if(result > 0) { // 성공 => index.jsp
			// RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			// view.forward(request, response);
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입에 성공했습니다.");
			response.sendRedirect(request.getContextPath());
			
		} else { // 실패 => 에러페이지로 포워딩
			request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			
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
