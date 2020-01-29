package core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();//세션객체 생성하거나 추출
		if(session.getAttribute("cnt")==null)
		session.setAttribute("cnt",new int[1]);//객체정보를 보관할 객체 등록
		int[]count = (int[])session.getAttribute("cnt");
		count[0]++;
		System.out.print("몇번째 방문?"+count[0]);				
		int su1=(Integer.parseInt(request.getParameter("number")));
		int su2=(int) (Math.random() * 6);			
		System.out.print("전달된 값:"+su1+" 추출된 값:"+su2);		
		RequestDispatcher req;		
		
		if(count[0]>=4) {
		req = request.getRequestDispatcher("/jspexam/impossible.jsp");}
		else {		
		if(su1==su2) {
		req = request.getRequestDispatcher("/jspexam/success.jsp");
		count[0]=4;}
		else
		req = request.getRequestDispatcher("/jspexam/fail.jsp");}		
		req.forward(request,response);
		
		
		

		
	}
}



