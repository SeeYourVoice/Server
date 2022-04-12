import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;

@WebServlet("/Moim_JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// =========회원가입===========
		
		// 0. 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 1. 파라미터 받아오기
		 
		String user_email = request.getParameter("user_email");
		String user_pw = request.getParameter("user_password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String corp_name = request.getParameter("corp_name");
		String dept_name = request.getParameter("dept_name");
		String position_name = request.getParameter("position_name");
		
		// dto를 만들어 --> 유저 정보를 담고 있는 객체 
		// 조인 매개변수로 dto를 써
		DTO dto = new DTO(String user_email, String user_password, String first_name, String last_name,
				String corp_name, String dept_name, String position_name);
		
		DAO dao = new DAO();
		
		int cnt = dao.join(user_email, user_password, first_name, last_name,
				corp_name, dept_name, position_name); // dao안에 있는 join메소드 호출
		
		
		//안드로이드 전달
		out.print(obj.toString());
		
	}else {//로그인 실패
		out.print(jsonStr);
	
	}

}