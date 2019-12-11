<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<table id="theaterDetail">
		<tr>
			<td rowspan="4"><img src="${theater.theater_photo }" id="poster"></td>
			<td><a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${theater.theater_number }"><h3 id="theater_title">${theater.theater_title }</h3></a></td>
		</tr>
		<tr>
			<td>${theater.theater_age } 세 관람가</td>
		</tr>
		<tr>
			<td>${theater.theater_time } 분</td>
		</tr>
		<tr>
			<td><c:forEach var="p" items="${theater.theater_person }">
				<a href="TheaterInfo.com.theaterDetail.ViewPerson?person_number=${p.person_number }">${p.person_name }</a>
			</c:forEach>
		</tr>
	</table>
	<div id="detailMove">
		<ul>
			<li class="detailMenu"><a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${theater.theater_number }"><em>작품 정보</em></a></li>
			<li class="detailMenu"><a href="TheaterInfo.com.theaterDetail.ViewPerson?theater_number=${theater.theater_number }"><em>배우 및 제작진</em></a></li>
			<li class="detailMenu"><a href="TheaterInfo.com.theaterDetail.ViewTime?theater_number=${theater.theater_number }"><em>시간표</em></a></li>
			<li class="detailMenu"><a href="TheaterInfo.com.theaterDetail.ViewReview?theater_number=${theater.theater_number }"><em>리뷰</em></a></li>
		</ul>
	</div>
</body>
</html>