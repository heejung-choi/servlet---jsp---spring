<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- java.net -->
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 테스트</title>
</head>
<body>
<h2>위도와 경도 받아오는 예제</h2>
<hr> 
<c:catch var="error">  
 <c:import var="map"  url="https://maps.googleapis.com/maps/api/geocode/xml"> 
   <c:param name="address" value="${param.address}"/>
   <c:param name="language" value="${param.language}"/>
   <c:param name="key" value="${param.key}"/>   
   </c:import>
 <x:parse varDom="mapDom" xml="${map}"></x:parse>
 <x:if select="$mapDom//status='OK'">  
	<h3>주소: <x:out select="$mapDom/GeocodeResponse/result/formatted_address"/> </h3>
	<h3>위도: <x:out select="$mapDom/GeocodeResponse/result/geometry/location/lat"/> </h3>
	<h3>경도: <x:out select="$mapDom/GeocodeResponse/result/geometry/location/lng"/> </h3> 
 </x:if>
   
<x:if select="$mapDom//status !='OK'">
		 <h3><x:out select="$mapDom/GeocodeResponse/error_message"/> </h3>  
			<a href="/mvc/jspexam/lating.jsp">입력 화면으로</a>
		</x:if>
</c:catch>
<c:if test="${!empty error}">
   <h2>잘못된 요청입니다.</h2>
   ${err} 
</c:if> 
</body>
</html>