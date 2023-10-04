package com.kosa.ucr.user.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.user.dto.Professor;

public class ProfessorOracleMybatisRepository {
	private SqlSessionFactory sqlSessionFactory;

	public ProfessorOracleMybatisRepository() {
		String resource = "com/kosa/ucr/sql/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public Professor selectProfessorById(int id) throws FindException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			Professor p = (Professor)session.selectOne("com.kosa.ucr.User.ProfessorMapper.selectById", id);
			if(p != null) {
				return p;
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
