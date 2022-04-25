package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.RecordDAO;
import model.RecordDTO;

@WebServlet("/Moim_insertRecService")
public class insertRecService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setContentType("text/html; charset=utf-8");
	      System.out.println("============Insert record service");
	
	      PrintWriter out = response.getWriter();
	      Gson gson = new Gson();
	      
	      String id =request.getParameter("id");
	      String position_num = request.getParameter("position_num");
	      String dept_seq = request.getParameter("dept_seq");
	      String rec_name =request.getParameter("rec_name");
	      
	      RecordDAO recordDAO=new RecordDAO();
	      RecordDTO recordDTO=new RecordDTO(id, position_num,dept_seq,rec_name);
	      //RecordDTO recordDTO=new RecordDTO("moim","원장","2","moim record");
	      
	      int cnt=recordDAO.insertRec(recordDTO);
	      
	      if(cnt>0) {
	    	  out.print("ok");
	      }else {
	    	  out.print("no");
	      }
	      
	}

}
