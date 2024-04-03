<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.kh.jsp.board.model.vo.*, java.util.ArrayList" %>
<%
	Board board = (Board)request.getAttribute("board");
	ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br>

	<%@ include file="../common/menubar.jsp" %>

<div class="outer">
	<div class="container">
	
		<div class="row">
		  <div class="offset-lg-2 col-lg-8">
		    <div class="card">
		      <div class="card-header text-white" style="background-color: #ff52a0;"><%= board.getBoardNo() %></div>
		      <div class="card-body">     
		        
		          <div class="form-group">
		            <label>작성자</label>
		            <input type="text" class="form-control" name='writer' value="<%= board.getBoardWriter() %>" readonly>
		          </div>
		          
		          <div class="form-group">
		            <label>제목</label>
		            <input type="text" class="form-control" name='title' value="<%= board.getBoardTitle() %>" readonly>
		          </div>
		
		          <div class="form-group">
		            <label>내용</label>
		            <textarea class="form-control" rows="5" name='content' readonly style="resize:none;"><%= board.getBoardContent() %></textarea>
		          </div>
		
		          <div class="form-group" align="center">
		            <label style="display: block">대표 이미지</label>
						<img width="500px" height="500px" src="<%= contextPath %>/<%= list.get(0).getFilePath()%>/<%= list.get(0).getChangeName() %>" />
		          </div>
		         	<%for(int i = 1; i < list.size(); i++){ %>
		         		<div class="form-group" align="center">
		         			<label style="display: block" >상세 이미지 번호 <%= i %></label>
		         			<img width="500px" height="500px" src="<%= contextPath %>/<%= list.get(i).getFilePath() %>/<%= list.get(i).getChangeName() %>" />
		         		</div>
		         	<%} %>
		         	
		          <a class="btn" href="<%= contextPath %>/thumbnailList"
		      		style="background-color: #ff52a0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8"
		      		>목록</a>&nbsp;&nbsp;
		      		
		      </div>
		    </div>
		  </div>
		</div>
	</div>
</div>
</body>
</html>