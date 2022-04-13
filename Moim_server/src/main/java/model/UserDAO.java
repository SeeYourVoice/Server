package model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;

	//회원정보 저장용 객체
	UserDTO userDTO=null;

	
	
	//====================================================
	
	
	public void DBconn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "ai1_nmr_oracle";
			String dbpw = "smhrd123";
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DBclose() {
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	//====================================================
	
	//로그인 
	public UserDTO LoginDB(UserDTO dto) {
		
		
		System.out.println("id= "+dto.getUser_email());
		System.out.println("pw= "+dto.getUser_password());
		
		DBconn();
		
		//====쿼리문==== 
		String sql="select * from t_user where USER_EMAIL=? and USER_PASSWORD=?";
		try {
			System.out.println("dao 실행됨");
			psmt=conn.prepareStatement(sql);
		
			
			psmt.setString(1, dto.getUser_email());
			psmt.setString(2, dto.getUser_password());
			
			rs=psmt.executeQuery(); //쿼리문 실행
			
			if(rs.next()) { //로그인 성공
				String user_email=rs.getString("USER_EMAIL");
				String user_password=rs.getString("USER_PASSWORD");
				String first_name=rs.getString("FIRST_NAME");
				String last_name=rs.getString("LAST_NAME");
				String profile_img=rs.getString("PROFILE_IMG");	
				String user_joindate=rs.getString("USER_JOINDATE");	
	
				int dept_seq=rs.getInt("DEPT_SEQ");
				int position_num=rs.getInt("POSITION_NUM");
				
				userDTO=new UserDTO(user_email, user_password, first_name, last_name, 
						profile_img, user_joindate, dept_seq, position_num);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose();
		}
		
		
		return userDTO;
		
		
	}

	//이름수정
	
	public int Editname(String id,String fname, String lname) {
		DBconn();
		
		String sql="update t_user set first_name=?, last_name=? where user_email=?";
		System.out.println("edit name 실행됨");
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, fname);
			psmt.setString(2, lname);
			psmt.setString(3, id);
			
			cnt=psmt.executeUpdate(); 
			
			System.out.println(cnt+"안녕");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBclose();
		}
	
		return cnt;
	}
	
}
