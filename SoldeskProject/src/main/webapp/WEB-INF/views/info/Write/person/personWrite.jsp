<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/js/site_move.js"></script>
<script type="text/javascript" src="resources/js/JQuery.js"></script>

</head>
<body>
	<form action="TheaterInfo.com.personResist?theater_number=${param.theater_number }" name="personWrite" method="post" enctype="multipart/form-data">
		<table id="InserTable">
			<tr>
				<td>사진 : <input name="person_photo" type="file"></td>
			</tr>
			<tr>
				<td>이름 : <input name="person_name"></td>
			</tr>
			<tr>
				<td>생년월일 : <input name="person_birth" type="date"></td>
			</tr>
			<tr>
				<td>출생지 : 
					<input id="member_addr3Input" readonly="readonly" name="person_place3" maxlength="5" autocomplete="off" placeholder="우편번호"><br>
					<input id="member_addr1Input" readonly="readonly" name="person_place1" maxlength="30" autocomplete="off" placeholder="주소"><br>
					<input name="person_place2" maxlength="30" autocomplete="off" placeholder="상세주소">	
				</td>
			</tr>
		</table>
		<button>입력</button>
	</form>
	<button id="member_address_btn">주소검색</button>
</body>
</html> 