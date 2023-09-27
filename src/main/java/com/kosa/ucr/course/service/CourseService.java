package com.kosa.ucr.course.service;

import java.util.List;
import java.util.Map;

import com.kosa.ucr.course.dao.CourseOracleMybatisRepository;
import com.kosa.ucr.course.dao.CourseRepository;
import com.kosa.ucr.course.dto.Course;

public class CourseService {
	private CourseRepository repository;
	private static CourseService service = new  CourseService();
	private  CourseService() {
		repository = new  CourseOracleMybatisRepository();
	}
	
	public static  CourseService getInstance() {
		return service;
	}
	
	public List<Course> searchCourses(Map<String, String> params) throws Exception {
		return repository.searchCourses(params);
	}
}
