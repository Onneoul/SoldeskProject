<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/mainDesign.css">
<link rel="stylesheet" href="resources/css/homeDesign.css">
<link rel="stylesheet" href="resources/css/memberDesign.css">
<link rel="stylesheet" href="resources/css/theaterDesign.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/site_move.js"></script>
</head>
<body>
	<table id="site_head">
		<tr>
			<td>
				<table id="site_head_area">
					<tr>
						<td id="result_place">${result }</td>
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
						<td colspan="2">
							<ul id="site_head_menu">
								<li>공지사항</li>
<<<<<<< HEAD
								<li onclick="goSNS();">게시판</li>
								<li>연극정보</li>
=======
								<li>게시판</li>
								<li><a href="TheaterInfo.com.theater">공연정보</a></li>
>>>>>>> refs/remotes/origin/master
								<li>고객센터</li>
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
					page="${content }"></jsp:include></td>
		</tr>
	</table>
</body>
</html>