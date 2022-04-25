package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TextDAO {
   Connection conn = null;

   PreparedStatement psmt = null;

   ResultSet rs = null;

   TextDTO textDTO =null;
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

   
   public TextDTO justText(int input_text_seq) {
      
      TextDTO justText = null;

         DBconn();
         String sql = "select REC_TEXT_SEQ,REC_TEXT,REC_FULLTEXT,REC_WORDCLOUD from t_record_text where rec_text_seq=?";

         try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, input_text_seq);

            rs = psmt.executeQuery();
            if (rs.next()) {
            	
            	int rec_text_seq=rs.getInt("REC_TEXT_SEQ"); 
               String rec_text=rs.getString("REC_TEXT");
               String rec_fulltext=rs.getString("REC_FULLTEXT");
               String wordcloud=rs.getString("REC_WORDCLOUD");
               
               
               justText=new TextDTO(rec_text_seq, rec_text, rec_fulltext, wordcloud);
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            DBclose();
         }
         return justText;
         
      }
}