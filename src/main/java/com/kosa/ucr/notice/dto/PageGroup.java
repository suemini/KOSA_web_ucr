package com.kosa.ucr.notice.dto;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

public class PageGroup<T> {
	public static final int CNT_PER_PAGE = 5;
	public static final int CNT_PER_PAGEGROUP = 5;
	private List<T> list; //List가 <>를 T로 바꿔서 재사용 가능하게 함
	private int totalCnt; //총상품수 11
	private int totalPage; //총페이지수 4
	private int currentPage; //현재페이지 1 2 3 4
	private int startPage; //시작페이지 1 1 3 3
	private int endPage;     //끝페이지 2 2 4 4
	
	public PageGroup(List<T> list, int currentPage, int totalCnt) {
		this.list = list;
		this.currentPage = currentPage;
		this.totalCnt = totalCnt;
		
		//총페이지수 계산
		if(totalCnt%CNT_PER_PAGE != 0) {
			this.totalPage = (totalCnt/CNT_PER_PAGE) + 1;
		}else {
			this.totalPage = totalCnt/CNT_PER_PAGE;
		}
		if(currentPage <= totalPage) {
			//시작페이지, 끝페이지 계산
			this.startPage = (currentPage - 1)/CNT_PER_PAGEGROUP*CNT_PER_PAGEGROUP + 1;
			this.endPage = startPage + CNT_PER_PAGEGROUP - 1;
			if(endPage > totalPage) {
				endPage = totalPage;
			}			
		}
	}
}
