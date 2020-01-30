<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "model.vo.MemberVO"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
width : 50%;
margin-left : auto;
margin-right : auto;	
padding: 50px;
border-style: dotted dashed solid double;
border-color: gray;
background: linear-gradient(to right, #ccccff 0%, #ffcccc 100%);
}
</style>
</head>
<body>
<div>
<%
MemberVO vo =(MemberVO)request.getAttribute("member");
	//session request 객체에 담았으면 꺼낼때 Object로 돌려주므로 형변환 해줘야 한다.
%>
<h1>회원정보</h1>
<hr>
<ur>
<li> 회원 이름: <%=vo.getName()%></li>
<li> 회원 전화번호: <%=vo.getPhone()%></li>
<li> 회원 계정: <%=vo.getEmail()%></li>
<li> 회원 패스워드: <%=vo.getPassword()%></li>
</ur>
</div>
</body>
</html>