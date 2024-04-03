<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.kh.jsp.member.model.vo.Member" %>
<% Member loginUser=(Member)session.getAttribute("loginUser");
	// 로그인 전 : menubar.jsp가 로딩될 때 null
	// 로그인 성공 후 :menubar.jsp가 로딩될 때 필드에 회원의 정보가 담겨있는 Member객체의 주소값  
	
	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");
	// System.out.println(alertMsg);
	// 로그인 성공 전 : alerMsg == null
	// 로그인 성공 후 : alerMsg == 메시지문구 
	
 %>

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
	<script>
		// script태그 안에서도 스크립틀릿 같은 JSP요소를 사용할 수 있음	
		
		const msg = '<%= alertMsg %>';
		
		if(msg != 'null'){
			alert(msg);
			
			// menubar.jsp가 로딩 될 때 마다 alert이 계속 수행됨
			// session에 들어있는 alrertMsg키값에 해당하는 밸류값을 지워줄 것!
			// xx.removeAttribute("키값");
			<% session.removeAttribute("alertMsg"); %>
		}
		
	</script>
	
    <h1 align="center">대답을 잘하자</h1>

    <div class="login-area">

        <!-- 사용자가 로그인 전 보게 될 화면(아이디 입력란 / 비밀번호 입력란 / 로그인버튼 / 회원가입)

        <!-- 
    	=> http://localhost:7777/jsp/서블릿매핑값

    	form태그 내부에 존재하는 제출버튼(submit)클릭 시 form태그가 가지고 있는 속성 중
    	action속성에 작성된 url로 요청을 보내게됨(제출)

    	==> Controller(Servlet)을 호출한다고 생각하면 됨

    	* 경로 지정 방식
    	절대 경로 방식(/) : /Context Root/요청할 url	
                        localhost:포트번호 뒤에 action속성에 작성한 값이 붙으면서 요청

    	상대 경로 방식(요청할url) :/없이 요청할 url문구로 시작하는 경우
                                            현재 이 페이지에 보여지는 url경로 중에서
                                            마지막 / 로부터 뒤에 action속성의 값이 붙으면서 요청
		-->
		
		<%if(loginUser == null) {%>
		<!-- <form action="/login" method="post"> -->
		<form action="<%=contextPath%>/login" method="post">
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
				// 페이지 이동
				// localhost:7777/jsp/views/member/memberEnrollForm.jsp
				// location.href = '<%=contextPath%>/views/member/memberEnrollForm.jsp';
				// 프로젝트의 디렉토리 구조가 url에 노출됨 => 보안에 취약
				
				location.href = '<%= contextPath %>/enrollForm.me';
				// 단순한 정적페이지 요청이지만 Servlet을 경유해서 띄어줄 것
				// localhost:7777/jsp/매핑값
				// => url에 서블릿매핑값까지만 노출됨
				
			}
			
		</script>
		<%} else { %>
		<!-- 사용자가 로그인 성공 후 보게 될 화면-->
		<div id="user-info">
		    <span><%= loginUser.getUserName() %></span>님 환영합니다.<br><br>
		    <div>
		        <a href="<%= contextPath %>/myPage" class="btn btn-sm btn-primary" >마이페이지</a>
		        <!-- <a href="/jsp/logout">로그아웃</a> -->
		        <a href="<%= contextPath %>/logout" class="btn btn-sm btn-secondary">로그아웃</a>
		    </div>
		</div>
		<%} %>
		
	</div>
	
	<br clear="both">
	
	<div class="nav-area" align="center">
		<div class="menu"><a href="<%= contextPath %>">HOME</a></div>
		<div class="menu"><a href="<%= contextPath %>/noticeList">공지사항</a></div>
		<div class="menu"><a href="<%= contextPath %>/boardList?currentPage=1">일반게시판</a></div>
		<div class="menu"><a href="<%= contextPath %>/thumbnailList">사진게시판</a></div>
	</div>
	
	
	
	
	
















</body>

</html>