<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String name=request.getParameter("name");

%>

<h2><%= name %>님은 C등급입니다... 조금만 더 분발하세요</h2>
<img src="/mvc/images/C.png" width="300px">
<br>
<a href=http://localhost:8000/mvc/htmlexam/eduForm.html>성적입력 화면으로</a>
</body>
</html>