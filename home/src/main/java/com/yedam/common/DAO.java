package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	//Java로 작성된 데이터베이스 접속을 위한 DAO(Data Access Object) 클래스
	//이 클래스는 JDBC(Java Database Connectivity)를 사용하여 Oracle 데이터베이스에 접속하고 쿼리를 실행하는 기능을 제공
	//데이터베이스에 접속하여 쿼리를 실행하는 다른 클래스에서 상속받거나 포함하여 사용될 수 있음
	//데이터베이스 연결 및 종료에 대한 로직을 한 곳에서 관리하여 코드의 중복을 줄이고 유지보수를 쉽게 할 수 있도록 구성되어 있음
	
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;

	public void conn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //GRAM
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "jsp", "jsp");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	public void disCon() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
