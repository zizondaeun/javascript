<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">반찬가게(${empty logId ? 'Guest' : logId })</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="main.do">상품목록</a>
                    <c:choose>
                    <c:when test="${logId eq 'admin'}">
	                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addForm.do">상품등록</a>
                    </c:when>
                   	<c:otherwise>
                   	</c:otherwise>
                    </c:choose>
                    <c:choose>
                    <c:when test="${logId != 'admin'}">
	                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="orderList.do?userId=${logId }" >내 주문목록</a>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                    </c:choose>
                    <c:choose>
						<c:when test="${empty logId }">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logForm.do">로그인</a>
						</c:when>                    
						<c:otherwise>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>
						</c:otherwise>
                    </c:choose>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="joinForm.do">회원가입</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!"></a>
                </div>
            </div>