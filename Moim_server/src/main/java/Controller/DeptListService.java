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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import model.DeptDAO;
import model.DeptDTO;

@WebServlet("/Moim_DeptListService")
public class DeptListService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
//		JsonObject jsonObj = new JsonObject();
//		JsonArray jsonArr = new JsonArray();
	
		
		ArrayList<DeptDTO> dept_name = new ArrayList<DeptDTO>();

		// 부서 리스트
		DeptDAO dao = new DeptDAO();

		dept_name = dao.deptdto();
		
		String jsonArr = gson.toJson(dept_name);
		out.print(jsonArr);
		
//		for (DeptDTO dept : dept_name) {
////			System.out.println(dept);
//			jsonArr.add(dept.getDept_nam.e());
//			
//		}
//
//		jsonObj.add("dept_name", jsonArr);
//	
//		
//		System.out.println(jsonObj.toString());
//
//		out.print(jsonObj.toString());

	}

}
