package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLocalServlet
 */
@WebServlet("/sessiontest1")
public class SessionTestServelt1 extends HttpServlet {

	int member_v=0;//멤버변수는 한번 메모리 할당되면 서버가 운영되는 내내 변수의 공간이 모든 클라이언트에 의해 공유된다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int local_v=0;//요청시 마다 메모리 각각 할당, 유지하지 않는다.  
		response.setContentType("text/html; charset=utf-8"); //꼭 해줘야 한다. 안그러면 한글이 깨짐.
		//text 형식인데 html 기반의 데이터임.		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();//세션객체가 만들어져 있다면 찾아오고, 없다면 만들어준다.
		/*session.setAttribute("cnt",new int[1]);*/
		//세션객체에 보관할 방을 만드는 것은 session.setAttribute인데. 안에는 객체만 들어올 수 있다. 
		//이렇게만 구현하면 하나 배열 생성될 때마다 cnt라는 객체가 또등록 되고 또등록 되고 해서 문제가 있다. 그래서 그냥해서는 안되고 if문을 써야 한다.
		if(session.getAttribute("cnt")==null)
		session.setAttribute("cnt",new int[1]);//데이터를 저장할 방을 등록 : 방은 반드시 객체여야 한다.
		int[]session_v = (int[])session.getAttribute("cnt");
		session_v[0] +=10;		
		member_v+=10;
		local_v+=10;		
		out.print("<ul>");
		out.print("<li>멤버변수 : "+member_v+"</li>");
		out.print("<li>지역변수 : "+local_v+"</li>");
		out.print("<li>세션객체에 저장된 배열 원소 값 수 : "+session_v[0]+"</li>");
		out.print("</ul>");
		out.close();
		//close를 안해도 되지만 에러를 내는 서버가 있기도 하기 때문에 항상
		//닫아준다.
	}
	//크롬과 IE에서 따로 이 클라스를 호출해도 한 객체만 참조한다. -> 메모리 관리에 있어서 효율적.
}
