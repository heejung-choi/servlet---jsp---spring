package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MeetingDAO;
import model.dao.MeetingJDBCDAO;
import model.vo.MeetingVO;

@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");		
		MeetingDAO dao = new MeetingJDBCDAO();
		String action = request.getParameter("action");		
		//int id =Integer.parseInt(request.getParameter("id"));	
		if(action==null) {		
		if(keyword == null) {
			List<MeetingVO> list = dao.listAll();
			for(MeetingVO vo : list) {
				System.out.println(vo.getTitle());
			}
			request.setAttribute("list", list);
		} else {
			List<MeetingVO> list = dao.search(keyword);
			if(list.size() == 0) {
				request.setAttribute("msg", keyword+"를 담고있는 글이 없어용");
			} else {
				request.setAttribute("list", list);
			}
		}			
		}	
		else if(action.equals("delete")) {			
		String id =request.getParameter("id");	
		System.out.println("id는?"+id);
		System.out.println("");
		dao.delete(Integer.parseInt(id));
		List<MeetingVO> list = dao.listAll();
		for(MeetingVO vo : list) {
			System.out.println(vo.getTitle());
		request.setAttribute("list", list);
		}			
		}			
		request.getRequestDispatcher("/jspexam/meetingView.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String meetingDate = request.getParameter("meetingDate");
		MeetingDAO dao = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();		
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(meetingDate);		
		boolean result = dao.insert(vo);
		if(result) {
			request.setAttribute("msg", name+"님의 글이 작성되었습니당!!!");
		} else {
			request.setAttribute("msg", name+"님의 글이 입력에 실패했어요!!ㅠㅠㅠㅠ");
		}
		request.getRequestDispatcher("/jspexam/meetingView.jsp")
		           .forward(request, response);
	}
}


/* get -> 전체리스트 출력(쿼리가 간다)과 search(쿼리가 가지 않는다) post -> 방명록 작성기능
 */
