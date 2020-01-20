package core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("ForwardServlet 수행시작");
		RequestDispatcher rd = request.getRequestDispatcher("/html/first.html"); //컨텍스트패스 이후 부분을 줘야 한다.
/*		RequestDispatcher rd = request.getRequestDispatcher("http://www.naver.com");*/
		/* 위와 같이 하는 것은 불가능 forward 방식은 같은 웹플리케이션 안에 있는것만 가능하다. */
		rd.forward(request,response);
		System.out.println("ForwardServlet 수행종료");
	}

}
