<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="member.join" method="post" enctype="multipart/form-data"
				name="memberJoinForm" onsubmit="return memberJoinCheck();">
		<table id="join_table">
			<tr>
				<td>회원가입 폼</td>
			</tr>
			<tr>
				<td>아이디 입력</td>
			</tr>
			<tr>
				<td><input name="member_id" placeholder="영어/숫자만" maxlength="10" autocomplete="off" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td>비밀번호 입력</td>
			</tr>
			<tr>
				<td><input name="member_pw" type="password" placeholder="영어/숫자만" maxlength="10" autocomplete="off" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
			</tr>
			<tr>
				<td><input name="member_pwChk" type="password" placeholder="비밀번호 한번 더 입력" maxlength="10" autocomplete="off" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td>이름</td>
			</tr>
			<tr>
				<td><input name="member_name" placeholder="필수" maxlength="10" autocomplete="off" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td>주소</td>
			</tr>
			<tr>
				<td>
					<input id="jm_addr3Input" name="member_addr3" maxlength="5" autocomplete="off" placeholder="우편번호"><br>
					<input id="jm_addr1Input" name="member_addr1" maxlength="30" autocomplete="off" placeholder="주소"><br>
					<input name="member_addr2" maxlength="30" autocomplete="off" placeholder="상세주소">	
				</td>
			</tr>
			<tr>
				<td>사진</td>
			</tr>
			<tr>
				<td><input name="member_photo" type="file"></td>
			</tr>
			<tr>
				<td>
					<button>가입완료</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>