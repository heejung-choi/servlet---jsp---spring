<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>EL의 Query 문자열 추출</h2>
<hr>
<!-- param은 쿼리의 네임벨류쌍을 해쉬맵에 담고있는 내장객체이다. -->

전달된 메시지의 존재 여부 : ${ !empty param.message }<hr>  <!-- param.message 가 비어있으면 -->
전달된 메시지의 내용은 ${param.message} 입니다.<br>
전달된 메시지의 내용은 ${param["message"]} 입니다.<br>
전달된 메시지의 내용은 <%=request.getParameter("message") %>입니다.
</body>
</html>