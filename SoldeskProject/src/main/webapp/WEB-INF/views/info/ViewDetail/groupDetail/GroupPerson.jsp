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
			<td class="detailMenu"><a href="TheaterInfo.com.groupDetail.Basic?group_number=${o.group_number }">주요 정보</a></td>
			<td id="CurrentdetailMenu"><a href="TheaterInfo.com.groupDetail.Person?group_number=${o.group_number }">소속 인원</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.groupDetail.Theater?group_number=${o.group_number}">공연작</a></td>
		</tr>
	</table>
	<table>
		<c:forEach var="p" items="${o.group_person }">
			<tr>
				<td rowspan="3">
					<a href="TheaterInfo.com.personDetail.Basic?person_number=${p.person_number }">
						<img src="resources/img/person/${p.person_number }">
					</a>
				</td>
				<td>
					이름 : 
					<a href="TheaterInfo.com.personDetail.Basic?person_number=${p.person_number }">
						${p.person_name }
					</a>
				</td>
			</tr>
			<tr>
				<td>
					생년월일 : 
					<fmt:formatDate pattern="yyyy년 MM월 dd일" value="${p.person_birth }"/>
				</td>
			</tr>
			<tr>
				<td>
					<c:forEach var="t" items="${p.person_cast }" end="3">
						<a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${t.theater_number }">
							${t.theater_title }
						</a>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>