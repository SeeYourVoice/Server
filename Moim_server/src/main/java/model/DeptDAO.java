package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptDAO {
	
	Connection conn = null;
	
	PreparedStatement psmt = null;

	ResultSet rs = null;
	
	public void DBconn() { // DB열기
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

	public void DBclose() { // DB닫기
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
	
	

	// 부서 리스트
	public ArrayList<DeptDTO> deptdto () {

	ArrayList<DeptDTO> dept_name_list= new ArrayList<DeptDTO>(); 
	
	try {
		DBconn();
		
		// 사용자의 소속 회사 부서 리스트 출력 쿼리문
		String sql = "select dept_name, dept_seq from t_dept where corp_name in "
				+ "(select d.corp_name from t_dept d, t_user u where u.dept_seq = d.dept_seq)"; 

		psmt = conn.prepareStatement(sql);
		
		rs = psmt.executeQuery();
		
		while(rs.next()) {
			
			String dept_name = rs.getString(1); // 1번째 컬럼 "dept_name"
			int dept_seq = rs.getInt(2);
			
			DeptDTO deptDTO=new DeptDTO(dept_name, dept_seq);
			dept_name_list.add(deptDTO);
		
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
		
	}finally {
		DBclose();
	}
	
	return dept_name_list;
	}
}
