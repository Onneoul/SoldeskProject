<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="page_title_table">
		<tr>
			<td class="page_title">회원정보</td>			
		</tr>
	</table>
				<table id="info_table">
					<tr>
						<td align="center" id="info_photxt">[프로필 사진]</td>
					</tr>
					<tr>
						<td>
							<img src="resources/img/${sessionScope.loginMember.member_photo }"
							id="updateMemberPhoto" width="100px" height="120px"></td>
					</tr>
				</table>
	<table id="info_area">
		<tr>
			<td>
			</td>
			<td>
				<table id="info_main">
					<tr>
						<td class="info_txt1">회원 ID</td>
						<td class="info_txt2">${sessionScope.loginMember.member_id }</td>
					</tr>
					<tr>
						<td class="info_txt1">이 &nbsp;&nbsp;&nbsp;&nbsp;름</td>
						<td class="info_txt2">${sessionScope.loginMember.member_name }</td>
					</tr>
					<tr>
						<td class="info_txt1">주 &nbsp;&nbsp;&nbsp;&nbsp;소</td>
						<td class="info_txt2">${sessionScope.loginMember.member_addr }</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

<button class="info_btn" onclick="goMemberUpdate();">수정하기</button>
<button class="info_btn" onclick="goMemberDelete();">탈퇴하기</button>

</body>
</html>