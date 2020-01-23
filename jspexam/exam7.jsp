<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 방식에 따른 처리</title>
<style>
	input {
		margin : 3px;
	}
</style>
</head>
<body>
	<% if (request.getMethod().equals("GET")) { %>
		<h2>원하는 칼라와 날짜를 선택하세요</h2>
		<!-- jsp는 get/post 방법 사용한다.  -->
		<form method="post" action="/sedu/jspexam/exam7.jsp"> 
		<!-- 이렇게 자기자신 요청할때에는 action 태그 생략해도 된다.  -->
			칼라 : <input type="color"  name="fcolor" ><br>
			날짜 : <input type="date"  name="fdate"><br>
			<input type="submit" value="전송">
		</form>
	<% } else { %>	
			<script>
				document.body.style.backgroundColor =
					         '<%= request.getParameter("fcolor") %>'; 
					         /* 인용부호 안에서도 표현식 방법을 사용할 수 있다. */
			</script>
			<h2>선택 날짜는 <%= request.getParameter("fdate") %> 이네요..</h2>
			
		<!-- 	jsp의 표현식 태그는 자바스크립트 태그에 필요한 값에도 쓸 수 있다.
			표현식태그 안에는 서버에서 먼저 수행되어 클라이언트에게 오기 때문에 최종적으로는 자바스크립트 or css 수행의 결과에 영향을 미친다 -->
	<% } %>
</body>
</html>





