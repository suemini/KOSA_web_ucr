package com.kosa.ucr.user.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.user.dto.Professor;

public interface ProfessorRepository {
	/***
	 * 직번과 일치하는 교수를 불러온다
	 * @param id 직번
	 * @return 교수객체
	 * @throws FindException 직번에 해당하는 교수가 없거나 DB와의 연결실패하면 예외발생한다
	 */
	Professor selectProfessorById(String id) throws FindException;
	
	/***
	 * 입력된 정보와 모두 일치하는 정보를 가지고 있는 교수를 불러온다
	 * @param name 이름
	 * @param idenNum 주민번호
	 * @param phone 핸드폰번호
	 * @return 교수객체
	 * @throws FindException 입력된 정보와 일치하는 교수가 없거나 DB와의 연결실패하면 예외발생한다
	 */
	String selectProfessorByUserInfo(String name, String idenNum, String phone) throws FindException;

	
	/***
	 * 입력된 정보와 모두 일치하는 정보를 가지고 있는 교수를 불러온다
	 * @param id 직번
	 * @param name 이름
	 * @param idenNum 주민번호
	 * @param phone 핸드폰번호
	 * @return 교수객체
	 * @throws FindException 입력된 정보와 일치하는 교수가 없거나 DB와의 연결실패하면 예외발생한다
	 */
	String selectProfessorByIdInfo(String id, String name, String idenNum, String phone) throws FindException;
		
}
