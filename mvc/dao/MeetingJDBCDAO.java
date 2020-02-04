package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.MeetingVO;


public class MeetingJDBCDAO implements MeetingDAO {
	public List<MeetingVO> listAll() {
		List<MeetingVO> list = new ArrayList<>(); //array list 생성
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//드라이버 로딩
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", //db서버 접속
						"jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select id, name, title, to_char(meetingDate, 'yyyy\"년\" mm\"월\" dd\"일\" hh24\"시\" mi\"분\"') from meeting");) {
			MeetingVO vo;
			while(rs.next()) {//result set 객체 받아와서 while 문으로 
				vo = new MeetingVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean insert(MeetingVO vo) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
		PreparedStatement pstmt = conn.prepareStatement(
				"insert into meeting values	(meeting_seq.nextval, ? ,?, to_date(?, 'yyyy-mm-dd\"T\"hh24:mi' ))");){
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getTitle());
				pstmt.setString(3, vo.getMeetingDate());
				pstmt.executeUpdate();
	
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	public List<MeetingVO> search(String keyword) { //visitor vo객체를 보관하고 있는 list를 출력
		List<MeetingVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select  id, name, title, to_char(meetingDate, 'yyyy\"년\" mm\"월\" dd\"일\" hh24\"시\" mi\"분\"') from meeting where title like '%"+keyword+"%'");) { //키워드가 들어간것을 뽑아줘
			MeetingVO vo;
			while(rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean delete(int eNo) {
		System.out.println("eNo는: "+eNo);
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
		PreparedStatement pstmt = conn.prepareStatement(
				"delete from meeting where id="+eNo);){
		pstmt.executeUpdate();
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;		
	}	
	public boolean update(MeetingVO vo) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest");
				PreparedStatement pstmt = conn.prepareStatement(
						"update meeting set " + 
						"name = ?, " + 
						"title = ?, " + 
						"meetingdate = to_date(?, 'yyyy-mm-dd\"T\"hh24:mi' ) " + 
						"where id = ?");){
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getMeetingDate());
			pstmt.setInt(4, vo.getId());
			pstmt.executeUpdate();			
		}catch(SQLException e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	

}


