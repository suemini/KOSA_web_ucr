package com.kosa.ucr.course.dao;

import java.util.List;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.user.dto.Student;

public interface CourseRepository {
	/***
	 * 직번으로 해당 교수의 이번학기 강좌목록을 조회한다
	 * @param proId 직번
	 * @return 교수의 강좌목록
	 * @throws FindException DB연결 실패 또는 조회실패 시 예외발생
	 */
	List<Course> selectByProfessor(int proId) throws FindException;
	
	List<Student> selectByCourse(String coCode) throws FindException;
}
