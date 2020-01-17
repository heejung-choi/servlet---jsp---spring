package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id =request.getParameter("pid");
		out.print("<h2>상품ID : "+id+"</h2><br>");
		out.print("<img src='/edu/images/"+id.charAt(3)+".png' style= 'width:200px; height:100px;'>"+"<br><br>");
		out.print("<a href='http://localhost:8000/sedu/html/productlog.html'>"
		  +"상품선택 화면으로 가기"+"</a>");		 
		out.close();
		/* "/edu/images/0.png" */
	}
}



