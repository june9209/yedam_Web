<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
</head>
<body>
<h2>사원등록</h2>
<form method="post" action="/firstApp/EmpInsert">
	employee_id<input name= "employee_id"><br/>
	last_name<input name= "last_name"><br/>
	email<input name= "email"><br/>
	job_id<input name= "job_id"><br/>
	hire_date<input name= "hire_date"><br/>
	<button>등록</button>
</form>
</body>
</html>