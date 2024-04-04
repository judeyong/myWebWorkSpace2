package com.kh.jsp.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class AjaxController2
 */
@WebServlet("/jqAjax2.do")
public class AjaxController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 값뽑기
		int number1 = Integer.parseInt(request.getParameter("number1"));
		int number2 = Integer.parseInt(request.getParameter("number2"));
		
		// VO 가공=> Service 요청
		// 결과 응답
		
		// 한글이 있을 수 있으니 인코딩 설정(필수)
		
		// response.setContentType("text/html; charset=UTF-8");
		
		// 넘기기
		// response.getWriter().print(number1);
		
		// 2개 넘기기 안됌
		
		// 숫자1 : xx, 숫자2 : xx
		/*
		String responseData = "숫자 1 : " + number1 + ", 숫자2 : " + number2;
		
		response.getWriter().print(responseData);
		*/
		
		// AJAX를 활용해서 실제 값을 여러개 보내고 싶을 때 => 정석
		// => JSON(JavaScript Object Notation)
		// 데이터 전송 시 이용할 수 있는 포맷형식 중 하나
		// 자바스크립트 배열 객체 => [value, value, value]
		// 자바스크립트 일반 객체 => { key:value, key:value }
		
		/*
		 * JSON 처리 시 사용하는 클래스
		 * => 자바에서 기본적으로 제공 x (라이브러리가 필요)
		 * 
		 * https://code.google.com/archive/p/json-simple/downloads
		 * 
		 * jsom-simple-1.1.1.jar 다운로드 후 dev로 이동 -> WEB-INF/lib에 넣음
		 * 
		 * 1. JSONArray
		 * 2. JSONObject
		 * 
		 */
		
		// String responseData = "[" + number1 + "," + number2 + "]";
		
		JSONArray responseData = new JSONArray();
		// 요소 추가 => add
		
		responseData.add(number1);
		responseData.add(number2);
		
		
		
		// => text/html로 넘기게 되면 문자열의 형태로 [1, 2] 이 넘어가기 때문에
		// 응답하기 전 데이터의 컨텐트 타입을 json으로 지정해줘야함
		
		JSONObject obj = new JSONObject(); // { 키 : 밸류 }
		// 요소 추가 => put()
		obj.put("number1", number1); // { "number1" : number1 }
		obj.put("number2", number2); // { "number1" : number1, "number2" : number2 }
		
		response.setContentType("application/json; charset=UTF-8");
		
		response.getWriter().print(obj);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
