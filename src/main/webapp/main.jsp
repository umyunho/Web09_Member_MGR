<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
 <script type="text/javaScript">
 function deleteConfirm(userid){
	 var and =  confirm("정말로 삭제할까요?");
	 if(ans){
		 location.href="delete.do?id=" + userid;
	 }else{
		 return; 
	 }
 }      
 
 
   </script>

</head>
<body>

<c:if test="$(delete=='ok')">
	<script type="text/javascript">
		alert("삭제되었습니다.");
	</script>
</c:if>

<table width="800" bgcolor="black" celspacing="1">
	<tr bgcolor="white"><th>아이디</th><th>이름</th><th>암호</th><th>전화번호</th><th>수정</th><th>삭제</th></tr>
	<c:forEach items="${ memberList}"  var="member">
		<tr bgcolor="white" align="center">
			<td>${member.id }</td>
			<td>${member.name }</td>
			<td>${member.pwd }</td>
			<td>${member.phone }</td>
			<td>
			<input type="button" value="수정" onClick="location.href='update.do?id=${member.id}'"/>
			</td>
			<td><input type="button" value="삭제" onClick="deleteConfirm('${member.id}')"/></td>
		</tr>
	</c:forEach>
</table>
<input type="button" value="멤버추가" onclick="location.href='Insert.do'"/>
</body>
</html>

























