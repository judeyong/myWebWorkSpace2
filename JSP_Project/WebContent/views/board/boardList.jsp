<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.jsp.board.model.vo.Board, com.kh.jsp.common.model.vo.PageInfo"%>
<%
	ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("boardList");
	PageInfo pi = (PageInfo)request.getAttribute("pageInfo");	
	
	// 페이징바 만들 때 필요한 변수 미리 세팅
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();

	// System.out.println(pi);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>일반게시판</title>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
    <div class="outer">
        <div class="row">
           <div class="col-lg-1">
           </div>
           
           <div class="col-lg-10">
              <div class="panel-body">
              <h2 class="page-header"><span style="color: #ff52a0;">일반</span> 게시판
                 <a 
                 href="<%= contextPath %>/enrollForm.board" 
                 class="btn float-right" 
                 style="background-color: #ff52a0; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8"
                 >글쓰기</a>
              
              </h2>
                 <table class="table table-bordered table-hover">
                    <tr style="background-color: #ff52a0; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">
                       <th>#번호</th>
                       <th>카테고리</th>
                       <th>제목</th>
                       <th>작성자</th>
                       <th>조회수</th>
                       <th>작성일</th>
                    </tr>
                    <%if(boardList.isEmpty()) {%>
                    	<tr>
                    		<td colspan="6" style="color: #ff52a0;">조회된 게시글이 없습니다.</td>
                    	</tr>
                    <%} else {%>
                    	<%for(Board b : boardList){ %>
                    		<tr style="color: #ff52a0;" class="board" id="<%= b.getBoardNo() %>">
		                        <td><%= b.getBoardNo() %></td>
		                        <td><%= b.getCategoryName() %></td>
		                        <td style="color: orange;">
		                        	<%= b.getBoardTitle() %>
		                        </td>
		                        <td><%= b.getBoardWriter() %></td>
		                        <td><%= b.getCount() %></td>
		                        <td>
		                            <%= b.getCreateDate() %>
		                        </td>
	                    	</tr> 	
                    	<%} %>
                    <%} %>  
                 </table>
                                
              </div>            
           </div>
        </div>
        
        <script>
        	$(function(){
        		$('.board').click(function(){
        			location.href = '<%= contextPath %>/detail.board?boardNo=' + $(this).attr('id');
        		});
        			
        	})	
        </script>
        
        <div class="paging-area" align="center">
        	<%if(currentPage > 1){ %>
        		<button class="btn btn-sm btn-outline-danger" style="color: #ff52a0;"
				onclick=" location.href='<%= contextPath %>/boardList?currentPage=<%= currentPage - 1 %>' " >이전</button>
			<%} %>
			
        	<%for(int i = startPage; i <= endPage; i++){ %>
        		<% if(currentPage != i) { %>
        			<button class="btn btn-sm btn-outline-danger" style="color: #ff52a0;"
        			onclick=" location.href='<%= contextPath %>/boardList?currentPage=<%= i %>' " ><%= i %></button>
        		<%} else { %>
        			<button
        			class="btn btn-sm btn-danger"
        			style="color: #ff52a0;" 
        			disabled ><%= i %></button>
        		<%} %>
        	<%} %>
        	
        	<%if(currentPage != maxPage){ %>
        		<button class="btn btn-sm btn-outline-danger" style="color: #ff52a0;"
        		onclick=" location.href='<%= contextPath %>/boardList?currentPage=<%= currentPage + 1 %>' " >다음</button>
        	<%} %>
        </div>
        
     </div>
    <script>
    	
    </script>
</body>
</html>