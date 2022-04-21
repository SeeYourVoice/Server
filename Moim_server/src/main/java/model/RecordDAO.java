package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordDAO {

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

	// ====================================================

	public RecordDTO recInfo(String input_rec_name) {

		RecordDTO record_list = new RecordDTO();

		
		System.out.println(input_rec_name);
		try {
			DBconn();

			// 사용자의 소속 회사 부서 리스트 출력 쿼리문
			String sql = "select * from t_record where rec_name = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, input_rec_name);

			rs = psmt.executeQuery();

			if (rs.next()) {
				System.out.println("dao 여깄어요~");
				String rec_seq = rs.getString(1);
				String user_email = rs.getString(2);
				String rec_date = rs.getString(3);
				String rec_text_seq = rs.getString(4);
				String position_num = rs.getString(5);
				String rec_wordcloud = rs.getString(6);
				String dept_seq = rs.getString(7);
				String rec_name = rs.getString(8);

				record_list = new RecordDTO(rec_seq, user_email, rec_date, rec_text_seq, position_num, rec_wordcloud,
						dept_seq, rec_name);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBclose();
		}

		return record_list;
	}

	// 부서별 회의 리스트
	public ArrayList<RecordDTO> recorddto(int user_dept_seq) {

		ArrayList<RecordDTO> record_list = new ArrayList<RecordDTO>();

		try {
			DBconn();

			// 사용자의 소속 회사 부서 리스트 출력 쿼리문
			String sql = "select rec_name, rec_date from t_record where dept_seq = ("
					+ "select dept_seq from t_dept where dept_seq = ?)"; // ?

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, user_dept_seq);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String rec_date = rs.getString("rec_date");
				String rec_name = rs.getString("rec_name");

				RecordDTO rec_list_dto = new RecordDTO(rec_date, rec_name);

				record_list.add(rec_list_dto);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBclose();
		}

		return record_list;
	}

	// ====================================================

	// 화자분리 text 불러오는 dao
	public String justText(int rec_text_seq) {
		String justText = "";

		DBconn();
		String sql = "select REC_TEXT from t_record_text where rec_text_seq=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rec_text_seq);

			rs = psmt.executeQuery();
			if (rs.next()) {
				justText = rs.getString("REC_TEXT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return justText;

	}

	// ====================================================

	// 전체 텍스트 불러오는 dao

	public String fullText(int rec_text_seq) {
		String fullText = "";

		DBconn();
		String sql = "select REC_FULLTEXT from t_record_text where rec_text_seq=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rec_text_seq);

			rs = psmt.executeQuery(sql);
			if (rs.next()) {
				fullText = rs.getString("REC_FULLTEXT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fullText;

	}

}
