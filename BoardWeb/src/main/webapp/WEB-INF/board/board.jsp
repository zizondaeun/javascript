<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>상세화면</h3>
<%
	BoardVO vo = (BoardVO) request.getAttribute("result");
%>

<%if (vo == null) { %>
<p>조회된 결과가 없습니다</p>
<%} else { %>
<form name="myFrm">
	<input type="hidden" name="bno" value="<%=vo.getBoardNo() %>">
</form>
<table class="table">
	<tr>
		<th>게시글번호</th>
		<td><%=vo.getBoardNo() %></td>
		<th>작성자<th>
		<td><%=vo.getWriter() %></td>
	</tr>
	<tr>
		<th>제목<td>
		<td colspan="3"><%=vo.getTitle() %></td>
	</tr>
	<tr>
		<th>내용<th>
		<td colspan="3"><%=vo.getContent() %></td>
	</tr>
	<tr>
		<th>작성일시<td>
		<td><%=vo.getCreateDate() %></td>
		<th>조회수<th>
		<td><%=vo.getViewCnt() %></td>		
	</tr>	
	<tr align="center">
		<td colspan="4">
			<button class="btn btn-primary" id="modBtn">수정</button>
			<button class="btn btn-danger" id="delBtn">삭제</button>
		</td>
	</tr>
</table>
<%} %>
<script src="js/board.js"></script>

<jsp:include page="../includes/footer.jsp"></jsp:include>