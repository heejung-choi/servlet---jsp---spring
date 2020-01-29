# 20200129 정리

xxxVO - Value Object : 값을 보관하는 용도의 객체

xxxDAO- Data Access Object : DB 연동기능(JDBC)를 지원하는 객체

xxxService(xxxbiz) - Service Object : 이런 저런 서비스 로직을 지원하는 객체



(1) mvc 라는 새로운 Dynamic Web project 생성

(2) 이프로젝트에서 생성되는 소스(텍스트)들의 인코딩정보를 utf-8로 설정

우클릭 - preperance - resource - other UTF-8

(3) mvc 프로젝트를 톰캣 서버에 컨텍스트로 등록

톰캣 우클릭 - add & remove 

(4) src 폴더에 controller, vo, mode 패키지 생성

(5) webcontent 폴더에 images, jspexam 폴더 생성

(6) 강사컴퓨터 교육자료 폴더에서 htmlexam 폴더를 복사하여 WebContent 에 붙인다.   
         브라우저에서 /mvc/htmlexam/visitorForm.html 을 요청



이전페이지 <a href="<%=request.getHeader("referer")%>">성적입력 화면으로</a>



   - lottoForm.html -> htmlexam, LottoServlet2.java -> controller 에 복사

   request.getParameter("xxx") 호출시 xxx 라는 이름의 Query 가 전달되지 않은 경우엔
   null 을 리턴하고 xxx 라는 이름의 Query 는 왔는데 value 가 비어 있는 경우엔 
   ""(널문자열)이 리턴됨.

   Query 가 어떻게 전달되는지 확인하려는 경우...
   POST 방식은 확인이 어려우니 GET 방식으로 변경하여 채크해 보는 것도 방법임..
      