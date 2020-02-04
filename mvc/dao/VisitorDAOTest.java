package model.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.vo.VisitorVO;
import static org.junit.jupiter.api.Assertions.*;
//static import 구무을 쓰면 class 이름을 안주고 메서드를 쓸 수 있다. Static 메서드를

import static java.lang.System.out;
//이렇게 하면 System을 안써도 out을 쓸 수 있다.

class VisitorDAOTest {

	@Test
	void test() {
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.listAll();
		System.out.print(list.size());
		for(VisitorVO vo:list)
			System.out.println(vo);
	}
	@Test
	void test1() {
		System.out.println("검색 기능 테스트");
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.search("집");
		System.out.print(list.size());
		for(VisitorVO vo:list)
			System.out.println(vo);
	}
	
	
	@Test
	void test2() {
		System.out.println("삽입 테스트");
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName("희동이");
		vo.setMemo("~~오늘은 그냥 금요일~~~");
		boolean result = dao.insert(vo);	
		if(result)
			System.out.println("삽입 성공");
		else 
			fail("삽입 실패");
	}
	/* 메서드의 이름을 가지고 하기 때문에 수행될 때 적용되는 순서가 메소드 이름 순서이다.
	 * 테스트를 하고 싶을 때 그 클래스들을 사용하는 또다른 클래스가 있어야 할 수 있다. 단위테스트를 하고 싶을때 junit을 사용한다.
	 */

}
