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

@WebServlet("/basket1")
public class BasketServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	     FileWriter writer = null;
	     String path = "C:/logtest";
	     File isDir = new File(path);
	     writer = new FileWriter("C:/logtest/mylog.txt",true);
	    	String id = request.getParameter("pid");//암
	 		Date today = new Date();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyymmddHHmm");
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
	 
			response.setContentType("text/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("{\"pid\":\""+id+"\"}");
			out.close();
	
	}
}
