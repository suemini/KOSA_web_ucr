package com.kosa.ucr.wishlist.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kosa.ucr.exception.AddException;
import com.kosa.ucr.wishlist.dto.Wishlist;

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
			Wishlist wl = new Wishlist();
			wl.setCoCode(coCode);
			wl.setStuId(stuId);
			session = sqlSessionFactory.openSession();
			session.insert("com.kosa.ucr.wishlist.WishlistMapper.insertWishlist", wl);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			throw new AddException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();				
			}
		}
	}
}
