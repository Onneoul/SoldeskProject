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
	<table id="detailMove">
		<tr>
			<td class="detailMenu"><a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${theater.theater_number }">작품 정보</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.theaterDetail.ViewPerson?theater_number=${theater.theater_number }">배우 및 제작진</a></td>
			<td id="CurrentdetailMenu"><a href="TheaterInfo.com.theaterDetail.ViewTime?theater_number=${theater.theater_number }">시간표</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.theaterDetail.ViewReview?theater_number=${theater.theater_number }">리뷰</a></td>
		</tr>
	</table>
	<table>
		<c:forEach var="d" items="${theater.theater_date_time }">
			<table class="dateTimes">
				<tr>
					<td>
						<fmt:formatDate value="${d.theater_date }" pattern="MM월 dd일 hh시 mm분"/>
					</td>
				</tr>
			</table>
		</c:forEach>
	</table>
</body>
</html>