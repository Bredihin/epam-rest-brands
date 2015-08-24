<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show</title>
</head>
<body>
	<h1>Show</h1>

	<table style="border: 1px solid; width: 500px; text-align: center">
		<thead style="background: #fcf">
			<tr>
				<th>Show Name</th>
				<th>Episode Name</th>
				<th>Episode description</th>
				<th>Episode date</th>
				<th colspan="3"></th>
			</tr>
		</thead>
		<tbody>

			<c:url var="editUrl" value="/shows/edit?id=${show.showId}" />
			<c:url var="deleteUrl" value="/shows/delete?id=${show.showId}" />
			<tr>
				<td><c:out value="${show.showName}" /></td>
				<c:forEach items="${show.episodes}" var="episode">
					<tr>
						<td></td>
						<td><c:out value="${episode.episodeName}" /></td>
						<td><c:out value="${episode.episodeDescription}" /></td>
						<td><c:out value="${episode.episodeDate}" /></td>
					<td><a href="${editUrl}">Edit</a></td>
				<td><a href="${deleteUrl}">Delete</a></td>
				<td><a href="${addUrl}">Add</a></td>
					</tr>
				
				</c:forEach>
				<c:if test="${empty show.episodes}">
					 There are currently no episodes in the list. <a href="${addUrl}">Add</a> a episode.
				</c:if>
				
			</tr>

		</tbody>
	</table>



</body>
</html>
