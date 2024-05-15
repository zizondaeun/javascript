<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form action="join.do" method="post">
	<table class="table">
		<tr>
			<th>아이디</th><td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th><td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<th>이름</th><td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="회원가입"></td>
		</tr>
	</table>
</form>
