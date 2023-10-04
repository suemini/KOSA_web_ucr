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
	 * @param coCode 학수번호
	 * @param stuId 학번
	 * @throws AddException DB연결 실패 또는 추가실패 시 예외발생
	 */
	void insertRegistration(String coCode, int stuId) throws AddException;
	
	/***
	 * 학수번호와 학번으로 수강신청 강좌를 제거한다
	 * @param coCode 학수번호
	 * @param stuId 학번
	 * @throws RemoveException DB연결 실패 또는 제거실패 시 예외발생
	 */
	void deleteRegistration(String coCode, int stuId) throws RemoveException;
	
	/***
	 * 학수번호로 수강신청 목록을 조회한다
	 * @param stuId 학수번호
	 * @return 수강신청 목록
	 * @throws FindException DB연결 실패 또는 조회실패 시 예외발생
	 */
	List<Course> selectByRegistration(int stuId)throws FindException;

	/***
	 * 학수번호로 학생의 이번학기 수강학점을 조회한다
	 * @param stuId 학수번호
	 * @return 이번학기 수강학점
	 * @throws FindException DB연결 실패 또는 조회실패 시 예외발생
	 */
	List<PastCredits> selectForNowCredit(int stuId) throws FindException;
	
	/***
	 * 학수번호로 학생의 과거학기 수강학점을 조회한다
	 * @param stuId 학수번호
	 * @return 과거학점
	 * @throws FindException DB연결 실패 또는 조회실패 시 예외발생
	 */
	List<PastCredits> selectForPastCredit(int stuId) throws FindException;
}
