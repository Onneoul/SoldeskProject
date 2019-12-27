<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${ti.theater_date_time }">
			<tr>
				<td>
					<fmt:formatDate value="${ti.theater_date_time.theater_date }"/>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="TheaterInfo.theaterDate" name="theaterDateTime">
		<table>
			<tr>
				<td>날짜 선택 : <input type="datetime-local" name="theater_date"></td>
			</tr>
		</table>
	</form>
</body>
</html>