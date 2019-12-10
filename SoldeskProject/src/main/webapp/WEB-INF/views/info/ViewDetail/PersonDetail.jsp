<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td rowspan="4"><img src="resources/img/person/${p.person_photo }"></td>
			<td>${p.person_name }</td>
		</tr>
		<tr>
			<td>${p.person_birth }</td>
		</tr>
	</table>
</body>
</html>