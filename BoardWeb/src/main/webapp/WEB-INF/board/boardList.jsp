<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include><!-- index.jsp에서 또 header.jsp를 여기에  -->

<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
%>
<h3>게시글목록</h3>
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
		<%
		for (BoardVO board : list) {
		%>
		<tr>
			<td><%=board.getBoardNo()%></td>
			<td><a href="boardInfo.do?bno=<%=board.getBoardNo()%>"><%=board.getTitle()%></a></td>
			<td><%=board.getWriter()%></td>
			<td><%=board.getCreateDate()%></td>
			<td><%=board.getViewCnt()%></td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>

<jsp:include page="../includes/footer.jsp"></jsp:include>
