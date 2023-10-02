package com.kosa.ucr.course.dao;

import java.util.List;
import java.util.Map;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.user.dto.Student;


public interface CourseRepository {
	/**
	 * 교수명으로 강의들을 검색한다
	 * @param proName
	 * @return 강의들
	 * @throws FindException DB와의 연결실패하면 예외발생한다
	 */
	List<Course> searchCourses(Map<String, String> params) throws FindException;
	
	/***
	 * 직번으로 해당 교수의 이번학기 강좌목록을 조회한다
	 * @param proId 직번
	 * @return 교수의 강좌목록
	 * @throws FindException DB연결 실패 또는 조회실패 시 예외발생
	 */
	List<Course> selectByProfessor(int proId) throws FindException;
	
	List<Student> selectByCourse(String coCode) throws FindException;
}
