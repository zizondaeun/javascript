<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<!-- WEB-INF/board/boardList.jsp -->
<form action="addBoard.do">
	<table class="table">
		<tr>
			<th>제목</th><td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th><td><textarea cols="30" rows="4" name="content"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th><td><input type="text" name="writer"></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>