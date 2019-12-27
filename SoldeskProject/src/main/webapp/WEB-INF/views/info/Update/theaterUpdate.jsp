<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<form action="TheaterInfo.com.theaterUpdate.value" method=post enctype="multipart/form-data" name="TheaterInfoForm">
		<table>
			<tr>
				<td> 
					<input name="theater_number" value="${theater.theater_number }" readonly="readonly">
					사진 : <input name="theater_photo" type="file" value="${theater.theater_photo }">
				</td>
			</tr>
			<tr>
				<td>제목 : <input name="theater_title" value="${theater.theater_title }"></td>
			</tr>
			<tr>
				<td>공연 시간 : <input name="theater_time" value="${theater.theater_time }"></td>
			</tr>
			<tr>
				<td>관람 연령 : <input name="thaeter_age" value="${theater.theater_age }"> </td>
			</tr>
		</table>
		<button>수정완료</button>
	</form>
</body>
</html>