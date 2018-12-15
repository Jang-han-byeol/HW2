<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 수강 신청 조회 메뉴-->
	<!-- docreate 한 후에 생성. -->
	<h2>2019년 수강 신청 메뉴 조회</h2>

	<table align="center" border="1">
		<tr>
			<td width="100px">수강년도</td>
			<td width="100px">학기</td>
			<td width="100px">교과코드</td>
			<td width="250px">교과목명</td>
			<td width="100px">구분</td>
			<td width="100px">학점</td>
		</tr>

		<c:forEach var="rgstdb" items="${registerstudent}">
			<tr>
				<td>2019</td>
				<td>1</td>
				<td><c:out value="${school.subjectcode}"></c:out></td>
				<td><c:out value="${school.subjectname}"></c:out></td>
				<td><c:out value="${school.classify}"></c:out></td>
				<td><c:out value="${school.credit}"></c:out></td>

			</tr>

		</c:forEach>

	</table>
</body>
</html>