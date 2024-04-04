package com.kh.jsp.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.jsp.board.model.service.BoardService;
import com.kh.jsp.board.model.vo.Attachment;
import com.kh.jsp.board.model.vo.Board;
import com.kh.jsp.common.MyFileRenamePolicy;
import com.kh.jsp.common.RequestTemplate;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ThumbnailInsertController
 */
@WebServlet("/insert.image")
public class ThumbnailInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post -> 인코딩
		
		// 01) 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 첨부파일 -> multipart/form-data => 조건제시 => 서버로 파일을 올려주자
		if(ServletFileUpload.isMultipartContent(request)) {
			// 1) multipartRequest객체 생성
			// 1_1. 전송용량 제한(10Mbyte)
			int maxSize = 1024 * 1024 * 10;
			
			// 1_2. 저장할 경로를 구해야함!
			String savePath = request.getServletContext()
							         .getRealPath("/resources/thumbnail_upfiles");
			
			// 2) MultipartRequest객체를 생성하면서 파일의 이름을 수정하면서 업로드!
			MultipartRequest multiRequest =
					new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// ---------------------------------------------------
			
			// 3) MultipartRequest로 부터 값 뽑기 => getParameter메소드 호출 
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			String userNo = multiRequest.getParameter("userNo");
			
			// 4) VO로 가공
			Board board = new Board();
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setBoardWriter(userNo);
			
			// Attachment => 사진게시판 작성 폼  메인이미지 required
			// => 게시글 한 개당 최소 한 갱의 첨부파일은 존재한다.
			// 여러 개의 VO를 묶어서 다룰 경우 LIST를 사용하면 편하지 않을까?
			ArrayList<Attachment> list = new ArrayList();
			
			/*
			if(multiRequest.getOriginalFileName("file1") != null) {
				Attachment at = new Attachment();
				at.setOriginName(originName);
				list.add(at);
			}
			if(multiRequest.getOriginalFileName("file2") != null) {
				Attachment at = new Attachment();
				at.setOriginName(originName);
				list.add(at);
			}
			// 반복됨
			*/
			
			// 키값 : file1 ~ file4
			for(int i = 1; i <= 4; i++) {
				// 키값만 미리 변수
				String key = "file" + i;
				
				// 현재 반복하고 있는 키값으로 파일이 업로드 된건지 파악
				if(multiRequest.getOriginalFileName(key) != null) { // 파일이 존재한다
					// 첨부파일 존재
					// 필드 : 원본이름, 바뀐이름, 파일경로
					Attachment at = new Attachment();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/thumbnail_upfiles");
					
					// 파일레벨
					if(i == 1) {
						// 대표이미지
						at.setFileLevel(1);
					} else {
						at.setFileLevel(2);
					}
					list.add(at);
					
				}
			}
			
			// 5) 서비스 요청
			int result = new BoardService().insertThumbnailBoard(board, list);
			
			// 6) 결과에 따른 응답 뷰 지정
			if(result > 0) {
				 request.getSession().setAttribute("alertMsg", "게시글 작성 성공");
				 response.sendRedirect(request.getContextPath() + "/thumbnailList");
			} else {
				RequestTemplate.requestErrorMsg(request, response, "게시글 작성 실패..");
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
