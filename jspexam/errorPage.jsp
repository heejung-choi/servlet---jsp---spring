<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center">
<h2>오류 발생했어욤ㅠㅠ</h2>
<h3>빠른시일내에 복구하겠습니다...</h3>
<img src="error.jpg">
<%	
    String msg = "오류 원인 : " + exception;	
/* exception은 jsp 내장객체 변수이다. 이것은 아무때나 쓸 수 없다. 예외가 발생해야 쓸수 있는 것이여서
page isErrorPage="true" 페이지 지시자 태그에 isErrorPage가 ture여야만 사용할 수 있다.
기본값이 false이기 때문에
*/
	System.out.println("----------------------------------------");
	System.out.println(msg);
	System.out.println("----------------------------------------");	
	exception.printStackTrace();
%>
</body>
</html>






