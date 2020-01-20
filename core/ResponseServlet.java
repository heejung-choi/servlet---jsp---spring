package core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/getHTML", "/getXML", "/getJSON", "/getImage" })//맵핑명 갯수 제한이 없다.
public class ResponseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();//getRequestURI() 이번에 요청된 URI 부분만 꺼내고 싶을때 사용한다.
		/*request.getRequestURI() 함수 = 프로젝트 + 파일경로까지 가져온다. 
		 * 예) http://localhost:8080/project/list.jsp -> /project/list.jsp 를 가져온다.*/
		System.out.println(uri);
		String filename = "";
		String contentType = "";
		if (uri.endsWith("getHTML")) {//URI가 getHTML로 끝나면
			filename = "c:/testcontent/sample.html";	
			contentType = "text/html; charset=utf-8";
		} else if (uri.endsWith("getXML")) {
			filename = "c:/testcontent/sample.xml";	
			contentType = "application/xml; charset=utf-8";
		} else if (uri.endsWith("getJSON")) {
			filename = "c:/testcontent/sample.json";	
			contentType = "text/json; charset=utf-8";
		} else {
			filename = "c:/testcontent/trans_duke.png";	
			contentType = "image/png";
		}
		File f = new File(filename);//파일객체 생성
		FileInputStream fis = new FileInputStream(f);//file 읽겠다
		/* FileInputStream:읽어올 파일에 바이너리도 있기 때문에, FileReader */
		response.setContentType(contentType);
		if(contentType.startsWith("image")) {
			byte[] content = new byte[(int)f.length()];
			ServletOutputStream sos = response.getOutputStream();//이미지를출력해야 해서.getWriter가 아니라 getOutputStream를 출력하고 있다.
			fis.read(content);
			sos.write(content);			
			sos.close();
		} else {
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			PrintWriter out = response.getWriter();//여기서는 텍스트 형식의 문서를 내보내면 되서 getWriter를 썼다.
			String line = null; 
			while((line = br.readLine()) != null) 
				out.println(line);
			out.close();
			br.close();
			isr.close();			
		}		
		fis.close();
	}
}
