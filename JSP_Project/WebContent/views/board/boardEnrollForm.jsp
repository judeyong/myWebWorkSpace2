<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.jsp.board.model.vo.Category"%>
<%
	ArrayList<Category> list =  (ArrayList<Category>)request.getAttribute("categoryList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<% if(loginUser == null) {%>
		<script>
			alert('글 작성은 회원만 가능합니다.');
			location.href = "<%= contextPath %>";
		</script>
	<%} %>
	
	<div class="outer">
	
        <h2 align="center">게시글 작성하기</h2>
        <br><br> <!-- 파일 첨부 한 개 -->
        
        <form action="<%= contextPath %>/insert.board" method="post" id="insert-form"
        	enctype="multipart/form-data">
        <!-- 파일을 첨부하는 요청을 보낼 때는 반드시 form태그에다가 enctype="multipart/form-data"를 추가를 해줘야함 -->	
        <!-- 제목, 내용, 카테고리, 작성자, 제출버튼  + 첨부파일 -->
			<input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>" />
			
			<div class="form-group">
				<select name="category">
					<% for(Category c : list){ %>
						<option value="<%= c.getCategoryNo() %>" >
							<%= c.getCategoryName() %>
						</option>
					<%} %>
				</select>
			</div>
            <div class="form-group">
                <label for="usr">제목</label>
                <input type="text" class="form-control" id="usr" name="title">
            </div>

            <div class="form-group">
                <label for="comment">내용</label>
                <textarea class="form-control" rows="15" id="comment" name="content" style="resize: none;"></textarea>
            </div>
            
            <div class="form-group">
                <input type="file" name="upfile">
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