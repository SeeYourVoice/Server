package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/Moim_Edit_MyInfo_Service")
public class Edit_MyInfo_Service extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		System.out.println("========= 정보 수정 서비스  =========");

	

		// 계정
		String id = request.getParameter("id");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");

		System.out.println(id+fname+lname);
		
		UserDAO userDAO = new UserDAO();
		int cnt = userDAO.Editname(id, fname, lname);
		System.out.println(cnt);
		if (cnt > 0) {
			
			out.print("성공");
		} else {
			out.print("실패");
		}

	}

}
