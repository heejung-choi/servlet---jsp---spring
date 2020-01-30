<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
  color: white;
  text-shadow: 0 0 15px #FF0000, 0 0 15px #0000FF;
}
div {
width : 50%;
margin-left : auto;
margin-right : auto;	
padding: 50px;
border-style: dotted dashed solid double;
border-color: gray;
background: linear-gradient(to right, #ccccff 0%, #ffcccc 100%);
}
span {
color: #ff1a8c;
}
</style>
</head>
<body>
<div>
<h1>요청을 처리하는 동안 오류가 발생했어요</h1>
<h2>오류의 원인 : <span><%=request.getAttribute("calcerror") %></span></h2>
<br>
<a href="<%=request.getHeader("referer")%>">입력화면 </a>
</div>
</body>
</html>