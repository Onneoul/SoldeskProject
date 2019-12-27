<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<td class="detailMenu"><a href="TheaterInfo.com.theaterDetail.ViewTime?theater_number=${theater.theater_number }">시간표</a></td>
			<td id="CurrentdetailMenu"><a href="TheaterInfo.com.theaterDetail.ViewReview?theater_number=${theater.theater_number }">리뷰</a></td>
		</tr>
	</table>
	view review
</body>
</html>