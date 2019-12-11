<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="theaterMain">
		<tr>
			<td><h3>공연 정보</h3></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3" class="underbar"></td>
		</tr>
		<tr id="theaterSelect">
			<td><button id="theaterButton">상영중</button>
			<button id="theaterButton2">예정</button></td>
			<td id="searchInput"><input><button id="searchButton">검색</button></td>
		</tr>
		<tr>
			<td id="currentPage"><h2>현재 상영작</h2></td>
		</tr>
		<tr>
			<td colspan="3" class="underbar"></td>
		</tr>
	</table>
	<c:forEach var="ti" items="${TheaterInfo }">
		<table class="theaterList" onclick="toTheaterDetail(${ti.theater_number})">
			<tr>
				<td rowspan="5"><img src="resource/theaterPoster/${ti.theater_photo }"></td>
			</tr>
			<tr>
				<td><h3>${ti.theater_title }</h3></td>
			</tr>
			<tr>
				<td>${ti.start_date }~</td>
				<td>${ti.end_date }</td>
			</tr>
			<tr>
				<td>${ti.theater_age }세 이상</td>
			</tr>
			<tr>
				<td>${ti.theater_time }분</td>
			</tr>
			<tr>
				<td><c:forEach var="P" items="${ti.theater_person }">
						<c:if test="${P.code == '02' }">
							<span>${P.person_name }</span>
						</c:if>
					</c:forEach>
				</td>
			</tr>
		</table>
	</c:forEach>
	
</body>
</html>