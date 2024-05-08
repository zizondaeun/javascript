<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- info/registerEmp.jsp -->
	<h3>사원등록화면</h3><!-- "../addEmp.do" -->
	<form action="addEmp.do" method="post"><!-- 어떤 페이지로 이동하겠다:action -->
		<table border="2"><!-- 민감한 내용 url에 안보이게 하는 방식:post -->
			<tr>
				<th>사원번호</th>
				<td><input type="number" name="eid"></td><!-- name의 값이 백으로 넘어가므로 어떻게 쓰는지 꼭 기억하기 -->
			</tr>
			<tr>
				<th>사원명</th>
				<td><input type="text" name="last_name"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="first_name"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<th>직무</th>
				<td><input type="text" name="job"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td><!-- submit클릭하면 addEmp.do 백으로 보내는... -->
			</tr>
		</table>
	</form>
	
</body>
</html>