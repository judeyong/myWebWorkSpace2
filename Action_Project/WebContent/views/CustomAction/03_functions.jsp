<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	

	<!-- 오늘의 꼭 기억할 내용 : 주객전도 금지 -->
	
	
	
	<h1>JSTL Functions Library</h1>
	
	<p>
		functions 라이브러리는 따로 태그를 제공하지는 않음<br>
		EL구문안에서 메소드를 호출하는 형태로 사용 <br>
		주로 문자열과 관련된 메소드들을 제공함 <br>
		=> fn:메소드명(인자값) 형식으로 사용
	</p>
	
	<c:set var="str" value="how are you?" />
	
	str: ${ str } <br>
	
	문자열의 길이 : ${ fn:length(str) }글자 <br>
	문자열의 길이 : ${ str.length() }글자 <br>
	<!-- 문자열의 길이 뿐만 아니라 인자로 list타입을 제시하면 list의 사이즈도 반환 받을 수 있음 -->
	
	<%String javaStr = "How are you?";%>
	<%= javaStr.length()  %> <br>
	
	대문자로 출력 : ${ fn:toUpperCase(str) } <br>
	소문자로 출력 : ${ fn:toLowerCase(str) } <br>
	
	are의 시작 인덱스 : ${ fn:indexOf(str, 'are') }번째 <br>
	are의 were로 변환 : ${ fn:replace(str, 'are', 'were') } <br>
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>