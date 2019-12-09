<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="info_text">회원정보</div>
	<table id="info_area">
		<tr>
			<td>
				<table id="info_table">
					<tr>
						<td align="center">프로필 사진</td>
					</tr>
					<tr>
						<td>
							<img src="resources/img/${sessionScope.loginMember.member_photo }"
							id="updateMemberPhoto" width="100px" height="120px"></td>
					</tr>
				</table>
			</td>
			<td>
				<table>
					<tr>
						<td>회원 ID</td>
						<td>${sessionScope.loginMember.member_id }</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${sessionScope.loginMember.member_name }</td>
					</tr>
					<tr>
						<td>주소</td>
						<td>${sessionScope.loginMember.member_addr }</td>
					</tr>
				</table>
			</td>
	</table>

<button onclick="goMemberUpdate();">수정하기</button>
<button onclick="goMemberDelete();">탈퇴하기</button>

</body>
</html>