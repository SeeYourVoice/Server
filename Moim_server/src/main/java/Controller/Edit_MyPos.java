package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;

@WebServlet("/Moim_Edit_MyPos")
public class Edit_MyPos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();		
	
		System.out.println("========= 직급 변경 서비스  =========");
		String id=request.getParameter("id");
		String position_name=request.getParameter("position_name");
		
		
		UserDAO userDAO= new UserDAO();
		int cnt=userDAO.EditPos(id, position_name);
		
		if (cnt > 0) {
			System.out.println("성공");
			out.print("성공");
		} else {
			out.print("실패");
		}

	}
	


}
