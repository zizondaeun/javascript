<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>삭제화면</h3>
<form name="myFrm" action="deleteBoard.do"><!-- 파라메터 3개가 넘어감(name) -->
<table class="table">
	<tr>
		<th>글번호</th><td>${bno.boardNo }</td>
	</tr>
	<tr>
		<th>제목</th><td><input type="text" name="title" value="${bno.title }"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${bno.content }</td>
	</tr>
	<tr>
		<th>작성자</th><td>${bno.writer }</td>
	</tr>
	<tr align="center">
		<td colspan="4">
			<input class="btn btn-danger" type="submit" value="삭제">
		</td>
	</tr>
</table>
	<input type="hidden" name="bno" value="${bno.boardNo }">
</form>
<script><!--  -->
	const logId = "${logId}";
	const writer = "${bno.writer}";
	
	document.forms.myFrm.addEventListener('submit',function(e){
		e.preventDefault();
		if(logId != writer){
			alert("권한이 없습니다");
			return;
		}
		this.submit();
	});
	
</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>