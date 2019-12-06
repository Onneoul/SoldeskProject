$(function() {
	memberAddressSearch();
	memberIdCheck();
});

function memberAddressSearch() {
	$("#member_address_btn").click(function () {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#member_addr3Input").val(data.zonecode);
				$("#member_addr1Input").val(data.roadAddress);
			}
		}).open();
	});
}

function memberIdCheck() {
	$("#member_idInput").keyup(function() {
		var member_id = $(this).val(); // 쓰고있는 내용 가져옴

		// data를 매칭시켜서 중복이면 빨간글자 뜨게
		// JQuery로 AJAX로 해당 데이터 불렀을 때 성공하면 ok가 뜸
		$.ajax({
			url : "member.get",
			data : {
				"member_id" : member_id
			},
			success : function(data) {
				if (data.member.length == 1) {
					$("#join_idchk").css("opacity", "1");
				} else {
					$("#join_idchk").css("opacity", "0");
				}
			}
		});
	});
}