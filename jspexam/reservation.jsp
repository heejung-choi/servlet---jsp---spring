<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url(//fonts.googleapis.com/earlyaccess/jejuhallasan.css);
@import url(//fonts.googleapis.com/earlyaccess/hanna.css);
section{
	font-family: 'Hanna', sans-serif;
	background: linear-gradient(to bottom, #33ccff 0%, #ff99cc 75%);
	width : 50%;			
	margin-left : auto;
	margin-right : auto;
	padding: 12px 20px;
}
h1 {
	font-size:2em;	
   	color: white;   	 
}
ul,a{
	font-size:1.3em;	
}

</style>
</head>
<body>
<% 
request.setCharacterEncoding("UTF-8");
String[] service = request.getParameterValues("service");	
String date = request.getParameter("date");
LocalDate ndate = LocalDate.parse(date);
DateTimeFormatter dateF = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
String newDate = ndate.format(dateF);
%>
<section>
<h1><%=request.getParameter("name")%>님의 예약 내용</h1><hr>
<ul>
<li>룸: <%=request.getParameter("room")%></li>
<li>추가 요청 사항 :
<%
for (int i = 0; i < service.length; ++i) {
	if (i == service.length - 1) {
		out.print(service[i]);
		break;}
	out.print(service[i] +",");} %>
</li>
<li>예약날짜: <%=newDate%></li>
</ul><hr>
<a href='http://localhost:8000/sedu/html/reservation.html'>예약 입력화면으로</a>
</section>
</body>
</html>



