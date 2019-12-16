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
	<div>공지사항 작성</div>
	<form action="notice.write" method="POST" name="noticeWriteForm"
		onsubmit="return noticeWriteCheck();">
	<input type="hidden" name="token" value="${token }">
	<table id="notice_write_area" style="border-spacing: 0px;">
		<tr>
			<td id="notice_write_txt">TITLE</td>
			<td id="notice_write_title"><input name="notice_title"></td>
		</tr>
		<tr>
			<td id="notice_write_category">게시글</td>
			<td id="notice_update_category">
				<div><input type="radio" name="notice_category" value="1"><label>공지사항</label></div> 
				<div><input type="radio" name="notice_category" value="2"><label>이벤트</label></div> 
			</td>		
		</tr>
		<tr>
			<td id="notice_write_txatxt" colspan="2">내용</td>
		</tr>
		<tr>
			<td id="notice_write_textarea" colspan="2">
				<textarea name="notice_text"></textarea>
			</td>
		</tr>
		<tr>
			<td id="notice_write_writebtn" colspan="2"><button>작성하기</button></td>
		</tr>
	</table>
	</form>
</body>
</html>