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
			<td class="detailMenu"><a href="TheaterInfo.com.stageDetail.Basic?stage_number=${stage.stage_number }">주요 정보</a></td>
			<td class="detailMenu"><a href="TheaterInfo.com.stageDetail.Detail?stage_number=${stage.stage_number }">상세 정보</a></td>
			<td id="CurrentdetailMenu"><a href="TheaterInfo.com.stageDetail.Theater?stage_number=${stage.stage_number}">공연작</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				공연 작
			</td>
		</tr>
	</table>
</body>
</html>