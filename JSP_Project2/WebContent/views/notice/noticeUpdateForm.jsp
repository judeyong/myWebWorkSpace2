<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.jsp.notice.model.vo.Notice" %>
<%
	Notice notice = (Notice)request.getAttribute("notice");    	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #insert-form{
        width: 800px;
        margin: auto;
    }
    label{
        font-weight: bold;
    }
</style>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
        <br>
        <h2 align="center">공지사항 수정하기</h2>
        <br><br>
        
        <form action="<%= contextPath %>/update.notice" method="post" id="insert-form">
        	<input type="hidden" name="noticeNo" value="<%= notice.getNoticeNo() %>" />
            <div class="form-group">
                <label for="usr">제목</label>
                <input type="text" class="form-control" id="usr" value="<%= notice.getNoticeTitle() %>" name="noticeTitle">
            </div>

            <div class="form-group">
                <label for="comment">내용</label>
                <textarea class="form-control" rows="15" id="comment" name="noticeContent" style="resize: none;"><%= notice.getNoticeContent() %></textarea>
            </div>

            <div align="center">
                <button type="submit" class="btn btn-sm btn-info" >등록하기</button>
                <button type="button" class="btn btn-sm btn-secondary" 
                    onclick="history.back();" >뒤로가기</button>
            </div>
        </form>

    </div>
	
</body>
</html>