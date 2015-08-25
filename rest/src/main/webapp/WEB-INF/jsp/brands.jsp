<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Brands</title>

<script type='text/javascript'
	src='http://code.jquery.com/jquery-1.6.2.js'></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css"
	href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css">
<script type='text/javascript'
	src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
<script type='text/javascript'
	src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"></script>
<style type='text/css'>
</style>
<script type='text/javascript' src="<spring:url value="/resources/brandTable.js"/>"></script>
<link rel="stylesheet" type="text/css" media="screen"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/base/jquery.ui.base.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/redmond/jquery-ui.css" />
</head>
<body>

	<table id="brandTable"></table>
	<div id="brandPagingDiv"></div>
	<br/>
	<table id="showTable"></table>
	<div id="showPagingDiv"></div>
</body>
</html>
