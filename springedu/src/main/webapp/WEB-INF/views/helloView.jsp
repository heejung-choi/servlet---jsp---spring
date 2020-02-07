<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>Result of processing the view</h1>
<hr>
<%
String result = (String)request.getAttribute("msg");
%>
expression tag : <%= result %> <!-- 스크립트 태그로 꺼낸것 -->
<hr>
EL : ${ msg }  <!-- el태그로 꺼낸것 -->
</body>
</html>


