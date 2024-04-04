<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="qweqdw.js"></script>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

    <div class="outer">
        <br>
        <h2 align="center">사진게시글 작성하기</h2>
        <br><br>
      
        <form action="<%= contextPath %>/insert.image" 
         enctype="multipart/form-data" method="post" id="insert-form" style="width:800px; margin: auto;">
        
			<input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>" />
			
            <div class="form-group" >
                <label for="usr">제목</label>
                <input type="text" class="form-control" id="usr" name="title">
            </div>

            <div class="form-group">
                <label for="comment">내용</label>
                <textarea class="form-control" rows="15" id="comment" name="content" style="resize: none;"></textarea>
            </div>
            
            <div class="form-group"><br>
                <label>대표이미지</label>
                <img width=200 id="title-img" height=100 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNN3hRy0nlgs3vdfK8K9ARSZBEhAHG0WE3I442b83XVeA8FMxSqkGOQ-UNDgvF0_Ee3oA&usqp=CAU" alt="대표이미지" >
            </div>
            <div class="form-group"><br>
                <label>상세이미지-1</label>
                <img width=200 id="sub-img1" height=100 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnWxw3jNUlCANwrkQnX_euFG-KgdN4vu9WX7GSUSQMJs5aQSBI4e9XQJYTYjrVuy7RmFU&usqp=CAU" alt="상세이미지1" >
            </div>
            <div class="form-group"><br>
                <label>상세이미지-2</label>
                <img width=200 id="sub-img2" height=100 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6NC0ysKCCCZ6YsL5MrfHd0638U6dO2mQhGjONaMZntRtaosJcV3wkABTGLqaYaCQH6W0&usqp=CAU" alt="상세이미지2" >
            </div>
            <div class="form-group"><br>
                <label>상세이미지-3</label>
                <img width=200 id="sub-img3" height=100 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT43-2IhqB0D0pqy-XkDiwTBpz_T1SeWXNcGa9w2LaS_06UD5dkwGFtVxu_wz_n6hK5M-Y&usqp=CAU" alt="상세이미지3" >
            </div>

            <div id="file-area">
                <input type="file" name="file1" id="file1" required onchange="loadImg(this, 1);" >
                <input type="file" name="file2" id="file2" onchange="loadImg(this, 2);">
                <input type="file" name="file3" id="file3" onchange="loadImg(this, 3);">
                <input type="file" name="file4" id="file4" onchange="loadImg(this, 4);">
            </div>
            
            <!-- onchange : input태그의 내용물이 변경되었을때 발생하는 이벤트 속성 -->
            
            <script>
                function loadImg(inputFile, num){
                    // inputFile : 현재 변화가 생긴 <input type="file"> 요소 객체
                    // num : 몇 번 째 input요소인지 확인 후 해당 영역에 미리보기 하기위해 받음
                    // console.log(inputFile);
                    // console.log(inputFile.files);

                    // files속성 : 업로드된 파일의 정보를 가지고 있음
                    // inputFile.files.length : 파일을 첨부 1, 선택 취소 0
                    // 파일이 첨부되었을 경우에는 inputFile.files[0]에 선택된 파일의 정보가 있음

                    if(inputFile.files.length){ // 파일이 첨부
                        
                        // 선택된 파일을 읽어서 영역에 맞는 미리보기
                        // 파일을 읽어들일 FileReader객체 생성
                        
                        const reader = new FileReader();

                        // console.log(inputFile.files[0]);
                        // reader객체를 가지고 파일을 읽어들이는 메소드를 호출
                        
                        reader.readAsDataURL(inputFile.files[0]);
                        // 해당파일을 읽는 순간 파일만의 고유한 겂나긴 url이 만들어짐
                        // url을 src속성의 값으로 부여할 것

                        // 파일을 읽기가 완료되면 실행할 이벤트 핸들러 정의
                        reader.onload = function(e){

                            // e의 target => 이벤트가 발생한 친구
                            // console.log(e.target);
                            // e.target.result에 파일의 url에 담겨 있는
                            // 각 영역에 맞춰서 미리보기

                            switch(num){
                                case 1 : $('#title-img').attr('src', e.target.result); break;
                                case 2 : $('#sub-img1').attr('src', e.target.result); break;
                                case 3 : $('#sub-img2').attr('src', e.target.result); break;
                                case 4 : $('#sub-img3').attr('src', e.target.result); break;
                            }
                        }
                    }
                    else {
                        const str = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNN3hRy0nlgs3vdfK8K9ARSZBEhAHG0WE3I442b83XVeA8FMxSqkGOQ-UNDgvF0_Ee3oA&usqp=CAU";

                        switch(num){
                            case 1: $('#title-img').attr('src', str); break;
                            case 2: $('#sub-img1').attr('src', str); break;
                            case 3: $('#sub-img2').attr('src', str); break;
                            case 4: $('#sub-img3').attr('src', str); break;
                        }

                    }
                    
                }
                
                $(function(){
                	$('#file-area').hide();
                	
                	$('#title-img').click(function(){
                		$('#file1').click();	
                	});
                	
                	$('#sub-img1').click(function(){
                		$('#file2').click();	
                	})
                	
                	$('#sub-img2').click(function(){
                		$('#file3').click();	
                	})
                	
                	$('#sub-img3').click(function(){
                		$('#file4').click();	
                	})
                });
                
            </script>

            <div align="center">
                <button type="submit" class="btn btn-sm btn-info" >등록하기</button>
                <button type="button" class="btn btn-sm btn-secondary" 
                    onclick="history.back();" >뒤로가기</button>
            </div>
        </form>


    </div>
</body>
</html>