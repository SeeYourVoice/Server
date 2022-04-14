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
import com.google.gson.JsonArray;

import model.PosDAO;
import model.PosDTO;
import oracle.jdbc.proxy.annotation.Post;

@WebServlet("/Moim_LoadPos")
public class LoadPos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		//리스트 가져와야함.
		PosDAO posDAO=new PosDAO();
		ArrayList<PosDTO> list = posDAO.AllPos();

				
		String jsonArr = gson.toJson(list);
		out.print(jsonArr);

	}

}
