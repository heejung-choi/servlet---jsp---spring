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
java.text.SimpleDateFormat format1 = new java.text.SimpleDateFormat ( "hh시 mm분");
java.util.Date time = new java.util.Date();
String time1 = format1.format(time);

%>

<h2><%= time1 %>에 실패!! 아쉽아쉽</h2>
<img src="/edu/images/fail.png" width="300px">
</body>
</html>