<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>수정화면</h3>
<!-- 우리가 리퀘스트선언한적없는데 어떻게 쓸수있나? 톰캣이editboard_jsp.java를 알아서 만들어주고 그안에 선언되어있어 우리는 바로쓸수있음 -->
<form action="updateBoard.do"><!-- 파라메터 3개가 넘어감(name) -->
<table class="table">
	<tr>
		<th>글번호</th><td>${bno.boardNo }</td>
	</tr>
	<tr>
		<th>제목</th><td><input type="text" name="title" value="${bno.title }"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="content" cols="30" rows="4">${bno.content }</textarea></td>
	</tr>
	<tr>
		<th>작성자</th><td>${bno.writer }</td>
	</tr>
		<tr align="center">
		<td colspan="2">
		<c:choose>
			<c:when test="${bno.writer eq logId }">
				<input class="btn btn-primary" type="submit">			
			</c:when>
			<c:otherwise>
				<input class="btn btn-primary" disabled type="submit">			
			</c:otherwise>		
		</c:choose>
		</td><!--비활성화 -->
	</tr>
</table>
	<input type="hidden" name="bno" value="${bno.boardNo }">
	<input type="hidden" name="page" value="${page }">
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>