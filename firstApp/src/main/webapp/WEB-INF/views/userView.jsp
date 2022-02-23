<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userView.jsp</title>
</head>
<body>
<h1>userView.jsp</h1>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>HOBBY</th>
		</tr>
	</thead>
<c:forEach items="${userlist}" var="user">
	<tbody>
		<tr>
			<td>${user.id}</td>
			<td><a href="UserUpdate?id=${user.id}">${user.name}</a></td>
			<td>${user.hobby}</td>
		</tr>
	</tbody>
</c:forEach>
</table>
</body>
</html>