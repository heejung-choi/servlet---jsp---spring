package core;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/upload")
@MultipartConfig (location = "c:/uploadtest") //여기 저장하라는 설정 이것 안하고 아래 절대패스 줘도 된다.
/* @MultipartConfig : 서블릿 3.0부터 구현 가능 */
public class UploadServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		request.setCharacterEncoding("utf-8");
		String path = "c:/uploadtest";
		File isDir = new File(path);
		if (!isDir.isDirectory()) {
			isDir.mkdirs();
		}
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if (part.getContentType() != null) {//업로드 되는 파일 일 경우(null이라면 사용자가 입력한 데이터)
				//해당 컨텐츠에 업로드 되는 파일이 있느냐?
				String fileName = part.getSubmittedFileName();//업로드되는 파일의 이름을 꺼내는 메소드
				if (fileName != null) {
					part.write(fileName.substring(0, fileName.lastIndexOf(".")) + //part 객체가 제공하는 write를 사용하면 된다.
							"_"	+ System.currentTimeMillis() 
							+ fileName.substring(fileName.lastIndexOf(".")));
					out.print("<br>업로드한 파일 이름: " + fileName);
					out.print("<br>크기: " + part.getSize());		//정해진 크기보다 큰사이즈라면 알려줘야 한다.		
				}
			} else {
				String partName = part.getName();
				String fieldValue = request.getParameter(partName);
				out.print("<br>" + partName + ": " + fieldValue);			
			}
		}
		out.close();		
	}
}




