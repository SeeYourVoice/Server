package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Rec_VO;
import model.RecordDAO;
import model.RecordDTO;
import model.TextDAO;
import model.TextDTO;

@WebServlet("/Moim_RecordInfoService")
public class RecordInfo_Service extends HttpServlet {
   private static final long serialVersionUID = 1L;


   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      response.setContentType("text/html; charset=utf-8");
      System.out.println("============record Info service");
      
      PrintWriter out = response.getWriter();
      Gson gson = new Gson();
      String rec_name =request.getParameter("rec_name");
   
      //dto
      RecordDTO dto = new RecordDTO();
      TextDTO textDTO=new TextDTO();//
      
      System.out.println(rec_name);
      
      // 녹음 리스트 dao
      RecordDAO dao = new RecordDAO();
      TextDAO textDAO=new TextDAO(); //
     
      dto = dao.recInfo(rec_name); 
      textDTO= textDAO.justText(Integer.parseInt(dto.getRec_text_seq()));//

      //vo
      Rec_VO rec_VO=new Rec_VO(dto, textDTO); //
      
      String jsonArr = gson.toJson(rec_VO);
      out.print(jsonArr);
      }
   }
