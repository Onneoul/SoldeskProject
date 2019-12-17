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
	<table class="page_title_table">
		<tr>
			<td class="page_title">회원가입</td>			
		</tr>
	</table>
	<form action="member.join" method="post" enctype="multipart/form-data"
				name="memberJoinForm" onsubmit="return memberJoinCheck();">
		<table id="join_table">
			<tr>
				<td class="join_txt">아이디 입력</td>
			</tr>
			<tr>
				<td class="join_input"><input id="member_idInput" name="member_id" placeholder="영어/숫자만" maxlength="10" autocomplete="off" autofocus="autofocus" style="margin-bottom: 3px !important;"><br>
					<div id="join_idchk">중복된 ID입니다</div>
				</td>
			</tr>
			<tr>
				<td class="join_txt">비밀번호 입력</td>
			</tr>
			<tr>
				<td class="join_input"><input name="member_pw" type="password" placeholder="영어/숫자만" maxlength="10" autocomplete="off" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td class="join_txt">비밀번호 확인</td>
			</tr>
			<tr>
				<td class="join_input"><input name="member_pwChk" type="password" placeholder="비밀번호 한번 더 입력" maxlength="10" autocomplete="off" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td class="join_txt">이름</td>
			</tr>
			<tr>
				<td class="join_input"><input name="member_name" placeholder="필수" maxlength="10" autocomplete="off" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td class="join_txt">주소</td>
			</tr>
			<tr>
				<td id="join_addr_input">
					<input id="member_addr3Input" readonly="readonly" name="member_addr3" maxlength="5" autocomplete="off" placeholder="우편번호"><br>
					<input id="member_addr1Input"  readonly="readonly" name="member_addr1" maxlength="30" autocomplete="off" placeholder="주소"><br>
					<input name="member_addr2" maxlength="30" autocomplete="off" placeholder="상세주소" style="margin-bottom: 15px">	
				</td>
			</tr>
			<tr>
				<td class="join_txt">사진등록</td>
			</tr>
			<tr>
				<td id="join_photo_input"><input name="member_photo" type="file" style="width: 310px; height: 30px; background-color: white;"></td>
			</tr>
			<tr align="center">
				<td id="join_complete_btn">
					<button>가입완료</button>
				</td>
			</tr>
		</table>
	</form>
	<button id="member_address_btn">주소검색</button>
</body>
</html>