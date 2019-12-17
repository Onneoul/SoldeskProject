<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="site_login" style="border-spacing: 0px;">
		<tr>
			<td id="site_login_icon" colspan="1">
				<c:if test="${sessionScope.loginMember.member_photo != null}">
					<img alt="" src="resources/img/${sessionScope.loginMember.member_photo }"><br>
				</c:if>
				<c:if test="${sessionScope.loginMember.member_photo == null}">
					<img alt="" src="resources/img/member.png"><br>
				</c:if>
			</td>
			<td class="site_login_btn">			
				<div id="site_login_successID"><span style="font-weight: 700;">${sessionScope.loginMember.member_id }</span>님 반갑습니다.<br></div>
				<button onclick="goMemberInfo();">회원정보</button>
				<span id="site_login_bar">|</span>
				<button onclick="goMemberLogOut();">로그아웃</button>
			</td>
		</tr>
	</table>
</body>
</html>