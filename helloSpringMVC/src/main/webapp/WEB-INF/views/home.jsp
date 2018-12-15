<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<h2>Student DB</h2><p>
	<p>
		1. <a href="${pageContext.request.contextPath}/semestergrade">학기별 이수 학점 조회</a>
	</p>
	
	
	
	<p>
		2. <a href="${pageContext.request.contextPath}/classregister">수강 신청하기</a>
	</p>
	
	<p>
		3. <a href="${pageContext.request.contextPath}/classregistermenu">수강 신청 조회 메뉴</a>
	</p>

</body>
</html>