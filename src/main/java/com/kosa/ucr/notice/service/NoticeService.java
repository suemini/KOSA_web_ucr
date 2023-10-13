package com.kosa.ucr.notice.service;

import java.util.List;

import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.notice.dao.NoticeOracleMybatisRepository;
import com.kosa.ucr.notice.dto.Notice;
import com.kosa.ucr.notice.dto.PageGroup;



public class NoticeService {
	private NoticeOracleMybatisRepository repository;
	private static NoticeService service = new NoticeService();
	private NoticeService() {
		repository = new NoticeOracleMybatisRepository();
	}
	public static NoticeService getInstance() {
		return service;
	}
	
	public PageGroup<Notice> findAll(int currentPage) throws FindException{
		if(currentPage < 1) {
			currentPage = 1;
		}
		
		int cntPerPage = 7; //한 페이지당 보여줄 목록 수
		//currentPage      //1  2  3  4
		int startRow = (currentPage - 1) * cntPerPage + 1;  //1  6  11  16
		int endRow = currentPage*cntPerPage;        //5  10  15  20
		//return repository.selectAll(startRow, endRow);
		
		List<Notice> list = repository.selectAll(startRow, endRow);
		int totalCnt = repository.selectCount();
		
		PageGroup<Notice> pg = new PageGroup<>(list, currentPage, totalCnt);
		return pg;
		
	}
	
	public Notice findByNoticeNo(String noticeNo) throws FindException{
		return repository.selectByNoticeNo(noticeNo);
	}
}
