function goHome() {
	location.href = "index.do";
}

function goNotice() {
	location.href = "notice.view"
}

function goNoticeWrite() {
	location.href = "notice.write.go";
}

function goNoticeContent(n) {
	location.href = "notice.content?notice_number=" + n;
}

function goNoticeUpdate(n) {
	location.href = "notice.update.go?notice_number=" + n;
}

function goMemberJoin() {
	location.href = "member.join.go";
}

function goMemberLogin() {
	location.href = "member.login.go";
}

function goMemberInfo() {
	location.href = "member.info.go";
}

function goMemberUpdate() {
	location.href = "member.update.go";
}

function goMemberDelete() {
	var ok = confirm("정말 탈퇴하시겠습니까?");
	if (ok) {
		location.href = "member.delete.go";
		alert("탈퇴되었습니다.");
	} else {
		alert("취소하셨습니다.");
	}
}

function goMemberLogOut() {
	location.href = "member.logout";
}

function goSNS() {
	location.href = "sns.view";
}

function snsDelete(n) {
	var ok = confirm("삭제하십니까?");
	if (ok) {
		location.href = "sns.delete?sns_number=" + n;
	}
}

function deleteSNSReply(n, p) {
	var ok = confirm("댓글을 삭제하시겠습니까?");
	if (ok) {
		location.href = "sns.reply.delete?reply_number=" + n + "&p=" + p;
	}
}

function snsUpdate(n, t, p) {
	t = prompt("수정하실 내용을 작성하세요.", t);
	if (t != null && t.length > 0 && t.length < 250) {
		location.href = "sns.update?sns_number=" + n + "&sns_text=" + t + "&p=" + p;
	}
}


