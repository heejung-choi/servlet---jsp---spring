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
<h2>${param.name} 님은 A등급입니다. 우수한 성적이네요(^^).</h2>
<img src="/mvc/images/A.png" width="300px">
<br>
<a href=http://localhost:8000/mvc/htmlexam/eduForm.html>성적입력 화면으로</a>
<a href="<%=request.getHeader("referer")%>">성적입력 화면으로</a>

</body>
</html>