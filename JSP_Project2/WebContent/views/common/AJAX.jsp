<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX.jsp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	
	<h1>AJAX</h1>
	
	<pre>
		Asynchronous JavaScript And XML의 약자로<br>
		서버로부터 데이터를 가져와서 전체 페이지를 다시 만드는 것이 아니라 일부만 내용물을 바꿀 수 있는 기법<br>
		
		참고로, 우리가 그동안 a태그 / form태그를 이용해서 요청한 방식은 동기식 요청 <br>
		=> 응답페이지가 돌아오고 전체 화면을 렌더링을 해야 결과를 확인할 수 있었음 <br>
		
		비동기 처리를 위해서는 우리가 AJAX라는 기술을 사용해야함! <br><br>
		
		* AJAX를 구현 방식 : JavaScript / JQuery / fetchAPI / axios...
		
		* 동기식 / 비동기식 요청 차이 <br>
		- 동기식 : 요청 처리 후 응답 HTML데이터가 돌아와야만 그 다음 작업이 가능 <br>
				만약 서버에서 응답페이지를 돌려주는 시간이 지연되면 무작정 기다리고 있어야함 <br>
				전체 화면이 새로고침 <br><br>

		- 비동기식 : 현재 페이지를 그대로 유지하면서 중간중간에 추가요청을 보낼 수 있음 <br>
				 요청을 보낸다고 해서 다른 페이지로 이동하는것이 아님 (현재 페이지가 그대로 유지) <br>
				 요청을 보내놓고 응답이 돌아올때까지 다른작업을 할 수 있음 <br><br>
		
		예) 예약, 중복확인, 검색어 자동완성 <br><br>
		
		* 비동기식 단점 <br>
		- 페이지 내 복잡도가 기하급수적으로 증가 => 에러 발생 시 디버깅이 어려움 <br>
		- 요청 후 돌아온 응답데이터를 가지고 현재 페이지에서 새로운 요소를 동적으로 만들어서 뿌려줘야함
		=> DOM요소를 새롭게 만드는 구문을 잘 익혀둬야함<br><br>
		
		* JQuery에서의 AJAX통식
		
		[ 표현식 ]
		$.ajax({
			속성명 : 속성값,
			속성명 : 속성값,
			속성명 : 속성값,
			...
		});
		
		* 주요 속성
		- url : 요청할 url(필수로작성) => form태그의 action속성
		- type : 요청 전송 방식(GET/POST 등등.. 생략 시 기본값은 get) => form태그의 method속성
		- date : 요청 시 전달한 값 ({ 키:밸류, 키:밸류 }) => form태그의 input요소의 value속성 같은것
		- success : AJAX통신 성공 시 콜백함수를 정의
		
		- error : AJAX통신 실패 시 콜백 함수를 정의
		- complete : AJAX통신 성공하든 실패하든 무조건 끝나면 실행할 콜백함수
		- async : 서버와 비동기 처리 방식 설정 여부 (기본값 true)
		
		
	</pre>
	z
	<hr>
	
	<h1>JQuery 방식을 이용한 AJAX테스트</h1>
	
	<h3>1. 버튼 클릭 시 GET방식으로 서버에 데이터 전송 및 응답</h3>
	
	입력 : <input id="input1" type="text" />
	<button id="btn1" >요청 버튼</button>
	
	<br> 
	
	응답 : <label id="result1">현재 응답 없음</label>
	
	<script>
		$('#btn1').click(function(){
			// console.log('click');
			// 동기식 요청 : location.href = '요청 url?쿼리스트링';
			
			// 비동기식 처리
			$.ajax({
				url : 'jqAjax1.do',
				data: {
					input: $('#input1').val()
				},
				type : 'get',
				success: function(result){
					// console.log('성공');
					console.log(result);
					$('#result1').text(result);
				},
				
			});
			
		});
	</script>
	
	<hr>
	
	<h3>2. Post방식으로 서버에 요청 및 응답</h3>
	
	숫자 1: <input type="text" id="input2_1"><br>
	숫자 2: <input type="number" id="input2_2"><br>
	<button onclick="ajaxTest2()">AJAX요청</button>
	
	<br>
	응답 : <label id="result2" >현재 응답 없음</label>
	응답 : <label id="result2_2" >현재 응답 없음</label>
	
	<script>
		function ajaxTest2(){
			// console.log(typeof($('#input2_1').val()));
			// console.log(typeof($('#input2_2').val()));
			// console.log(typeof([]));
			
			$.ajax({
				url : 'jqAjax2.do',
				type: 'post',
				data:{
					number1 : $('#input2_1').val(),
					number2 : $('#input2_2').val()
				},
				success : function(result){
					console.log(result);
					$('#result2').html('<span style="color:red">' + result['number1'] + "</span>");
					$('#result2_2').html('<span style="color:orange">' + result["number2"] + "</span>");
				},
				
				
			});
			
			
		}
	</script>
	
	<h3>3. 객체를 응답데이터로 받아보기</h3>
	
	게시글 번호 입력 : <input type="text" id="input3" >
	<button onclick="test3()">조회</button>
	
	<div id="output3">
	
	</div>
	
	<table id="output4">
		<thead>
			<tr>
				<th>게시글 번호</th>
				<th>게시글 제목</th>
				<th>게시글 내용</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	
	<script>
		function test3(){
			
			$.ajax({
				url : 'jqAjax3.do',
				data: {
					boardNo : $('#input3').val()
				},
				type: 'get',
				success : function(result){
					console.log(result);
					/*
					const resultStr = '게시글 번호 : ' + result.boardTitle + '<br>'
								    + '게시글 내용 : ' + result.boardContent + '<br>'		
									+ '조회수 : ' + result.count + '<br>';
									*/
					// $('#output3').html(resultStr);
									
					let resultStr = '';
					
					for(let i = 0; i < result.length; i++){
						resultStr += '<tr>'
									  + '<td>' + result[i].boardNo + '</td>'
									  + '<td>' + result[i].boardTitle + '</td>'
									  + '<td>' + result[i].boardContent+ '</td>'
								  + '</tr>';
					}
					
					$('#output4 tbody').html(resultStr);
					
				},
				
			})
			
			
		}
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>