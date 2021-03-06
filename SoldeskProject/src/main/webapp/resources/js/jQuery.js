$(function() {
	memberAddressSearch();
	memberIdCheck();
	memberpwCheck();
	updateAddressSearch();
	noticeTitleClick();
	imgslide();
	noticeCategoryClick();
	siteMenu1Mouse();
	siteMenu2Mouse();
});

// 회원가입 주소검색
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

function noticeCategoryClick() { 
	$("#notice_category_sel").on("change", function () { 
		var value = $(this).val();
		
		if (value == null) {
			location.href = "notice.view";
			
		} else {
			location.href = "notice.view?notice_category=" + value;
		}
			
	}); 
}


function noticeTitleClick() {
	
	$(".notice_title").click(function () {
		
	});
}

// 정보수정 주소검색
function updateAddressSearch() {
	$("#update_address_btn").click(function () {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#update_addr3Input").val(data.zonecode);
				$("#update_addr1Input").val(data.roadAddress);
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


function memberpwCheck() {
	
	$("#member_pwchkInput").keyup(function() {		
		var pw = $(this).closest("table").find("#member_pwInput").val();
		var pwchk = $(this).val();
	if (pw != pwchk) {
		$("#join_pwchk").css("opacity", "1");
	}	else {
		$("#join_pwchk").css("opacity", "0");
		}
	});
}

function siteMenu1Mouse() {
		var element = document.getElementById("site_head_menu1");
		var element2 = document.getElementById("site_menu_notice_js");
		var result = true;
		element.onmouseenter = function() {
			$("#site_menu_notice_js").css("opacity","1");
			$("#site_menu_notice_js").css("top","156px");
			$("#site_menu_notice_js").css("left","325px");
			result = false;
		}
		element2.onmouseenter = function () {
			if (!result) {
				$("#site_menu_notice_js").css("opacity","1");
				$("#site_menu_notice_js").css("top","156px");
				$("#site_menu_notice_js").css("left","325px");
				result = true;
			} else {
				$("#site_menu_notice_js").css("opacity","0");	
				$("#site_menu_notice_js").css("top","-138px");
				$("#site_menu_notice_js").css("left","-335px");
			}
		} 
		element.onmouseleave = function() {
				$("#site_menu_notice_js").css("opacity","0");	
				$("#site_menu_notice_js").css("top","-138px");
				$("#site_menu_notice_js").css("left","-335px");
		}
		element2.onmouseleave = function () {
				$("#site_menu_notice_js").css("opacity","0");	
				$("#site_menu_notice_js").css("top","-138px");
				$("#site_menu_notice_js").css("left","-335px");
		}
}

function siteMenu2Mouse() {
	var element = document.getElementById("site_head_menu2");
	var element2 = document.getElementById("site_menu_sns_js");
	var result = true;
	element.onmouseenter = function() {
		$("#site_menu_sns_js").css("opacity","1");
		$("#site_menu_sns_js").css("top","156px");
		$("#site_menu_sns_js").css("left","535px");
		result = false;
	}
	element2.onmouseenter = function () {
		if (!result) {
			$("#site_menu_sns_js").css("opacity","1");
			$("#site_menu_sns_js").css("top","156px");
			$("#site_menu_sns_js").css("left","535px");
			result = true;
		} else {
			$("#site_menu_sns_js").css("opacity","0");	
			$("#site_menu_sns_js").css("top","-138px");
			$("#site_menu_sns_js").css("left","-547px");
		}
	} 
	element.onmouseleave = function() {
			$("#site_menu_sns_js").css("opacity","0");	
			$("#site_menu_sns_js").css("top","-138px");
			$("#site_menu_sns_js").css("left","-547px");
	}
	element2.onmouseleave = function () {
			$("#site_menu_sns_js").css("opacity","0");	
			$("#site_menu_sns_js").css("top","-139px");
			$("#site_menu_sns_js").css("left","-335px");
	}
}


function imgslide(){

  $val = $("#slide").attr("val"); //현재 이미지 번호를 가져옵니다

  $mx = $("#slide").attr("mx"); //총 이미지 개수를 가져옵니다

	$("#img"+$val).hide(); //현재 이미지를 사라지게 합니다.

	if( $val == $mx ){ $val = 1; } //현재이미지가 마지막 번호라면 1번으로 되돌립니다.

	else{ $val++; } //마지막 번호가 아니라면 카운트를 증가시켜줍니다

	$("#img"+$val).fadeIn(1500); //변경된 번호의 이미지영역을 나타나게 합니다.괄호 안에 숫자는 페이드인 되는 시간을 나타냅니다.

	$("#slide").attr('val',$val); //변경된 이미지영역의 번호를 부여합니다.

	setTimeout('imgslide()',5000); //1초 뒤에 다시 함수를 호출합니다.(숫자값 1000당 1초)

}
