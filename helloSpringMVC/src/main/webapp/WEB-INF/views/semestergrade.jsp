<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�б⺰ �̼� ���� ��ȸ</h2>
	
	<table  align="center" border="1">
			<tr>
				<td width="100px">�⵵ </td>
				<td width="100px">�б�</td>
				<td width="100px">�̼�����</td>
				<td width="200px">�󼼺���</td>
			</tr>
			<c:forEach var="stdb" items="${student}">
			<tr>
				<td><c:out value="${school.year}"></c:out></td>
				<td><c:out value="${school.semester}"></c:out></td>
				<td><c:out value="${school.credit}"></c:out></td>
				<td><a href="${pageContext.request.contextPath}/semestergrade2?year=${school.year}&semester=${school.semester}">�󼼺���</a></td>
			</tr>
			
			</c:forEach>
		</table>
	
</body>
</html>