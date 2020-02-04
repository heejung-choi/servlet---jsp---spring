<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.MeetingVO, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<h2>미팅 스케줄(JSTL)</h2><hr>
	<!-- List<MeetingVO> list = (List<MeetingVO>)request.getAttribute("list"); -->
<c:if test="${! empty requestScope.list}">   
<!-- ! empty -> null이 아니라면 -->
<%-- request.setAttribute("이름","값")으로 저장한 값들은 ${requestScope.이름}형식으로 가져와야 한다. --%>
<%-- request.setAttribute("list", list); 으로 저장했기 때문에 ${requestScope.list} 으로 가져오는 것이다. --%>
<table>	
<c:forEach var="j" items="${requestScope.list}">	
<tr>	
	<td><c:out value="${j.id}"/></td>
	<td><c:out value="${j.name}"/></td>
	<td><c:out value="${j.title}"/></td>
	<td><c:out value="${j.meetingDate}"/></td>			
	<td><a href=/mvc/meeting?action=delete&id=<c:out value="${j.id}"/>><img src="/mvc/images/hu.jpg" width=50 height=50 ></a></td>
	<td><a href=/mvc/meeting?action=update&id=<c:out value="${j.id}"/>><img src="/mvc/images/edit.png" width=50 height=50 ></a></td>		
</tr>
</c:forEach>
</table>
</c:if>    
<c:if test="${empty requestScope.list}">
		<h2>${msg}</h2>
</c:if>
<hr>
<a href="/mvc/htmlexam/meetingForm.html">미팅 홈 화면으로 가기</a>

</div>

</body>
</html>



