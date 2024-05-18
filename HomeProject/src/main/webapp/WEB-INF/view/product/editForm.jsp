<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="UTF-8">
<h2>수정화면</h2>
<form name="myFrm" action="updateProduct.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<input type="hidden" name="pno" value="${product.prodNo }">
		<tr>
			<th>상품이름</th>
			<td><input type="text" name="name" value="${product.prodName }"></td>
		</tr>
		<tr>
			<th>상품가격</th>
			<td><input type="text" name="price" value="${product.prodPrice }"></td>
		</tr>
		<tr>
			<th>상품설명</th>
			<td><textarea rows="10" cols="40" name="ex">${product.prodEx }</textarea></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><p>현재 파일: <a href="./images/${product.prodImg}" target="_blank">파일 보기</a></p><input type="file" name="img"></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="수정" class="btn btn-primary">
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