jQuery(document).ready(function() {

		jQuery("#brandTable").jqGrid({
			url : "/rest/brands/json",
			datatype : "json",
			jsonReader : {
				repeatitems : false,
				id : "ref"
			},
			colNames : [ 'Brand ID' ,'Brand Name' ],
			colModel : [{
				name:'brandId',
				index:'brandId',
				width:50
			}, {
				name : 'brandName',
				index : 'brandName',
				width : 475,
				editable : true
			}],
			rowNum : 5,
			rowList : [ 5, 10, 20 ],
			height : 200,
			pager : "#brandPagingDiv",
			sortname: 'brandId',
			viewrecords : true,
			caption : "Brands",
			onSelectRow: function(ids) { 
				if(ids == null) 
				{ 
					ids=0;
					if(jQuery("#showTable").jqGrid('getGridParam','records') >0 ) 
					{
						jQuery("#showTable").jqGrid('setGridParam',
								{
							url:"shows/?id="+ids,
							page:1
							});
						jQuery("#showTable").jqGrid('setCaption',"Shows: "+ids) .trigger('reloadGrid');
						}
					}
				else { 
					jQuery("#showTable").jqGrid('setGridParam',{
						url:"shows/?id="+ids,
						page:1});
					jQuery("#showTable").jqGrid('setCaption',"Shows: "+ids).trigger('reloadGrid');
					}
				}
			});
			    
		 	jQuery("#brandTable").jqGrid('navGrid', '#brandPagingDiv', {edit : true,add : true,del : true,search : true},	 {url: 'rest/brands/edit'}, {url: 'rest/brands/add'});
		 	jQuery("#showTable").jqGrid({
		 		height: 100,
		 		url:'shows/?id=0',
		 		datatype: "json",
		 		colNames:['Show ID','Show Name', 'Show Description'],
		 		colModel:[ 
		 		    {
		 		    name:'showId',
		 		    index:'showId',
		 		    width:50		 		
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
		 		rowNum:5,
		 		rowList:[5,10,20],
		 		height : 200,
		 		pager: '#showPagingDiv',
		 		sortname: 'showId',
		 		viewrecords: true,
		 		subGrid: true,
		 		caption:"shows",
		 		subGridOptions: {
			    	"plusicon" : "ui-icon-triangle-1-e",
			    	"minusicon" : "ui-icon-triangle-1-s",
			    	"openicon" : "ui-icon-arrowreturn-1-e",
			    	"reloadOnExpand" : false, 
			    	"selectOnExpand" : true
			    },
			    subGridRowExpanded: function(subgrid_id, row_id) {
			    	var subgrid_table_id, pager_id;
			    		subgrid_table_id = subgrid_id+"_t";
			    		pager_id = "p_"+subgrid_table_id; 
			    		$("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
			   			jQuery("#"+subgrid_table_id).jqGrid({
			    			url:"shows/episodes/?id="+row_id,
			    			datatype: "json",
			    			colNames: ['Episode Id','Episode name','Episode Description','Episode Date'], 
			    			colModel: [ {name:"episodeId",index:"episodeId",width:50,key:true} ,
			    			            {name:"episodeName",index:"episodeName",width:150,key:true},
			    			            {name:"episodeDescription",index:"episodeDescription",width:150,key:true},
			    			            {name:"episodeDate",index:"episodeDate",width:150,key:true}],
			    			rowNum:20,
			    			pager: pager_id,
			    			sortname: 'episodeId',
			    			height: '100%' 
			    		});
			    		jQuery("#"+subgrid_table_id).jqGrid('navGrid',"#"+pager_id,{edit:true,add:true,del:true})
			    		} 
			    
			}).navGrid('#showPagingDiv',{add:true,edit:true,del:true}); 
		 	jQuery("#ms1").click( function() { 
		 		var s; s = jQuery("#showTable").jqGrid('getGridParam','selarrrow'); 
		 		alert(s); 
		 	});
	});
