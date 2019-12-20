<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>
	<table id="site_main">
		<tr>
			<td id="site_main_img" colspan="3" align="center">
					<div class="banner">
						<ul>
							<li><img
								src="resources/img/slideimg1.png"
								width="1000px" height="500px"></li>
							<li><img
								src="resources/img/slideimg3.jpg"
								width="1000px" height="500px"></li>
							<li><img
								src="resources/img/slideimg5.jpg"
								width="1000px" height="500px"></li>
						</ul>
					</div>
			</td>
		</tr>
		<tr align="center">
			<td id="site_main_info">
				<table class="site_main_info_table">
					<tr>
						<td class="site_main_info_title" colspan="2">연극정보</td>
					</tr>
					<tr>
						<td>
							<table>
								<tr>
									<td class="site_main_info_img"><img
										src="resources/img/Penguins.jpg"></img></td>
								</tr>
								<tr>
									<td>제목입력</td>
								</tr>
								<tr>
									<td>기간~기간</td>
								</tr>
								<tr>
									<td>작가</td>
								</tr>
								<tr>
									<td>평점</td>
								</tr>
							</table>
						</td>
						<td>
							<table>
								<tr>
									<td class="site_main_info_img"><img
										src="resources/img/Penguins.jpg"></img></td>
								</tr>
								<tr>
									<td>제목입력</td>
								</tr>
								<tr>
									<td>기간~기간</td>
								</tr>
								<tr>
									<td>작가</td>
								</tr>
								<tr>
									<td>평점</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
			<!-- 리뷰 -->
			<td>
				<table id="site_main_review_table">
					<tr>
						<td class="site_main_info_title"><img
							src="resources/img/notice.gif"></img> <a
							id="site_main_review_more" href="notice.view">+더보기</a></td>
					</tr>
					<!-- 몇개정도 보일지? -->
					<c:forEach var="n" items="${notices }">
						<tr>
							<td class="site_main_review_title"><a
								onclick="goNoticeContent(${n.notice_number});">${n.notice_title }</a></td>
							<td class="site_main_review_id">${n.notice_id }</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
