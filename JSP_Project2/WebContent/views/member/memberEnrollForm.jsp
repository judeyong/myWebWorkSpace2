<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#enroll-form input{
		margin: 8px;
	}
</style>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center" >회원가입</h2>
		
		<form id="enroll-form" method="post" action="<%= contextPath %>/insert.me">
			<table align="center">
				<tr>
					<td>* 아이디</td>
					<td><input type="text" maxlength="12" required name="userId"></td>
					<td><button class="btn btn-sm btn-primary" type="button" onclick="idCheck();">중복확인</button></td>
					<!-- 중복확인 나중에 AJAX배우고 다음주..? -->
				</tr>
				<script>
					function idCheck(){
						const $userId = $('#enroll-form input[name=userId]');
						
						// AJAX 요청
						$.ajax({
							url: 'idCheck.do',
							data: {
								checkId : $userId.val()
							},
							// 성공시 콜백함수
							success : function(result){
								// console.log(result);
								// result 경우의 수 : "NNNNN" / "NNNNY"
								if(result == 'NNNNN'){ // 중복된 아이디
									alert('이미 존재하거나 탈퇴한 아이디 입니다.');
								
									$userId.val('').focus();
								}
								else {
									if(confirm('사용 가능한 아이디입니다. 사용하시겠습니까?')){
										// 아이디값은 변경 불가능 하도록 == readonly
										$userId.attr('readonly', true);
									}
									else {
										$('#enroll-form button[type=submit]').removeAttr('disabled');
									}
								}
								
							},
							
							// 실패시 콜백함수
							error : function(){
								console.log('AJAX 통신 실패!');
							}
							
							
						});
						
						
						
					}
				</script>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" maxlength="15" required name="userPwd"></td>
					<td></td>
				</tr>
				<tr>
					<td>* 비밀번호확인</td>
					<td><input type="password" maxlength="15" required></td>
					<td></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" maxlength="5" required name="userName"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;전화번호</td>
					<td><input type="text" placeholder="-포함해서 입력해주세요." name="phone"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;이메일</td>
					<td><input type="email" name="email"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;주소</td>
					<td><input type="text" name="address"></td>
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

			<br><br>

			<div align="center">
				<button type="reset" class="btn btn-sm btn-secondary">취소</button>
				<button type="submit" class="btn btn-sm btn-primary" disabled>회원가입</button>
			</div>

			<br><br>
			
		</form>
		
	</div>
	
</body>
</html>