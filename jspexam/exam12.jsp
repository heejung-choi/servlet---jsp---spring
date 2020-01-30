<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 예제</title>
</head>
<body>
<h2>include 지시자와 액션태그 비교</h2>
<hr>
<%-- <%@ include file="date.jsp" %>
<hr>
<%@ include file="date.jsp" %> --%>
<!-- 두번 include하면 에러가 난다. 1개의 서블릿안에 두개가 복사되기 때문에
선언됬던 변수가 한번더 선언되어 오류가 난다.-->

<%-- <hr>
<jsp:include page="date.jsp" />
<hr>
<jsp:include page="date.jsp" /> --%>
<!-- html주석으로 묶게되면 실행된다. 따라서 jsp주석으로 묶어야 한다. -->
</body>
</html>






