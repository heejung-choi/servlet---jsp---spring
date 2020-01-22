package core;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html; charset=UTF-8");	jsp가 자동으로 해주기 때문에 필요 없다.
		int su1=(Integer.parseInt(request.getParameter("number")));
		int su2=(int) (Math.random() * 6);		
		System.out.print("전달된 값:"+su1+" 추출된 값:"+su2);
		RequestDispatcher req;		
		if(su1==su2)
		req = request.getRequestDispatcher("/jspexam/success.jsp");
		else
		req = request.getRequestDispatcher("/jspexam/fail.jsp");		
		req.forward(request,response);
		
		/*
		 * String url; if(su1==su2) url="/jspexam/success.jsp"; else
		 * url="/jspexam/fail.jsp"; req =
		 * request.getRequestDispatcher(url).forward(request,response);
		 */
		
	}
}



