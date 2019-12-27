<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<form action="TheaterInfo.com.theaterRegist" enctype="multipart/form-data" name="TheaterInfo" method="post">
		<table>
			<tr>
				<td>
					<input name="token" value="${token }">
					사진 : <input type="file" name="theater_photo">
				</td>
			</tr>
			<tr>
				<td>
					제목 : <input name="theater_title">
				</td>
			</tr>
			<tr>
				<td>
					공연 길이 : <input name="theater_time"> 
				</td>
			</tr>
			<tr>
				<td>
					시청 연령 : <input name="theater_age">
				</td>
			</tr>
			<tr>
				<td><button>등록</button></td>
			</tr>
		</table>
	</form>
</body>
</html>