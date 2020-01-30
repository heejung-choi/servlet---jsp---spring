package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");			
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String password=request.getParameter("password");		
		MemberVO vo = new MemberVO();	// jsp에서 사용하는 것은 defalut 생성자는 필수이다.	
		if(name.equals("")) { 
			name="없음";	}		
		if(phone.equals("")) {
			phone="없음";	}		
		if(email.equals("")) {
			email="없음";	}		
		if(password.equals("")) { 
			password="없음";}		
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setPassword(password);		
	request.setAttribute("member", vo);		
	RequestDispatcher impossible = request.getRequestDispatcher("/jspexam/memberView.jsp");	
	impossible.forward(request,response);		
	}
}



