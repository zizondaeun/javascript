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

<h3>주문목록</h3>
<table class="table">
	<thead>
		<tr>
			<th>상품번호</th>
			<th>주문번호</th>
			<th>주문개수</th>
			<th>주문가격</th>
			<th>회원아이디</th>
		</tr>
	</thead>
	<tbody id="tby">
		<c:forEach var="orders" items="${orderList}">
		<tr>
			<td>${orders.prodNo }</td>
			<td>${orders.orderNo }</td>
			<td>${orders.orderCnt }</td>
			<td>${orders.price}원</td>
			<td>${orders.userId }</td>
			<td colspan="4">
				<button class="btn btn-danger" id="cnlBtn">주문취소</button>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<hr />
<script>	
	//const price = ${orders.orderCnt * result.prodPrice };
	
	//console.log(price);
	let btn = document.querySelectorAll('#tby button')
		btn.forEach(result => {
			result.addEventListener('click',function(e){
				let ono = e.target.parentElement.parentElement.children[1].innerText;
				fetch('orderDelete.do', {
					method: 'post',
			 		headers: { 'Content-type': 'application/x-www-form-urlencoded' },
			 		body: 'ono=' + ono
					//ono.remove();
			})
					.then(resolve => console.log(resolve))
			})
		})
		
</script>
