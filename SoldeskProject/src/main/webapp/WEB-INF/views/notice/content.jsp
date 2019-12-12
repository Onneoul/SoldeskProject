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
	<div id="notice_content_img"><img src="resources/img/notice.gif"></img></div>
	<table id="notice_write_area" style="border-spacing: 0px;">
		<tr>
			<td id="notice_write_txt">TITLE</td>
			<td id="notice_write_title">${noticeContent.notice_title }</td>
		</tr>
		<tr>
			<td id="notice_write_txatxt" colspan="2">내용</td>
		</tr>
		<tr>
			<td id="notice_write_textarea" colspan="2">
				<textarea name="notice_text" readonly="readonly">${noticeContent.notice_text }</textarea>
			</td>
		</tr>
		<tr>
			<td id="notice_write_writebtn" colspan="2"><button>뒤로가기</button></td>
			<c:if test="${'admin' == sessionScope.loginMember.member_id }">
				<button onclick="goNoticeUpdate(${noticeContent.notice_number});">수정하기</button>
			</c:if>
		</tr>
	</table>
</body>
</html>