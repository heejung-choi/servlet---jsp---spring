package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getpost3")
public class GetPostServlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>��û ��� : "+request.getMethod()+"</h2>");
		out.print("<h2>Query ���ڿ� : "+
		                  request.getParameter("name")+"</h2>");
		out.close();
		System.out.println("GET ��� ����");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		out.print("<h2>��û ��� : "+request.getMethod()+"</h2>");
		out.print("<h2>Query ���ڿ� : "+request.getParameter("name")+"</h2>");
		out.close();
		System.out.println("POST ��� ����");
	}
}



