<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.jsp.board.model.dao.BoardDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
		* CRUD : 대부분의 컴퓨터가 소프트웨어가 가지는 기본적인 데이터 처리 기능을 묶어서 일컫는 말
				사용자 인터페이스가 갖춰야 할 기능을 가리키는 용도로 사용됨
				
		- C : Create(생성)			=> INSERT
		- R : READ(읽기/인출)			=> SELECT
		- U : Update(갱신)			=> UPDATE
		- D : DELETE(파괴/삭제) 		=> DELETE
		
		* 회원 서비스
		로그인(R), 회원가입(C)-(아이디중복체크(R)), 마이페이지(R), 내정보변경(U), 회원탈퇴(D/U)
		
		* 공지사항 서비스
		공지사항목록조회(R), 공지사항상세조회(R), 공지시항작성(C), 공지사항수정(U), 공지사항삭제(D/U)
		
		* 일반게시판 서비스
		게시글목록조회(R)-페이징처리, 게시글상세조회(R), 게시글작성(C)-첨부파일 1개 업로드, 게시글수정(U), 게시글삭제(D/U)
		(댓글목록조회(R), 댓글작성(C))
		
		* 사진게시판 서비스
		사진게시판목록조회(R)-썸네일, 사진게시글상세조회(R), 사진게시글작성(C)-다중파일업로드
	-->

	<% com.kh.jsp.common.JDBCTemplate.getConnection(); %>

	<% new BoardDao(); %>
	
	<%@ include file="views/common/menubar.jsp" %>


















</body>
</html>