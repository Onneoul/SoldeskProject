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
			<td class="detailMenu"><a href="TheaterInfo.com.personDetail.Basic?person_number=${p.person_number }">주요 정보</a></td>
			<td id="CurrentdetailMenu"><a href="TheaterInfo.com.personDetail.Cast?person_number=${p.person_number }">출연작</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.personDetail.Detail?person_number=${p.person_number }">상세 정보</a></td>
		</tr>
	</table>
	출연작
	<table>
		<c:forEach var="cast" items="${p.person_cast }">
			<table>
				<tr>
					<td rowspan="4">
						<a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${cast.theater_number }">
							<img src="resources/theaterPoster/${cast.theater_photo }">
						</a>
					</td>
					<td>
						<a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${cast.theater_number }">
							${cast.theater_title }
						</a>
					</td>
				</tr>
				<tr>
					<td>
					<!-- 장르 들어갈 곳 -->
					</td>
				</tr>
				<tr>
					<td>
						${cast.start_date } ~ ${cast.end_date }
					</td>
				</tr>
				<tr>
					<td>
						출연진 : 
						<c:forEach var="tp" items="${cast.theater_person }">
							${tp.person_name }
						</c:forEach>
					</td>
				</tr>
			</table>
		</c:forEach>
	</table>
</body>
</html>