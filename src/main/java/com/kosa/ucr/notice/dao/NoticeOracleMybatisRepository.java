package com.kosa.ucr.notice.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kosa.ucr.exception.FindException;
import com.kosa.ucr.notice.dto.Notice;

public class NoticeOracleMybatisRepository implements NoticeRepository {
	private SqlSessionFactory sqlSessionFactory;

	public NoticeOracleMybatisRepository() {
		String resource = "com/kosa/ucr/sql/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}
	
	public List<Notice> selectAll(int startRow, int endRow) throws FindException {
		SqlSession session = null;
		List<Notice> list = new ArrayList<>();
		try {
			session = sqlSessionFactory.openSession();
//			session.selectOne(); //return자료형이 <T>임 = selectSQL실행시 예상 실행결과가 최대 1개
			Map<String, Integer> map = new HashMap<>();
			map.put("start", startRow);
			map.put("end", endRow);
			list = session.selectList("com.kosa.ucr.Notice.NoticeMapper.selectAll", map); //return자료형이 <E>임 = 실행결과가 여러개
			return list;
		} catch (Exception e) {
//			e.printStackTrace();
			throw new FindException("공지사항이 없습니다");
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	public int selectCount() throws FindException {
		SqlSession session = null;	
		try {
			session = sqlSessionFactory.openSession();
			int count = session.selectOne("com.kosa.ucr.Notice.NoticeMapper.selectCount"); //autoUnboxing
			return count;
		} catch (Exception e) {
//			e.printStackTrace();
			throw new FindException("공지사항 조회 오류 발생! 관리자에게 문의하세요");
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	public Notice selectByNoticeNo(String noticeNo) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession(); //Conncection
			Notice n = session.selectOne("com.kosa.ucr.Notice.NoticeMapper.selectByNoticeNo", noticeNo);
//			Map<String, Object> parameters = new HashMap<>();
//	        parameters.put("noticeNO", noticeNo);
	        session.selectList("com.kosa.ucr.Notice.NoticeMapper.callIncreaseViewCount", noticeNo);
			if(n != null) {
				return n;
			} else {
				throw new FindException("공지사항 조회 오류 발생! 관리자에게 문의하세요");
			}			
		} catch(Exception e){
			throw new FindException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
}
