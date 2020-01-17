package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberLocalServlet
 */
@WebServlet("/memberlocal")
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
    public MemberLocalServlet() {
        super();
    }
	 */
	int member_v=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int local_v=0;
		response.setContentType("text/html; charset=utf-8"); //꼭 해줘야 한다. 안그러면 한글이 깨짐.
		//text 형식인데 html 기반의 데이터임.
		
		PrintWriter out = response.getWriter();
		
		member_v+=10;
		local_v+=10;
		
		out.print("<ul>");
		out.print("<li>멤버변수 : "+member_v+"</li>");
		out.print("<li>지역변수 : "+local_v+"</li>");
		out.print("</ul>");
		out.close();
		//close를 안해도 되지만 에러를 내는 서버가 있기도 하기 때문에 항상
		//닫아준다.
	}
	//크롬과 IE에서 따로 이 클라스를 호출해도 한 객체만 참조한다. -> 메모리 관리에 있어서 효율적.
}
