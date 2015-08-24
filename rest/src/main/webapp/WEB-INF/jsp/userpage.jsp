<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>

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

<script type='text/javascript'>
	jQuery(document).ready(function() {

		jQuery("#userTable").jqGrid({
			url : "/rest/users/json",
			datatype : "json",
			jsonReader : {
				repeatitems : false,
				id : "ref"
			},
			colNames : [ 'User ID' ,'First Name', 'Last Name', 'UniqueNumber' ],
			colModel : [{
				name:'userId',
				index:'userId',
				width:55
			}, {
				name : 'userFirstName',
				index : 'userFirstName',
				width : 150,
				editable : true
			}, {
				name : 'userLastName',
				index : 'userLastName',
				width : 150,
				editable: true
			}, {
				name : 'userUniqueIdentity',
				index : 'userUniqueIdentity',
				width : 150,
				editable: true
			}],
			rowNum : 5,
			rowList : [ 5, 10, 20 ],
			height : 200,
			pager : "#userPagingDiv",
			viewrecords : true,
			caption : "Users"
		});
		 jQuery("#userTable").jqGrid('navGrid', '#userPagingDiv', {
             edit : true,
             add : true,
             del : true,
             search : true
         },{url: 'rest/users/edit'},{url: 'rest/users/add'});
 
	});

</script>




<script type="text/javascript">
 
function addRow() {
 
 // Get the currently selected row
    jQuery("#userTable").jqGrid('editGridRow','new',
      {  url: "/rest/users/add", 
     editData: {
       },
       recreateForm: true,
       beforeShowForm: function(form) {
       },
    closeAfterAdd: true,
    reloadAfterSubmit:false,
    afterSubmit : function(response, postdata) 
    { 
           var result = eval('(' + response.responseText + ')');
     var errors = "";
      
           if (result.success == false) {
      for (var i = 0; i < result.message.length; i++) {
       errors +=  result.message[i] + "
";
      }
           }  else {
        	   jQuery("#dialog").text('Entry has been added successfully');
        	   jQuery("#dialog").dialog( 
        { title: 'Success',
         modal: true,
         buttons: {"Ok": function()  {
          jq(this).dialog("close");} 
         }
        });
                 }
        // only used for adding new records
        var new_id = null;
         
     return [result.success, errors, new_id];
    }
      });
 
}
</script>

<link rel="stylesheet" type="text/css" media="screen"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/base/jquery.ui.base.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/redmond/jquery-ui.css" />
</head>
<body>

	<%-- <c:url var="addUrl" value="/main/users/add" />
	<table style="border: 1px solid; width: 500px; text-align: center">
		<thead style="background: #fcf">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th colspan="3"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<c:url var="editUrl" value="/main/users/edit?id=${user.userId}" />
				<c:url var="deleteUrl" value="/main/users/delete?id=${user.userId}" />
				<tr>
					<td><c:out value="${user.userFirstName}" /></td>
					<td><c:out value="${user.userLastName}" /></td>
					<td><a href="${editUrl}">Edit</a></td>
					<td><a href="${deleteUrl}">Delete</a></td>
					<td><a href="${addUrl}">Add</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:if test="${empty users}">
		 There are currently no users in the list. <a href="${addUrl}">Add</a> a user.
	</c:if> --%>
	<table id="userTable"></table>
	<div id="userPagingDiv"></div>
</body>
</html>
