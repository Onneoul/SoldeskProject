<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td rowspan="4">
				<a href="TheaterInfo.com.stageDetail.Basic?stage_number=${stage.stage_number }">
					<img src="resources/img/stage/${stage.stage_photo }">
				</a>
			</td>
			<td>
				<a href="TheaterInfo.com.stageDetail.Basic?stage_number=${stage.stage_number }">
					<strong>${stage.stage_name }</strong>
				</a>
			</td>
		</tr>
		<tr>
			<td>
				${stage.stage_place }
			</td>
		</tr>
		<tr>
			<td>
				설립일 : 
				<fmt:formatDate pattern="yyyy년 MM월 dd일" value="${stage.stage_date }"/>
			</td>
		</tr>
	</table>
	<div id="stageDetailMain"><jsp:include page="${StageDetailInfo }"></jsp:include></div>
</body>
</html>