<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String errorMsg = (String)request.getAttribute("errorMsg");
%>
<html>
<head>
<meta charset="UTF-8">
<title>서비스 실패 시 오는 곳..</title>

<style>
	h1{
		color : skyblue;
		margin-top : 80px;
		text-align : center;
		font-size : 33ox;
		font-weight : bold;
	}
</style>
</head>
<body>

	<%@ include file="menubar.jsp" %>
	
	<h1><%= errorMsg %></h1>


</body>
</html>