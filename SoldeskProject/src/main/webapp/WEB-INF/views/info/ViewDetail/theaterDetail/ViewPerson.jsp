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
			<td class="detailMenu"><a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${theater.theater_number }">작품 정보</a></td>
			<td id="CurrentdetailMenu"><a href="TheaterInfo.com.theaterDetail.ViewPerson?theater_number=${theater.theater_number }">배우 및 제작진</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.theaterDetail.ViewTime?theater_number=${theater.theater_number }">시간표</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.theaterDetail.ViewReview?theater_number=${theater.theater_number }">리뷰</a></td>
		</tr>
	</table>
	<table id="theaterPersonTable">
		<c:forEach var="p" items="${theater.theater_person }">
			<tr>
				<td rowspan="2">
					<a href="TheaterInfo.com.personDetail.Basic?person_number=${p.person_number}">
						<img src="resources/img/personProfile/${p.person_photo }" class="theaterDetailPersonProfile">
					</a>
				</td>
				<td>
					<a href="TheaterInfo.com.personDetail.Basic?person_number=${p.person_number}">
						${p.person_name }
					</a>
				</td>
			</tr>
			<tr>
				<td>
					${p.age }세
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>