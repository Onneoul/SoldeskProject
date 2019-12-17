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
<link rel="stylesheet" href="resources/css/snsDesign.css">
<link rel="stylesheet" href="resources/css/noticeDesign.css">
<link rel="stylesheet" href="resources/css/theaterDesign.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> 
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/site_move.js"></script>

<script type="text/javascript" src="resources/js/homeSlide.js"></script>
<link rel="stylesheet" href="resources/css/homeSlide.css">

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
									<td onclick="goHome();"><img alt="" src="resources/img/mainlogo.jpg"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table id="site_head_menu_area">
					<tr>
						<td colspan="3">
							<ul id="site_head_menu">
								<li id="site_head_menu1" onclick="siteMenu1Mouse();" style="cursor: pointer;">
								연극소식
								</li>
								<!-- 메뉴 마우스 대면 나오는 부분 -->
									<table id="site_menu_notice_js">
										<tr><td class="site_menu_notice_li"><a href="notice.view?notice_category=1">공지사항</a></td></tr>
										<tr><td class="site_menu_notice_li"><a href="notice.view?notice_category=2">이 벤 트</a></td></tr>
									</table>
								<li id="site_head_menu2" style="cursor: pointer;">
								게시판
								</li>
								<!-- 메뉴 마우스 대면 나오는 부분 -->
									<table id="site_menu_sns_js">
											<tr><td id="site_menu_sns_li" onclick="goSNS();">SNS</td></tr>
									</table>
								<li id="site_head_menu3" style="cursor: pointer;">
									<a href="TheaterInfo.com.theater">공연정보</a>
								</li>
								<li id="site_head_menu4" style="cursor: pointer;">
									<a href="TheaterInfo.com.theater">고객센터</a>
								</li>
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