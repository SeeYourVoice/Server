package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.DeptDAO;
import model.RecordDAO;
import model.RecordDTO;

@WebServlet("/Moim_RecordService")
public class RecordService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html; charset=utf-8");
	
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		System.out.println("========= 녹음 리스트  전송 서비스  =========");


		int dept_seq=Integer.parseInt(request.getParameter("dept_seq"));
		//System.out.println(dept_seq);
		ArrayList<RecordDTO> rec_list = new ArrayList<RecordDTO>();

		// 녹음 리스트
		RecordDAO dao = new RecordDAO();

		rec_list = dao.recorddto(dept_seq);// 유저의 부서 seq를 넘겨줌. 

		String jsonArr = gson.toJson(rec_list);
		System.out.println(jsonArr);
		out.print(jsonArr);
	
	}

}
