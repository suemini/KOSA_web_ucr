package com.kosa.ucr.course.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.user.dto.Student;

public class CourseOracleMybatisRepository implements CourseRepository{
	private SqlSessionFactory sqlSessionFactory;

	public CourseOracleMybatisRepository() {
		String resource = "com/kosa/ucr/sql/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> searchCourses(Map<String, String> params) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			List<Course> list = session.selectList("com.kosa.ucr.course.SearchCourseMapper.searchCourses", params);
	        if (list.isEmpty()) {
	            throw new FindException("강좌가 없습니다");
	        }
//	        System.out.println(list.get(0).getCoCode() + ":" +    list.get(0).getCoMajorName());
	        return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException("강좌 검색 중 오류 발생: " + e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	@Override
	public List<Course> selectByProfessor(int proId) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			List<Course> courses = new ArrayList<>();
			courses = session.selectList("com.kosa.ucr.Course.ProfessorCourseMapper.selectByProfessor", proId);
			if (courses != null) {
//				for(Course course: courses) { //근데 또 line에서는 oderp이렇게 안받던데
//					Professor proName = course.getProName();
//					Major mName = course.getMName();
//				}
				return courses;
			} else {
				throw new FindException("강좌가 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Student> selectByCourse(String coCode) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			List<Student> students = new ArrayList<>();
			students = session.selectList("com.kosa.ucr.course.StudentListMapper.selectByCourse", coCode);
			if (students != null) {
				return students;
			} else {
				throw new FindException("학생이 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
	