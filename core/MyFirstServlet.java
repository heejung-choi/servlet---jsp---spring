package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");/*17~18행 순서는 꼭 지켜야됨 */
		PrintWriter out= response.getWriter();	/* 타입 설정 후(17행) 출력 String객체 만들어야함(18행) */
		String name = request.getParameter("name");  /*p1에 저장된 쿼리문자열을 출력하여 p1이라는 변수에 담으세요*/
		LocalDate date = LocalDate.now();
		
		String result="";
		  switch(date.getDayOfWeek()){
		  case MONDAY : result ="월";break; 
		  case TUESDAY : result ="화"; break; 
		  case WEDNESDAY: result ="수"; break; 
		  case THURSDAY : result ="목"; break; 
		  case FRIDAY : result ="금"; break; 
		  case SATURDAY : result ="토"; break; 
		  case SUNDAY : result ="일"; break; 
		  }
		  if(name==null) {
			  name = "guest";
		  }
		/* out.print("<h2>"+name+"님 반가워요..오늘은 "+date.getDayOfWeek()+"입니다!!"+"</h2>"); */
		out.print("<h2>"+name+"님 반가워요..오늘은 "+result+"요일 입니다!!"+"</h2>");
		out.close();		
	}

}
