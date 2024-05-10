<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>=> index.jsp</title>
</head>
<body>
	<!-- Expression Language : 간단한 비교연산,정보가져오는거 가능 -->
	<p>${'hong' == 'hong' ?  true : false }</p>
	<a href="main.do">메인컨트롤 이동</a><!-- 첫화면 -->
	<my:lines/>
</body>
</html>