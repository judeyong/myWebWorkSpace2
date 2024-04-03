<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.jsp.notice.model.vo.Notice" %>
<%
	Notice notice = (Notice)request.getAttribute("notice"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#detail-area{
		border : 1px solid lightpink;
		background: rgb(64,214,236);
		color: white;
		font-weight: bold;
	}
</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
    <div class="outer">
        <br>
        <h2 align="center">공지사항 상세보기</h2>
        <br><br>

        <table id="detail-area" align="center">
            <tr>
                <th width="90">제목</th>
                <td width="500" colspan="3"><%= notice.getNoticeTitle() %></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><%= notice.getNoticeWriter() %></td>
                <th>작성일</th>
                <td><%= notice.getCreateDate() %></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    <p style="height:200px"><%= notice.getNoticeContent() %></p>
                </td>
            </tr>
        </table>

        <br><br>

        <div align="center">
            <a href="<%=contextPath%>/noticeList" class="btn btn-sm btn-primary">목록으로</a>
            <!-- 작성자만 보이게끔 -->
            <!-- 로그인유저가 작성자와 같은지 -->
            <!-- 로그인 여부 판단 그리고 로그인유저의 이름이랑 공지사항의 작성자 <- 적합하지 않음 -->
            <!-- 새롭게 조회해온 USER_NO컬럼의 값을 가지고 비교-->
            <%if(loginUser != null && loginUser.getUserNo() == notice.getUserNo() ){ %>
                <a 
                  href="<%= contextPath %>/updateForm.notice?noticeNo=<%= notice.getNoticeNo() %>"
                  class="btn btn-sm btn-warning" >수정하기</a>
                <a 
                  class="btn btn-sm btn-danger"
                  href="<%= contextPath %>/delete.notice?noticeNo=<%= notice.getNoticeNo() %>"
                >삭제하기</a>
            <%} %>
            
        </div>


    </div>
</body>
</html>