<%@page import="com.home.product.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
div.reply div {
	margin: auto;
}

div.reply ul {
	list-style-type: none;
	margin-top: 5px;
}

div.reply li {
	padding-top: 1px;
	padding-bottom: 1px;
}

div.reply span {
	display: inline-block;
}

.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

<h3>상세화면</h3>

<c:choose>
	<c:when test="${empty result }">
		<p>조회된 결과가 없습니다</p>
	</c:when>
	<c:otherwise>
		<form name="myFrm">
			<input type="hidden" name="pno" value="${result.prodNo }">
		</form>
		<table class="table">
			<tr>
				<th>상품번호</th>
				<td>${result.prodNo }</td>
			</tr>
			<tr>
				<th>상품이름<td>
				<td>${result.prodName }</td>
			</tr>
			<tr>
				<th>상품가격<th>
				<td>${result.prodPrice }원</td>
			</tr>
			<tr>
				<th>상품설명<td>
				<td colspan="3">${result.prodEx }</td>
			</tr>	
			<tr>
				<th>이미지<th>
				<td>${result.prodImg }</td>
			</tr>
			<tr align="center">
				<td colspan="4">
					<button class="btn btn-primary" id="modBtn">수정</button>
					<button class="btn btn-danger" id="delBtn">삭제</button><!-- 교수님은 id=delbtn안했어 -->
				</td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>

<script>
	const pno = '${result.prodNo}';
	console.log(pno);
	document.querySelector('#modBtn').addEventListener('click',function(){
		document.forms.myFrm.action = "modProductForm.do?pno=" + pno;
		document.forms.myFrm.submit();
	})
	document.querySelector('#delBtn').addEventListener('click', function(){
		document.forms.myFrm.action = "deleteProduct.do?pno=" + pno; 
		document.forms.myFrm.submit(); 
	})
</script>