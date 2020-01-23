<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h2><%= time1 %>에 당첨!! 추카추카</h2>
<img src="/edu/images/success.jpeg" width="300px">



</body>
</html>