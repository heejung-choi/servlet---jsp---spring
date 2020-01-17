package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		name=request.getParameter("name");
		
		String days="일월화수목금토";
		
		LocalDate date=LocalDate.now();
		int whatday=date.getDayOfWeek().getValue();
		
		if(name==null) {
			name="Guest";
		}
		out.print("<h2>"+name+"님 반가워요..오늘은" +days.charAt(whatday) + "요일입니다!!</h2>");
		out.close();
	}

}
