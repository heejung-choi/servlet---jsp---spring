<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Query 문자열 추출(GET&amp;POST)</h1> <!-- 특수문자에 원인에러가 나오기 때문에 amp를 써줘야 한다. -->
<hr>
<% 
	if(request.getMethod().equals("POST")){ /* request.getMethod()요청방식이 뭔지 추출하는 메서드 */
		request.setCharacterEncoding("utf-8");
	}
%>
<h2>당신의 이름은 <%= request.getParameter("name")%>이군요!!</h2>
<a href= "<%= request.getHeader("referer") %>"> 입력화면으로 </a> 
<!-- request.getHeader("referer")는 jsp를 요청한 html의 URL을 호출해준다 -->.
</body>
</html>