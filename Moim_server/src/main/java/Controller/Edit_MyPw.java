package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;

@WebServlet("/Moim_Edit_MyPw")
public class Edit_MyPw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();		
	
		System.out.println("========= 비밀번호 변경 서비스  =========");
	
		String id=request.getParameter("id");
		String npw=request.getParameter("npw"); //새 비밀번호
		System.out.println(id+"\n"+npw);
		
		UserDAO userDAO= new UserDAO();
		int cnt=userDAO.EditPw(id, npw);
		System.out.println(cnt);
		
		if (cnt > 0) {
			out.print("성공");
		} else {
			out.print("실패");
		}

		
	}

}
