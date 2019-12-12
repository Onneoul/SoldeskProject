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
	<div id="notice_content_img"><img src="resources/img/notice.gif"></div>
	<table>
		<tr>
			<td>
				<table id="notice_area">
					<tr id="notice_tr_txt">
						<td id="notice_no_txt">No.</td>
						<td id="notice_title_txt">Title</td>
						<td id="notice_date_txt">작성자</td>
					</tr>
				<c:forEach var="n" items="${notices }">
					<tr class="notice_tr">
						<td class="notice_no">${n.notice_number }</td>
						<td class="notice_title" onclick="goNoticeContent(${n.notice_number});">${n.notice_title }</td>
						<td class="notice_date">${n.notice_id }</td>						
					</tr>
				</c:forEach>
				<tr>
					<td id="notice_paging" colspan="3">
						<c:if test="${curPage != 1 }">
							<a id="noticeL" href="notice.page.change?p=${curPage - 1 }">이전페이지로</a>
						</c:if>
							<a class="notice_page_no" href="notice.page.change?p=${curPage }">${curPage }Page</a>
						<c:if test="${curPage != pageCount }">
							<a id="noticeR" href="notice.page.change?p=${curPage + 1 }">다음페이지로</a>
						</c:if>
					</td>
				</tr>
				<c:if test="${'admin' == sessionScope.loginMember.member_id }">
					<tr>
						<td colspan="3" id="notice_write_btn">
							<button onclick="goNoticeWrite();">글쓰기</button>
						</td>
					</tr>
				</c:if>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>