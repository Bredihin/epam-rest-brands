<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Brands</title>
</head>
<body>
	<h1>Brands</h1>

	<c:url var="addUrl" value="/brands/add" />
	<table style="border: 1px solid; width: 500px; text-align: center">
		<thead style="background: #fcf">
			<tr>
				<th>Brand name</th>
				<th>Show name</th>
				<th>Show Description</th>
				<th colspan="3"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${brands}" var="brand">
				<c:url var="editUrl" value="/brands/edit?id=${brand.brandId}" />
				<c:url var="deleteUrl"
					value="/brands/delete?id=${brand.brandId}" />
				<tr>
					<td><c:out value="${brand.brandName}" /></td>
					<c:forEach items="${brand.shows}" var="show">
						<c:url var="showInfo" value="/brands/show?id=${show.showId}" />
						<tr>
							<td></td>
							<td><a href="${showInfo}"><c:out
										value="${show.showName}" /></a></td>
							<td><c:out value="${show.showDescription}" /></td>
							<td><a href="${editUrl}">EditShow</a> <a href="${deleteUrl}">DeleteShow</a>
								<a href="${addUrl}">AddShow</a></td>
						</tr>
					</c:forEach>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:if test="${empty brands}">
 There are currently no brands in the list. <a href="${addUrl}">Add</a> a brand.
</c:if>

</body>
</html>

