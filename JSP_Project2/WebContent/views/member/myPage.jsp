<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보조회</title>

<style>
	#update-form input{
		margin: 8px;
	}
</style>
</head>
<body>
	
	
	<jsp:include page="../common/menubar.jsp" />
	<c:set var="path" value="${ pageContext.request.contextPath }"/>
	
	<div class="outer">
		<br>
		<h2 align="center" >마이페이지</h2>
		
		<br>
		
		<form id="mypage-form" method="post" action="${ path }/update.me">
			<table align="center">
				<tr>
					<td>* 아이디</td>
					<td><input type="text" readonly maxlength="12" required name="userId" value="${ sessionScope.loginUser.userId }"></td>
					<td></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" maxlength="5" required name="userName" value="${ sessionScope.loginUser.userName }"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;전화번호</td>
					<td><input type="text" placeholder="-포함해서 입력해주세요." name="phone" value="${ sessionScope.loginUser.phone }"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;이메일</td>
					<td><input type="email" name="email" value="${ sessionScope.loginUser.email }"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;주소</td>
					<td><input type="text" name="address" value="${ sessionScope.loginUser.address }"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;취미</td>
					<td colspan="2">
						<input type="checkbox" id="travel" value="여행" name="interest"><label for="travel">여행</label>
						<input type="checkbox" id="lodge" value="숙박" name="interest"><label for="lodge">숙박</label>
						<input type="checkbox" id="movie" value="영화" name="interest"><label for="movie">영화</label>
						<br>
						<input type="checkbox" id="lent" value="차량대여" name="interest"><label for="lent">차량대여</label>
						<input type="checkbox" id="tea" value="다도" name="interest"><label for="tea">다도</label>
						<input type="checkbox" id="java" value="자바" name="interest"><label for="java">자바</label>
					</td>
				</tr>
			</table>
	
			<script>
				const interest ='${ sessionScope.loginUser.interest}';
				
				$('input[type=checkbox]').each(function() {
					if(interest.search($(this).val()) != -1){
						$(this).attr('checked', true);
					}
				});
			</script>
		
			<br><br>

			<div align="center">
				<button type="submit" class="btn btn-sm btn-info">정보수정</button>
				<button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#updatePwd" >비밀번호수정</button>
                <button type="button" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
			</div>

			<br><br>
			
		</form>
	</div>
	
	<!-- 비밀번호 변경 모달 -->
	<div class="modal" id="updatePwd">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">비밀번호 변경</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <!-- 현재 비밀번호, 변경할 비밀번호, 변경할 비밀번호 재입력 -->
	      <div class="modal-body">
	       <form action="${ path }/updatePwd.me" method="post">
			  <div class="form-group">
			    <label for="userPwd">현재 비밀번호 : </label>
			    <input type="password" name="userPwd" class="form-control" placeholder="비밀번호를 입력해주세요." id="userPwd" required>
			  </div>
			  
			  <div class="form-group">
			    <label for="changePwd">변경할 비밀번호 : </label>
			    <input type="password" name="changePwd" class="form-control" placeholder="변경할 비밀번호를 입력해주세요." id="changePwd" required>
			  </div>
			  
			   <div class="form-group">
			    <label for="checkpwd">변경할 비밀번호 확인 : </label>
			    <input type="password" class="form-control" placeholder="다시 한 번 입력해주세요." id="checkPwd" required>
			  </div>
			  
			  <button type="submit" class="btn btn-primary" onclick="return validatePwd();">비밀번호 변경</button>
			  
			  <input type="hidden" value="${ sessionScope.loginUser.userNo }" name="userNo">
			</form>
	      </div>
		 <script>
			function validatePwd(){
				//console.log($('#changePwd').val());
				// console.log($('#checkPwd').val());
				if($('#changePwd').val() != $('#checkPwd').val()){
					alert('비밀번호를 동일하게 입력해주세요!');
					$('#checkPwd').focus().val('');
					return false;
				}
				
				return true;
			}
		 </script>
	    </div>
	  </div>
	</div>
	
	<!-- 회원 탈퇴 모달  -->
	<div class="modal" id="deleteForm">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title" style="color:red;">회원탈퇴</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <!-- 현재 비밀번호, 변경할 비밀번호, 변경할 비밀번호 재입력 -->
	      <div class="modal-body">
	       <form action="${ path }/delete.me" method="post">
			  <div class="form-group">
			    <label for="userPwd" style="font-size:12px; color:red;">탈퇴를 원하신다면 비밀번호를 입력해주세요. </label>
			    <input type="password" name="userPwd" class="form-control" placeholder="비밀번호를 입력해주세요." id="deletePwd" required>
			  </div>
			  
			  <button type="submit" class="btn btn-primary" onclick="return deleteMember();">회원탈퇴</button>
			  
			  <input type="hidden" value="${ sessionScope.loginUser.userNo }" name="userNo">
			</form>
	      </div>
		 <script>
			function deleteMember() {
				const value = prompt('탈퇴를 원하신다면 "어쩌고저쩌고"를 정확히 입력해주세요.');
				
				if(value === '어쩌고저쩌고'){
					return true;
				}
				else {
					return false;
				}
				
			}
		 </script>
	    </div>
	  </div>
	</div>
	
	
</body>
</html>