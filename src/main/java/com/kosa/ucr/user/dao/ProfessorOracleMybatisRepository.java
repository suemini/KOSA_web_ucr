package com.kosa.ucr.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


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

	
	public Professor selectProfessorById(String id) throws FindException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			Professor p = (Professor)session.selectOne("com.kosa.ucr.User.ProfessorMapper.selectById", id);
			if(p != null) {
				return p;
			} else {
				throw new FindException("해당하는 직번이 없습니다");
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
	
	public String selectProfessorByUserInfo(String name, String idenNum, String phone) throws FindException{
		SqlSession session = null;
		try {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("name", name);
			paramMap.put("idenNum", idenNum);
			paramMap.put("phone", phone);
			session = sqlSessionFactory.openSession();
			String proId = session.selectOne("com.kosa.ucr.User.ProfessorMapper.selectByUserInfo", paramMap);
			if(proId != null) {
				return proId;
			} else {
				return "fail";
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
