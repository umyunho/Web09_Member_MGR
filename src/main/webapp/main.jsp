<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>

<table width="800" bgcolor="black" celspacing="1">
	<tr bgcolor="white"><th>아이디</th><th>이름</th><th>암호</th><th>전화번호</th><th>수정</th><th>삭제</th></tr>
	<c:forEach items="${ memberList}"  var="member">
		<tr bgcolor="white" align="center">
			<td>${member.id }</td>
			<td>${member.name }</td>
			<td>${member.pwd }</td>
			<td>${member.phone }</td>
			<td><input type="button" value="수정"/></td>
			<td><input type="button" value="삭제"/></td>
		</tr>
	</c:forEach>
</table>
<input type="button" value="멤버추가"/>
</body>
</html>