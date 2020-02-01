<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"  %>
    <%-- xml문서는 기본적으로 UTF-8이다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 테스트</title>
</head>
<body>
<h2>xml 라이브러리  태그 예제</h2>
<hr>
<c:import var="xmldata" url="http://localhost:8000/sedu/jspexam/student.xml" charEncoding="UTF-8"/>
<x:parse xml="${xmldata}" varDom="xdata"/> 
<!-- 파싱이 끝난 객체는 varDom에 저장하고 있다. -->
<c:catch var="ex">
<x:out select="$xdata//학생[1]/이름" /> <x:out select="$xdata//학생[1]/@번호" /><br>  <!-- xpath식에 el을 사용할때에는 $를 사용해야 한다. -->
<!-- //를 줘서 조상이 누구든 간에 찾아오게 하고 있다. out은 xpath에 알맞는 태그를 찾아서, 속성의 value를 out하는 태그이다. -->
<!-- 번호라는 속성의 값이 출력된다. -->
<x:out select="$xdata//학생[2]/이름" /> <x:out select="$xdata//학생[2]/@번호" /><br>
<x:out select="$xdata//학생[3]/이름" /> <x:out select="$xdata//학생[3]/@번호" /><br>
<x:out select="$xdata//학생[4]/이름" /> <x:out select="$xdata//학생[4]/@번호" /><br>
<hr>
<x:forEach select="$xdata//학생">
<!-- select할 때 조상이 누구든간의 학생속성을 다 뽑아내라(4명이므로 forEach문이 4번 돈다.) -->
  <x:out select="이름" /> <!-- 학생을 기준으로해서 학생의 이름이라는 서브태그, 번호라는 속성 -->
  <x:out select="@번호" /><br>
</x:forEach>
<hr>
<x:forEach select="$xdata//이름[@성별='남']" var="result">
남학생 : <x:out select="text()" /> <br>
</x:forEach>
<hr>

<x:if select="$xdata//학생[@번호='st0004']" >
번호가 st0004 번인 학생 이름 : <x:out select="$xdata//학생[@번호='st0004']/이름" /><br>
</x:if>
<x:choose>
<x:when select="$xdata//학생[@번호='st0005']" >
번호가 st0005 번인 학생 이름 : <x:out select="$xdata//학생[@번호='st0005]/이름" /><br>
<!-- 0005는 없기 때문에 조건이 거짓이므로 when태그의 결과는 거짓이 되어 otherwise가 된다. -->
</x:when>
<x:otherwise>
<h3>번호가 st0005인 학생 데이타가 존재하지 않습니다!!</h3>
</x:otherwise>
</x:choose> 
</c:catch>
<c:if test="${ex != null}">
<h3>${ex}</h3>
</c:if>
</body>
</html>