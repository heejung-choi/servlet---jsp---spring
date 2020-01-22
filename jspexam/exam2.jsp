<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int member_v =0; %> <!-- 멤버변수 선언에는 !를 줘야하고 선언문 태그는 서블릿의 멤버를 정의하는 태그이다.-->
<!-- 지역변수 선언에는 !를 주면 안된다. 매서드안에 작성하는 것은 수행문 태그에 작성하면 된다.-->
<% /* 수행문 태그 */
	int local_v =0; 
	member_v +=10;
	local_v +=10;
%> 
<ul>
<li>멤버변수 : <%= member_v %></li><!--  표현식 태그: 대입연산자의 오른쪽에 오는것만 올 수 있다. out.print 안에 들어간다. -->
<li>로컬변수 : <%= local_v %></li>
</ul>

</body>
</html>