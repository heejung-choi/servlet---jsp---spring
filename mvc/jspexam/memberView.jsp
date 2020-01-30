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
<h1>스크립트 태그</h1>
<div>
<%
MemberVO vo =(MemberVO)request.getAttribute("member");
	//session request 객체에 담았으면 꺼낼때 Object로 돌려주므로 형변환 해줘야 한다.
%>
<h1>회원정보</h1>
<hr>
<ul>
<li> 회원 이름: <%=vo.getName()%></li>
<li> 회원 전화번호: <%=vo.getPhone()%></li>
<li> 회원 계정: <%=vo.getEmail()%></li>
<li> 회원 패스워드: <%=vo.getPassword()%></li>
</ul>
<hr>
</div>
<h1>액션 태그</h1>
<div>
<jsp:useBean id="member" class="model.vo.MemberVO" scope="request"/> 
<!-- scope="request" -> request객체에서 꺼내오기 때문에 -->
<h1>회원정보</h1>
<hr>
<ul>
<li> 회원 이름: <jsp:getProperty name="member" property="name"/></li>
<li> 회원 전화번호: <jsp:getProperty name="member" property="phone"/></li>
<li> 회원 계정: <jsp:getProperty name="member" property="email"/></li>
<li> 회원 패스워드: <jsp:getProperty name="member" property="password"/></li>
</ul>
<hr>
</div>
<h1>표현언어(EL)</h1>
<div>
<h1>회원정보</h1>
<hr>
<ul>
<!--requstScope.꺼내고자 하는 객체의 이름.getter메서드의 property명 -->
<li> 회원 이름: ${requestScope.member.name}</li>
<li> 회원 전화번호: ${requestScope.member.phone}</li>
<li> 회원 계정: ${requestScope.member.email}</li>
<li> 회원 패스워드: ${requestScope.member.password}</li>
</ul>
<hr>
</div>
</body>
</html>