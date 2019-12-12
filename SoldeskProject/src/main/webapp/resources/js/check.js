function memberJoinCheck() {
	
	var idInput = document.memberJoinForm.member_id;
	var pwInput = document.memberJoinForm.member_pw;
	var pwChkInput = document.memberJoinForm.member_pwChk;
	var nameInput = document.memberJoinForm.member_name;
	var addr1Input = document.memberJoinForm.member_addr1;
	var addr2Input = document.memberJoinForm.member_addr2;
	var addr3Input = document.memberJoinForm.member_addr3;
	var photoInput = document.memberJoinForm.member_photo;

	if(isEmpty(idInput) || containsHS(idInput)) {
		alert("ID입력을 다시 확인하세요.");
		idInput.value = "";
		idInput.focus();
		return false;
	} else if (isEmpty(pwInput) || notEquals(pwInput, pwChkInput)
			|| notContains(pwInput, "1234567890")) {
		alert("PW입력을 다시 확인하세요.");
		pwInput.value = "";
		pwChkInput.value = "";
		pwInput.focus();
		return false;
	} else if (isEmpty(nameInput)) {
		alert("이름을 입력하세요.");
		nameInput.value = "";
		nameInput.focus();
		return false;
	} else if (isEmpty(addr1Input) || isEmpty(addr2Input)
			|| isEmpty(addr2Input)) {
		alert("주소를 입력하세요.");
		addr1Input.value = "";
		addr2Input.value = "";
		addr3Input.value = "";
		addr1Input.focus();
		return false;
	} else if (isEmpty(photoInput)
			|| (isNotType(photoInput, "png") && isNotType(photoInput, "gif")
					&& isNotType(photoInput, "jpg") && isNotType(photoInput,
					"bmp"))) {
		alert("사진을 등록하세요.");
		return false;
	}
	return true;
	alert("가입완료");
}
function snsWriteCheck() {
	var textInput = document.snsWriteForm.sns_text;

	if (isEmpty(textInput)) {
		alert("작성하지 않아 등록할 수 없습니다.")
		textInput.focus();
		return false;
	}
	return true;
}

function snsReplyWriteCheck() {
	var textInput = f.txt;
	
	if (isEmpty(textInput)) {
		alert("댓글을 입력하세요.");
		textInput.focus();
		return false;
	}
	return true;
}

function noticeWriteCheck() {
	var titleInput = document.noticeWriteForm.notice_title;
	var textInput = document.noticeWriteForm.notice_text;
	
	if (isEmpty(titleInput)) {
		alert("제목을 입력하세요.");
		titleInput.focus();
		return false;
	} else if (isEmpty(textInput)) {
		alert("내용을 입력하세요.");
		textInput.focus();
		return false;
	}
	return true;
}
