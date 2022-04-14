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
	
	String position_name="";
	//회원정보 저장용 객체
	UserDTO userDTO=null;
	String[] arr=new String[2];
	
	
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
				position_name=searchPos(position_num);
				
				searchDept(dept_seq);
				String corp_name=arr[0];
				String dept_name=arr[1];
				
				
				
				userDTO=new UserDTO(user_email, user_password, first_name, last_name, profile_img, user_joindate, 
						corp_name, dept_seq, dept_name, position_num, position_name);
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
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBclose();
		}
	
		return cnt;
	}

	public int EditPw(String id, String pw) {
		
		DBconn();
		String sql= "update t_user set user_password =? where  user_email=?";
		
				try {
					psmt=conn.prepareStatement(sql);
					psmt.setString(1, pw);
					psmt.setString(2, id);
			
					cnt=psmt.executeUpdate(); 
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					DBclose();
				}
			
				return cnt;
	}

	public String searchPos(int pos_num) {
		
		
		DBconn();
		
		String sql="select POSITION_NAME from t_position where POSITION_NUM=?";
		
		try {
			psmt=conn.prepareStatement(sql);

			psmt.setInt(1, pos_num);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				position_name=rs.getString("POSITION_NAME");
				System.out.println(position_name);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBclose();
		}
		
		
		
		
		
		return position_name;
	}

	public void searchDept(int dept_seq) {

		DBconn();
		
		String sql="select CORP_NAME,DEPT_NAME from t_dept where DEPT_SEQ=?";
		
		try {
			psmt=conn.prepareStatement(sql);
			
			psmt.setInt(1, dept_seq);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				
				arr[0]=rs.getString("CORP_NAME");
				arr[1]=rs.getString("DEPT_NAME");
				
				
			}else {
				arr[0]="none";
				arr[1]="none";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBclose();
		}
		
		
	}
}

