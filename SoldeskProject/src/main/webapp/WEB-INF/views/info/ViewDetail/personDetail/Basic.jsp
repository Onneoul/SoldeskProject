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
			<td id="CurrentdetailMenu"><a href="TheaterInfo.com.personDetail.Basic?person_number=${p.person_number}">주요 정보</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.personDetail.Cast?person_number=${p.person_number }">출연작</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.personDetail.Detail?person_number=${p.person_number }">상세 정보</a></td>
		</tr>
	</table>
	베이직 정보창
</body>
</html>