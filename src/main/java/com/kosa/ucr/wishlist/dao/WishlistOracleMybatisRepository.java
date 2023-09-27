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
	public void insertWishlist(Wishlist wish) throws AddException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			session.insert("com.kosa.ucr.wishlist.WishlistMapper.insertWishlist", wish); //wishController, wishlistController 구분위해 wish.xml로 만듬
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
