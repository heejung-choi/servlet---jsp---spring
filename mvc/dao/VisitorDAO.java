package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.VisitorVO;

public class VisitorDAO {
	public List<VisitorVO> listAll() {
		List<VisitorVO> list = new ArrayList<>(); //array list 생성
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
				("select name, to_char(writedate, "
				+ "'yyyy\"년\" mm\"월\" dd\"일\"'), memo from visitor");) {
			VisitorVO vo;
			while(rs.next()) {//result set 객체 받아와서 while 문으로 
				vo = new VisitorVO();
				vo.setName(rs.getString(1));
				vo.setWriteDate(rs.getString(2));
				vo.setMemo(rs.getString(3));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<VisitorVO> search(String keyword) { //visitor vo객체를 보관하고 있는 list를 출력
		List<VisitorVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), memo "
						+"from visitor where memo like '%"+keyword+"%'");
				) { //키워드가 들어간것을 뽑아줘
			VisitorVO vo;
			while(rs.next()) {
				vo = new VisitorVO();
				vo.setName(rs.getString(1));
				vo.setWriteDate(rs.getString(2));
				vo.setMemo(rs.getString(3));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean insert(VisitorVO vo) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
				PreparedStatement pstmt = conn.prepareStatement(
						"insert into visitor values(?, sysdate, ?)");) {
			/* 각각의 물음표에는 getter메세지를 호출에서 쓰게하고 있다. */
			pstmt.setString(1, vo.getName());
			pstmt.setString(2,  vo.getMemo());
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
}


