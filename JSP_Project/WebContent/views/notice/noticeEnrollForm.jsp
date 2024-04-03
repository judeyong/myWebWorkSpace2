<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <h2 align="center">공지사항 작성하기</h2>
        <br><br>
        <!-- 
            get SELECT
            
            post INSERT

            put / fetch UPDATE
            
            delete DELETE
        -->
        <form action="<%= contextPath %>/insert.notice" method="post" id="insert-form">
        
			<input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>" />
			
            <div class="form-group">
                <label for="usr">제목</label>
                <input type="text" class="form-control" id="usr" name="title">
            </div>

            <div class="form-group">
                <label for="comment">내용</label>
                <textarea class="form-control" rows="15" id="comment" name="content" style="resize: none;"></textarea>
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