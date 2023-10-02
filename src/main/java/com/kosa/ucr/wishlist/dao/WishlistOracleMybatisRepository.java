package com.kosa.ucr.wishlist.dao;

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

public class WishlistOracleMybatisRepository implements WishlistRepository {
	private SqlSessionFactory sqlSessionFactory;

	public WishlistOracleMybatisRepository() {
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
	public void insertWishlist(String coCode, int stuId) throws AddException {
		SqlSession session = null;
		try {
			Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("coCode", coCode);
	        paramMap.put("stuId", stuId);
			session = sqlSessionFactory.openSession();
			session.insert("com.kosa.ucr.wishlist.WishlistMapper.insertWishlist", paramMap);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();				
			}
		}
	}

	@Override
	public void deleteWishlist(String coCode, int stuId) throws RemoveException {
		SqlSession session = null;
		try {
			Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("coCode", coCode);
	        paramMap.put("stuId", stuId);
			session = sqlSessionFactory.openSession();
			session.delete("com.kosa.ucr.wishlist.WishlistMapper.deleteWishlist", paramMap);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new RemoveException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();				
			}
		}
	}

	@Override
	public List<Course> selectByWishlist(int stuId) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			List<Course> list = session.selectList("com.kosa.ucr.wishlist.WishlistMapper.selectByWishlist", stuId);
	        if (list.isEmpty()) {
	            throw new FindException("희망강좌가 없습니다");
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
}
