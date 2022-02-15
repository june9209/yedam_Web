package com.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDAO extends DAO{
	// pstmt, conn, rs, connect(), disconnect()
	
	public List<Map<String, String>> getMemberList(){
		connect();
		List<Map<String, String>> list = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("name", rs.getString("name"));
				map.put("age", rs.getString("age"));
				map.put("score", rs.getString("score"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
		
	}
	
	public void insertMember(Map<String, String> map) {
		String sql = "insert into member values(?,?,?)";
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("name"));
			pstmt.setString(2, map.get("age"));
			pstmt.setString(3, map.get("score"));
			
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
	}
}
