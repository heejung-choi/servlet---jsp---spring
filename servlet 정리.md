# 20200116 정리 내용

[ Query String (쿼리 문자열 ) ]
  웹 클라이언트에서 웹 서버에 정보를 요청할 때 추가로 전달하는 문자열
  이 문자열을 정해 규칙으로 구성되어 전달되어야 하는데 이규칙을
  url encoding 또는 query string encoding 규칙이라 한다.

  (1) 모든 데이터들은 name=value 형식이어야 한다.
  (2) 여러개의 name=value쌍을 전달할 때는 & 기호로 구분한다.
  (3) 공백은 + 문자로 변환되어 전달된다.
  (4) 영문과 숫자 그리고 일부 특수문자를 제외하고 % 기호와 함께 
        16진수 코드값으로 전달되어야 한다.


https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8
                               &query=ABCabc+123%EA%B0%80%EB%82%98%EB%8B%A4


	id=ajaxtest&passwd=12345
	id=%EA%B0%80%EB%82%98%EB%8B%A4&passwd=12345
	id=100%20200&passwd=12345

 Web Client : HTML5, CSS3, JavaScript   ---> edu
 Web Server : Servlet, JSP, (JDBC), Spring FW, MyBatis FW
                   (Junit FW, Log4J) - Java    ---> sedu


  http://localhost:8000/sedu/first.jsp?gname=듀크
  http://localhost:8000/sedu/first.jsp?gname=또치
  http://localhost:8000/sedu/firstone
  http://localhost:8000/sedu/firstone?gname=고길동
  http://localhost:8000/sedu/firstone?gname=둘리

 [ Servlet ]
 - 1998년 가을에 발표된 기술
    CGI(Common Gateway Interface)-웹의 표준, 구현언어 투명성
    ---> Fast CGI
    ---> Servlet
 - Server Side Applet(Applet : 웹 브라우저에서 싱행되는 Java 프로그램)
 - 구현상의 특징
   (1) HttpServlet 을 상속해야 한다.
   (2) main() 구현하지 않는다. (main() 메서드를 담고 있는 메인 클래스는 톰캣이 내장)
   (3) 수행하는 동안 호출되는 메서드가 정해져 있는데
        이 때 호출되는 메서드는 init(), service(), destory(), doGet(), doPost() 등이다.
        하여 이 메서드들을 선택적으로 오버라이딩해서 구현한다.
   (4) 서블릿에서 수행 결과를 출력할 때
        - 요청해온 브라우저로의 출력(응답) - HttpServletResponse 의 getWriter() 를
                                                     호출해서 클라이언트로의 출력 스트림 객체 생성
                                                     해서 출력
        - 표준 출력 : System.out.println() - 톰캣서버의 콘솔창에 출력
    (5) 서블릿이 수행하는데 필요한 데이터를 요청 보내오는 클라이언트로 부터 전달받을 수
         있다. 이 때 전달받는 데이터를 쿼리 문자열이라 한다.
	HttpServletRequest 의 getParameter():String
             또는 getParameterValues():String[]  를 사용한다.          
 - 수행상의 특징
    (1) 서블릿을 요청할 때는 "/컨텍스트루트명/서블릿의매핑명" 형식의 URI 를 사용한다.
    (2) 서블릿의 요청은 
       - 서블릿을 요청하는 URL 문자열을 브라우저의 주소 필드에 입력해서 직접 요청:GET
       - <a> 태그로 요청:GET
       - <form> 태그를 통해서 요청:GET/POST
    (3) 서블릿 객체는 한 번 생성되는 서버 종료되거나 컨텍스트가 리로드될때까지
         객체 상태를 유지한다.
    (4) 여러 클라이언트가 동일한 서블릿을 동시 요청하면 하나의 서블릿 객체를 공유해서
         수행한다.
    (5) 최초 요청시의 수행 흐름
          init(),     service() -> doGet(),     destroy()     
		          -> doPost()


   core 패키지 : FlowServlet(/flow)
                     MemberLocalServlet(/memberlocal) - GET
	        QueryServlet(/query) - GET

   http://localhost:8000/sedu/memberlocal

   Web Server : Web 통신에서 서버역할을 수행하는 프로그램(Http Server)

   Web Server + Application Server = Web Application Server = WAS
   TOMCAT = WAS = 코요테(웹서버)+카탈리나(어플리케이션서버)   

   http://localhost:8000/edu/query?p1=듀크&p2=24&p3=또치&p3=희동&p3=도우너

   java 소스들은 core 패키지에 붙인다.
   html 파일들은 WebContent 에 html 폴더를 생성하고 여기에 붙인다.

  http://localhost:8000/sedu/querytest?
  stname=%EB%93%80%ED%81%AC&pwd=1234&age=5&
  gender=%EC%97%AC%EC%9E%90&
  hobby=%ED%94%BC%EC%95%84%EB%85%B8&
  hobby=%EC%88%98%EC%98%81&
  hobby=%EB%8F%85%EC%84%9C&
  hobby=%EA%B2%8C%EC%9E%84&
  color=%EB%85%B8%EB%9E%91%EC%83%89&
  food=%EB%9D%BC%EB%A9%B4&
  food=%EB%83%89%EB%A9%B4&
  food=%EC%A7%9C%EC%9E%A5%EB%A9%B4&
  food=%ED%96%84%EB%B2%84%EA%B1%B0&
  food=%EC%9C%A1%ED%9A%8C&
  op=%EC%A7%91%EC%97%90+%EA%B0%80%EC%9E%90...%0D%0A%EC%A7%91%EC%97%90&
  h_1=-%E3%85%85-&
  h_2=%3D%E3%85%85%3D



# 20200117 정리 내용

- 이름을 똑같이 주고 value 값을 다르게 해서 해야 한다. 체크박스를 체크 안하면 hobby는 제외되고 출력된다.

- required는 필수라는 의미이다.

- 애초에 required 라면 필수입력이지만, required가 아니면 선택항목이기 때문에 서버에서 체크해야 한다.

  - name=duke&passwd=1234&age=&gender=female

    ​	request.getparameter("name")  -> "duke"

    ​	request.getparameter("passwd")  -> "1234"

    ​	request.getparameter("age")  -> "" 값이 없으면 ""

    ​	request.getparameter("hobbu") -> null 애초에 hobby에 대한 입력이 없으면 null return

    

