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
background: linear-gradient(to bottom left, #ffff99 0%, #ff6699 84%);
}
</style>
</head>
<body>
<div>
<%
ProductVO vo =(ProductVO)session.getAttribute("cnt");
	//session request 객체에 담았으면 꺼낼때 Object로 돌려주므로 형변환 해줘야 한다.
%>
<h1>선택된 상품 정보는 다음과 같습니다.(스크립트 태그))</h1>
<hr>
<h3>선택된 사과의 갯수: <%=vo.getApple()%></h3>
<h3>선택된 바나나의 갯수: <%=vo.getBanana()%></h3>
<h3>선택된 한라봉의 갯수: <%=vo.getHalabong()%></h3>
<br>
<a href="/mvc/htmlexam/product.html">상품 선택화면</a>
</div>
<br>
<div>
<jsp:useBean id="cnt" class="model.vo.ProductVO" scope="session"/> <!-- 보관하는 변수 명으로도 쓰이고  객체명으로도 쓰인다. -->
<!-- useBean은 직접 저장하든 새로 만들어서 저장하든, 저장하라는 의미 -->
<h1>선택된 상품 정보는 다음과 같습니다.(액션 태그)</h1>
<hr>
<h3>선택된 사과의 갯수:<jsp:getProperty name="cnt" property= "apple"/></h3>
<h3>선택된 바나나의 갯수:<jsp:getProperty name="cnt" property= "banana"/></h3>
<h3>선택된 한라봉의 갯수:<jsp:getProperty name="cnt" property= "halabong"/></h3>
<br>
<a href="/mvc/htmlexam/product.html">상품 선택화면</a>
</div>
<br>
<div>
<h1>선택된 상품 정보는 다음과 같습니다.(표현 언어)</h1>
<hr>
<h3>선택된 사과의 갯수: ${sessionScope.cnt.apple}</h3>
<h3>선택된 바나나의 갯수: ${sessionScope.cnt.banana}</h3>
<h3>선택된 한라봉의 갯수: ${sessionScope.cnt.halabong}</h3>
<br>
<a href="/mvc/htmlexam/product.html">상품 선택화면</a>
</div>
</body>
</html>