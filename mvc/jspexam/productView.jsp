<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "model.vo.ProductVO"%>
    
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
ProductVO vo =(ProductVO)session.getAttribute("cnt");
	//session request 객체에 담았으면 꺼낼때 Object로 돌려주므로 형변환 해줘야 한다.
%>
<h1>선택된 상품 정보는 다음과 같습니다.</h1>
<hr>
<h3>선택된 사과의 갯수: <%=vo.getApple()%></h3>
<h3>선택된 바나나의 갯수: <%=vo.getBanana()%></h3>
<h3>선택된 한라봉의 갯수: <%=vo.getHalabong()%></h3>
<br>
<a href="/mvc/htmlexam/product.html">상품 선택화면</a>
</div>
</body>
</html>