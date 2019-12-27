<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/site_move.js"></script>
</head>
<body>
	<table>
		<c:forEach var="g" items="${genre }">
			<tr onclick="insertGenre(${param.theater_number}, ${g.genre_number })">
				<td>${g.genre_name }</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${curPage != 1 }">
	<a href="nTheaterInfo.com.searchGenre.move?p=${curPage - 1}&theater_number=${param.theater_number}"><img class="floatMoveL" src="resources/icons/chevron_left-24px.svg"></a>
	</c:if>
	<c:if test="${curPage != pageCount }">
	<a href="TheaterInfo.com.searchGenre.move?p=${curPage + 1}&theater_number=${param.theater_number}"><img class="floatMoveR" src="resources/icons/chevron_right-24px.svg"></a>
	</c:if>
	<button onclick="toGenreWrite()">작성</button>
</body>
</html>