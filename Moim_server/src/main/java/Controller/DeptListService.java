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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import model.DeptDAO;

@WebServlet("/Moim_DeptListService")
public class DeptListService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");

		PrintWriter out = response.getWriter();

		JsonObject jsonObj = new JsonObject();
		JsonArray jsonArr = new JsonArray();

		ArrayList<String> dept_name = new ArrayList<String>();

		// 부서 리스트
		DeptDAO dao = new DeptDAO();

		dept_name = dao.deptdto();

		for (String dept : dept_name) {
//			System.out.println(dept);
			jsonArr.add(dept);
		}

		jsonObj.add("dept_list", jsonArr);

		System.out.println(jsonObj.toString());

		out.print(jsonObj.toString());

	}

}