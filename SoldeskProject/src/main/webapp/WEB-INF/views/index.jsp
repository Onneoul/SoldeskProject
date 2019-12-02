<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="stylesheet" href="resources/css/MenuDesign.css">
</head>
<body>
	<table id="menu">
		<tr>
			<td id="siteMenuArea" align="center">
				<span>공연 정보</span>
				<span>게시판</span>
				<span>공지사항</span>
		</tr>
		<tr>
			<td id="siteTitleArea">
				<div id="SiteTitle" align="center">사이트 제목</div>
			</td>
		</tr>
		<tr>
			<td id="SiteContent" align="center"><jsp:include page="${SiteMain }"></jsp:include></td>
		</tr>
	</table>
</body>
</html>