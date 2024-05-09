<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>삭제화면</h3>
<%
	BoardVO vo = (BoardVO) request.getAttribute("bno");
%>
<form action="deleteBoard.do"><!-- 파라메터 3개가 넘어감(name) -->
<table class="table">
	<h2>삭제하시겠습니까?</h2>
	<tr align="center">
		<td colspan="4">
			<button class="btn btn-danger">삭제</button>
		</td>
	</tr>

</table>
	<input type="hidden" name="bno" value="<%=vo.getBoardNo() %>">
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>