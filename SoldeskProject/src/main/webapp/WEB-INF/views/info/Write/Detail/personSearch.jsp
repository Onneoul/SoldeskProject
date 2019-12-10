<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="search">
		<input id="searchBox"> 검색
	</form>
	<table id="searchArea">
		<tr>
			<td>이름</td>
			<td>나이</td>
			<td>생일</td>
			<td>출생지</td>
		</tr>
	</table>
	<c:forEach var="p" items="${person }">
		<table>
			<tr>
				<td>${p.person_name }</td>
				<td>${p.person_age }</td> <!-- person_age = sysdate의 year 부분 - p.person_date의 year 부분 -->
				<td>${p.person_birth }</td> <!-- fmt로 MMdd 부분만 출력  MM월 dd일-->
				<td>${p.person_birthplace }</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>