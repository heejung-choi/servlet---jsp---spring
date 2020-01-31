<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.MeetingVO, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url(//fonts.googleapis.com/earlyaccess/hanna.css);
body{
font-family: 'Hanna', sans-serif;
}
	td {
		border-bottom : 1px dotted green;
	}
	tr:hover {
		background-color : pink;
		font-weight : bold;
	}
	td:nth-child(3) {
		width : 400px;
	}
	img{
	border-radius: 10px;
	}
	h2 {
  	color: black;
    text-shadow: 0 0 50px #ccffcc, 0 0 50px #ccffcc;
	}
	div {
	width : 50%;
	margin-left : auto;
	margin-right : auto;	
	padding: 50px;
	border-style: dotted dashed solid double;
	border-color: gray;
	background: linear-gradient(to right, #ffcccc 20%, #ccffcc 99%);
	}
</style>
</head>
<body>
<div>
<%
	List<MeetingVO> list = (List<MeetingVO>)request.getAttribute("list");
    if (list != null) {
%>
   	<h2>미팅 스케줄</h2><hr>
   	<table>    
<%	
   	for(MeetingVO vo : list) { 	   
%>
	<tr>
		<td><%= vo.getId() %></td>
		<td><%= vo.getName() %></td>
		<td><%= vo.getTitle() %></td>
		<td><%= vo.getMeetingDate() %></td>
		<td><a href=/mvc/meeting?action=delete&id=<%=vo.getId()%>><img src="/mvc/images/hu.jpg" width=50 height=50 ></a></td>
		<td><a href=/mvc/meeting?action=update&id=<%=vo.getId()%>><img src="/mvc/images/update.png" width=50 height=50 ></a></td>		
	</tr>
<%
    	}
%>
<%


%>			
<%
    } else {
%>
		<h2>${msg}</h2>
<%
    }
%>
<hr>
<a href="/mvc/htmlexam/meetingForm.html">미팅 홈 화면으로 가기</a>

</div>

</body>
</html>



