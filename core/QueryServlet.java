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
@WebServlet("/query")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
    public MemberLocalServlet() {
        super();
    }
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html; charset=utf-8"); //꼭 해줘야 한다. 안그러면 한글이 깨짐.
		//text 형식인데 html 기반의 데이터임.
		
		PrintWriter out = response.getWriter();
		String p1=request.getParameter("p1");
		int p2 = Integer.parseInt(request.getParameter("p2"));
		String p3[]=request.getParameterValues("p3");
		
		out.print("<ul>");
		out.print("<li>p1 : "+p1+"</li>");
		out.print("<li>p2 : "+p2+"</li>");
		
		for(int i=0;i<p3.length;i++) {
			out.print("<li>p3["+i+"] : "+p3[i]+"</li>");
		}
		out.print("</ul>");
		out.close();
		//close를 안해도 되지만 에러를 내는 서버가 있기도 하기 때문에 항상
		//닫아준다.
	}
	//크롬과 IE에서 따로 이 클라스를 호출해도 한 객체만 참조한다. -> 메모리 관리에 있어서 효율적.
}
