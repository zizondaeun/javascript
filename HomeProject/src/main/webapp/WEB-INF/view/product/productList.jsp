<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
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

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>

<table class="table">
	<thead>
		<tr>
			<th>상품번호</th>
			<th>상품이름</th>
			<th>상품가격</th>
			<th>이미지</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${productList}">
		<tr>
			<td>${product.prodNo }</td>
			<td><a href="productInfo.do?pno=${product.prodNo }">${product.prodName }</a></td>
			<td>${product.prodPrice }원</td>
			<c:choose>
				<c:when test="${not empty product.prodImg }">
					<td><img src="./images/${product.prodImg }" width="100" height="100"></td>				
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</tr>
		</c:forEach>
	</tbody>
</table>
<hr />
