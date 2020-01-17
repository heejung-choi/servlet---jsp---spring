package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8"); /* post 방식인 경우 이것을 해줘야 한다.*/
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy년 MM월dd일 ");
		Date time = new Date();
		String time1 = format1.format(time);		
		
		out.print("<h2>방식 : "+request.getMethod()+"</h2>");
		out.print("<h2>"+request.getParameter("name")+" 님이 "+time1+" 남긴 글 입니다."+"</h2>");
		out.print("<hr>");
		out.print("<h2>"+request.getParameter("memo")+"</h2>");
		out.print("<a href='http://localhost:8000/sedu/html/visitorForm.html'>입력화면으로</a>");
		out.close();
		System.out.println("POST 방식");
	}
}



