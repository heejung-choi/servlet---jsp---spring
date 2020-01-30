<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "model.vo.LottoVO"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	LottoVO vo =(LottoVO)request.getAttribute("lotto");
	//session request 객체에 담았으면 꺼낼때 Object로 돌려주므로 형변환 해줘야 한다.
%>
<h1><%=vo.getMsg()%></h1>
<%
if(vo.getImgUrl()!=null){
%>
	<img src= "<%= vo.getImgUrl() %>" width="100"><br><br> <!-- 단위안써도 자동으로 px -->
<%}%>
<%
if(vo.isLinkDisplay() ==true){
%>
	<a src= "<%= request.getHeader("referer")%>">로또응모</a>
<%}%>



</body>
</html>