package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int num1=(Integer.parseInt(request.getParameter("num1")));
		int num2=(Integer.parseInt(request.getParameter("num2")));
		String cal=request.getParameter("cal");
		int result=0;	
		String error="";
		String url="/jspexam/calcResult.jsp";
		
		System.out.println("전달된 값1:"+num1+"연산자:"+cal+"전달된 값2:"+num2);		
		
		if(cal.equals("+")) {
		result= num1+num2;}
		else if(cal.equals("-")) {
		result= num1-num2;}
		else if(cal.equals("*")) {
		result= num1*num2;}
		else {		
		if(num2==0)
		{error="나눗셈 연산시 두번째 숫자는 0일수 없습니다!!";
			url="/jspexam/errorResult.jsp";}
		else {
		result= num1/num2;	}	
		}	
		System.out.println("결과값:"+result);
	request.setAttribute("calcresult",result);
	request.setAttribute("calcerror",error);	
	RequestDispatcher rd = request.getRequestDispatcher(url);//request객체는 또 있는지 체크할 필요가 없다.
	rd.forward(request,response);	
	}
}


