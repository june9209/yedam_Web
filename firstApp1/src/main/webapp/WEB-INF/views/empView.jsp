<%@page import="com.yedam.employees.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empView.jsp</title>
<style>
	.imp {color: red;}
</style>
</head>
<body>
<h1>empView.jsp</h1>
<%--
List<Employee> obj = (List<Employee>)request.getAttribute("empList");
out.print(obj.get(0).getFirstName());
--%>
<hr>
${empList[0].getFirstName()}	<!-- promotion, null check -->
<hr>
${fn:length(empList)} 건
<table>
	<thead>
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>부서번호</td>
			<td>급여</td>
		</tr>
	</thead>
<c:forEach items="${empList}" var="emp">
	<tr>
		<td>${emp.employeeId}</td>
		<td><a href="EmpUpdate?employeeId=${emp.employeeId}">${emp.getFirstName()}</a></td>
		<td>${emp.departmentId}</td>
		<td <c:if test="${emp.salary>=10000}">class="imp"</c:if>>${emp.salary}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>