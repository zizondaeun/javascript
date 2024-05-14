<%@ tag body-content="empty" pageEncoding="utf-8" %>
<!-- 태그 만들어보기 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="pageInfo" type="com.yedam.common.PageDTO" required="true" %>
<style>
.center{
  text-align: center;
}
</style>
<div class="center">
	<div class="pagination">
	
	<c:if test="${pageInfo.prev }">
	  <!-- 이전페이지 여부 -->
	  <a href="main.do?page=${pageInfo.startPage-1 }">&laquo;</a>
	</c:if>
	  
	  <c:forEach var="p" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
	  <a href="main.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${p }" class="${p == pageInfo.page ? 'active' : '' }">${p }</a>
	  </c:forEach>
	  
	<c:if test="${pageInfo.next }">
	  <!-- 이후페이지 여부 -->
	  <a href="main.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${pageInfo.endPage+1 }">&raquo;</a>
	</c:if>
	
	</div>
</div>