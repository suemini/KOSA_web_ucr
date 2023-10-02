package com.kosa.ucr.wishlist.dao;

import java.util.List;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.exception.AddException;
import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.exception.RemoveException;

public interface WishlistRepository {
	/***
	 * 학수번호와 학번으로 희망강좌를 추가한다
	 * @param coCode 학수번호
	 * @param stuId 학번
	 * @throws AddException DB연결 실패 또는 추가실패 시 예외발생
	 */
	void insertWishlist(String coCode, int stuId) throws AddException;
	
	/***
	 * 학수번호와 학번으로 희망강좌를 제거한다
	 * @param coCode 학수번호
	 * @param stuId 학번
	 * @throws RemoveException DB연결 실패 또는 제거실패 시 예외발생
	 */
	void deleteWishlist(String coCode, int stuId) throws RemoveException;
	
	/***
	 * 학수번호로 희망강좌 수강신청 목록을 조회한다
	 * @param stuId 학수번호
	 * @return 희망강좌 수강신청 목록
	 * @throws FindException DB연결 실패 또는 조회실패 시 예외발생
	 */
	List<Course> selectByWishlist(int stuId) throws FindException;
}
