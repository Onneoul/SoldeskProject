<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="member_logo_table">
		<tr>
			<td id="member_logo"><img alt="" src="resources/img/loginimg.gif"></td>			
		</tr>
	</table>
	<form action="member.login" method="post" name="memberLoginForm"
		onsubmit="return MemberLoginCheck();">
		<table id="loginform_area">
			<tr>
				<td class="loginform_input"><input name="member_id" placeholder="아이디 입력"></td>
			</tr>
			<tr>
				<td class="loginform_input"><input name="member_pw" type="password" placeholder="비밀번호 입력"></td>
			</tr>
			<tr>
				<td id="loginform_btn">
					<button>로그인</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>