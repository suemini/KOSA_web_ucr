package com.kosa.ucr.sql;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {
	public static void selectTest(){
		//1. JDBC드라이버 설치    *JDBC드라이버(오라클제공,자바개발자용 압축 라이브러리파일)
				//2. 드라이버 클래스들을 JVM에 로드
				try {
					Class.forName("oracle.jdbc.OracleDriver"); //lib디렉토리에 있어서 못 찾음
					System.out.println("JDBC드라이버 로드성공");   //jdbc파일에서 빌드패스 들어가서 설정손봐줌
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					return;
				}
				
				//3. DB와 연결
				Connection conn = null;        //@ip주소:포트번호:서비스아이디
				String ur1 = "jdbc:oracle:thin:@localhost:1521:xe"; //thin과 oci드라이버가 있음
				String user = "ucr";
				String password = "ucr";
				try {
					conn = DriverManager.getConnection(ur1, user, password);
					System.out.println("DB와 연결성공"); 
				} catch (SQLException e) {
					e.printStackTrace();
					return;
				}
				
				/*//4. SQL문 DB에 송신하기
				Statement stmt = null;
				//5. SQL문 결과 수신하기
				ResultSet rs = null;
				try {
					stmt = conn.createStatement(); //일반 stmt
					int dId = 60; //부서번호
					String fn = "D";
					String selectSQL = "SELECT employee_id, first_name, hire_date, salary\r\n"
							+ "FROM employees\r\n"
							+ "WHERE department_id=" + dId                  //반드시 실행테스트 해서 확인!
							+ "AND SUBSTR(first_name, 1, 1)='" + fn + "'"; //java와 sql문법 구분 잘 하기
					rs = stmt.executeQuery(selectSQL); //송신, rs: 결과집합수신
					while(rs.next()) { //while(rs.next() == true){
						int eId = rs.getInt("employee_id");
						String eName = rs.getString(2); //인덱스를 쓰더라도 SQL인덱스 써야함//s.getString("first_name");
						Date eHdt = rs.getDate("hire_date");
						int eSal = rs.getInt("salary");
						System.out.println(eId + ":" + eName + ":" + eHdt + ":" + eSal);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//6. DB와 연결끊기(필수)
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
				}*/	
				
				//4. SQL문 DB에 송신하기
				PreparedStatement pstmt = null; //일반statement보다 권장
				//5. SQL문 결과 수신하기
				ResultSet rs = null;
				
				String selectSQL = "SELECT employee_id, first_name, hire_date, salary\r\n"
						+ "FROM employees\r\n"
						+ "WHERE department_id=?\r\n" //?(바인드변수)는 값의 위치에만 올 수 있다
						+ "AND SUBSTR(first_name, 1, 1) = ?";
				try {
					pstmt = conn.prepareStatement(selectSQL);
					pstmt.setInt(1, 60);
					pstmt.setString(2, "D");
					rs = pstmt.executeQuery();
					while(rs.next()) { //while(rs.next() == true){
						int eId = rs.getInt("employee_id");
						String eName = rs.getString(2); //인덱스를 쓰더라도 SQL인덱스 써야함//s.getString("first_name");
						Date eHdt = rs.getDate("hire_date");
						int eSal = rs.getInt("salary");
						System.out.println(eId + ":" + eName + ":" + eHdt + ":" + eSal);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					//6. DB와 연결끊기(필수)
					if(rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
						}
					}
					if(pstmt != null) {
						try {
							pstmt.close();
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
	

	public static void insertTest() {
		//2. JDBC드라이버 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//3. DB와 연결
		Connection conn = null; //interface라 객체생성불가
		String ur1 = "jdbc:oracle:thin:@172.30.1.1:1521:xe"; //DB사마다 드라이브 옵션이 다름
		String user = "ucr";
		String password = "ucr";
		try {
			conn = DriverManager.getConnection(ur1, user, password);
			//conn.setAutoCommit(false); //JDBC는 자동커밋이라 취소하고 싶을 시
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//4. SQL구문 송신
		PreparedStatement pstmt = null;
		String insertSQL = "INSERT INTO customer(id, pwd, name) VALUES (?,?,?)";
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, "id14");
			pstmt.setString(2, "p14");
			pstmt.setString(3, "isae");
			int rowcnt = pstmt.executeUpdate(); //executeUpdate는 수정된 횟수 반환
			System.out.println(rowcnt + "건 추가성공");
			//conn.commit(); //성공시 커밋
		} catch (SQLException e) {
			e.printStackTrace();
			//conn.rollback(); //실패시 롤백
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		//selectTest();
		insertTest();
	}
}
