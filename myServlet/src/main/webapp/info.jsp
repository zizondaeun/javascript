<%@page import="com.yedam.vo.EmployeeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% //자바코드는 <% 안에
	Object req = request.getAttribute("req"); //empVO는 객체라 오브젝트 타입
	String name = (String) request.getAttribute("name"); //getAttribute는 object타입 그래서 형변환시킴
	//System.out.println("jsp: " + name);
	List<EmployeeVO> list = (List<EmployeeVO>) request.getAttribute("elist");
	%> 
	<p><%=name %></p> 
	<ul>
	<% for (EmployeeVO evo : list) { %> 
		<li>사번: <%=evo.getEmployeeId() %> 이름: <%=evo.getFirstName() %></li> <!-- //셀렉 쿼리문이 반복문 돌려서 나옴 -->
	<% } %>
	</ul>
</body>
</html>