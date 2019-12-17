<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="page_title_table">
		<tr>
			<td id="sns_img"><img src="resources/img/sns.png"></td>			
		</tr>
	</table>
	<form action="sns.index" method="post">
		<table id="sns_head_area">
			<tr>
				<td id="sns_index_text">
					<input name="search">
				</td>
				<td id="sns_index_btn">
					<button><img src="resources/img/06-magnify.png"></button>
				</td>
			</tr>
		</table>
	</form>
	<table id="sns_snswrite_area">
		<tr>
			<td>
				<form action="sns.write" method="POST" name="snsWriteForm"
					onsubmit="return snsWriteCheck();">
					<input type="hidden" name="token" value="${token }">
					<input type="hidden" name="sns_user" value="${sessionScope.loginMember.member_id }">
					<table id="sns_snswrite_input">
						<tr>
							<td><textarea name="sns_text" maxlength="250"
									placeholder="무슨생각을 하고 계신가요?"></textarea></td>
							<td><button>등록하기</button></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<c:forEach var="s" items="${snss}">
		<table id="sns_view_area">
			<tr class="sns_view_tr1">
				<td class="sns_view_td2">작성자 &nbsp;&nbsp;&nbsp;<span class="sns_view_re">${s.sns_user }</span></td>
				<td class="sns_view_re">
				<c:if test="${s.sns_user == sessionScope.loginMember.member_id }">
					<span onclick="snsUpdate(${s.sns_number}, '${s.sns_text}', ${curPage });">수정</span>&nbsp;&nbsp;&nbsp;
					<span onclick="snsDelete(${s.sns_number });">삭제</span>
				</c:if>
				</td>
			</tr>
			<tr class="sns_view_tr1">
				<td class="sns_view_td1">작성일&nbsp;:&nbsp;<fmt:formatDate value="${s.sns_date }" type="both" pattern="MM/dd hh:mm" timeStyle="short" /></td>
			</tr>
			<tr>			
				<td class="sns_view_td3">${s.sns_text }</td>
			</tr>
				<tr>
					<td class="sns_reply_re">[댓글]</td>
				</tr>	
			<c:forEach var="sr" items="${s.sns_replys }">
				<tr>
					<td class="sns_reply_area">
						<span class="sns_reply_user">${sr.reply_user }</span>
						<span class="sns_reply_text">${sr.reply_text }</span>
						<span class="sns_reply_date">
							<fmt:formatDate value="${sr.reply_date }" type="both" pattern="MM/dd hh:mm" timeStyle="short" />
						</span>
						<c:if test="${sr.reply_user == sessionScope.loginMember.member_id }">
							<button class="sns_reply_delbtn" onclick="deleteSNSReply(${sr.reply_number}, ${curPage });">삭제하기</button>
						</c:if>
						<br>
					</td>
				</tr>
			</c:forEach>
			<c:if test="${sessionScope.loginMember != null }">
				<tr>
					<td class="sns_reply_write">
						<form action="sns.reply.write" method="get" name="snsReplyWriteForm" 
							onsubmit="return snsReplyWriteCheck(this);">
							<span class="SNSReply_id">${sessionScope.loginMember.member_id }</span>
							<input id="SNSComment_me" type="hidden" name="token" value="${token }"> 
								<input type="hidden"name="reply_number_num" value="${s.sns_number }"> 
								<input type="hidden" name="p" value="${curPage }"> 
								<input class="SNSReply_txt" name="reply_text" maxlength="800">
							<button class="SNSComment_btn">댓글쓰기</button>
						</form>
					</td>
				</tr>
			</c:if>
		</table>
	</c:forEach>
	<c:choose>
	<c:when test="${curPage == 1}">
		<a id="sns_change" href="sns.page.change?p=${curPage + 1}">더보기</a>
	</c:when>
	<c:when test="${curPage != 1 }">
		
	</c:when>
	</c:choose>
</body>
</html>