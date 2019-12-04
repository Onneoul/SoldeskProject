<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="member.login" method="post"
				name="loginForm" onsubmit="return loginCheck();">
		<table id="login_table">
			<tr>
				<td>아이디</td><br>
				<td><input name="member_id"></td>
			</tr>
			<tr>
				<td>비밀번호</td><br>
				<td><input name="member_pw" type="password"></td>
			</tr>
			<tr>
				<td>
					<button>로그인</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>