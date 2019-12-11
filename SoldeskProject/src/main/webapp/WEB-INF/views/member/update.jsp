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

				<div id="info_text">회원정보수정</div>

		<table id="update_table">
			<tr>
				<td>
					<table id="update_photo">
						<tr>
							<td id="update_photxt">[프로필 사진]</td>
						</tr>
						<tr>
							<td>
								<img
									src="resources/img/${sessionScope.loginMember.member_photo }"
									id="updateMemberPhoto">
							</td>
						</tr>
						<tr>
							<td><input name="member_photo" type="file"></td>
						</tr>
					</table>
				</td>
				<td>
					<table id="update_area">
						<tr>
							<td class="update_txt">이름</td>
							<td class="update_input1"><input name="member_name"  value ="${sessionScope.loginMember.member_name }" readonly="readonly" ></td>
						</tr>
						<tr>
							<td class="update_txt">회원 ID</td>
							<td class="update_input1"><input name="member_id"  value ="${sessionScope.loginMember.member_id }" readonly="readonly" ></td>
						</tr>
						<tr>
							<td class="update_txt">PW</td>
							<td class="update_input2"><input name="member_pw"
								placeholder="필수, 숫자 하나이상 반드시" type="password" maxlength="10"
								autocomplete="off"></td>
						</tr>
						<tr>
							<td class="update_txt">PW확인</td>
							<td class="update_input2"><input name="member_pwChk"
								placeholder="필수, 숫자 하나이상 반드시" type="password" maxlength="10"
								autocomplete="off"></td>
						</tr>
						<tr>
							<td class="update_txt">주소</td>
							<td class="update_input3">
								<input value="${addr[2] }" name="update_addr3" maxlength="5"
								autocomplete="off" placeholder="우편번호" readonly="readonly" id="update_addr3Input"><br>
								<input value="${addr[0] }" name="update_addr1"
								maxlength="30" autocomplete="off" placeholder="주소" readonly="readonly" id="update_addr1Input"><br>
								<input value="${addr[1] }" name="update_addr2" maxlength="30"
								autocomplete="off" placeholder="상세주소"> 
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2" id="update_btn"><button>수정완료</button></td>
			</tr>
		</table>
	</form>
	<button id="update_address_btn">주소검색</button>
</body>
</html>