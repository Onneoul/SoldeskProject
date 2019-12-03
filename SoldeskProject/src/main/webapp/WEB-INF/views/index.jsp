<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/mainDesign.css">
<link rel="stylesheet" href="resources/css/homeDesign.css">
</head>
<body>
	<table id="site_head">
		<tr>
			<td id="site_head_list" align="right">
				<table>
					<tr id="site_login">
						<td>로그인</td>
						<td id="site_login_bar"> | </td>
						<td>회원가입</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table id="site_title">
					<tr>
						<td>홈페이지 제목</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<ul id="site_head_menu">
					<li>메뉴1</li>
					<li>메뉴2</li>
					<li>메뉴3</li>
					<li>메뉴4</li>
				</ul>
			</td>
		</tr>
		<tr>
		</tr>
	</table>
	<table id="site_content">
		<tr>
			<td id="SiteContent" align="center"><jsp:include page="${SiteMain }"></jsp:include></td>
		</tr>
	</table>
</body>
</html>