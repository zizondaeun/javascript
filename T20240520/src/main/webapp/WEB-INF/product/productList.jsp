<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="list" items="${productList}">
<div class="col mb-5">
	<div class="card h-100">
		<!-- Sale badge-->
		<div class="badge bg-dark text-white position-absolute"
			style="top: 0.5rem; right: 0.5rem">Sale</div>
		<!-- Product image-->
		
		<img class="card-img-top"
			src="resources/images/${list.prodImage }" alt="..." />
		<!-- Product details-->
		<div class="card-body p-4">
			<div class="text-center">
				<!-- Product name-->
				<h5 class="fw-bolder">${list.prodName }</h5>
				<!-- Product reviews-->
				
					<div class="d-flex justify-content-center small text-warning mb-2">
						<div class="bi-star-fill"></div>
						<div class="bi-star-fill"></div>
						<div class="bi-star-fill"></div>
						<div class="bi-star-fill"></div>
						<div class="bi-star-fill"></div>
						<!-- foreach반복문 -->
					</div>
				<!-- Product price-->
				<span class="text-muted text-decoration-line-through">${list.price }원</span>
				${list.offPrice }원
			</div>
		</div>
		<!-- Product actions-->
		<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
			<div class="text-center">
				<a class="btn btn-outline-dark mt-auto" href="productInfo.do?prodCode=${list.prodCode }">Add to cart</a>
			</div>
		</div>
	</div>
</div>
</c:forEach>
