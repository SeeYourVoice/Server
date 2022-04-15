package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/Moim_JoinService")
public class JoinService<DAO> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("조인 서비스입니다");
		// =========회원가입===========
		
		// 0. 인코딩
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();	
		// 1. 파라미터 받아오기
		 
		String user_email = request.getParameter("user_email");
		String user_password = request.getParameter("user_password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String corp_name = request.getParameter("corp_name");
		String dept_name = request.getParameter("dept_name");
		String position_name = request.getParameter("position_name");
		
		
		// test
		System.out.println("user_email : " +user_email);
		System.out.println("user_password : " +user_password);
		System.out.println("first_name : " +first_name);
		System.out.println("last_name : " +last_name);
		System.out.println("corp_name : " +corp_name);
		System.out.println("dept_name : " +dept_name);
		System.out.println("position_name : " +position_name);
		
		// dto를 만들어 --> 유저 정보를 담고 있는 객체 
		// 조인 매개변수로 dto를 써
		UserDAO userDAO = new UserDAO();
		UserDTO dto = new UserDTO(user_email, user_password, first_name, last_name, corp_name, dept_name, position_name);
		//int cnt = userDAO.checkDept
		//if(cnt == 0){
		// inserDept, joinDB
		//else{joinDB}
		// dao안에 있는 join메소드 호출
		int cnt = userDAO.JoinDB(dto); ///////////////////////////////////
		//안드로이드 전달
		if(cnt>0) {
			System.out.println("회원가입 성공");
		}else{ // 가입실패
			System.out.println("회원가입 실패~~~~");
			out.print(1);
		}
	}
}
