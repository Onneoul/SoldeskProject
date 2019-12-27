<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td> 배우 : 
				<c:forEach var="p" items="${ti.theater_person }">
					<tr>
						<td>
							${p.person_name }<button onclick="deleteCasting(${ti.theater_number}, ${p.person_number})">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</td>
			<td>
				<button onclick="toPersonSearch(${ti.theater_number});">검색</button>
			</td>
		</tr>
		<tr>
			<td>
				공연장 : ${ti.theater_stage.stage_name } <button onclick="toStageSearch(${ti.theater_number});">검색</button>
			</td>
		</tr>
		<tr>
			<td> 장르 : 
				<c:forEach var="g" items="${ti.theater_genre }">
					<tr>
						<td>
							${g.genre_name }<button onclick="deleteTheaterGenre(${g.genre_number})">삭제</button>
						</td>
					</tr>
				</c:forEach>
				<button onclick="toGenreSearch(${ti.theater_number});">검색</button>
			</td>
		</tr>
		<tr>
			<td> 주최 단체 : 
				<c:forEach var="o" items="${ti.theater_organization }">
					<tr>
						<td>
							${o.group_name }<button onclick="deleteTheaterGroup(${o.group_number})">삭제</button>
						</td>
					</tr>
				</c:forEach>
				<button onclick="toGroupSearch(${ti.theater_number});">검색</button>
			</td>
		</tr>
		<tr>
			<td>
				공연장 : ${ti.theater_stage.stage_name }<button onclick="deleteTheaterStage(${ti.theater_stage.staeg_number })">삭제</button> 
				<button onclick="toStageSearch(${ti.theater_stage.stage_number })">검색</button>
			</td>
		</tr>
		<tr>
			<td>
				<a href="TheaterInfo.com.theaterDetail.Basic?theater_number=${ti.theater_number }"><button>확인</button></a>
			</td>
		</tr>
	</table>
</body>
</html>