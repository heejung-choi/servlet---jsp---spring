```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "vo.NewsVO, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head><style>
@import url(//fonts.googleapis.com/earlyaccess/hanna.css);

table.type1 {
	border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
    margin: 20px 10px;

}

table.type1 th {
    width: 155px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background:#e7708d ;
}
table.type1 td {
    width: 155px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #eee;
}
tr:hover{
font-weight : bold;
}
#d {
	width: 300px;
}

#all {
	width : 60%;
	margin-left : auto;
	margin-right : auto;	
	padding: 50px;
	border-style: dotted dashed solid double;
	border-color: gray;
	font-family: 'Hanna', sans-serif;
		
}
h1{
	font-size: 3em;
  	text-align:center;
  	text-shadow: 2px 2px 4px #000000;
}
textarea {
  width: 100%;
  height: 150px;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #eee;
  font-size: 16px;
  resize: none;
}
input[type=text] {
  width: 80%;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  background-color: #eee;
  background-image: url('searchicon.png');
  background-position: 10px 10px; 
  background-repeat: no-repeat;
  padding: 12px 20px 12px 40px;
  -webkit-transition: width 0.4s ease-in-out;
  transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
  width: 100%;
}
select {
width: 200px;
padding: .8em .5em;
border: 1px solid #999;
border-radius: 0px;

}

.button {
  display: inline-block;
  padding: 10px 15px;
  font-size: 10px;
  cursor: pointer;
  text-align: center;
  outline: none;
  color: #fff;
  background-color: #e7708d;
  border: none;
  border-radius: 15px;
  box-shadow: 0 2px #999;
}

.button:hover {
background-color: #b366ff
}

#deco{
  color: #ff99bb;  
}
img{ 
	width: 100%; 
	display: block;
	margin-botton: -3px;

}
</style>
<body>
<div id="all">
<%
	ArrayList<NewsVO> list = (ArrayList<NewsVO>)request.getAttribute("list");
	NewsVO listview = (NewsVO)request.getAttribute("listview");
	System.out.println("listview는?"+listview);
	
	
	if(list !=null){
%> 	
	
	<img src="https://lh3.googleusercontent.com/proxy/_GMZo-qkrJ1thQY27xGkWCnCEbS4PQyeyD-oPfGNWwz5qmuG3Mlyy0zdJkrrxqlVLu3rfMit4TAb6f7PvB-_mD3L9OtAzZawjkRYjZK7Ka0">
	<h1 id="deco">HEE JUNG <span style="color:red">★</span><span style="color:\#ff6633" >뉴</span><span style="color: #ffff33">스</span><span style="color:#66ff33"> 게</span><span style="color:#33ccff">시</span><span style="color: #3333ff">판</span><span style="color:#9933ff">★</span></h1><hr>
	<table class="type1">
		<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
		</tr> <%
		for(NewsVO vo : list){%>
			<tr>					
			<td><%= vo.getId() %></td>		
			<td onClick="location.href='/mvc/news?action=read&newsid=<%=vo.getId()%>'" > <%= vo.getTitle() %></td>
			<td onClick="location.href='/mvc/news?action=listwriter&newswriter=<%=vo.getWriter()%>'"><%= vo.getWriter() %></td>
			<td id="d"><%= vo.getWritedate() %></td>
			<td><%= vo.getCnt() %></td>
			</tr><%
		} 		
		
		
	
%>
	</table>
	<hr>
	
	<div>
	<form method ="get" action ="/mvc/news">	
	<select name="searchType">
	  <option value="title">제목</option>
	  <option value="writer">작성자</option>	  
	</select>
	<br>
	<input type="text" placeholder="Search.." name="key">	
	<br>
	<br>
	<input type ="submit"  value="뉴스 검색" class="button">
	</form>
	</div>	
	<hr>
	
	
<%}	
%>	
<%
	if (request.getAttribute("msg") != null) {
%>
	<script>
		alert('${ msg }');
	</script>
<%}
	
	%>

<button onclick="displayDiv(1);" class="button">뉴스 작성</button>
<br>
<div id="write"  style="display:none">
<form method = "post" action = "/mvc/news">
<input type="hidden" name="action" value="insert">
<input placeholder="작성자명을 입력해주세요" type="text"  name="writer">
<br>
<input placeholder="제목을 입력해주세요" type="text"  name="title"
>
<br>
<textarea placeholder="내용을 입력해주세요" rows="3" cols="30" name ="content" ></textarea>
<br>
<input type = "submit" value = "등록" class="button">
<input type = "reset" value = "재작성" class="button">
<input type ="button" value="취소"  onclick="displayDiv(2)" class="button">
</form>
</div>
<hr>
<% 
if(listview !=null){
%>
<div id="update">
<form method = "post" action = "/mvc/news">
<input type="hidden" name="newid" value="${listview.id}">
<input id="m_writer"  type="text"  name="writer" value="${listview.writer}">
<br>
<input id="m_title" type="text"  name="title"  value="${listview.title}">
<br>
<textarea id="m_content" rows="3" cols="30" name ="content" >${listview.content}</textarea>
<br>
<input type = "button" value = "확인 " onclick="displayDiv(3)" class="button">
<input type = "submit" value = "수정" onclick="displayUpdateForm(${listview.id})" class="button" >
<input type ="button" value="삭제" onclick="location.href='/mvc/news?action=delete&newsid=${listview.id}'" class="button">
</form>	
</div>	
<%		
	}		
%>
<script>
function displayDiv(dis) { 
		if(dis==1){
		document.getElementById("write").style.display='block';		
		}
		else if(dis==2){
		document.getElementById("write").style.display='none';			
		}
		else if(dis==3){
		document.getElementById("update").style.display='none';
		}
	
}
function displayUpdateForm(cv) {
    var doms = document.getElementsByClassName(cv)
	document.getElementById("update").style.display='block';	
	document.getElementById("m_writer").value = doms[0].textContent;
	document.getElementById("m_title").value = doms[1].textContent;
	document.getElementById("m_content").value = doms[2].textContent;

}
</script>
</div>
</body>
</html>






```

