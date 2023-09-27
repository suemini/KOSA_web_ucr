package com.kosa.ucr.course.dao;

import java.util.List;
import java.util.Map;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.exception.FindException;


public interface CourseRepository {
	/**
	 * 교수명으로 강의들을 검색한다
	 * @param proName
	 * @return 강의들
	 * @throws FindException DB와의 연결실패하면 예외발생한다
	 */
	List<Course> searchCourses(Map<String, String> params) throws FindException;
}
