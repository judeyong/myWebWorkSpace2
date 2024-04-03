package com.kh.jsp.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.jsp.board.model.service.BoardService;
import com.kh.jsp.board.model.vo.Attachment;
import com.kh.jsp.board.model.vo.Board;
import com.kh.jsp.common.MyFileRenamePolicy;
import com.kh.jsp.common.RequestTemplate;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.board")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// String file = request.getParameter("upfile");
		// System.out.println(file);
		// String userNo = request.getParameter("userNo");
		// System.out.println(userNo);
		
		// form태그로 요청을 보내는데 multipart/form-data방식으로 전송하는 경우
		// request.getParameter로는 값뽑기 불가능
		
		// http://www.servlets.com -> 라이브러리를 다운로드 받기
		// 파일 업로드를 위한 라이브러리 : com.oreilly.servlet
		// 					    cos.jar
		
		// 스텝 0) 요청이 multipart방식으로 잘 전송이 되었을 경우
		// 		 이후 요청 처리를 진행할 수 있도록 조건문 작성
		if(ServletFileUpload.isMultipartContent(request)) {
			// System.out.println("요청 잘옴!");
			
			// 스텝 1) 전송되는 파일을 처리할 작업
			// 1_1. 전송파일 용량 제한 
			
			/*
			 * 단위 정리
			 * 
			 * bit X 8 => Byte => KByte => MByte => GByte => TByte => PByte => ...
			 * 
			 * 10Megabyte
			 * 
			 * 1KByte = 1024Byte
			 * 
			 * 1Mbyte => 1024KByte => 1024* 1024Byte
			 * 
			 */
			int maxSize = 1024 * 1024 * 10;
			
			
			// 1_2. 전달된 파일을 저장할 서버의 폴더 경로를 알아내기 
			// getRealPath() => 인자값으로 WebContent로부터 board_upfiles폴더 까지의 경로를 문자열로 전달
			
			// HttpServletRequest
			// HttpSession
			// ServletContext
			
			HttpSession session = request.getSession();
			ServletContext app = session.getServletContext();
			String savePath =  app.getRealPath("/resources/board_upfiles/");

			// System.out.println(maxSize);
			// System.out.println(savePath);
			
			// 스텝 2). 서버에 업로드
			
			/*
			 * - HttpServletRequest request -> MutilpartRequest multipartrequest 객체로 반환
			 * 
			 * [ 표현법 ]
			 * MultipartRequest multiRequest
			 * = new MultipartRequest(request, savePath, maxSize, 인코딩, 파일명을 수정해주는객체);
			 * 
			 * MultiRequest객체를 생성하면 파일이 업로도됨!
			 * 
			 * 사용자가 올린파일명은 해당폴더에 그대로 업로드 하지않는것이 일반적
			 * 
			 * 파일명을 수정해주는 객체
			 * 
			 * Q) 파일명을 수정하는 이유?
			 * A) 같은 파일명이 있을 경우를 대비해서
			 * 	파일명에 한글 / 특수문자 / 공백문자가 포함된 경우 서버에 따라 문제가 발생할 수 있음
			 * 
			 * cos.jar => 기본적으로 파일명을 수정해주는 객체 FileRenamePolicy
			 * => 내부적으로 rename()호출하면서 파일명 수정
			 * => 기본적으로 동일한 파일명이 존재할 경우 뒤에 숫자를 카운팅해서 붙여줌
			 * 
			 * => bono.jpg, bono1.jpg, bono2.jpg
			 * 
			 * => 우리 입맛대로 파일명을 수정해서 파일명이 겹치지 않게끔 MyRenamePolicy라는 클래스를 만들었음
			 * 
			 */
			
			MultipartRequest multiRequest =
					new MultipartRequest(request, savePath, maxSize, "UTF-8",
										new MyFileRenamePolicy());
			
			// ------------------------ 파일업로드 ------------------------ 
			// 일반게시글작성과는 아무런 연관이 없음
			
			// 2) 값뽑기 (mutipart)
			String userNo = multiRequest.getParameter("userNo");
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			int categoryNo = Integer.parseInt(multiRequest.getParameter("category"));
			
			// 3) VO 객체로 가공 => 무조건 INSERT
			Board board = new Board();
			board.setBoardWriter(userNo);
			board.setBoardTitle(title);
			board.setBoardContent(content);
			board.setCategoryNo(categoryNo);
			
			// 3_2) 첨부파일의 경우 => 선택적
			Attachment at = null;
			
			// 첨부파일의 유무를 파악
			// multiRequest.getOriginalFileName("키값");
			// 첨부파일이 존재한다면 "원본파일명"/ 첨부파일이 존재 하지 않으면 null값을 반환
			
			if(multiRequest.getOriginalFileName("upfile") != null) {

				// 첨부파일이 있다 => VO객체로 가공
				
				at = new Attachment();
				// originName
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				
				// changeName
				// multiRequest.getFilesystemName("키값");
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				
				// filePath
				at.setFilePath("resources/board_upfiles");
				
			}
			
			// 4) 서비스 호출
			int result = new BoardService().insert(board, at);
			
			// 5) 응답화면 지정
			
			if(result > 0) { // 성공 => 일반 게시판 목록
				request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
				response.sendRedirect(request.getContextPath() + "/boardList?currentPage=1");
				
			} else { // 실패
				// 이미 업로드된 파일을 삭제
				if(at != null) {
					new File(savePath + at.getChangeName()).delete();
					
				}
				
				RequestTemplate.requestErrorMsg(request, response, "게시글 작성 실패");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
