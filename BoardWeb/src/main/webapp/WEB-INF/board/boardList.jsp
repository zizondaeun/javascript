<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
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

<h3>게시글목록</h3>
<div class="center">
	<form action="main.do">
		<div class="row">
			<div class="col-sm-2">
				<select name="searchCondition" class="form-control">
					<option value="">선택하세요</option>
					<option value="T" ${searchCondition == 'T' ? 'selected' : '' }>제목</option>
					<option value="W" ${searchCondition == 'W' ? 'selected' : '' }>작성자</option>
					<option value="TW" ${searchCondition == 'TW' ? 'selected' : '' }>제목 & 작성자</option>
				</select>
			</div>
			<div class="col-sm-6">
				<input type="text" name="keyword" value="${keyword }" class="form=control">
			</div>
			<div class="col-sm-2">
				<input type="submit" value="조회" class="btn btn-primary">
			</div>
		</div>
	</form>
</div>
<!-- 두번째 화면 -->
<!-- 글번호, 제목, 작성자, 작성일시, 조회수 -->
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

<my:paging pageInfo="${paging }"/>

