<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/js/site_move.js"></script>
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
		<c:forEach var="p" items="${person }">
			<tr onclick="insertCasting(${theater.theater_number}, ${p.person_number});">
				<td>${p.person_name }</td>
				<td>${p.age }</td> <!-- person_age = sysdate의 year 부분 - p.person_date의 year 부분 -->
				<td><fmt:formatDate pattern="MM월 dd일" value="${p.person_birth }"/> </td> <!-- fmt로 MMdd 부분만 출력  MM월 dd일-->
				<td>${p.person_birthplace }</td>
			</tr>
		</c:forEach>
		<tr>
			<td><button onclick="toPersonWrite(${param.theater_number})">작성</button></td>
			<td><button onclick="castingClose(${param.theater_number})">닫기</button></td>
		</tr>
	</table>
</body>
</html>