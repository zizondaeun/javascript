<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form name="myFrm" action="addProduct.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>상품이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>상품가격</th>
			<td><input type="text" name="price"></td>
		</tr>
		<tr>
			<th>상품설명</th>
			<td><textarea rows="10" cols="40" name="ex"></textarea></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><input type="file" name="myImg"></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="등록" class="btn btn-primary">
				<input type="reset" value="취소" id="cancel" class="btn btn-secondary">
			</td>
		</tr>
	</table>
</form>
<script>
	const pno = '${prodNo}';
	document.querySelector('#cancel').addEventListener('click', function(e){
		e.preventDefault();
		document.forms.myFrm.action = "main.do";
		document.forms.myFrm.submit();
	})
</script>