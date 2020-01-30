package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score")
public class EduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");///setChatagterEncoding은 반드시 여기서 해야한다.
		int score=(Integer.parseInt(request.getParameter("score")));	
		System.out.print("평균점수:"+score);	
		RequestDispatcher req;
		
		if(score>=90) {
			req = request.getRequestDispatcher("/jspexam/gradeA.jsp");				
		}
		else if(score>=80){
			req = request.getRequestDispatcher("/jspexam/gradeB.jsp");			
		}
		else if(score>=70){
			req = request.getRequestDispatcher("/jspexam/gradeC.jsp");			
		}
		else {			
			req = request.getRequestDispatcher("/jspexam/gradeD.jsp");	
		}
		req.forward(request,response);
	
		
	

	}
}



