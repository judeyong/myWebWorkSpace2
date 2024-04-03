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
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) post방식 => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) request로 부터 요청 시 전달값 뽑기
		// userName, phone, email, address, interest
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interestArr = request.getParameterValues("interest");
		String interest = "";
		
		if(interestArr != null) {
			interest = String.join(",",interestArr);
		}
		
		String userId = request.getParameter("userId");
		
		// 3) VO객체에 담기
		Member member = new Member();
		
		member.setUserName(userName);
		member.setPhone(phone);
		member.setEmail(email);
		member.setAddress(address);
		member.setInterest(interest);
		member.setUserId(userId);
		
		// 4) Service 호출
		int result = new MemberService().updateMember(member);
		
		// 5) 결과물에 따라서 응답화면 지정
		if(result > 0) {
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "정보수정에 성공하였습니다.!");;
			
			// case 1.
			// Member updateMem = new MemberService().selectMember(userId);
			// session.setAttribute("loginUser", updateMem);
			
			
			// case 2.
			String userPwd = ((Member)session.getAttribute("loginUser")).getUserPwd();
			Member updateMem = new MemberService().login(userId, userPwd);
			
			session.setAttribute("loginUser", updateMem);
			
			// 1. 포워딩
			// 2. 리다이렉트
			// request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
			
			// localhost:7777	/jsp/myPage
			response.sendRedirect(request.getContextPath() + "/myPage");
			
		} else {
			request.setAttribute("errorMsg", "회원정보 수정에 실패했습니다.");
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
