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
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<!-- url 에 /main.do로 들어가야함 아니면 404뜸!!! -->
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.boardNo }</td><!-- 글수정하면 원래페이지로 가는방법(1페이지말고) -->
			<td><a href="boardInfo.do?bno=${board.boardNo }&page=${paging.page}&keyword=${keyword }&searchCondition=${searchCondition}">${board.title }</a></td>
			<td>${board.writer }</td>
			<td><fmt:formatDate value="${board.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			<td>${board.viewCnt }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<hr />

