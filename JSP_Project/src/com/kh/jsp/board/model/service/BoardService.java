package com.kh.jsp.board.model.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.commit;
import static com.kh.jsp.common.JDBCTemplate.getConnection;
import static com.kh.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.jsp.board.model.dao.BoardDao;
import com.kh.jsp.board.model.vo.Attachment;
import com.kh.jsp.board.model.vo.Board;
import com.kh.jsp.board.model.vo.Category;
import com.kh.jsp.board.model.vo.Reply;
import com.kh.jsp.common.model.vo.PageInfo;

public class BoardService {

	public int selectListCount() {
		Connection conn = getConnection();
		
		int result = new BoardDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<Board> selectList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Category> selectCategoryList() {
		Connection conn = getConnection();
		
		ArrayList<Category> list =  new BoardDao().selectCategoryList(conn);
		
		close(conn);
		
		return list;
	}
	
	public int insert(Board b, Attachment at) {
		
		Connection conn = getConnection();
		
		// Board 테이블에는 무조건 INSERT
		// ATTACHMENT는 있을때만 INSERT
		
		// 1) BOARD테이블에는 INSERT
		int boardResult = new BoardDao().insertBoard(conn, b);
		int attachmentResult = 1;
		
		// 2) ATTACHMENT 테이블에 INSERT
		if(at != null) {
			attachmentResult = new BoardDao().insertAttachment(conn, at);
		}
		
		// 3) 트랜잭션 처리
		// boardResult도 성공, attachmentResult도 성공이면 commit;
		// 둘 중 하나라도 실패했다. 무조건 rollback
		
		if((boardResult * attachmentResult) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return (boardResult * attachmentResult);
	}
	
	public int increaseCount(int boardNo) {
		Connection conn = getConnection();
		
		int result = new BoardDao().increaseCount(conn, boardNo);
		
		if(result > 0) commit(conn);
			
		close(conn);
		
		return result;
		
	}
	
	public Board selectBoard(int boardNo) {
		Connection conn = getConnection();
		
		Board board = new BoardDao().selectBoard(conn, boardNo);
		
		close(conn);
		
		return board;
	}
	
	public Attachment selectAttachment(int boardNo) {
		Connection conn = getConnection();
		
		Attachment at = new BoardDao().selectAttachment(conn, boardNo);
		
		close(conn);
		
		return at;
	}
	
	public int deleteBoard(int boardNo, int fileNo) {
		Connection conn = getConnection();
		
		BoardDao deleteBoard = new BoardDao();
		
		int deleteBoardNo = deleteBoard.deleteBoard(conn, boardNo);
		int deleteAttch = 1;
		
		if(fileNo > 0 && deleteBoardNo > 0) {
			deleteAttch = deleteBoard.deleteAttachment(conn, fileNo);
		}
		
		if((deleteBoardNo * deleteAttch) > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return deleteBoardNo;
	}
	
	public int updateBoard(Board board, Attachment at) {
		
		Connection conn = getConnection();
		
		// UPDATE BOARD
		int boardResult = new BoardDao().updateBoard(conn, board);
		
		// ATTACHMENT테이블과 관련된 작업
		
		int atResult = 1;
		// 첨부파일이 존재할 경우
		if(at != null) {
		
			if(at.getFileNo() != 0) {
				// UPDATE ATTACHMENT => 기존 첨부파일이 존재했을 경우
				int result = new BoardDao().updateAttachment(conn, at);
				
			} else {
				// INSERT ATTACHMENT => 기존 첨부파일이 없었을 경우
				atResult = new BoardDao().insertNewAttachment(conn, at);
			}
		}
		
		// 둘 다 성공했을 경우 commit
		if((boardResult * atResult) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return (boardResult * atResult);
		
	}
	
	public int insertThumbnailBoard(Board board, ArrayList<Attachment> list) {
		
		Connection conn = getConnection();
		
		// 한 개의 트랜잭션에 최소 2개 최대 5개의 INSERT수행 되어야함
		int boardResult = new BoardDao().insertThumbnailBoard(conn, board);
		
		int listResult = new BoardDao().insertAttachmentList(conn, list);
		
		if((boardResult * listResult) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return (boardResult * listResult);
	}
	
	public ArrayList<Board> selectThumbnailList(){
		
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectThumbnailList(conn);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Attachment> selectAttachmentList(int boardNo){
		
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new BoardDao().selectAttachmentList(conn, boardNo);
		
		close(conn);
		
		return list;
	}
	
	public int insertReply(Reply reply) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertReply(conn, reply);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public List<Reply> selectReplyList(int boardNo) {
		Connection conn = getConnection();
		
		List<Reply> list = new BoardDao().selectReplyList(conn, boardNo);
		
		close(conn);
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
