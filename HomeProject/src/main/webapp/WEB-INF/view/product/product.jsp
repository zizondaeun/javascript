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

table{
	width: 80%;
    margin: auto;
    border-collapse: collapse;
    table-layout: fixed; /* 테이블 레이아웃 고정 */
}

</style>

<h3>상세화면</h3>

<c:choose>
	<c:when test="${empty result }">
		<p class="center">조회된 결과가 없습니다</p>
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
				<th>상품이름</th>
				<td>${result.prodName }</td>
			</tr>
			<tr>
				<th>상품가격</th>
				<td>${result.prodPrice }원</td>
			</tr>
			<c:choose>
				<c:when test="${logId != 'admin' }">
					<tr>
						<th>주문개수</th>
						<td>
							<input type="number" id="orderCnt">
						</td>
					</tr>
				</c:when>
			</c:choose>
			<tr>
				<th>상품설명</th>
				<td colspan="3">${result.prodEx }</td>
			</tr>	
			<tr>
				<th>이미지</th>
				<td><img src="./images/${result.prodImg }" width="100" height="100"></td>
			</tr>
			<c:choose>
				<c:when test="${logId eq 'admin' }">
					<tr align="center">
						<td colspan="4">
							<button class="btn btn-primary" id="modBtn">수정</button>
							<button class="btn btn-danger" id="delBtn">삭제</button>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr align="center">
						<td colspan="4">
							<button class="btn btn-primary" id="ordBtn">주문하기</button>
						</td>
					</tr>				
				</c:otherwise>
			</c:choose>
		</table>
	</c:otherwise>
</c:choose>

<script>
	const pno = '${result.prodNo}';
	const logId = '${logId}';
	const price = '${result.prodPrice }';

	if (logId == 'admin') {
		document.querySelector('#modBtn').addEventListener('click', function() {
			document.forms.myFrm.action = "modProductForm.do?pno=" + pno;
			document.forms.myFrm.submit();
		})
		document.querySelector('#delBtn').addEventListener('click', function() {
			document.forms.myFrm.action = "deleteProduct.do?pno=" + pno;
			document.forms.myFrm.submit();
		})

	}
	function orderProduct(params) {
		fetch('orderProduct.do', {
		 		method: 'post',
		 		headers: { 'Content-type': 'application/x-www-form-urlencoded' },
		 		body: 'pno=' + params.pno + '&orderCnt=' + params.orderCnt
		 				+ '&price=' + params.price + '&userId=' + params.logId
		})
		 	.then(resolve => resolve.json())
	}

	//주문하기 클릭이벤트
	document.querySelector('#ordBtn').addEventListener('click', function() {
		const orderCnt = document.querySelector('#orderCnt').value;
		const params = {
			pno: pno,
			orderCnt: orderCnt,
			price: price,
			logId: logId
		};
		orderProduct(params);
	})
	
</script>


