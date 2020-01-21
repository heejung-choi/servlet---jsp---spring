package core;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sessiontest3")
public class SessionTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
	    String action = request.getParameter("action"); 
		/*
		 * 쿼리를 어떤 이름으로 얼마나 추출하는지 먼저 확인해야 한다. request.getParameter를 보고 확인한다. 
		 * 정상적으로 수행하려면 action이름의 쿼리를 줘야 한다.
		 */
	    HttpSession session = null;
	    String msg = "값으로 create나 destroy를 전달하시오. "; 
	    if(action.equals("create")) {
	    	session = request.getSession();// getSession(true)와 동일
	    	if(session.isNew())//처음만들어진 것인지 확인하고 싶을때
	    		msg = "세션 객체가 생성됨";
	    	else 
	    		msg = "세션 객체는 이미 생성되어 있었음";    	
	    } else if (action.equals("destroy")) {
	    	session = request.getSession(false);
	    	//false는 만들어져 있으면 만들어져 있는것 리턴, 아니라면 null 리턴
	    	if(session != null) {
	    		session.invalidate();//세션객체 삭제
	    		msg = "세션 객체가 삭제됨";
	    	} else 
	    		msg = "삭제할 세션 객체가 없음";    	
	    }
	
		 
		out.print("<h2>"+msg+"</h2>");
		out.close();
	}
}








