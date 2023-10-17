package com.kosa.ucr.notice.dao;

import java.util.List;

import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.notice.dto.Notice;

public interface NoticeRepository {
	/***
	 * noticeNo의 시작행부터 끝행까지 공지사항을 불러온다
	 * @param startRow 시작행
	 * @param endRow 끝행
	 * @return 공지사항들
	 * @throws FindException DB와의 연결실패시 예외발생
	 */
	List<Notice> selectAll(int startRow, int endRow) throws FindException;
	
	/***
	 * noticeNo에 해당하는 공지사항을 불러온다
	 * @param noticeNo
	 * @return 공지사항
	 * @throws FindException
	 */
	Notice selectByNoticeNo(String noticeNo) throws FindException;
	
	
	
}
