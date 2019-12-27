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
			<td id="CurrentdetailMenu"><a href="TheaterInfo.com.groupDetail.Basic?group_number=${o.group_number }">주요 정보</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.groupDetail.Person?group_number=${o.group_number }">소속 인원</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.groupDetail.Theater?group_number=${o.group_number}">공연작</a></td>
		</tr>
	</table>
	
</body>
</html>