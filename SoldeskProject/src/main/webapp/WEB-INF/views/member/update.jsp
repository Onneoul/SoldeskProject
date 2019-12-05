<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="member.update" method="post"
		enctype="multipart/form-data" name="updateMemberForm"
		onsubmit="return updateMemberCheck();">
		<table>
			<tr>
				<td>회원정보수정</td>
			</tr>
			<tr>
				<td>
					<table id="insertMemberPhoto">
						<tr>
							<td>프로필 사진</td>
						</tr>
						<tr>
							<td>
								<img
									src="resources/img/${sessionScope.loginMember.member_photo }"
									id="updateMemberPhoto" width="100px" height="120px">
							</td>
						</tr>
						<tr>
							<td><input name="member_photo" type="file"></td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td>이름</td>
							<td><input name="member_name"  value ="${sessionScope.loginMember.member_name }" readonly="readonly" ></td>
						</tr>
						<tr>
							<td>회원 ID</td>
							<td><input name="member_id"  value ="${sessionScope.loginMember.member_id }" readonly="readonly" ></td>
						</tr>
						<tr>
							<td class="td1">PW</td>
							<td class="td2"><input name="member_pw"
								placeholder="필수, 숫자 하나이상 반드시" type="password" maxlength="10"
								autocomplete="off"></td>
						</tr>
						<tr>
							<td class="td1">PW확인</td>
							<td class="td2"><input name="member_pwChk"
								placeholder="필수, 숫자 하나이상 반드시" type="password" maxlength="10"
								autocomplete="off"></td>
						</tr>
						<tr>
							<td>주소</td>
							<td>
								<input value="${addr[2] }" name="member_addr3" maxlength="5"
								autocomplete="off" placeholder="우편번호"><br>
								<input value="${addr[0] }" name="member_addr1"
								maxlength="30" autocomplete="off" placeholder="주소"><br>
								<input value="${addr[1] }" name="member_addr2" maxlength="30"
								autocomplete="off" placeholder="상세주소"> 
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr align="center">
				<td><button>수정완료</button></td>
			</tr>
		</table>
	</form>
</body>
</html>