<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>1. formatNumber 태그</h1>
	
	<p>
		숫자형 데이터의 형식을 지정<br>
		- 표현하고자 하는 숫자 데이터의 형식을 통화기호, %등 원하는 쓰임에 맞게 지정할 수 있는 태그 <br><br>
		
		[ 표현법 ]
		
		&lt;fmt:formatNumber value="출력한값" groupingUsed="true/false" type="percent/currency" /&gt;<br>
	</p>
	<br>
	<!-- 테스트할 속성 -->
	<c:set var="num1" value="123456789" />
	<c:set var="num2" value="0.75" />
	<c:set var="num3" value="50000" />
	
	<!-- 
		- Missing end tag for "c:set" : 태그를 안닫음
		- unknow tag (c:set) : 상단에 taglib지시어를 작성하지 않음
	 -->
	 
	 num1 : ${ num1 } <br>
	 formatNumber태그를 이용해서 출력 : <fmt:formatNumber value="${ num1 }" /> <br>
	 그냥 출력 : <fmt:formatNumber value="${ num1 }" groupingUsed="false" /> <br><br>
	 
	 num2의 경우 <br>
	 percent : <fmt:formatNumber value="${ num2 }" type="percent" /> <br><br>
	 
	 num3의 경우 <br>
	 currency : <fmt:formatNumber value="${ num3 }" type="currency" /> <br><br>
	 
	 <!-- 
	 	type="currency" : 통화(돈) 단위가 보여짐
	 				   	  현재 사용하고 있는 컴퓨터의 시스템에 따라서 단위가 정해짐
	 				   	  + groupingUsed속성의 기본값이 true이기 때문에 3자리마다 , 또 찍혀있음 
	  -->
	 
	 currency $ : <fmt:formatNumber value="${ num3 }" type="currency"  currencySymbol="상품가격 : " />
	 <!-- 
	 	currencySymbol : 통화기호 문자의 종류를 지정할 수 있음
	  -->
	 
	 <hr>
	 
	 <h3>2. formatDate 태그</h3>
	 
	 <p>
	 	날짜 및 시간 데이터의 포맷(형식)을 지정<br>
	 	단, java.util.Date클래스의 객체를 이용해야만 한다.
	 </p>
	 
	 <c:set var="current" value="<%= new java.util.Date() %>" />
	 
	 current 출력: ${ current } <br>
	 
	 <ul>
	 	<li>
	 		현재 날짜 : <fmt:formatDate value="${ current }"/>
	 		<!-- 
	 			type속성은 생략가능
	 			기본값은 type="date"
	 			년. 월. 일 출력
	 		 -->
	 	</li>
	 	<li>
	 		현재 시간 : <fmt:formatDate value="${ current }" type="time"/>
	 		<!-- type=time : 시간을 출력하겠다 -->
	 	</li>
	 	<li>
	 		현재 날짜 및 시간 : <fmt:formatDate value="${ current }" type="both"/>
	 		<!-- type=both : 둘 다 출력하겠다. -->
	 	</li>
	 	<li>
	 		medium : <fmt:formatDate value="${ current }" type="both" dateStyle="medium" timeStyle="medium"/>
	 	</li>
	 	<li>
	 		long : <fmt:formatDate value="${ current }" type="both" dateStyle="long" timeStyle="long" />
	 	</li>
	 	<li>
	 		full : <fmt:formatDate value="${ current }" type="both" dateStyle="full" timeStyle="full" />
	 	</li>
	 	<li>
	 		short : <fmt:formatDate value="${ current }" type="both" dateStyle="short" timeStyle="short"/>
	 	</li>
	 	<li>
	 		pattern : <fmt:formatDate value="${ current }" type="both" pattern="a HH:mm:ss yyyy//MM//dd(E)"/>
	 	</li>
	 </ul>
	 
	 <!-- 
	 	yyyy : 4자리 년도
	 	MM : 2자리 월
	 	dd : 2자리 일
	 	E : 요일
	 	a : 오전 / 오후
	 	HH : 2자리 시간 (24시간제)
	 	mm : 2자리 분
	 	ss : 2자리 초
	  -->
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
</body>
</html>