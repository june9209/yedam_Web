<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>Form Text</title>
<meta charset='utf-8'>
</head>
<body>
	<h3>회원 정보</h3>
	<form action="<%=request.getContextPath() %>/UserUpdate" method="POST">
	<!-- <form> -->
		ID : <input type="text" name="id" value="${user.id} }"><br>
		비밀번호 : <input type="password" name="pwd" value ="${user.password}"><br>
		이름 : <input type="text" name="name" value="${user.name}"> <br>
		취미 : 
			<input type="checkbox" name="hobby" value="climbing">등산
			<input type="checkbox" name="hobby" value="sports" >운동
			<input type="checkbox" name="hobby" value="reading">독서
			<input type="checkbox" name="hobby" value="traveling">여행<br>
		성별 : 
			<input type="radio" name="gender" value="male">남자
			<input type="radio" name="gender" value="female">여자<br>
		종교 :
			<select name="religion">
				<option value="Christianity" >기독교</option>
				<option value="Buddhism">불교</option>
				<option value="Catholicism">천주교</option>
				<option value="atheism" selected="selected">무교</option>
			</select><br>
		자기소개 : <br>
			<textarea cols="30" rows="10" name="introduction"${user.introduction}></textarea><br>

		<input type="submit" value="전송">
		<input type="reset" value="지우기">
	</form>
	
	<script>
		const submitBtn = document.querySelector('input[type=submit]');
		const form = document.getElementsByTagName('form')[0];
		
		form.addEventListener('submit',() => {
			event.preventDefault();
			
			const id = document.querySelector('input[name=id]').value;
			const pwd = document.querySelector('input[name=pwd]').value;
			const name = document.querySelector('input[name=name]').value;
			const checkedHobby = document.querySelectorAll('input[name=hobby]:checked').length;
			const checkedGender = document.querySelector('input[name=gender]:checked');
			const religion = document.querySelector('select').value;
			const introduction = document.querySelector('textarea[name=introduction]').value;
			
			if ((id == false || pwd == false || name == false || checkedHobby == false || checkedGender == null || religion == false || introduction == false) ) {
				alert('모든 항목을 입력하세요.')
				return;
			}
			
			form.submit();
			
		})
	
		
	</script>
</body>
</html>