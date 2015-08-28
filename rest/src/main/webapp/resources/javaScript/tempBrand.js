jQuery(document)
		.ready(
				function() {

					jQuery("#brandTable")
							.jqGrid(
									{
										url : "/rest/brands/json",
										datatype : "json",
										jsonReader : {
											repeatitems : false,
											id : "ref"
										},
										colNames : [ 'Brand ID', 'Brand Name' ],
										colModel : [ {
											name : 'brandId',
											index : 'brandId',
											width : 50
										}, {
											name : 'brandName',
											index : 'brandName',
											width : 475,
											editable : true
										} ],
										rowNum : 5,
										rowList : [ 5, 10, 20 ],
										height : 200,
										pager : "#brandPagingDiv",
										sortname : 'brandId',
										viewrecords : true,
										caption : "Brands",
										onSelectRow : function(ids) {
											if (ids == null) {
												ids = 0;
												if (jQuery("#showTable")
														.jqGrid('getGridParam',
																'records') > 0) {
													jQuery("#showTable")
															.jqGrid(
																	'setGridParam',
																	{
																		url : "shows/?id="
																				+ ids,
																		page : 1
																	});
													jQuery("#showTable")
															.jqGrid(
																	'setCaption',
																	"Shows: "
																			+ ids)
															.trigger(
																	'reloadGrid');
												}
											} else {
												jQuery("#showTable").jqGrid(
														'setGridParam',
														{
															url : "shows/?id="
																	+ ids,
															page : 1
														});
												jQuery("#showTable").jqGrid(
														'setCaption',
														"Shows: " + ids)
														.trigger('reloadGrid');
											}
										}
									});

					jQuery("#brandTable").jqGrid(
							'navGrid',
							'#brandPagingDiv',
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
									rp_ge.url = 'delete?brandId='
											+ $('#brandTable').getCell(
													postdata, 'brandId');
								}
							});
					jQuery("#brandTable").jqGrid(
							'inlineNav',
							'#brandPagingDiv',
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
										url : "add",
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
								editParams : {
									keys : true,
									url : "edit",
									extraparam : {
										brandId : function() {
											var sel_id = $('#brandTable')
													.jqGrid('getGridParam',
															'selrow');
											var value = $('#brandTable')
													.jqGrid('getCell', sel_id,
															'brandId');
											return value;
										}
									},

									mtype : "POST"
								}

							}

					);
					jQuery("#showTable")
							.jqGrid(
									{
										height : 100,
										url : 'shows/?id=0',
										datatype : "json",
										colNames : [ 'Show ID', 'Brand',
												'Show Name', 'Show Description' ],
										colModel : [ {
											name : 'showId',
											index : 'showId',
											width : 50
										}, {
											name : 'showBrand',
											index : 'showBrand',
											width : 200,
											editable : true
										}, {
											name : 'showName',
											index : 'showName',
											width : 200,
											editable : true
										}, {
											name : 'showDescription',
											index : 'showDescription',
											width : 250,
											editable : true
										} ],
										rowNum : 5,
										rowList : [ 5, 10, 20 ],
										height : 200,
										pager : '#showPagingDiv',
										sortname : 'showId',
										viewrecords : true,
										subGrid : true,
										caption : "shows",
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
																url : "shows/episodes/?id="
																		+ row_id,
																datatype : "json",
																colNames : [
																		'Episode Id',
																		'Episode name',
																		'Episode Description',
																		'Episode Date' ],
																colModel : [
																		{
																			name : "episodeId",
																			index : "episodeId",
																			width : 50,
																			key : true
																		},
																		{
																			name : "episodeName",
																			index : "episodeName",
																			width : 150,
																			key : true
																		},
																		{
																			name : "episodeDescription",
																			index : "episodeDescription",
																			width : 150,
																			key : true
																		},
																		{
																			name : "episodeDate",
																			index : "episodeDate",
																			width : 150,
																			key : true
																		} ],
																rowNum : 20,
																pager : pager_id,
																sortname : 'episodeId',
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
																url : "shows/episodes/edit"
															},
															{
																url : "shows/episodes/add"
															},
															{
																url : "shows/episodes/"
															},
															{
																onclickSubmit : function(
																		rp_ge,
																		postdata) {
																	rp_ge.url = 'shows/episodes/delete?episodeId='
																			+ $(
																					"#"
																							+ subgrid_table_id)
																					.getCell(
																							postdata,
																							'episodeId');
																}
															})
										}

									})
							.navGrid(
									'#showPagingDiv',
									{
										edit : false,
										add : false,
										del : true,
										search : false,
									},
									{},
									{},
									{
										onclickSubmit : function(rp_ge,
												postdata) {
											rp_ge.url = 'shows/delete?showId='
													+ $('#showTable').getCell(
															postdata, 'showId');
										}
									});
					jQuery("#showTable").jqGrid(
							'inlineNav',
							'#showPagingDiv',
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
										url : "shows/add",
										extraparam : {},

									}
								},
								editParams : {
									keys : true,
									url : "shows/edit",
									extraparam : {
										showId : function() {
											var sel_id = $('#showTable')
													.jqGrid('getGridParam',
															'selrow');
											var value = $('#showTable')
													.jqGrid('getCell', sel_id,
															'showId');
											return value;
										}
									},

									mtype : "POST"
								}

							}

					);

					jQuery("#ms1").click(
							function() {
								var s;
								s = jQuery("#showTable").jqGrid('getGridParam',
										'selarrrow');
								alert(s);
							});
				});
