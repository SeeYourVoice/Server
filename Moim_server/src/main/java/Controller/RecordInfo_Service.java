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

import model.RecordDAO;
import model.RecordDTO;

@WebServlet("/Moim_RecordInfoService")
public class RecordInfo_Service extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html; charset=utf-8");
		System.out.println("record Info service");
		
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();


		String rec_name =request.getParameter("rec_name");
		
		ArrayList<RecordDTO> rec_list = new ArrayList<RecordDTO>();

		// 녹음 리스트
		RecordDAO dao = new RecordDAO();

		rec_list = dao.recInfo(rec_name); 

		String jsonArr = gson.toJson(rec_list);
		out.print(jsonArr);
	
		}
	}

