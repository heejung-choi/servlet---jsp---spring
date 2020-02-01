<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 테스트</title>
</head>
<body>
<h2>&lt;c:forEach&gt;와 &lt;c:forTokens&gt;태그 예제</h2>
<hr>
<h3>[ 맵 ]</h3>
<c:set var="map" value="<%= new java.util.HashMap<String,String>() %>" /><!--  hashmap의 key와 value를 나타내고 있다. -->
<c:set target="${map}"  property="st1" value="듀크" /><!--  st1의 키값으로 듀크 -->
<c:set target="${map}"  property="st2" value="둘리" /><!--  st2의 키값으로 둘리 -->
<c:set target="${map}"  property="st3" value="또치" />
<c:forEach var="data"  items="${map}">
   [ ${data.key} = ${data.value} ]
</c:forEach>

<h3>[ 배열 ]</h3>
<c:set var="intArray" value="<%= new int[] {1,2,3,4,5} %>" />
<!--  el에서는 배열을 만들 수 없다. 따라서 표현식 태그를 사용하여 자바 코드로 한다.  -->
<c:forEach var="i" items="${intArray}" begin="2" end="4">
    [${i}]
    <!--  begin end가 없다면 원소만큼만 돌았겠지만  begin end가 있기 때문에 3번째 원소부터 5번째 원소까지 뽑아내게 된다. -->
</c:forEach>

<h3>[ 값을 변화시키면서 반복처리 ]</h3>
<c:set var="sum" value="0" />
<c:forEach var="i" begin="1" end="100" step="2"> <!-- begin 부터 end까지의 것을 var라는 변수에 담는 것이다. step -> 2씩 증가-->
	<c:set var="sum" value="${sum + i}" />
</c:forEach>
<h4>결과 = ${sum}</h4>

<h4>구구단: 4단</h4> <!-- 1부터 시작하여 1씩 증가 -->
<c:forEach var="i"  begin="1"  end="9">
   4 * ${i} = ${4 * i}&nbsp;&nbsp;
</c:forEach>

<hr>
콤마와 점을 구분자로 사용:<br>
<c:forTokens var="token" 
             items="빨강색,주황색.노란색.초록색,파랑색,남색.보라색"
             delims=",.">
<button>${token} </button>
</c:forTokens>
</body>
</html>