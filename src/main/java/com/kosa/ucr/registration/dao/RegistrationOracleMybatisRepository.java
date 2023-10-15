package com.kosa.ucr.registration.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kosa.ucr.course.dto.Course;
import com.kosa.ucr.exception.AddException;
import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.exception.RemoveException;
import com.kosa.ucr.registration.dto.PastCredits;

public class RegistrationOracleMybatisRepository implements RegistrationRepository {
	private SqlSessionFactory sqlSessionFactory;

	public RegistrationOracleMybatisRepository() {
		String resource = "com/kosa/ucr/sql/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}

	@Override
	public void insertRegistration(String coCode, int stuId) throws AddException {
		SqlSession session = null;
		try {
			Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("coCode", coCode);
	        paramMap.put("stuId", stuId);
			session = sqlSessionFactory.openSession();
			session.insert("com.kosa.ucr.registration.RegistrationMapper.insertRegistration", paramMap);
			session.commit();
		} catch (Exception e) {
			session.rollback();
//			e.printStackTrace();
			throw new AddException(": 수강신청이 불가능합니다");
		} finally {
			if(session != null) {
				session.close();				
			}
		}
		
	}

	@Override
	public void deleteRegistration(String coCode, int stuId) throws RemoveException {
		SqlSession session = null;
		try {
			Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("coCode", coCode);
	        paramMap.put("stuId", stuId);
			session = sqlSessionFactory.openSession();
			session.delete("com.kosa.ucr.registration.RegistrationMapper.deleteRegistration", paramMap);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new RemoveException(": 수강취소가 불가능합니다");
		} finally {
			if(session != null) {
				session.close();				
			}
		}
		
	}

	@Override
	public List<Course> selectByRegistration(int stuId) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			List<Course> list = session.selectList("com.kosa.ucr.registration.RegistrationMapper.selectByRegistration", stuId);
	        if (list.isEmpty()) {
	            throw new FindException("수강강좌가 없습니다");
	        }
	        return list;
		} catch (Exception e) {
//			e.printStackTrace();
			throw new FindException("수강강좌가 없습니다");
//			return null;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}


	@Override
	public List<PastCredits> selectForPastCredit(int stuId) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			List<PastCredits> list = session.selectList("com.kosa.ucr.registration.RegistrationMapper.selectForPastCredits", stuId);
	        if (list.isEmpty()) {
	            throw new FindException("과거 수강학점 내역이 없습니다");
	        }
	        return list;
		} catch (Exception e) {
//			e.printStackTrace();
			throw new FindException("과거 수강학점 내역이 없습니다");
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public void selectRegiDupChk(String coCode, String coDay, String coTime, int stuId) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("coCode", coCode);
	        paramMap.put("coDay", coDay);
	        paramMap.put("coTime", coTime);
	        paramMap.put("stuId", stuId);
			List<Map<String, String>> list = session.selectList("com.kosa.ucr.registration.RegistrationMapper.selectRegiDupChk", paramMap);
	        if (!list.isEmpty()) {
	        	String gubun = list.get(0).get("gubun");
	        	if(gubun.equals("course")) {
	        		throw new FindException(": 이전에 신청한 과목과 같은 과목(학수번호)입니다");
	        	}else if(gubun.equals("time")) {
	        		throw new FindException(": 이전에 신청한 과목과 시간이 겹칩니다");
	        	}
	        }
		} catch (Exception e) {
//			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public void increaseRegiCnt(String coCode) throws AddException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			session.update("com.kosa.ucr.registration.RegistrationMapper.increaseRegiCnt", coCode);
			session.commit();
		} catch (Exception e) {
			session.rollback();
//			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	   @Override
	   public void decreaseRegiCnt(String coCode) throws RemoveException {
	      SqlSession session = null;
	      try {
	         session = sqlSessionFactory.openSession();
	         session.update("com.kosa.ucr.registration.RegistrationMapper.decreaseRegiCnt", coCode);
	         session.commit();
	      } catch (Exception e) {
	         session.rollback();
//	         e.printStackTrace();
	         throw new RemoveException(e.getMessage());
	      } finally {
	         if(session != null) {
	            session.close();            
	         }
	      }      
	   }

	@Override
	public Course selectByRegiCnt(String coCode) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			Course list = session.selectOne("com.kosa.ucr.registration.RegistrationMapper.selectByRegiCnt", coCode);
	        if (list.getCoLimit() <= list.getRegiCnt() ) {
	        	throw new FindException(": 정원이 마감되었습니다");	            
	        }else {
	        	return list;	        	
	        }
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

}
