package com.kosa.ucr.course.service;

import java.util.List;
import java.util.Map;

import com.kosa.ucr.course.dao.CourseOracleMybatisRepository;
import com.kosa.ucr.course.dao.CourseRepository;
import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.user.dto.Student;

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
	
	//searchByProfessor
	public List<Course> searchByProfessor(int proId) throws FindException{
		return repository.selectByProfessor(proId);
	}
	
	//searchByCourse
	public List<Student> searchByCourse(String coCode) throws FindException{
		return repository.selectByCourse(coCode);
	}
}
