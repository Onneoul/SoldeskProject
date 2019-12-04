<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/mainDesign.css">
<link rel="stylesheet" href="resources/css/homeDesign.css">
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>
</head>
<body>
	<table id="site_head">
		<tr>
			<td>
				<table id="site_head_area">
					<tr>
						<td id="site_head_list" align="right"><jsp:include
								page="${loginPage }"></jsp:include></td>
					</tr>
					<tr>
						<td>
							<table id="site_title">
								<tr>
									<td onclick="goHome();">홈페이지 제목</td>
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
				</table>
			</td>
		</tr>
	</table>
	<table id="site_content">
		<tr>
			<td id="SiteContent" align="center"><jsp:include
					page="${SiteMain }"></jsp:include></td>
		</tr>
	</table>
</body>
</html>