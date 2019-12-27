<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="GroupInfo">
		<tr>
			<td>
				<a href="TheaterInfo.com.groupDetail.Basic?group_number=${o.group_number }">
					${o.group_name }
				</a>
			</td>
		</tr>
		<tr>
			<td>
				구성원 : 
				<c:forEach var="p" items="${o.group_person }">
					<a href="TheaterInfo.com.personDetail.Basic?person_number=${p.person_number }">
						${p.person_name }
					</a>	
				</c:forEach>
			</td>
		</tr>
		<tr>
		</tr>
	</table>
	<div id="DetailMain"><jsp:include page="${GroupDetailInfo }"></jsp:include></div>
</body>
</html>