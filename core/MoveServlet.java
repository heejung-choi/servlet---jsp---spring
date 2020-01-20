package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action =request.getParameter("action");		
		if(action!=null) {
			
			String website="";
		if(action.equals("naver")) {
			website="https://www.naver.com";
		}
		else if(action.equals("daum")) {
			website="https://www.daum.net";						
		}
		else if(action.equals("google")) {			
			website="https://www.google.com";
		}response.sendRedirect(website);}
		else {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();	
		out.print("<h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니당..</h2>");			
		out.close();
		}		
	}
}


/*
 * http://localhost:8000/edu/move?action=naver
 * http://localhost:8000/edu/move?action=daum
 * http://localhost:8000/edu/move?action=google http://localhost:8000/edu/move
 */