<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empView.jsp</title>
</head>
<body>
<h1>mvc패턴</h1>
<table>
<c:forEach items="${list} "var="emp">
	<tr><td>${emp.getFirstName()}</td>
		<td>${emp.lastName}</td>
		<td>${emp.salary}</td></tr>
</c:forEach>
</table>
</body>
</html>