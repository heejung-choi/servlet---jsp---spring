package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.vo.NewsVO;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String keyword = request.getParameter("keyword");		
		NewsDAO dao = new NewsDAO();
		String action = request.getParameter("action");		
		String newsid =request.getParameter("newsid");
		
		if(action==null) {
			List<NewsVO> list = dao.listAll();
			for(NewsVO vo : list) {
				System.out.println(vo.getTitle());
			}
			request.setAttribute("list", list);
		}			
		else if(action.equals("read")){		
		NewsVO listview =dao.listOne(Integer.parseInt(newsid));
		List<NewsVO> list = dao.listAll();
		for(NewsVO vo : list) {
			System.out.println(vo.getTitle());
		}
		
		request.setAttribute("listview", listview);	
		
		request.setAttribute("list", list);	
		// id 선택하면 리스트 출력하는 문 여기 		
		
		
		}					
		else if(action.equals("delete")) {		
		System.out.println("id는?"+newsid);
		System.out.println("");
		dao.delete(Integer.parseInt(newsid));
		List<NewsVO> list = dao.listAll();
		for(NewsVO vo : list) {
			System.out.println(vo.getTitle());
		request.setAttribute("list", list);
		}			
		}			
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");	
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String newid = request.getParameter("newid");
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();		
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		/* System.out.println("action은?"+action); */
		
		if(newid !=null) {
			vo.setId(Integer.parseInt(newid));
			boolean result = dao.update(vo);
			if (result) {			
				request.setAttribute("msg", writer + "님의 글이 성공적으로 수정되었습니다.");			
			} else {
				request.setAttribute("msg", writer + "님의 글이 수정되지 않았습니다.");
			}
		}		
		else {
			if(action.equals("insert")) {
				boolean result = dao.insert(vo);
				if (result) {			
					request.setAttribute("msg", writer + "님의 글이 성공적으로 입력되었습니다.");			
				} else {
					request.setAttribute("msg", writer + "님의 글이 입력되지 않았습니다.");
				}
			}		
			
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}
	
}


/* get -> 전체리스트 출력(쿼리가 간다)과 search(쿼리가 가지 않는다) post -> 방명록 작성기능
 */
