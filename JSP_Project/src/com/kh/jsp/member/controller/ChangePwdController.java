package com.kh.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.jsp.member.model.service.MemberService;
import com.kh.jsp.member.model.vo.Member;

/**
 * Servlet implementation class ChangePwdController
 */
@WebServlet("/updatePwd.me")
public class ChangePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) POST방식 -> 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) request에서 값뽑기
		
		String userPwd = request.getParameter("userPwd");
		String changePwd = request.getParameter("changePwd");
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		// 3) VO객체에 담아서 가공 => 이번에는 그냥 넘기기
		// UPDATE MEMBER SET USER_PWD = CHANGE_PWD WHERE USER_PWD = userPwd AND 누구꺼
		// 											 AND STATUS = 'Y'
		
		// 4) Seivice단으로 넘기기
		int result = new MemberService().updatePwd(userNo, userPwd, changePwd);
		
		// 5) 결과값을 가지고 성공 / 실패 여부 판단해서 응답화면 지정
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		String alertMsg = "";
		if(result > 0) {
			alertMsg = "비밀번호 변경에 성공하였습니다.";
			// session.setAttribute("alertMsg", "비밀번호 변경에 성공하였습니다.");
			
			session.setAttribute("loginUser",
						new MemberService().selectMember(loginUser.getUserId()));
		} else {
			alertMsg = "비밀번호 변경에 실패하였습니다.";
			// session.setAttribute("alertMsg", "비밀번호 변경에 실패하였습니다.");
		}
		session.setAttribute("alertMsg", alertMsg);
		
		// 성공 실패 여부와 상관없이 응답화면은 myPage.jsp
		response.sendRedirect(request.getContextPath() + "/myPage");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
