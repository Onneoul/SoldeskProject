<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${genre.genre_name }</h2>
	<hr>
	<table id="genreInfoTable">
		<c:forEach var="ti" items="${theater }">
		<table class="theaterList">
			<tr>
				<td rowspan="5">
					<a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${ti.theater_number }">
						<img src="resource/theaterPoster/${ti.theater_photo }">
					</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${ti.theater_number }">
						<h3>${ti.theater_title }</h3>
					</a>
				</td>
			</tr>
			<tr>
				<td>
					<c:forEach var="g" items="${ti.theater_genre }">
						<a href="TheaterInfo.com.genreDetail.Basic?genre_number=${g.genre_number }">
							${g.genre_name }
						</a>
					</c:forEach>
				</td>
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
				<td>배우 : 
					 <c:forEach var="P" items="${ti.theater_person }">
						<c:if test="${P.code == '02' }">
							<a href="TheaterInfo.com.personDetail.Basic?person_number=${P.person_number }">
								<span>${P.person_name }</span>
							</a>
						</c:if>
					</c:forEach>
				</td>
			</tr>
		</table>
	</c:forEach>
	</table>
</body>
</html>