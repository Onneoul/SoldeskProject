function goHome() {
	location.href = "index.do";
}

function goMemberJoin() {
	location.href = "member.join.go";
}

function goMemberLogin() {
	location.href = "member.login.go";
}

function goMemberInfo() {
	location.href= "member.info.go";
}

function goMemberUpdate() {
	location.href= "member.update.go";
}

function goMemberDelete() {
	var ok = confirm("정말 탈퇴하시겠습니까?");
	if (ok) {
		location.href= "member.delete.go";
		alert("탈퇴되었습니다.");
	} else {
		alert("취소하셨습니다.");
	}
	
}

function goMemberLogOut() {
	location.href= "member.logout";
}