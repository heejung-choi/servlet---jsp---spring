<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP 맛보기</h1>
<hr>
<h3>현재 시간 정보: <%= java.time.LocalDateTime.now() %></h3>
<!-- jsp는 최초 요청시 서블릿으로 바뀌기 때문에 최초요청시 시간이 조금 걸린다. -->
</body>
</html>