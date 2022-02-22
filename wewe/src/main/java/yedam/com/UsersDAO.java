package yedam.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UsersDAO {
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "hr","hr");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");} 
		catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}

	
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("정상적으로 자원이 해제되지 않았습니다.");
		}
	}
	
	public List<User> selectAll() {
		List<User> list = new ArrayList<>();
		try {
			connect();
			String select = "SELECT * FROM employees ORDER BY employee_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User emp = new User();
				emp.setId(rs.getString("id"));
				emp.setPwd(rs.getString("pwd"));
				emp.setName(rs.getString("name"));
				emp.setHobby(rs.getInt("hobby"));
				emp.setGender(rs.getInt("gender"));
				emp.setReligion(rs.getInt("religion"));
				emp.setIntroduction(rs.getString("introduction"));

				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}
	
	public void insert(User emp) {
		try {
			connect();
			String insert = "INSERT INTO employees (id,pwd,name,hobby,gender,religion,introduction)"+" VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1,emp.getId());
			pstmt.setString(2,emp.getPwd());
			pstmt.setString(3,emp.getName());
			pstmt.setInt(4,emp.getHobby());
			pstmt.setInt(5,emp.getGender());
			pstmt.setInt(6,emp.getReligion());
			pstmt.setString(7,emp.getIntroduction());
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}

