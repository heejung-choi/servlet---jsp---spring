package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/querytest2")
/* "/querytest2"�̰� �ȸ����� 404 ���� */
public class QueryTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 405 doGet�ȸ����� */
		String name = request.getParameter("stname");
		int num = Integer.parseInt(
				request.getParameter("stnum"));
		String[] sub = request.getParameterValues("subject");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h3>�̸� : "+name+"</h3>");
		out.print("<h3>��ȣ : "+num+"</h3>");
		if(sub == null)
			out.print("<h3>������ ������� ���׿�!!</h3>");
		else {
			out.print("<h3>������ �����</h3>");
			for(String s : sub)
				out.print("<h4>"+s+"</h4>");
		}
		out.close();
	}
}




