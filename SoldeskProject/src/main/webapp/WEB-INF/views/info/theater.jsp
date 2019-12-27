<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<td>
				<button onclick="toTheaterReg();">작성</button>
			</td>
		</tr>
		<tr>
			<td colspan="3" class="underbar"></td>
		</tr>
		<tr id="theaterSelect">
			<td>
				<a href="TheaterInfo.theaterNow">
					<button id="theaterButton">상영중</button>
				</a>
				<a href="TheaterInfo.theaterPlan">
					<button id="theaterButton2">예정</button>
				</a>
			</td>
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
		<table class="theaterList">
			<tr>
				<td rowspan="8"><img src="${ti.theater_photo }"></td>
			</tr>
			<tr>
				<td>
					<a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${ti.theater_number}">
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
				<td><fmt:formatDate value="${ti.start_date.theater_date }" pattern="yyyy년 MM월 dd일"/>~</td>
				<td><fmt:formatDate value="${ti.end_date.theater_date }" pattern="yyyy년 MM월 dd일"/></td>
			</tr>
			<tr>
				<td>${ti.theater_age }세 이상</td>
			</tr>
			<tr>
				<td>${ti.theater_time }분</td>
			</tr>
			<tr>
				<td>배우 : <c:forEach var="P" items="${ti.theater_person }">
						<c:if test="${P.code == '02' }">
							<a href="TheaterInfo.com.personDetail.Basic?person_number=${P.person_number }">
								<span>${P.person_name }</span>
							</a>
						</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>
					주최 단체 : 
							<a href="TheaterInfo.com.groupDetail.Basic?group_number=${ti.theater_organization.group_number}">
								${ti.theater_organization.group_name }
							</a>				
				</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>