<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<link rel="stylesheet" href="resources/css/theaterDesign.css">
<title>Insert title here</title>
</head>
<body>
	<table id="personInfoDetail">
		<tr>
			<td rowspan="4">
				<a href="TheaterInfo.com.personDetail.Basic?person_number=${p.person_number}">
					<img src="resources/img/person/${p.person_photo }" id="personProfile">
				</a>
			</td>
			<td><a href="TheaterInfo.com.personDetail.Basic?person_number=${p.person_number}">${p.person_name }</a></td>
		</tr>
		<tr>
			<td>${p.age }</td>
		</tr>
		<tr>
			<td>
				출연작 : 
				<c:forEach var="i" items="${p.person_cast }">
					<span class="theaterTitle" onclick="toTheaterDetail(${i.theater_number})"> ${i.theater_title },</span>
				</c:forEach>
			</td>
		</tr>
	</table>
	<div id="personDetailMain"><jsp:include page="${PersonDetailInfo }"></jsp:include></div>
	<c:if test="${sessionScope.loginMember.member_level == 2 }">
		<button onclick="updateTheater(${theater.theater_number});">수정</button>
		<button onclick="deleteTheater(${theater.theater_number});">삭제</button>
	</c:if>
</body>
</html>