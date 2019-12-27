<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<table id="detailMove">
		<tr>
			<td class="detailMenu"><a href="TheaterInfo.com.groupDetail.Basic?group_number=${o.group_number }">주요 정보</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.groupDetail.Person?group_number=${o.group_number }">소속 인원</a></td>
			<td id="CurrentdetailMenu"><a href="TheaterInfo.com.groupDetail.Theater?group_number=${o.group_number}">공연작</a></td>
		</tr>
	</table>
		<c:forEach var="t" items="${o.group_theater }">
		<table class="theaterList">
			<tr>
				<td rowspan="5">
					<a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${t.theater_number }">
						<img src="resource/theaterPoster/${t.theater_photo }">
					</a>
				</td>
					
			</tr>
			<tr>
				<td>
					<a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${t.theater_number }">
						<h3>${t.theater_title }</h3>
					</a>
				</td>
			</tr>
			<tr>
				<td>
					<c:forEach var="g" items="${t.theater_genre }">
						<a href="TheaterInfo.com.genreDetail.Basic?genre_number=${g.genre_number }">
							${g.genre_name }
						</a>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>${t.start_date }~</td>
				<td>${t.end_date }</td>
			</tr>
			<tr>
				<td>${t.theater_age }세 이상</td>
			</tr>
			<tr>
				<td>${t.theater_time }분</td>
			</tr>
			<tr>
				<td>배우 : <c:forEach var="P" items="${t.theater_person }">
						<c:if test="${P.code == '02' }">
							<span>${P.person_name }</span>
						</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>주최 단체 : <strong>${t.theater_organization.group_name }</strong></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>