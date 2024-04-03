<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, com.kh.jsp.board.model.vo.Board" %>
    <%
    	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.list-area{
		text-align: center;
	}
	
	.thumbnail{
		box-shadow: 2px 2px 4px lightgray;
		width: 300px;
		padding: 12px;
		margin: 25px;
		display:inline-block;
		background-color: lightblue;
		font-weight: bold;
		border-radius: 12px;
	}
	
	.thumbnail > img {
		width: 250px;
		height: 180px;
		margin-botton: 8px;
		border-radius: 12px;
	}
	
	.thumbnail:hover {
		cursor:pointer;
		opacity: 0.8;
	}	
	
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<div style="margin-top: 15px; width: 400px; height: 280px; margin: auto;" >
			<img width=400 height=280 src="https://i.namu.wiki/i/uwHGKFJAZTgXlnja_ul4Z-myJ1KUyA32HL9mOw69w9c3-KRKwb6S0Sk5EtuE_cRWoES5QIUORWgXHH6oJleBMA.webp" >
		</div>
		
		<%if(loginUser != null) {%>
			<div style="align:right">
				<a class="btn btn-sm btn-primary" style="color:black; background-color: lightblue; border:none;'"
				   href="<%= contextPath %>/enrollForm.imageBoard"
				>글작성</a>
			</div>
		<%}  %>
		
		<div class="list-area">
		<%if(list.isEmpty()){ %>
			등록된 게시글이 존재하지 않습니다. <br>
		<%} else { %>
			<% for(Board b : list){ %>
				<div class="thumbnail" align="center">
					<input type="hidden" value="<%= b.getBoardNo() %>">
					<img src="<%= b.getTitleImg() %>" />
					<p>
						<!-- <label>No. <%= b.getBoardNo() %></label>/ -->
						<span style="font-size: 17px;"><%= b.getBoardTitle() %></span><br>
						<label>조회수</label> : <span><%= b.getCount() %></span>
					</p>
				</div>
			<%} %>
			
		<%} %>
		<script>
			$(function(){
				$('.thumbnail').click(function(e){
					// 클릭 할 때 마다 url요청 => location.href
					// console.log($(this).children().eq(1).children().eq(0).text().split(' ')[1]);
					// console.log($(this).children().eq(0).val());
					
					const boardNo = $(this).children().eq(0).val();
					location.href='<%= contextPath %>/detail.image?boardNo=' + boardNo;
					
				});
				
				
			});
		</script>
		
			<!-- 
			<div class="thumbnail" align="center">
				<img src="https://cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/UVBJZL3RXAB36BDSHVM3MW2WNY.jpg" >
				<p>
					<label>No.1</label> / <span>개구리 페페</span><br>
					<label>조회수</label> : <span>200</span>
				</p>
			</div>
			 -->
		</div>
		
	</div>

</body>
</html>