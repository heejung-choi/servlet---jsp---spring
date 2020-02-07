<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><%= request.getAttribute(
		"javax.servlet.forward.request_uri") %> Request successful!!!</h2>
<!-- 	 /springedu/select  -->
<h2><%= request.getRequestURI() %> Request successful!!!</h2>
<!-- 	jsp는 포워드 당한것인데 거기에 getRequestURI()라는 api가 있다.
/springedu/WEB-INF/views/viewTest.jsp
컨트롤러에서 추출할때는 문제가 없는데 포워드를 하는 순간 넘어간 자원의 URI가 나왔다. 그래서 포워드가 일어날 때에는 
와스가"javax.servlet.forward.request_uri" 이름으로 보관해준다. 클라이언트가 요청했던 URI를
여기서 확인할 수 있다. -->
<hr>
<h2>Request Method : ${ pageContext.request.method }</h2>
<hr>
<h2>Query Value : ${ param.pageno }</h2>
<hr>
<a href='${ header.referer }'>To Form Page....</a>
<!-- el에서는 referer도 간단하다. -->
</body>
</html>





