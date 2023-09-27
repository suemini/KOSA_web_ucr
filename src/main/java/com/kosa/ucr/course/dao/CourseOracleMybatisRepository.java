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
}
