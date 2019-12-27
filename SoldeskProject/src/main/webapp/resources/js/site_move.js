function toTheaterInfo() {
	location.href = "TheaterInfo.com.theater";
}

function toTheaterDetail(theater_number) {
	location.href = "TheaterInfo.com.theaterDetail.Basic?theater_number=" + theater_number;
}

function toTheaterDetailTime() { // Controller에 아래 주소로 요청 보내서 theater_number의 date_time 테이블에서 select 해오기
	// select * from theater_info, date_time, theater_date;
	location.href = "theaterInfo.com.theaterTime.Detail?theater_number=" + theater_number;
}

function toPersonInfo(person_number) {
	location.href = "TheaterInfo.com.personDetail.Basic?person_number=" + person_number;
}

function toGenreInfo(genre_number) {
	location.href = "theaterInfo.com/genre?genre_number=" + genre_number;
}

function toStageInfo(stage_number) {
	location.href = "theaterInfo.com/stage?stage_number=" + stage_number;
}

function toGroupInfo(group_number) {
	location.href = "theaterInfo.com/group?group_number=" + group_number;
}

function toPersonSearch(c, t) {
	location.href = "TheaterInfo.com.personSearch?code_name=" + person + "&code=" + c + "&theater_number=" + t
}

function toTheaterReg() {
	location.href = "TheaterInfo.com.theaterReg";
}

function toTheaterInsert() {
	var t_title = document.theater_write.theater_title;
	var t_photo = document.theater_write.theater_photo;
	var t_age = document.theater_write.theater_age;
	var t_time = document.theater_write.theater_time;
	location.href = "TheaterInfo.com.theaterRegist?theater_title="+t_title+"&theater_photo"+t_photo+"&theater_age="+t_age+"&theater_time="+t_time;
}

function toPersonSearch(theater_number) {
	window.open("TheaterInfo.com.searchPerson?theater_number="+theater_number, "배우 검색", "width=450 height=550, left=500, top=200");
}

function insertCasting(theater_number, person_number) {
	location.href = "TheaterInfo.com.insertCasting?theater_number="+theater_number+"&person_number="+person_number;
}

function castingClose(theater_number) {
		window.opener.location.href = "TheaterInfo.com.theaterRegisted?theater_number="+theater_number;
		window.close();
}

function deleteCasting(theater_number, person_number) {
	location.href = "TheaterInfo.com.deleteCasting?theater_number="+theater_number+"&person_number="+person_number;
}

function toPersonWrite(theater_number) {
	location.href = "TheaterInfo.com.writePerson?theater_number="+theater_number;
}

function toGenreSearch(theater_number) {
	window.open("TheaterInfo.com.searchGenre?theater_number="+theater_number, "장르 검색", "width=450 height=550, left=500, top=200");
}

function insertGenre(theater_number, genre_number) {
	location.href = "TheaterInfo.com.insertGenre?theater_number="+theater_number+"&genre_number="+genre_number;
}


function toGenreWrite() {
	location.href("TheaterInfo.com.insertGenre");
}

function toStageSearch(theater_number) {
	location.href = "TheaterInfo.com.searchStage?theater_number="+theater_number;
	
}

function toupdateTheater(theater_number) {
	location.href = "TheaterInfo.com.theaterUpdate?theater_number="+theater_number;
}

function updateTheater(theater_number) {
	location.href = "TheaterInfo.com.theaterUpdate.value?theater_number="+theater_number;
}

function deleteTheater(theater_number) {
	location.href = "TheaterInfo.com.theaterDelete?theater_number="+theater_number;
}

