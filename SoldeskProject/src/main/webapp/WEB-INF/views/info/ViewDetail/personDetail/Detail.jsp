<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<td class="detailMenu"><a href="TheaterInfo.com.personDetail.Basic?person_number=${p.person_number }">주요 정보</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.personDetail.Cast?person_number=${p.person_number }">출연작</a></td>
			<td id="CurrentdetailMenu"><a href="TheaterInfo.com.personDetail.Detail?person_number=${p.person_number }">상세 정보</a></td>
		</tr>
	</table>
	<table id="PersonDetailPage">
		<tr>
			<td>이름 : <a href="TheaterInfo.com.personDetail.Basic?person_number=${p.person_number}">${p.person_name }</a></td>
		</tr>
		<tr>
			<td>생년월일 : <fmt:formatDate pattern="yyyy년 MM월 dd일" value="${p.person_birth }"/></td>
			<td>나이 : ${p.age }세</td>
		</tr>
		<tr>
			<td>출생지 : ${p.person_birthplace }</td>
		</tr>
	</table>
</body>
</html>