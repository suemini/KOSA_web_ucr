package com.kosa.ucr.course.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.user.dto.Student;

public class CourseOracleMybatisRepository implements CourseRepository {
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
			students = session.selectList("com.kosa.ucr.user.dto.StudentMapper.selectByCourse", coCode);
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
