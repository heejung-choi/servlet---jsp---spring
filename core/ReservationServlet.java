package core;

import java.io.IOException;
import java.io.PrintWriter;
/*import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");			
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8"); 		
		String[] service = request.getParameterValues("service");		
		String date = request.getParameter("date");
		LocalDate ndate = LocalDate.parse(date);
		DateTimeFormatter dateF = DateTimeFormatter.ofPattern(
						"yyyy년 MM월 dd일");
		String newDate = ndate.format(dateF);

		
		out.print("<h1>"+request.getParameter("name")+" 님의 예약내용</h2>");
		out.print("<hr><ul>");
		out.print("<li> 룸: " +request.getParameter("room")+ "</li>");
		out.print("<li> 추가 요청 사항 : ");
		for (int i = 0; i < service.length; ++i) {
			if (i == service.length - 1) {
				out.print(service[i]);
				break;}
			out.print(service[i] +",");}
		out.print("</li>");
		out.print("<li> 예약날짜: " +newDate+ "</li>");	
		out.print("</ul><hr>");		
		out.print("<a href='http://localhost:8000/sedu/html/reservation.html'>예약 입력화면으로</a>");
		out.close();
		
	}
}


