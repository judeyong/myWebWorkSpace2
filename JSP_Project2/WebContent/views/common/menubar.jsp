<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.kh.jsp.member.model.vo.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>헤더</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	
	  <style>
	      .login-area {
	          float: right;
	      }
		.menu{
			width: 200px;
			height: 50px;
			display: table-cell;
		}
	
	.menu > a {
		display: block;
		width: 100%;
		height: 100%;
		text-decoration: none;
		color: black;
		font-weight: bold;
		font-size: 20px;
		line-height: 50px;
	}
	.menu > a:hover{
		font-size: 21px;
		background-color: lightslategray;
	}
	.outer{
		width: 1200px;
		height: auto;
		margin: auto;
		border: 1px solid lightpink;
		padding-top: 15px;
		padding-bottom: 15px;
		margin-top: 10px;
	}
	  </style>
    
</head>

<body>
	
	<c:if test="${ not empty alertMsg }">
		<script>	
			alert('${ alertMsg }');
			<c:remove var="alertMsg" scope="session" />
		</script>
	</c:if>
	
	<c:set var="path" value="${ pageContext.request.contextPath }" />
	
    <h1 align="center">대답을 잘하자</h1>

    <div class="login-area">
		<c:choose>
			<c:when test="${ empty sessionScope.loginUser }">
				<form action="${ path }/login" method="post">
				    <table>
				        <tr>
				            <th>아이디</th>
				            <td><input type="text" name="userId" required></td>
				        </tr>
				        <tr>
				            <th>비밀번호</th>
				            <td><input type="password" name="userPwd" required></td>
				        </tr>
				        <tr>
				            <th colspan="2">
				                <button type="submit" class="btn btn-sm btn-primary">로그인</button>
				                <button type="button" class="btn btn-sm btn-secondary" onclick="enrollPage();">회원가입</button>
				            </th>
				        </tr>
				    </table>
				</form>
				
				<script>
					function enrollPage() {			
						location.href = '${ path }/enrollForm.me';				
					}
				</script>
			</c:when>
			
			<c:otherwise>
				<div id="user-info">
		    		<span>${ sessionScope.loginUser.userName }</span>님 환영합니다.<br><br>
		    		<div>
		        		<a href="${ path }/myPage" class="btn btn-sm btn-primary" >마이페이지</a>
		        		<a href="${ path }/logout" class="btn btn-sm btn-secondary">로그아웃</a>
		    		</div>
				</div>
			</c:otherwise>
			
		</c:choose>
	</div>
	
	<br clear="both">
	
	<div class="nav-area" align="center">
		<div class="menu"><a href="${ path }">HOME</a></div>
		<div class="menu"><a href="${ path }/noticeList">공지사항</a></div>
		<div class="menu"><a href="${ path }/boardList?currentPage=1">일반게시판</a></div>
		<div class="menu"><a href="${ path }/thumbnailList">사진게시판</a></div>
	</div>
	
	


</body>

</html>