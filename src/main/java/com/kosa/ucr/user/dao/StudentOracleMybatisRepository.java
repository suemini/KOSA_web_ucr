package com.kosa.ucr.user.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.user.dto.Professor;
import com.kosa.ucr.user.dto.Student;

public class StudentOracleMybatisRepository {
	private SqlSessionFactory sqlSessionFactory;

	public StudentOracleMybatisRepository() {
		String resource = "com/kosa/ucr/sql/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public Student selectStudentById(int id) throws FindException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			Student s = (Student)session.selectOne("com.kosa.ucr.user.StudentMapper.selectById", id);
			if(s != null) {
				return s;
			} else {
				throw new FindException("해당하는 아이디가 없습니다");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
	}

	

}
