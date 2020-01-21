package core;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/part")
@MultipartConfig
public class PartTestServlet extends HttpServlet {   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
        Collection<Part> parts = request.getParts();
        //getParts라는 메소드 사용 @MultipartConfig 이것이 정의되어 있지 않으면 에러
		/* 파트객체만큼 request */
        System.out.println("========== 요청 받음 =========");
        for(Part part : parts) {    //파츠객체들을 하나씩 꺼내서    	
            System.out.print("name : ");
            System.out.println(part.getName());   //input 태크에서 name속성이 있다. getName()로 꺼내준다.         
            System.out.println("[ 헤더 정보 ] ");
            for(String headerName : part.getHeaderNames()) {//getHeaderNames()네임 꺼내줘
                System.out.print(headerName + " : ");
                System.out.println(part.getHeader(headerName));              
            }
            System.out.println("size : "+ part.getSize());//실제 content의 사이즈
            //업로드된 파일이 아닌 경우에는 입력되는 데이터 사이즈
            String filename = part.getSubmittedFileName(); //실제 업로드 된 파일의 이름
            if (filename != null) //null이 아니면 출력
            	System.out.println("file name : "+filename);
            System.out.println("------------------------------------");
        }        
    }
}


