# 2020 01 22 정리

# [JSP : Java Server Pages]

### Servlet 과 JSP 비교

CGI : 어떤 언어로든 구현 가능하지만, API가 없어서 코드 구현이 어려웠다. 

CGI를 쉽게 구현해 주는것이 ASP, PHP 이다.

 ASP, PHP 가 쉽다. sun사에서 JSP만들때 가장 많이 염두한 것이 ASP보다 쉽게 하는것 이다.

|                           Servlet                            |                             JSP                              |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
|                             1998                             |                             1999                             |
| html 태그 출력하는 것, 오타입력, 자바언어를 어느 수준으로  알아야 하는것에 대한 어려움이 있다. | 서블렛프로그램을 웹기반으로 편하게 하기 위해서 개발 되었다.  실행될 때 Servlet으로 변경된다. |
|                JAVA 기반으로 출력 결과는 HTML                |              HTML + JSP 태그 + 약간의 Java코드               |

Servlet과 JSP의 장점과 단점개선을 한것이 MVC 개발패턴이다.(Servlet+JSP)

요청은 Servlet이 응답은 JSP가 받는다 -> 유지보수성, 재사용성, 확장성이 좋다.





# JSP

(1) 내장객체 : 가져다 쓰기만 하면 된다. -> 자바를 잘 모르는 사람도 Servlet기반의 프로그래밍을 할 수 있다. -> 기본적으로 html문서안에서 수행하기 때문에 원하는 곳에 java 코드를 껴 넣는 형식이다. 



- 내장객체는 9개가 있다.

- request, response, session, out, (이 네가지를 가장 많이 쓴다.)

- application, config, exception, page, pageContext

  (상태정보 확인하고 싶다면 session.뭐뭐뭐 이런식으로 해도 된다.)



(2) JSP  태그 

|   <%@   %>   |   <%!   %>    |      <%=   %>      |      <%   %>      | <%--  --%> |
| :----------: | :-----------: | :----------------: | :---------------: | :--------: |
|  지시자태그  |  선언문 태그  |    표현식 태그     |    수행문 태그    |  주석태그  |
| 지시하는태그 | 멤버변수 선언 | out.print를 대신함 | if문 for문등 수행 |            |

- 선언문, 표현식 , 수행문 3개의 태그를 스크립팅태그라고 한다.
- 표현식 태그만 html 태그 안에 선언하는 것이 가능하다.
- 표현식 태그 안에는 출력할 수 있는 식만 들어올 수 있다. (while, if, 변수선언 못온다.)
- 수행문 태그는 멤버변수선언 이외에 어떤 코드든 올 수 있다. 요청시마다 수행되는 코드가 된다. 또한 이안에 선언되는 변수는 지역변수가 된다.
- 지시자태그는 소스코드 변화할때 (import와 같은것)
- 지시자 태그 -> jsp를 servlet으로 변환해주는 프로그램을 컴버터? 라고 하는데 그것이 jsp코드를 읽고 그것에 알맞는 servlet소스로 변환시켜주는데 error page 속성은 jsp파일이 서블릿으로 변환되고 나서 효과가 있다. 여기서 지시자 태그는 서블릿한테 이렇게해라 라고 지시하는 것인데. 지금까지 본것은 페이지 지시자 태그 였다.
- <%@ page 속성명 ="속성값" ....%> : **page 지시자 태그**
- language, contentType, pageEncoding,  errorPage, isErrorpage, import
- session, buffer, isELIgored ....
- <%@ include file="포함하려는 대상파일의 로컬URL" %> : **include 지시자 태그**
  - 포함하는 위치: 이지시자 태그가 사용된 위치
  - 포함하는 시기: JSP를 Servlet으로 변환하기 전
  - 포함하는 대상: html, jsp, jspf 
  - include 지시자는 안에 대상을 불러와서 서블릿으로 변환한다.
  - 페이지 지시자는 맨아래 해도 결과가 같지만 통상적으로 위에 작성한다.



(3) 액션태그

자바코드를 대신해서 사용하는 코드이고, 그기능이 필요할 때  쓰면 된다.

| <jsp:include /> | <jsp:forward /> | <jsp:param /> |
| :-------------: | :-------------: | :-----------: |
|                 |   요청재지정    |               |

<jsp:forward /> 이렇게 jsp를 붙여줘야 한다. 붙여주지 않으면 jsp로 인식 못하기 때문에, 브라우저에 보내진다. 

<jsp:include />: 다른것을 포함하여 같이 응답하고 싶을때 사용

(4) 커스텀태그 -> 원하면 자기 고유의 태그를 만들 수 있다.

JSTL







- jsp는 get방식, post방식을 나누지 않고 모두 지원 한다.

- 선언문 태그는 첫번째 멤버변수로 선언되어 있다.

- 각각의 태그의 기능에 맞춰서  Servlet으로 바뀔때 적당한 코드를 넣어 다른 위치에 들어간다.

- request.getHeader("referer")는 jsp를 요청한 html의 URL을 호출해준다.
- <%! 에서 !는 태그 자체 임으로 %와 !사이에 공백이 있으면 안된다.



# 2020 01 23 정리

### date 속성 다르게 해서 주는 방법

```
<%
String date = request.getParameter("date");
String pattern = "(\\d{4})-(\\d{2})-(\\d{2})";
Pattern p = Pattern.compile(pattern);
Matcher m = p.matcher(date);
String datestr="";
while(m.find()) {
	datestr = String.format("%s년%s월%s일", m.group(1), m.group(2), m.group(3));
}
%>
<li>예약날짜: <%= datestr %> </li>
```



- exception은 jsp 내장객체 변수이다. 이것은 아무때나 쓸 수 없다. 예외가 발생해야 쓸수 있는 것이여서
  page isErrorPage="true" 페이지 지시자 태그에 isErrorPage가 ture여야만 사용할 수 있다.
  기본값이 false이기 때문에 jsp가 servlet으로 변환될때 true이면 사용할 수 있다.



- jsp 안에 html로만 구성할수도 있고 적당한 자바코드와 함께 구성할수도 있다.
- include 지시자는 안에 대상을 불러와서 서블릿으로 변환한다.
- include 지시자로 할때에는 jsp구문에 위배되지 않는것만 할 수 있다. ex> servelt코드를 한다라고 하면 안된다. 

```
 <jsp:forward page="admin_new.jsp"> 
<!--   forward의 url을 주는데 컨텍스드패스 제외한 것만 줘야한다. -->

<jsp:param name="message" value="Hi! Administrator" />
<!-- 	종료태그가 없다면 >옆에 슬레시(/)를 줘야 한다. -->

<jsp:forward page="user_new.jsp">
<jsp:param name="message" value="Hi! User" />
jsp:param 이라는서버를 추가하면 forward되는 대상의 name값을 지정해줄 수 있다.
```

-  include는 수행시키고 결과를 포함해라라는 뜻 / 수행자체는 별개로 이루어진다. 수행 결과만 포함하는 것이다.
- forward는 결과를 바꿔줌 





a.jsp  b.jsp

- include action 태그로 : 2개의 서블릿

- include 지시자 태그로: 1개의 서블릿 (포함관계 a.jsp안에 b.jsp가 포함되어 있다.)

- include 지시자를 사용하는 것을  적정include, include action으로 하는것을 동적 include(동적포함) 이라고 한다.

```jsp
<jsp:include page="date.jsp" />
<jsp:include page="date.jsp" />
-> 결과 2020년 1월 23일이 두번 나온다.
-> 같은 버퍼안에 있다가 한꺼번에 클라이언트한테 응답되는 형식이다.

<%@ include file="date.jsp" %>
<hr>
<%@ include file="date.jsp" %> 
<!-- 두번 include하면 에러가 난다. 1개의 서블릿안에 두개가 복사되기 때문에
선언됬던 변수가 한번더 선언되어 오류가 난다.-->


```

