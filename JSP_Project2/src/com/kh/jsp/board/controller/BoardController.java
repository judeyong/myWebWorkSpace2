package com.kh.jsp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController {
	public String insert(HttpServletRequest requset, HttpServletResponse response) {
		
		String view = "views/board/boardList";
		
		// 1.포워딩
		// 2.리다이렉션
		return view;
	}
	public String select(HttpServletRequest requset, HttpServletResponse response) {
		
		return "";
	}
	
	public String update(HttpServletRequest requset, HttpServletResponse response) {
		
		return "";
	}
}
