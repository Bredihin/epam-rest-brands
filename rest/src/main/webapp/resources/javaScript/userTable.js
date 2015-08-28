jQuery(document)
		.ready(
				function() {

					jQuery("#userTable")
							.jqGrid(
									{
										url : "/rest/users/json",
										datatype : "json",
										jsonReader : {
											repeatitems : false,
											id : "ref"
										},
										colNames : [ 'User ID', 'First Name',
												'Last Name', 'UniqueNumber' ],
										colModel : [ {
											name : 'userId',
											index : 'userId',
											width : 55
										}, {
											name : 'userFirstName',
											index : 'userFirstName',
											width : 150,
											editable : true
										}, {
											name : 'userLastName',
											index : 'userLastName',
											width : 150,
											editable : true
										}, {
											name : 'userUniqueIdentity',
											index : 'userUniqueIdentity',
											width : 150,
											editable : true
										} ],
										rowNum : 5,
										rowList : [ 5, 10, 20 ],
										height : 200,
										pager : "#userPagingDiv",
										viewrecords : true,
										subGrid : true,
										caption : "Users",
										subGridOptions : {
											"plusicon" : "ui-icon-triangle-1-e",
											"minusicon" : "ui-icon-triangle-1-s",
											"openicon" : "ui-icon-arrowreturn-1-e",
											"reloadOnExpand" : false,
											"selectOnExpand" : true
										},
										subGridRowExpanded : function(
												subgrid_id, row_id) {
											var subgrid_table_id, pager_id;
											subgrid_table_id = subgrid_id
													+ "_t";
								
											pager_id = "p_" + subgrid_table_id;
											$("#" + subgrid_id)
													.html(
															"<table id='"
																	+ subgrid_table_id
																	+ "' class='scroll'></table><div id='"
																	+ pager_id
																	+ "' class='scroll'></div>");
											jQuery("#" + subgrid_table_id)
													.jqGrid(
															{
																url : "users/subscriptions/?id="
																		+ row_id,
																datatype : "json",
																colNames : [
																		'showId',
																		'showName' ],
																colModel : [
																		{
																			name : "showId",
																			index : "showId",
																			width : 180,
																			key : true
																		},
																		{
																			name : "showName",
																			index : "showName",
																			width : 180,
																			key : true
																		} ],
																rowNum : 20,
																pager : pager_id,
																height : '100%'
															});
											jQuery("#" + subgrid_table_id)
													.jqGrid(
															'navGrid',
															"#" + pager_id,
															{
																edit : true,
																add : true,
																del : true
															},
															{
																url : 'users/subscriptions/edit'
															},
															{
																url : 'users/subscriptions/add'
															},
															{
																onclickSubmit : function(rp_ge, postdata) {
																	rp_ge.url = 'users/subscriptions/delete?subscriptionShowId='
																			+ $("#"+subgrid_table_id).getCell(postdata,
																					'subscriptionShowId');
																}
															})
										}

									});
					jQuery("#userTable").jqGrid(
							'navGrid',
							'#userPagingDiv',
							{
								edit : false,
								add : false,
								del : true,
								search : false,
							},
							{},
							{},
							{
								onclickSubmit : function(rp_ge, postdata) {
									rp_ge.url = 'users/delete?userId='
											+ $('#userTable').getCell(postdata,
													'userId');
								}
							});
					jQuery("#userTable").jqGrid(
							'inlineNav',
							'#userPagingDiv',
							{
								edit : true,
								editicon : "ui-icon-pencil",
								add : true,
								addicon : "ui-icon-plus",
								del : true,
								delicon : "ui-icon-backet",
								search : true,
								addParams : {
									useDefaultValues : true,
									addRowParams : {
										keys : true,
										url : "users/add",
										extraparam : {},
										successfunc : function(val) {
											if (val.responceText != "") {
												alert(val.responceText);
												$(this).jqGrid('setGridParam',
														{
															datatype : 'json'
														})
														.trigger('reloadGrid');
											}
										}
									}
								},
								editParams:{
									keys:true,
									url:"users/edit",
									extraparam:{
										 userId: function() {
		                                        var sel_id = $('#userTable').jqGrid('getGridParam', 'selrow');
		                                        var value = $('#userTable').jqGrid('getCell', sel_id, 'userId');
		                                        return value;
									}},
									
									mtype: "POST"
								}
								
								
							}

					);

				});
