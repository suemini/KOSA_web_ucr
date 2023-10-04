package com.kosa.ucr.sql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConnection {
	/**
	 * JDBC드라이버 로드 및 DB와 연결한다
	 * @return Connection객체를 반환한다
	 * @throws Exception 드라이버클래스를 찾지 못하거나 DB연결실패시 예외발생한다
	 */
	public static Connection getConnection() throws Exception {
		//JDBC드라이버로드
		Class.forName("oracle.jdbc.OracleDriver");	
		//DB연결
		String url = "jdbc:oracle:thin:@192.168.1.35:1521:xe"; //test전 본인 ip주소로 바꾸기
		String user = "ucr";
		String password = "ucr";
		return DriverManager.getConnection(url, user, password);
	
	}
	
	
	/**
	 *  DB와 연결을 닫는다
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		//DB연결해제
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}			
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}			
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
