package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.NewsVO;


public class NewsDAO {
	private Connection connectDB() {	
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//드라이버 로딩
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", //db서버 접속
						"jdbctest");		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;		
	}
	/*
	 * private void close(Connection conn,Statement stmt,ResultSet rs) throws
	 * SQLException {
	 * 
	 * conn.close(); stmt.close(); rs.close(); }
	 */
	
	public boolean insert( NewsVO vo) {
		boolean result = true;	
		PreparedStatement pstmt;
		Connection conn = connectDB();
		try {pstmt = conn.prepareStatement(
			"insert into news values	(news_seq.nextval, ? ,?,?,ROUND(sysdate,'HH'),0)");
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());			
			pstmt.setString(3, vo.getContent());				
			pstmt.executeUpdate();
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;		
	}
	
	public boolean update(NewsVO vo) {		
		boolean result = true;	
		PreparedStatement pstmt;
		Connection conn = connectDB();
		try {pstmt = conn.prepareStatement(
				"update news set " + 
						"title = ?, " + 
						"writer = ?, " + 
						"content = ? " +				
						"where id = ?");{
							pstmt.setString(1, vo.getTitle());
							pstmt.setString(2, vo.getWriter());
							pstmt.setString(3, vo.getContent());							
							pstmt.setInt(4, vo.getId());
							pstmt.executeUpdate();
						}								
						
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;		
	}
	public boolean delete(int id) {
		System.out.println("제거할 id는: "+id);
		boolean result = true;	
		PreparedStatement pstmt;
		Connection conn = connectDB();
		try {pstmt = conn.prepareStatement(
				"delete from news where id="+id);			
				pstmt.executeUpdate();							
			} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;		
	}
	
	public List<NewsVO>listAll(){
		Statement stmt;
		Connection conn = connectDB();
		List<NewsVO> list = new ArrayList<>();
		try {stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery
					("select id, title, content, writer, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), cnt from news"); 								
			NewsVO vo;	
			while(rs.next()) {//result set 객체 받아와서 while 문으로 
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setTitle(rs.getString(2));				
				vo.setContent(rs.getString(3));
				vo.setWriter(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
				list.add(vo);
			}		
		} catch (SQLException e) {		
			e.printStackTrace();
		}		
		return list;
		}
	
	public NewsVO listOne(int id) {
		PreparedStatement pstmt;
		Statement stmt;
		Connection conn = connectDB();
		List<NewsVO> list = new ArrayList<>();
		NewsVO vo = null;
		try {pstmt = conn.prepareStatement("update news set cnt=cnt+1 where id=?");{
			pstmt.setInt(1, id);			
			pstmt.executeUpdate();
						}						
		} catch (SQLException e) {		
			e.printStackTrace();
		}		
		try {stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery
					("select id, title, content, writer,  writedate, cnt from news where id="+id);			
			
			while(rs.next()) {//result set 객체 받아와서 while 문으로 
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setTitle(rs.getString(2));				
				vo.setContent(rs.getString(3));
				vo.setWriter(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
				list.add(vo);
			}		
		} catch (SQLException e) {		
			e.printStackTrace();
		}		
		
		if(list==null)
		return null;
		else
		return vo;	
	}	
	/*
	 * public void setReadCount(int id) { PreparedStatement pstmt; Connection conn =
	 * connectDB(); try { pstmt =
	 * conn.prepareStatement("update news set cnt=cnt+1 where id=?");
	 * pstmt.setInt(1, id); }catch (SQLException e) { e.printStackTrace(); } }
	 */

	
	
	
	

}


