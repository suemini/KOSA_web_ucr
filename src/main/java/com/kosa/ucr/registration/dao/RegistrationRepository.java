package com.kosa.ucr.registration.dao;

import java.util.List;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.exception.AddException;
import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.exception.RemoveException;
import com.kosa.ucr.registration.dto.PastCredits;

public interface RegistrationRepository {
	/***
	 * 학수번호와 학번으로 수강신청 강좌를 추가한다
	 * 
	 * @param coCode 학수번호
	 * @param stuId  학번
	 * @throws AddException DB연결 실패 또는 추가실패 시 예외발생
	 */
	void insertRegistration(String coCode, int stuId) throws AddException;

	/***
	 * 학수번호와 학번으로 수강신청 강좌를 제거한다
	 * 
	 * @param coCode 학수번호
	 * @param stuId  학번
	 * @throws RemoveException DB연결 실패 또는 제거실패 시 예외발생
	 */
	void deleteRegistration(String coCode, int stuId) throws RemoveException;

	/***
	 * 학번으로 수강신청 목록을 조회한다
	 * 
	 * @param stuId 학수번호
	 * @return 수강신청 목록
	 * @throws FindException DB연결 실패 또는 조회실패 시 예외발생
	 */
	List<Course> selectByRegistration(int stuId) throws FindException;

	/***
	 * 학번으로 학생의 과거학기 수강학점을 조회한다
	 * 
	 * @param stuId 학수번호
	 * @return 과거학점
	 * @throws FindException DB연결 실패 또는 조회실패 시 예외발생
	 */
	List<PastCredits> selectForPastCredit(int stuId) throws FindException;

	/***
	 * 학번, 학수번호, 강의요일과 시간으로 같은 과목이나 시간이 겹치는 과목을 신청한 게 있는지 조회한다
	 * 
	 * @param stuId  학번
	 * @param coCode 학수번호
	 * @param coDay  강의요일
	 * @param coTime 강의시간
	 * @throws FindException DB연결 실패 또는 조회실패 시 예외발생
	 */
	void selectRegiDupChk(String coCode, String coDay, String coTime, int stuId) throws FindException;

	/***
	 * 수강신청시 해당하는 학수번호의 regiCnt(수강신청인원)을 1 올려준다
	 * @param coCode 학수번호
	 * @throws AddException DB연결 실패 또는 업데이트 실패 시 예외발생
	 */
	void increaseRegiCnt(String coCode) throws AddException;

	/**
	 * 수강취소시 해당하는 학수번호의 regiCnt(수강신청인원)을 1 줄인다
	 * @param coCode 학수번호
	 * @throws RemoveException DB연결 실패 또는 제거실패 시 예외발생
	 */
	void decreaseRegiCnt(String coCode) throws RemoveException;
	
	/**
	 * 수강신청시 신청하려는 정원이 가능한지 확인한다
	 * @param coCode
	 * @return 가능하면 1이 나오고, 불가능하면 0이 나온다
	 * @throws AddException DB연결 실패 또는 업데이트 실패 시 예외발생
	 */
	int selectByRegiCnt (String coCode) throws FindException;
}
