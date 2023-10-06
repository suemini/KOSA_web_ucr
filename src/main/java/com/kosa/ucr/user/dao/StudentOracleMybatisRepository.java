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

	
	public Student selectStudentById(String id) throws FindException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			Student s = (Student)session.selectOne("com.kosa.ucr.User.StudentMapper.selectById", id);
			if(s != null) {
				return s;
			} else {
				throw new FindException("해당하는 학번이 없습니다");
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


	public String selectStudentByUserInfo(String name, String idenNum, String phone) throws FindException{
		SqlSession session = null;
		try {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("name", name);
			paramMap.put("idenNum", idenNum);
			paramMap.put("phone", phone);
			session = sqlSessionFactory.openSession();
			String stuId = session.selectOne("com.kosa.ucr.User.StudentMapper.selectByUserInfo", paramMap);	
			if(stuId != null) {
				return stuId;
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
	
	public String selectStudentByIdInfo(String id, String name, String idenNum, String phone) throws FindException{
		SqlSession session = null;
		try {
			session =  sqlSessionFactory.openSession();
			Map<String, Object> paramMap =  new HashMap<>();
			paramMap.put("id", id);
			paramMap.put("name", name);
			paramMap.put("idenNum", idenNum);
			paramMap.put("phone", phone);
			String stuPwd = session.selectOne("com.kosa.ucr.User.StudentMapper.selectByIdInfo", paramMap);
			if (stuPwd != null) {
				return stuPwd;
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
