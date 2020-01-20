# 20200116 정리 내용

- Web Client : HTML5, CSS3, JavaScript	-----> edu

- Web Server : Servlet, JSP, (JDBC), Spring FW, Mybatis FW

  ​						(Junit FW, Log4J) - Java	-----> sedu



[http://localhost:8000/sedu/first.jsp?gname=%EB%98%90%EC%B9%98](http://localhost:8000/sedu/first.jsp?gname=또치)

[http://localhost:8000/sedu/first.jsp?gname=%EB%93%80%ED%81%AC](http://localhost:8000/sedu/first.jsp?gname=듀크)

http://localhost:8000/sedu/firstone

http://localhost:8000/sedu/firstone?gname=고길동

http://localhost:8000/sedu/firstone?gname=둘리



## [ Servlet ]

- 1998년 가을에 발표된 기술

  CGI(Common Gateway Interface) - 웹의 표준, 구현언어 투명성

------> Fast CGI

------> Servlet



- Server Side Applet(Applet : 웹 브라우저에서 실행되는 Java 프로그램)

  

- 구현상의 특징

  1. HttpServlet 상속해야 한다.

     

  2. main() 구현하지 않는다. (main() 메서드를 담고 있는 메인 클래스는 톰캣이 내장)

     

  3. 수행하는 동안 호출되는 메서드가 정해져 있는데

     - 이 때 호출되는 메서드는 init(), service(), destroy(), doGet(), doPost() 등이다.

     - 하여 이 메서드들을 선택적으로 오버라이딩해서 구현한다.

       

  4. 서블릿에서 수행 결과를 출력 할 때

     - 요청해온 브라우저로의 출력(응답)

       - HttpServletResponse의 getWriter()를 호출해서 클라이언트로의 출력 스트링 객체 생성 해서 출력

     - 표준 출력 : System.out.println() 

       - 톰캣 서버의 콘솔창에 출력

         

  5. 서블릿이 수행하는데 필요한 데이터를 요청 보내오는 클라이언트로 부터 전달받을 수 있다.

     - 이 때 전달받는 데이터를 쿼리 문자열이라 한다.
     - HttpServletRequest 의 getParameter() /// String (값이 1개가 오기 때문)
     - 또는 getParameterValues() /// String[]를 사용한다. (값이 여러개가 오기 때문)



- 수행상의 특징

1. 서블릿을 요청할 때는 "/컨택스루트명/서블릿의매핑명" 형식의 URI를 사용한다.

   

2. 서블릿의 요청 방법

   - 서블릿을 요청하는 URL 문자열을 브러우저의 주소 필드에 입력해서 직접 요청 // GET방식

   - <a> 태그로 요청 // GET방식

   - ```
     <form> 태그를 통해서 요청 // GET방식이나 POST방식 사용가능
     ```



3. 서블릿 객체는 한 번 생성되면 서버가 종료되거나 컨택스트가 리로드 될 때까지 객체 상태를 유지한다.

   - 이것이 바로 서블릿이 속도가 빠른 이유이다.

     

4. 여러 클라이언트가 동일한 서블릿을 동시에 요청하면 하나의 서블릿 객체를 공유해서 수행한다.

   

5. 최초 요청시의 수행 흐름

   ```java
   init() -> service() -> doGet(), destroy()
       				-> doPost()
   ```

   

core 패키지 : FlowServlet(/flow)

​						MemberLocalServlet(/memberlocal) - GET



## [ Web Server ]

- Web 통신에서 서버역할을 수행하는 프로그램(Http Server)

- Web Server + Application Server = Web Application Server = WAS
- TOMCAT = WAS = COYOTE (웹서버) + Catalina (어플리케이션 서버)
  - 톰캣은 대표적인 무료 WAS이다.

[http://localhost:8000/sedu/query?p1=%EB%93%80%ED%81%AC&p2=24&p3=%EB%98%90%EC%B9%98&p3=%ED%9D%AC%EB%8F%99&p3=%EB%8F%84%EC%9A%B0%EB%84%88](http://localhost:8000/sedu/query?p1=듀크&p2=24&p3=또치&p3=희동&p3=도우너)



[http://localhost:8000/sedu/querytest?stname=%EB%93%80%ED%81%AC&pwd=12345&age=11&gender=%EB%82%A8%EC%9E%90&hobby=%EB%8F%85%EC%84%9C&color=%ED%8C%8C%EB%9E%91%EC%83%89&food=%EC%A7%9C%EC%9E%A5%EB%A9%B4&food=%ED%96%84%EB%B2%84%EA%B1%B0&food=%EB%8B%AD%EA%B0%95%EC%A0%95&op=%E3%84%B1%E3%84%B1%E3%84%B1&h_1=-%E3%85%85-&h_2=%3D%E3%85%85%3D](

# 20200117 정리 내용

- 이름을 똑같이 주고 value 값을 다르게 해서 해야 한다. 체크박스를 체크 안하면 hobby는 제외되고 출력된다.

- required는 필수라는 의미이다.

- 애초에 required 라면 필수입력이지만, required가 아니면 선택항목이기 때문에 서버에서 체크해야 한다.

  - name=duke&passwd=1234&age=&gender=female

    ​	request.getparameter("name")  -> "duke"

    ​	request.getparameter("passwd")  -> "1234"

    ​	request.getparameter("age")  -> "" 값이 없으면 ""

    ​	request.getparameter("hobbu") -> null 애초에 hobby에 대한 입력이 없으면 null return



# 주요 error

| error |                                                              |
| ----- | ------------------------------------------------------------ |
| 200   | OK: 오류없이 접속 성공                                       |
| 404   | Not Found, 문서를 찾을 수 없음->클라이언트가 요청한 문서를 찾지 못한 경우에 발생함 (URL을 잘 살펴보기) --> 404 톰캣서버 죽어있는가, 주소가 잘못 입력되었는가 |
| 405   | Method not allowed, 메소드 허용 안됨-> Request 라인에 명시된 메소드를 수행하기 위한 해당 자원의 이용이 허용되지 않았을 경우 발생함.  (페이지는 존재하나, 그걸 못보게 막거나 리소스를 허용안함)-->요청방식과 서블릿이 서포트하는 방식이 다른지 봐야 한다. 서블릿이 get방식, 서블릿이 post 방식이면 각각 그 방식으로 해야 한다. |
| 500   | 서버 내부 오류는 웹 서버가 요청사항을 수행할 수 없을 경우에 발생함 --> 서블릿이 제대로 찾아지고 요청되었으나, 서블릿에서 수행하다가 오류가 난 것이다.(서버내부오류) |



## 그외 error



클라이언트가 서버에 접속하여 어떠한 요청을 하면, 서버는 세 자리 수로 된 응답 코드와 함께 응답한다. HTTP의 응답 코드는 다음과 같다.

|  코드  |                   메시지                   |                             설명                             |
| :----: | :----------------------------------------: | :----------------------------------------------------------: |
|  1XX   |            Informational(정보)             |                          정보 교환.                          |
|  100   |                  Continue                  | 클라이언트로부터 일부 요청을 받았으니 나머지 요청 정보를 계속 보내주길 바람. (HTTP 1.1에서 처음 등장) |
|  101   |            Switching Protocols             | 서버는 클라이언트의 요청대로 Upgrade 헤더를 따라 다른 프로토콜로 바꿀 것임. (HTTP 1.1에서 처음 등장) |
|  2XX   |               Success(성공)                | 데이터 전송이 성공적으로 이루어졌거나, 이해되었거나, 수락되었음. |
|  200   |                     OK                     |                     오류 없이 전송 성공.                     |
|  202   |                  Accepted                  |              서버가 클라이언트의 요청을 수락함.              |
|  203   |       Non-authoritavive Information        |            서버가 클라이언트 요구중 일부만 전송.             |
|  204   |                Non Content                 |     클라이언트의 요구를 처리했으나 전송할 데이터가 없음.     |
|  205   |               Reset Content                | 새 문서 없음. 하지만 브라우저는 문서 창을 리셋해야 함. (브라우저가 CGI 폼 필드를 전부 지우도록 할 때 사용됨.) (HTTP 1.1에서 처음 등장) |
|  206   |              Partial Content               | 클라이언트가 Range 헤더와 함께 요청의 일부분을 보냈고 서버는 이를 수행했음. (HTTP 1.1에서 처음 등장) |
|  3XX   |           Redirection(방향 바꿈)           |                   자료의 위치가 바뀌었음.                    |
|  300   |              Multiple Choices              |                 최근에 옮겨진 데이터를 요청.                 |
|  301   |             Moved Permanently              |            요구한 데이터를 변경된 URL에서 찾았음.            |
|  302   |             Moved Permanently              | 요구한 데이터가 변경된 URL에 있음을 명시. 301과 비슷하지만 새 URL은 임시 저장 장소로 해석됨. |
|  303   |                 See Other                  |     요구한 데이터를 변경하지 않았기 때문에 문제가 있음.      |
|  304   |                Not modified                | 클라이언트의 캐시에 이 문서가 저장되었고 선택적인 요청에 의해 수행됨 (보통 지정된 날짜보다 더 나중의 문서만을 보여주도록 하는 If-Modified-Since 헤더의 경우).[[9\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-9) |
|  305   |                 Use Proxy                  | 요청된 문서는 Location 헤더에 나열된 [프록시](https://ko.wikipedia.org/wiki/프록시)를 통해 추출되어야 함. (HTTP 1.1에서 처음 등장) |
|  307   |             Temporary Redirect             |                  자료가 임시적으로 옮겨짐.                   |
|  4XX   |       Client Error(클라이언트 오류)        | 클라이언트 측의 오류. 주소를 잘못 입력하였거나 요청이 잘못 되었음. |
|  400   |                Bad Request                 | 요청 실패. 문법상 오류가 있어서 서버가 요청사항을 이해하지 못함,[[10\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-10) |
| 401.1  |                Unauthorized                | 권한 없음 (접속실패). 서버에 로그온 하려는 요청사항이 서버에 들어있는 권한과 비교했을 때 맞지 않음.[[11\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-11) |
| 401.2  |                Unauthorized                | 권한 없음 (서버설정으로 인한 접속 실패). 서버에 로그온 하려는 요청사항이 서버에 들어있는 권한과 비교했을 때 맞지않음.[[12\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-12) |
| 401.3  |                Unauthorized                | 권한 없음 (자원에 대한 ACL에 기인한 권한 없음). 클라이언트가 특정 자료에 접근할 수 없음.[[13\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-13) |
| 401.4  |                Unauthorized                | 권한 없음 (필터에 의한 권한 부여 실패). 서버에 접속하는 사용자들을 확인하기 위해 설치한 필터 프로그램이 있음.[[14\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-14) |
| 401.5  |                Unauthorized                | 권한 없음 (ISA PI/CGI 애플리케이션에 의한 권한부여 실패). 이용하려는 서버의 주소에 ISA PI나 CGI프로그램이 설치되어 있고, 권한을 부여할 수 없음.[[15\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-15) |
|  402   |              Payment Required              |                           예약됨.                            |
| 403.1  |                 Forbidden                  | 금지 (수행접근 금지). 수행시키지 못하도록 되어있는 디렉터리 내의 실행 파일을 수행하려고 하였음. |
| 403.2  |                 Forbidden                  | 금지 (읽기 접근 금지). 접근한 디렉터리에 가용한 기본 페이지가 없음.[[16\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-16) |
| 403.4  |                 Forbidden                  | 금지 ([SSL](https://ko.wikipedia.org/wiki/SSL) 필요함). 접근하려는 페이지가 SSL로 보안유지 되고 있음.[[17\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-17) |
| 403.5  |                 Forbidden                  | 금지 ([SSL](https://ko.wikipedia.org/wiki/SSL) 128필요함). 페이지가 128비트의 SSL로 보안유지 되고 있음.[[18\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-18) |
| 403.6  |                 Forbidden                  | 금지 (IP 주소 거부됨). 사용자가 허용되지 않은 IP로부터 접근함. |
| 403.7  |                 Forbidden                  | 금지 (클라이언트 확인 필요). 클라이언트가 자료에 접근할 수 있는지 확인 요함.[[19\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-19) |
| 403.8  |                 Forbidden                  | 금지 (사이트 접근 거부됨). 서버가 요청사항을 수행하고 있지 않거나, 해당 사이트에 접근하는 것이 허락되지 않음. |
| 403.9  |                 Forbidden                  | 접근금지 (연결된 사용자수 과다). 서버가 BUSY 상태에 있어서 요청을 수행할 수 없음. |
| 403.10 |                 Forbidden                  |              접근금지 (설정이 확실 하지 않음).               |
| 403.11 |                 Forbidden                  |     접근금지 (패스워드 변경됨). 잘못된 암호를 입력했음.      |
| 403.12 |                 Forbidden                  | 접근금지(Mapper 접근 금지됨). 클라이언트 인증용 맵이 해당 웹 사이트에 접근하는 것이 거부됨. |
|  404   |                 Not Found                  | 문서를 찾을 수 없음. 서버가 요청한 파일이나 스크립트를 찾지 못함. |
|  405   |             Method not allowed             | 메서드 허용 안됨. 요청 내용에 명시된 메서드를 수행하기 위해 해당 자원의 이용이 허용되지 않음.[[20\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-20) |
|  406   |               Not Acceptable               | 받아들일 수 없음.[[21\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-21) |
|  407   |       Proxy Authentication Required        | 프록시 서버의 인증이 필요함.[[22\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-22) |
|  408   |              Request timeout               |                      요청 시간이 지남.                       |
|  409   |                  Conflict                  | 요청을 처리하는 데 문제가 있음. 보통 PUT 요청과 관계가 있다. 보통 다른 버전의 파일을 업로드할 경우 발생함. (HTTP 1.1에서 새로 등장) |
|  410   | [Gone](https://ko.wikipedia.org/wiki/Gone) |                  영구적으로 사용할 수 없음.                  |
|  411   |              Length Required               | 클라이언트가 헤더에 Content-Length를 포함하지 않으면 서버가 처리할 수 없음.(HTTP 1.1에서 새로 등장) |
|  412   |            Precondition Failed             | 선결조건 실패. 헤더에 하나 이상의 선결조건을 서버에서 충족시킬 수 없음.[[23\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-23) |
|  413   |          Request entity too large          | 요청된 문서가 현재 서버가 다룰 수 있는 크기보다 큼.[[24\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-24) (HTTP 1.1에서 새로 등장) |
|  414   |            Request-URI too long            | 요청한 URI가 너무 김.[[25\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-25) |
|  415   |           Unsupported media type           |    요청이 알려지지 않은 형태임. (HTTP 1.1에서 새로 등장)     |
|  5XX   |          Server Error(서버 오류)           |        서버 측의 오류로 올바른 요청을 처리할 수 없음.        |
|  500   |           Internal Server Error            |                       서버 내부 오류.                        |
|  501   |              Not Implemented               | 필요한 기능이 서버에 설치되지 않았음.[[27\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-27) |
|  502   |                Bad gateway                 | 게이트웨이 상태 나쁨.[[28\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-28) |
|  503   |            Service Unavailable             | 외부 서비스가 죽었거나 현재 멈춘 상태 또는 이용할 수 없는 서비스.[[29\]](https://ko.wikipedia.org/wiki/HTTP#cite_note-29) |
|  504   |              Gateway timeout               | 프록시나 게이트웨이의 역할을 하는 서버에서 볼 수 있음. 초기 서버가 원격 서버로부터 응답을 받을 수 없음. (HTTP 1.1에서 새로 등장) |
|  505   |         HTTP Version Not Supported         |               해당 HTTP 버전을 지원하지 않음.                |



### 웹의 처리 구조

- 요청은  클라이언트 응답은 서버가 해야 한다.

- 서버는 동시에 접속할 수 있는 수의 제한이 있다.

- Connection Oriented : 전화하는 것 과 같이 신뢰성이 높다.
- stateless: 문자 보내는것 과 같이 신뢰성은 낮지만, 많은 숫자를 보낼 수 있다.
- get과 post를 주로 하고, ajax를 사용한다면 다른 방식을 사용하는 경우도 있다.



### Servlet 프로그래밍

- 스레드: 어떠한 프로그램 내에서, 특히 프로세스 내에서 실행되는 흐름의 단위를 말한다. 

```
<servlet>
<servlet-name>abc </servlet-name>
<servlet-class>FirstServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>abc </servlet-name>
<url-pattern>/firstthree</url-pattern>
</servlet-mapping>
</web-app>
```

톰캣: Web Server + Application Server : WAS

-----------			--------------------

 			코요테 				카탈리나

​										서블릿 엔진

​										서블릿 컨테이너

​									(클라이언트로부터 요청된 servlet 또는 tomcat을 요청하는 역할을 한다.)



#### HttpServletRequest 객체 

 getMethod()



# 20200120 정리 내용

​		

- **getRequestDispatcher 방식 -->forward()**는 컨텍스트패스 이후 부분을 줘야 한다.

  ```java
  RequestDispatcher rd = request.getRequestDispatcher("/sedu/first.html");
  이렇게 주면 404에러가 난다.(설명 Origin 서버가 대상 리소스를 위한 현재의 representation을 찾지 못했거나, 그것이 존재하는지를 밝히려 하지 않습니다.) 
  이렇게 하면 sedu 뒤에 또 seud가 붙기 때문이다. 따라서 아래와 같이 해야 한다.
  RequestDispatcher rd = request.getRequestDispatcher("/html/first.html"); 
  ```

  

edu,sedu는

os 입장에서 폴더 이다.

Exlipse 입장에서 Web Project

Tomcat 입장에서  Context(Context Path : / edu, /sedu)

Developer 입장에서 Web Application





- **redirect 방식**

1. Request URL: http://localhost:8000/sedu/redirect
2. Request Method: GET
3. Status Code: 302
4. 바뀐 URL :  http://localhost:8000/sedu/html/first.html
   - redirect 방식은 요청지정대상에 제한이 없다. forward는 제한이 있다.



### 상태정보 유지 기술

- 쿠키
  - 쿠키는 웹서버가 필요에 의해 웹 클라이언트인 브라우저에게 저장하는 네임벨류쌍의 데이터이다.
  - 장점: 서버에 오버헤드를 주지 않는다.
  - 단점: 클라이언트에 보관하는 거여서 보안적으로 기대하기 어렵다. 클라이언트가 제거하면 끝이다.
  - 서블렛/ 자바스크립트로 구현 가능
  - 쿠키는 저장할 수 있는 데이터에 제한이 있고, 최대 유지 기간이 3년이다.
- HttpSession 객체를 이용한 방법
  - 모든 클라이언트 정보를 서버에 저장
  - 단점: 서버 업그레이드



- 멤버변수 :
  - 멤버변수는 한번 메모리 할당되면 서버가 운영되는 내내 변수의 공간이 모든 클라이언트에 의해 공유된다.
- 지역변수:
  - 요청시 마다 메모리 각각 할당, 유지하지 않는다. 
- 세션 객체:(배열이든, 다른 객체이든 무관하다.)
  - 세션이 유지되는 동안, 클라이언트별로 개별적으로 요청

