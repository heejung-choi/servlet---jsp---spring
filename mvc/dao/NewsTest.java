package model.dao;

import java.util.List;

import org.junit.Test;

import model.vo.NewsVO;

public class NewsTest {

	@Test
	public void test() {
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		vo.setWriter("또치");
		vo.setTitle("테스트");
		vo.setContent("성공인가?");		
		dao.insert(vo);
		List<NewsVO> list = dao.listAll();
		for(NewsVO data : list)
			System.out.println(data);			
	}	
}
