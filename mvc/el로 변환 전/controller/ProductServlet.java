package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.ProductVO;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");			
		HttpSession session = request.getSession();
		if(session.getAttribute("cnt")==null)
			session.setAttribute("cnt",new ProductVO());
		ProductVO vo = (ProductVO)session.getAttribute("cnt");
		String url="/jspexam/productView.jsp";
		
		if(pid.equals("p001"))
			vo.setApple(1);
		else if(pid.equals("p002"))	
			vo.setBanana(1);
		else if(pid.equals("p003"))
			vo.setHalabong(1);
	
		 if(session != null) {
			if(pid.equals("del")) { 
			session.invalidate();
			url = "/jspexam/productDel.jsp";}
			}		
		RequestDispatcher impossible = request.getRequestDispatcher(url);	
		impossible.forward(request,response);		
	}
}




