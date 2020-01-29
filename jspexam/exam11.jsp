<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<HTML>
<HEAD>
<META charset="UTF-8">
<TITLE>INCLUDE 액션태그 예제</TITLE>
</HEAD>
<BODY>
<H3>INCLUDE 액션태그 예제</H3>
<H4>각 나라의 감사 인사말입니다.</H4>
<P>
한국어 : 
<!-- include 지시자로 할때에는 jsp구문에 위배되지 않는것만 할 수 있다. ex> servelt코드를 한다라고 하면 안된다. -->
<!-- include는 수행시키고 결과를 포함해라라는 뜻 / 수행자체는 별개로 이루어진다. 수행 결과만 포함하는 것이다.
forward는 결과를 바꿔줌 -->
<jsp:include page="greeting.jsp"> 
   <jsp:param name="country" value="korea" />
</jsp:include>
</P>
<P>
영어 :
<jsp:include page="greeting.jsp">
   <jsp:param name="country" value="english" />
</jsp:include>
</P>
<P>
일본어 :
<jsp:include page="greeting.jsp">
   <jsp:param name="country" value="japan" />
</jsp:include>
</P>
</BODY>
</HTML>





