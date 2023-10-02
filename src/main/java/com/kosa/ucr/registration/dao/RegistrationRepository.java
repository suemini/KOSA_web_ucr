package com.kosa.ucr.registration.dao;

import com.kosa.ucr.exception.AddException;
import com.kosa.ucr.exception.RemoveException;

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
}
