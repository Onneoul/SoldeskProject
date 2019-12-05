<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>회원정보</td>
		</tr>
		<tr>
			<td>
				<table id="insertMemberPhoto">
					<tr>
						<td>프로필 사진</td>
					</tr>
					<tr>
						<td><img
							src="resources/img/${sessionScope.loginMember.member_photo }"
							id="updateMemberPhoto" width="100px" height="120px"></td>
					</tr>
					<tr>
						<td><input name="member_photo" type="file"></td>
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
		<tr>
			<td><button onclick="goMemberUpdate();">수정하기</button></td>
			<td><button onclick="goMemberDelete();">탈퇴하기</button></td>
		</tr>
	</table>
</body>
</html>