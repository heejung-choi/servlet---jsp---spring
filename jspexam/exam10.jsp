<%@ page contentType="text/html; charset=utf-8"   %>
<!DOCTYPE html>
<html>
<HEAD>
<meta charset="UTF-8">
<TITLE>forward 액션 태그를 이용한 분기 예제  </TITLE>
</HEAD>
<BODY>
<% if(request.getParameter("type")==null || 
           request.getParameter("type").equals("admin") ){ %>
  <jsp:forward page="admin_new.jsp"> 
<!--   forward의 url을 주는데 컨텍스드패스 제외한 것만 줘야한다. -->
  	<jsp:param name="message" value="Hi! Administrator" />
  <!-- 	종료태그가 없다면 >옆에 슬레시(/)를 줘야 한다. -->
  </jsp:forward>
<% } else  {%>
  <jsp:forward page="user_new.jsp">
  	<jsp:param name="message" value="Hi! User" />
  	jsp:param 이라는서버를 추가하면 forward되는 대상의 name값을 지정해줄 수 있다.
  </jsp:forward>
<%} %> 
</BODY>
</HTML>
