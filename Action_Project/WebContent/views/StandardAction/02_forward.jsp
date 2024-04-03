<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>여기는 포워드 페이지야</h1>
	
	<jsp:forward page="footer.jsp" />
	
	<!-- 
		url로는 
		http://localhost:7777/action/views/StandardAction/02_forward.jsp
		가 찍혀있음
		
		jsp:forward : 화면 전환 태그
		특지 : url은 그대로고 화면만 바뀐다.
		
	 -->
	
	
	
</body>
</html>