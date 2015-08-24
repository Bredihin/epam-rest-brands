jQuery(document).ready(function() {

		jQuery("#projectTable").jqGrid({
			url : "/rest/users/json",
			datatype : "json",
			jsonReader : {
				repeatitems : false,
				id : "ref"
			},
			colNames : [ 'First Name', 'Last Name', 'UniqueNumber' ],
			colModel : [ {
				name : 'userFirstName',
				index : 'userFirstName',
				width : 150
			}, {
				name : 'userLastName',
				index : 'userLastName',
				width : 150
			}, {
				name : 'userUniqueIdentity',
				index : 'userUniqueIdentity',
				width : 150
			} ],
			rowNum : 5,
			rowList : [ 5, 10, 20 ],
			height : 200,
			pager : "#pagingDiv",
			viewrecords : true,
			caption : "Users"
		});
	});