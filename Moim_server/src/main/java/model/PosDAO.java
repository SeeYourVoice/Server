package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PosDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;

	//회원정보 저장용 객체

	PosDTO posDTO=null;

	
	
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

	
	public ArrayList<PosDTO> AllPos() {
		ArrayList<PosDTO> list=new ArrayList<PosDTO>();
		DBconn();
		
		String sql= "select * from t_position";
		try {
			psmt=conn.prepareStatement(sql);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				int posNum= rs.getInt("POSITION_NUM");
				String pos=rs.getString("POSITION_NAME");
				
				PosDTO posDTO=new PosDTO(posNum, pos);
				list.add(posDTO);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBclose();
		}
		
		return list;
	}
}
