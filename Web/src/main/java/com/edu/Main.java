package com.edu;

import java.util.HashMap;
import java.util.Map;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		String nameVal = "Choi";
		String ageVal = "25";
		String scoreVal = "85";
		
		MemberDAO dao = new MemberDAO();
		Map<String, String> map = new HashMap<String, String>();	
		map.put("name", nameVal);
		map.put("age", ageVal);
		map.put("score", scoreVal);
		
		dao.insertMember(map);
	}
}

//
//System.out.println("main method.");
//PreparedStatement psmt = null;
//Connection conn = null;
//ResultSet rs = null;
//try {
//	Class.forName("oracle.jdbc.driver.OracleDriver");
//	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "prj", "prj");
//	if (conn != null) {
//		System.out.println("정상수 백발백중 나는 명사수 연결.!");
//	}
//
//	//insert
//	psmt = conn.prepareStatement("insert into member values('Park' , 22, 85)");
//	int r = psmt.executeUpdate();
//	System.out.println(r + "건 입력.");
//	psmt.close();
//	
//	//select
//	psmt = conn.prepareStatement("select*from member");
//	rs = psmt.executeQuery();
//	while(rs.next()) {
//		System.out.println("이름 : " + rs.getString("name"));
//		System.out.println("나이 : " + rs.getInt("age"));
//		System.out.println("점수 : " + rs.getInt("score"));
//		
//	}
//	
//}
//
//catch (ClassNotFoundException | SQLException e) {
//	e.printStackTrace();
//} finally {
//	if(rs != null) {
//		try {
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}if (psmt != null) {
//		try {
//			psmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}if(conn != null) {
//		try {
//			conn.close();
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
