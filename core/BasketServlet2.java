package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json; charset=UTF-8"); 
		FileWriter writer = null;
	     String path = "C:/logtest";
	     File isDir = new File(path);
	     writer = new FileWriter("C:/logtest/mylog.txt",true);
	     Date today = new Date();
	 	 SimpleDateFormat format1 = new SimpleDateFormat("yyyymmddHHmm");
	     String id = request.getParameter("pid");
	  
	     if (!isDir.exists()) {//디렉토리에 파일이 있느냐?
	        	isDir.mkdirs();// 파일이 없으면 mkdirs-> 파일을 생성하라는 명령어
	     }	     
	     try {	    	
			String day = format1.format(today);		
			writer.write(day+" "+id);
			writer.write("\r\n");
			writer.close();
	     } catch(IOException ioe) {
	    	 System.out.println("파일로 출력할 수 없습니다.");
	     } 		
			
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession(); ////세션객체가 만들어져 있다면 찾아오고, 없다면 만들어준다.
			if(session != null) {
				if(id.equals("del")) {
					session.invalidate();
					out.print("{\"msg\":\"상품이 모두 삭제 되었습니다.\"}");
					return;
				}
			}//세션객체가 null이면 상품 삭제 <선택한 상품 비우기>
			
					
			if(session.getAttribute("arr") == null) 
			session.setAttribute("arr", new int[10]);//데이터 저장할 방을 등록, 방은 반드시 객체여야 한다.			
			int[] session_v = (int[])session.getAttribute("arr");
			int plus=id.charAt(3)-'0'; 
			session_v[plus]++;
			session.setAttribute("arr", session_v);			
			out.print("{");
			for(int i=0; i<session_v.length; i++) {			
				if(i==session_v.length-1)
				out.print("\"p00"+i+"\":"+session_v[i]);			
				else
				out.print("\"p00"+i+"\":"+session_v[i]+",");							
			}	
			out.print("}");
			//out.write("<a href=\"http://localhost:8000/sedu/basket2?action=remove\">상품 비우기</a>");
			
			out.close();
			
			
			
	}
}
