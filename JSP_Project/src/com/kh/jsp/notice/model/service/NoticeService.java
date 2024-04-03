package com.kh.jsp.notice.model.service;

import java.util.ArrayList;

import com.kh.jsp.notice.model.vo.Notice;

public interface NoticeService {
	
	// 공지사항목록조회(R)
	ArrayList<Notice> selectNoticeList();
	
	// 공지사항상세조회(R)
	Notice selectNotice(int noticeNo);
	
	// 공지사항작성(C)
	
	
}
