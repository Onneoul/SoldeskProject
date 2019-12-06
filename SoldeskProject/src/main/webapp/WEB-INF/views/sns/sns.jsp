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
<form action="sns.index" method="post">
	<table>
		<tr>
			<td>SNS소통 게시판</td>
		</tr>
		<tr>
			<td><input name="search"></td>
			<td><button>검색</button></td>
		</tr>
	</table>
</form>
	<table>
		<tr>
			<td>
				<form action="sns.write" method="POST" name="snsWriteForm"
					onsubmit="return snsWriteCheck();">
					<input type="hidden" name="token" value="${token }">
					<table>
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
		<table>
			<tr>
				<td>${s.sns_user }</td>
			</tr>
			<tr>
				<td>${s.sns_date }</td>
			</tr>
			<tr>
				<td>${s.sns_text }</td>
			</tr>
			<tr>
				<td>
				<c:forEach var="sr" items="${s.sns_replys }">
					<span>${sr.reply_date }</span>
					<span>${sr.reply_text }</span>
					<c:if test="${sr.reply_user == sessionScope.loginMember.member_id }">
						<button onclick="deleteSNSReply(${sr.reply_number}, ${curPage });">삭제하기</button>
					</c:if>
				<br>
				</c:forEach>
				</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>