<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>표현식 태그 테스트</h1>
<hr>
<% int num=10; %>
<ul>
	<li><%= 100 %></li> <!-- 리터럴 -->
	<li><%= num %></li> <!-- 변수 선언 안하면 오류가 난다 위에 선언해야 한다.  -->
	<li><%= ++num %></li>
	<li><%= num*2 %></li>
	<li><%= "가나다".length() %></li>
	<li><%= num % 2 == 0  %></li>
	<li><%= request.getParameter("stname") %></li>	
	<li><%= new java.util.Date(session.getCreationTime()) %></li>
	<li><%= application.getServerInfo() %></li>
	<li><%= application.getContextPath() %></li>

	
</ul>
</body>
</html>