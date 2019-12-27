<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/theaterDesign.css">
</head>
<body>
	<table id="theaterDetail">
		<tr>
			<td rowspan="8">
				<a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${ti.theater_number }">
					<img src="resources/theaterPoster/${ti.theater_photo }" id="poster">
				</a>
			</td>
			<td>
				<a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${ti.theater_number }">
					<h3 id="theater_title" onclick="toTheaterDetail(${ti.theater_number})">${ti.theater_title }</h3>
				</a>
			</td>
		</tr>
		<tr>
			<td>${ti.theater_age } 세 관람가</td>
		</tr>
		<tr>
			<td>
				장르 : 
				<c:forEach var="g" items="${ti.theater_genre }">
					<a href="TheaterInfo.com.genreDetail.Basic?genre_number=${g.genre_number }">${g.genre_name }</a>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>${ti.theater_time } 분</td>
		</tr>
		<tr>
			<td>배우 : 
			<c:forEach var="p" items="${ti.theater_person }">
				<a onclick="toPersonInfo(${p.person_number});">${p.person_name }</a>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td>
				주최 단체 : 
				<a href="TheaterInfo.com.groupDetail.Basic?group_number=${ti.theater_organization.group_number }">
					${ti.theater_organization.group_name }
				</a>
			</td>
		</tr>
		<tr>
			<td>
				공연장 : 
				<a href="TheaterInfo.com.stageDetail.Basic?stage_number=${ti.theater_stage.stage_number }">
					${ti.theater_stage.stage_name }
				</a>
			</td>
		</tr>
	</table>
	<div id="DetailMain"><jsp:include page="${DetailInfo }"></jsp:include></div>
	<c:if test="${sessionScope.loginMember.member_level == 2 }">
		<button onclick="toupdateTheater(${ti.theater_number});">수정</button>
		<button onclick="deleteTheater(${param.theater_number});">삭제</button>
	</c:if>
</body>
</html>