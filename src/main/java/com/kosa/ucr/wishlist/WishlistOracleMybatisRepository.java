package com.kosa.ucr.wishlist;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kosa.ucr.wishlist.dao.WishlistRepository;

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
}
