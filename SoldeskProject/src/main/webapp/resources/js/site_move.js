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
	location.href = "theaterInfo.com/person?person_number=" + person_number;
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