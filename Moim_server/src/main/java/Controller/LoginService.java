package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


import model.UserDAO;
import model.UserDTO;


@WebServlet("/Moim_LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();		
		//Gson gson = new Gson();
			
		 //=========로그인정보=========

		//이거 해시맵상태임?
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		//DB에서 일치하는지 보고 
		UserDAO userDAO=new UserDAO();
		UserDTO userDTO=new UserDTO(id, pw); 
		
		//회원가입 여부 판단
		UserDTO info=userDAO.LoginDB(userDTO);
		 

		String jsonStr="false";
		JsonObject obj=new JsonObject();
	
		
		if(info!=null) {//로그인 성공
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("info", info);//현재 로그인된 사용자의 정보를 세션에 저장.
		
			obj.addProperty("user_email", info.getUser_email());
			obj.addProperty("user_password",info.getUser_password());
			obj.addProperty("first_name", info.getFirst_name());
			obj.addProperty("last_name", info.getLast_name());
			obj.addProperty("profile_img", info.getProfile_img());
			obj.addProperty("user_joindate", info.getUser_joindate());
			obj.addProperty("dept_seq", info.getDept_seq());
			
			
			//안드로이드 전달
			out.print(obj.toString());
			
		}else {//로그인 실패
			out.print(jsonStr);
		}
		
		
		

		 
		 


	}

}
