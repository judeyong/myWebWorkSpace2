<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.jsp.notice.model.vo.Notice" %>

    <% 
    	ArrayList<Notice> list= (ArrayList<Notice>)request.getAttribute("noticeList");
    	
    	//for(Notice n : list){
    		//System.out.println(n);	
    	//}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<style>
.outer{
    width: 1000px;
    height: 800px;
    margin: auto;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
        <br>
        <h2 align="center">공지사항!</h2>
        <br>
        
        <!-- 관리자만 공지사항 작성 버튼이 보이게끔 -->
        <!-- 우리의 MEMBER 테이블은 1번회원이 관리자 -->
		<%if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
			
			<a class="btn btn-sm btn-info" href="<%= contextPath %>/insertForm.notice" >공지사항 작성</a>
			
		<%} %>        
        <table class="table table-hover">
            <thead>
              <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>조회수</th>
                <th>작성일</th>
              </tr>
            </thead>
            <tbody>
              <!-- 공지사항이 있을수도 있고 없을 수도 있음 -->
              <% if(list.isEmpty()) { %>
              	<tr>
              		<th colspan="5">공지사항이 존재하지 않습니다.</th>
              	</tr>
              <%} else {%>
              	
              	<%for(Notice n : list){ %>
              		<tr class="list">
              			<td><%= n.getNoticeNo() %></td>
              			<td><%= n.getNoticeTitle() %></td>
              			<td><%= n.getNoticeWriter() %></td>
              			<td><%= n.getCount() %></td>
              			<td><%= n.getCreateDate() %></td>
              		</tr>
              	<%} %>
              <%} %>
            </tbody>
        </table>
    </div>

	<script>
        
        // 1절 선택한 뒤 이벤트 부여
        $('tbody > tr.list').click(function(){
            //console.log('클릭!');
            
            // 2절 상세페이지 요청
            // console.log(location.href);
        	// location.href = 'http://www.naver.com';
            
        	// localhost:7777	/jsp/detail.notice
        	
        	
        	
        	// 클릭한 공지사항의 번호를 넘겨줘야 한다.
        	// console.log(this);
            // 이벤트의 발생한 tr요소의 자식중에서도 첫 번째 td요소의 Content영역의 값이 필요함
            
            const noticeNo = $(this).children().eq(0).text();

            // 공지사항번호를 이용한 요청
            // GET방식  : 요청할url?키=밸류&키=밸류&키=밸류
            // queryString
            // url을 직접 만들어서 보낼 것
            // /jsp/detail.notice?noticeNo=글번호
            location.href = '<%= contextPath %>/detail.notice?noticeNo=' + noticeNo;

        });
        
    
	</script>

</body>
</html>