<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="errorPage.jsp"%>
<!--     실행하다가 오류가 나면 errorPage="errorPage.jsp"를 수행해서 에러페이지를 보여주게 하는것이다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>errorPage 속성 테스트</h2>
<hr>
<%
     String name = request.getParameter("guestName"); 
%>
<h3>당신의 이름은 <%= name %> 이고 이름의 길이는
           <%= name.length() %> 입니다.</h3>
</body>
</html>















