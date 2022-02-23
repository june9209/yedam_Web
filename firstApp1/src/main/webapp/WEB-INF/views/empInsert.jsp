<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
</head>
<body>
<h2>사원등록</h2>
<form method="post" action="<%=request.getContextPath() %>/EmpInsert">
	employee_id <input name= "employee_id"><br/>
	last_name <input name= "last_name"><br/>
	email <input name= "email"><br/>
	job_id <select name= "job_id">
				<c:forEach items="${jobList}" var="job">
					<option value="${job.jobId}">${job.jobTitle}</option>
				</c:forEach>
			</select><br/>
			<%--
	department_id <select name = "department_id">
						<option value="">선택</option>
						<c:forEach items="${부서리스트}" var="dept">
							<option value="${부서번호}">${부서명}</option>
						</c:forEach>
					</select>
	 --%>
	hire_date <input type="date" name="hire_date"><br/>
	<!-- 
	<input type='checkbox' name='hobby' value='ski'>스키<br>
	<input type='checkbox' name='hobby' value='reading'>독서<br>
	 -->
	<button>등록</button>
</form>
</body>
</html>