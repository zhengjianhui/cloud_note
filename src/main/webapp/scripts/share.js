
// 查看分享笔记
function findSearch() {
	//设置选中状态
	$("#search_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");

	$("#can").load("alert/showShare.html");
	
	// 获取请求参数
	// var $li = $('#search_ul a.checked').parent();
	// var shareID = $li.data('shareId');
	var shareID = $(this).data('shareId');
//	console.log(shareID);

	// 发送ajax请求
	$.ajax({
		data:{"shareID":shareID},
		dataType:"json",
		error:function() {
			altre('加载预览失败')
		},success:function(result) {
			if(result.status==0){

				$("#pc_part_5").show();
//				解析出标题和内容
				var title =
					result.data.cn_share_title;
				var body =
					result.data.cn_share_body;
				 //显示到预览区
				 $("#noput_note_title").html(title);
				
				 $("#noput_note_body").html(body);
//				 获取 data.cn_note_title 字段 写入笔记标题
//				$('#input_note_title').val(title);
//				// um 编辑器
//				um.setContent(body);
				 showMsg(result.msg);
			}
		},
		type:"post",
		url:"http://localhost:8080/cloud_note/share/load.do"
	});



}



// 为搜索添加回车事件 并监听键盘回车事件
function loadShareSearch(event) {

	if(event.keyCode == 13) {
		// 隐藏笔记 区
		$("#pc_part_2").hide().hide();
		// 显示 分享区
		$("#pc_part_6").show();

		// 获取连接参数
		var noteTitle = $('#search_note').val();
		console.log(noteTitle);
		// 发送ajax 请求
		$.ajax({
			data:{"noteTitle":noteTitle},
			dataType:"json",
			error:function() {
				alert('查询失败');
			},
			success:function(result) {
				if(result.status == 0) {
					// contacts-list 获取ul
					var notes = result.data;
					//清空原有搜索列表
					$("#search_ul").empty();
					//循环生成新搜索列表
					for(var i=0;i<notes.length;i++){
						//获取分享笔记的ID和标题
						var id = notes[i].cn_share_id;
						var title = notes[i].cn_share_title;
						//拼一个li
						var sli = '';
						sli+='<li class="online">';
						sli+='	<a>';
						sli+='		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> ';
						sli+= title;
						sli+='		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-star"></i></button>';
//						sli+='		<button type="button" class="btn btn-default btn-xs btn_delete but_share_delete title="删除"><i class="fa fa-times"></i></button>';
						sli+='	</a>';
						sli+='</li>';
						var $li = $(sli);
						$li.data("shareId",id);//绑定分享ID
						//添加到搜索结果列表ul中
						$("#search_ul").append($li);
					}

				} if(result.status == 1) {
					
					showMsg(result.msg);
					
				}
			},
			type:"post",
			url:"http://localhost:8080/cloud_note/share/search.do"
			});

	}

}
