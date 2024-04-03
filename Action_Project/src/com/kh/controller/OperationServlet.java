package com.kh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.vo.Person;

/**
 * Servlet implementation class OperationServlet
 */
@WebServlet("/operation.do")
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 테스트 할 수 있는 값 넘기기
		request.setAttribute("big", 10);
		request.setAttribute("small", 3);
		
		request.setAttribute("strOne", "안녕");
		request.setAttribute("strTwo", new String("안녕"));
		
		request.setAttribute("personOne", new Person("홍길동", 15, "한양"));
		request.setAttribute("personTwo", null);
		
		ArrayList<String> list1 = new ArrayList();
		request.setAttribute("listOne", list1);
		
		ArrayList<String> list2 = new ArrayList();
		list2.add("ㅎㅇ");
		request.setAttribute("listTwo", list2);
		
		// 일단 여기까지 requestScope에 총 8개의 값을 담았음
		request.getRequestDispatcher("views/02_elOperation.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
