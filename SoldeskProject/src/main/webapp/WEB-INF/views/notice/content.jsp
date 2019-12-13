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
			<td id="notice_write_category">게시글</td>
			<td id="notice_update_category">
				<c:if test="${noticeContent.notice_category == 1}">
					<div>공지사항</div> 
				</c:if>
				<c:if test="${noticeContent.notice_category == 2}">
					<div>이벤트</div> 
				</c:if>
			</td>
		</tr>
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
			<td id="notice_write_writebtn" colspan="2"><button onclick="goNotice();">뒤로가기</button>
			<c:if test="${'admin' == sessionScope.loginMember.member_id }">
				<button onclick="goNoticeUpdate(${noticeContent.notice_number});" style="margin-left: 25px;">수정하기</button>
			</c:if>
			</td>
		</tr>
	</table>
</body>
</html>