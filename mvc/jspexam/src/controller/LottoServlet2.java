package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.LottoVO;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();//세션객체 생성하거나 추출
		if(session.getAttribute("cnt")==null)
		session.setAttribute("cnt",new int[1]);//객체정보를 보관할 객체 등록
		int[]count = (int[])session.getAttribute("cnt");
		count[0]++;
		System.out.print("몇번째 방문?"+count[0]);				
		int su1=(Integer.parseInt(request.getParameter("number")));
		int su2=(int) (Math.random() * 6);			
		System.out.print("전달된 값:"+su1+" 추출된 값:"+su2);		
		RequestDispatcher req;	
		
		java.text.SimpleDateFormat format1 = new java.text.SimpleDateFormat ( "hh시 mm분");
		java.util.Date time = new java.util.Date();
		String time1 = format1.format(time);
		
		LottoVO vo = new LottoVO();
		if(count[0]>=4) {
			vo.setMsg("더이상 응모할 수 없어요.. 브라우저를 재기동 한다음에 도전하세요");}		
		else {		
		if(su1==su2) {	
			vo.setMsg(time1+"에 당첨!! 추카추카");
			vo.setImgUrl("/edu/images/success.jpeg");		
		count[0]=4;}
		else {
		vo.setMsg(time1+"에 실패!! 아쉽아쉽~");
		vo.setImgUrl("/edu/images/fail.png");
		vo.setLinkDisplay(true);
		}			
		}	
	request.setAttribute("lotto", vo);		
	RequestDispatcher impossible = request.getRequestDispatcher("/jspexam/lottoView.jsp");	
	impossible.forward(request,response);		
	}
}



