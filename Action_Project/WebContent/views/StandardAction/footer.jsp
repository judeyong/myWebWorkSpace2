<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나는 푸터야</title>
</head>
<body>
	<%
		// Date date = new Date();
		// 오늘 날짜
		// 오늘 날짜 기준으로 년도만 뽑아서 채워넣어야함
		// => SimpleDateFormat
		String year = new SimpleDateFormat("yyyy").format(new Date());
	%>
	
	Copyright © 1998-<%= year %> KH Information Educational Institute All Right Reserved
	
	<br>
	
	01_include로 부터 전달받은 test라는 키값의 value ==> test : ${ param.test } <br>
	
</body>
</html>