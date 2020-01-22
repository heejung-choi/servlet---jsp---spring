package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/visitordb")
public class VisitorDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//GET - visitor 테이블의 데이터들을 모두 읽어 와서 테이블 형식으로 브라우저로 출력
	//POST - 전송되는 Query 문자열을 가지고 visitor 테이블에 저장

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//doGet 메서드의 조상 메서드가 throws 하는 범위보다 더 많이 예외를 throws 하지 못함!
		
		try {
			//드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 오류");
		}
		
		//DB서버 접속, Statement 객체 생성, "SELECT * FROM VISITOR" SQL 명령문 수행
		String sql = "select name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"') writedate, memo from visitor"; 
		try (	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();			
				ResultSet rs = stmt.executeQuery(sql);) {
			out.print("<h1>방명록 리스트</h1><hr>");
			out.print("<table border='1'>");
			while(rs.next()) {
				out.print("<tr>");
				out.print("<td>"+rs.getString("name")+"</td>");
				out.print("<td>"+rs.getString("writedate")+"</td>");
				out.print("<td>"+rs.getString("memo")+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//방명록 읽기
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String memo = request.getParameter("memo");
		//doGet 메서드의 조상 메서드가 throws 하는 범위보다 더 많이 예외를 throws 하지 못함!
		
		try {
			//드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 오류");
		}
		
		//DB서버 접속, Statement 객체 생성, "SELECT * FROM VISITOR" SQL 명령문 수행
		String sql = "insert into visitor values('"+name+"',sysdate.'"+memo+"')";
		System.out.println(sql);
		try (	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();			
				) {
			stmt.executeUpdate(sql);//객체를 만드는것이 아니기 때문에 try에 있을 수 없다.
			//ResultSet rs = stmt.executeQuery(sql);위의 try안에 있는것은 객체를 만드는 것이여서 안에 넣었던 것이다.	
			out.print("<h2>방명록글 저장 성공!!</h2>");
		}
		catch(SQLException e) {
			e.printStackTrace();
			out.print("<h2>방명록글 저장 실패!!</h2>");
		}
	}
		
		
	}
	//방명록 작성

