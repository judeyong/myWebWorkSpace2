package com.kh.jsp.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.jsp.board.model.vo.Attachment;
import com.kh.jsp.board.model.vo.Board;
import com.kh.jsp.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/update.board")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1) POST => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 값 뽑기 전
		// multipart방식으로 잘 왔을 때만 내용이 수정되도록 조건
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 파일업로드
			
			// 1. 전송파일 용량 제한 int maxSize => 10MByte
			int maxSize = 1024 * 1024 * 10;
			
			// 2. 전송된 파일을 저장할 물리적인 경로 알아내기 String savePath
			String savePath = request.getSession()
					                 .getServletContext()
					                 .getRealPath("/resources/board_upfiles");
			
			// multipartRequest객체를 생성함으로 서버에 파일을 업로드
			MultipartRequest multiRequest =
					new MultipartRequest(
										request,
										savePath,
										maxSize,
										"UTF-8",
										new MyFileRenamePolicy());
			
			// ----------------------- 파일을 서버에 업로드
			
			// BOARD UPDATE
			// 2) 값 뽑기 => request / multiRequest
			String category = multiRequest.getParameter("category");
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			int boardNo = Integer.parseInt(multiRequest.getParameter("boardNo"));
			
			// VO 가공
			Board board = new Board();
			board.setCategoryNo(Integer.parseInt(category));
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setBoardNo(boardNo);
			
			// case 1. 첨부파일이 없었을 경우 => board UPDATE + at X
			// case 2. 첨부파일이 존재, 기존 첨부파일도 존재 => board UPDATE + at UPDATE
			// case 3. 첨부파일이 존재, 기존 첨부파일이 없는 경우 => board UPDATE + at INSERT
			
			
			// Attachment 객체 선언만
			// 실제 첨부파일이 존재할 경우에만 => 객체 생성
			
			Attachment at = null;
			
			if(multiRequest.getOriginalFileName("reupfile") != null) {
				
				// 새로운 파일명이 존재한다면 객체 생성 후 원본파일명, 수정파일명, 파일경로
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("reupfile"));
				at.setChangeName(multiRequest.getFilesystemName("reupfile"));
				at.setFilePath("resources/board_upfiles");
				// 여기까지가 새롭게 업로드한 첨부파일에 관한내용
			
				// name속성 = value 
				if(multiRequest.getParameter("fileNo") != null) {
					// 첨부파일이 존재 + 원본파일도 존재 => UPDATE ATTACHMENT => 원본 파일 번호가 필요
					
					
				} else {
					// 첨부파일이 존재 + 원본파일은 없음 => INSERT ATTACHMENT => 어떤게시글의 첨부파일인지 (REF_BNO)
					
				}
				
				
				
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
