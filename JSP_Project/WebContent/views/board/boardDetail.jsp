<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.jsp.board.model.vo.*" %>
    <%
    	Board board = (Board) request.getAttribute("board");
    	Attachment at = (Attachment)request.getAttribute("attachment");
    	String newUrl = "";
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<br/><br/>

	<%@ include file="../common/menubar.jsp" %>

<div class="outer">
	<div class="container">
	
		<div class="row">
		  <div class="offset-lg-2 col-lg-8">
		    <div class="card">
		      <div class="card-header text-white" style="background-color: #ff52a0;"><%= board.getBoardNo() %></div>
		      <div class="card-body"> 
		
		
		          <div class="form-group">
		            <label>카테고리</label><br>
		            <span><%= board.getCategoryName() %></span>
		          </div>      
		        
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
		
		          <div class="form-group">
		            <label>첨부파일</label>
		            <!-- 첨부파일은 있을수도있음 -->
					<%if(at != null){ %>
						<!-- /jsp/resources/board_upfiles/changeName -->
						
						<a
						 download="<%= at.getOriginName() %>" 
						 href="<%= contextPath %>/<%= at.getFilePath() %>/<%= at.getChangeName() %>"
						><%=at.getOriginName() %></a>
						
						<img src="<%= contextPath %>/<%= at.getFilePath() %>/<%= at.getChangeName() %>" >
						
						<%
							newUrl = "&fileNo=" + at.getFileNo();
							// System.out.println(newUrl);						
						%>
					<%} else {%>
						<!-- 첨부파일은 없을수도있음 -->
						&nbsp;&nbsp;<span>첨부파일이 존재하지 않습니다.</span>
					<%} %>
		            
		          </div>
		         
		          <a class="btn" href="<%= contextPath %>/boardList?currentPage=1"
		      		style="background-color: #ff52a0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">목록</a>&nbsp;&nbsp;
		      		
		      		<%if(loginUser != null && loginUser.getUserId().equals(board.getBoardWriter())){ %>
			          <a class="btn" href="<%= contextPath %>/updateForm.board?boardNo=<%= board.getBoardNo() %>"
			      	  style="background-color: orange; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">수정</a>&nbsp;&nbsp;
			      		
			      		<%
			      			String url = contextPath + "/delete.board?boardNo=" + board.getBoardNo() + newUrl;
			      		%>
			      		
			      		<a class="btn" href="<%= url %>" onclick="return confirm('정말로 삭제하시겠습니까?')"
			      	     style="background-color: red; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">삭제</a>&nbsp;&nbsp;
			          
		       		<%} %>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div id="reply-area">
			
			<table border="1" align="center">
				<thead>
					<tr>
						<th>댓글작성</th>
						<% if(loginUser != null) { %>
							<td>
								<textarea id="replyContent" cols="50" rows="3" style="resize:none;"></textarea>
							</td>
							<td><button onclick="insertReply();">댓글등록</button></td>
						<% } else { %>
							<td>
								<textarea readonly cols="50" rows="3" style="resize:none;">로그인 후 이용가능한 서비스입니다.</textarea>
							</td>
							<td><button>댓글등록</button></td>
						<% } %>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
			<br><br><br><br>
	    </div>
		
	</div>
	
	<script>
		function selectReplyList(){
			// Servlet요청 Ajax로 보내서 조회
			
			$.ajax({
				url : 'replyList.do',
				data: {
					// 문자 보낼떄는 ''에 감쌓서 보낸다.
					boardNo : <%= board.getBoardNo() %>,
				},
				success : function(result){
					let resultStr = '';
					for(let i in result){
						resultStr += '<tr>'
								   + '<td>' + result[i].replyWriter + '</td>'
								   + '<td>' + result[i].replyContent + '</td>'
								   + '<td>' + result[i].createDate + '</td>'
								   + '</tr>'
					};
					$('#reply-area tbody').html(resultStr);
				},
				
				error : function(e){
					console.log(e);
				}
			});
			
		}
	
		// 제이쿼리 온로딩
		$(function(){
			selectReplyList();
		});
	
	
		function insertReply(){
			$.ajax({
				url: 'replyInsert.do',
				type: 'post',
				data:{
					content: $('#replyContent').val(),
					boardNo: <%= board.getBoardNo() %>
				},
				success : function(result){
					console.log(result);
					
					if(result == 'success'){
						$('#replyContent').val('');
						selectReplyList();
					}
				}
			});
			
		}
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</div>
</body>
</html>