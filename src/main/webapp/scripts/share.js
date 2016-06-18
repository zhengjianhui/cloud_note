
// 查看分享笔记
// 预览功能
function findSearch(event) {

	//设置选中状态
	$("#search_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");

	// 重新定义选择
	$("#delete_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");



//	$("#can").load("alert/showShare.html");

	// 获取请求参数
	// var $li = $('#search_ul a.checked').parent();
	// var shareID = $li.data('shareId');
//	var shareID = $(this).data('shareId');
//	console.log(shareID);

	// 定义全局变量，用于判断ajax请求
	var num = event.data.num;

	var shareID = $(this).data('shareId');
	var noteID = $(this).data('noteID');

	var shareJson = {"shareID":shareID};
	var deleteJson = {"noteID":noteID}

	var shareUrl = "http://localhost:8080/cloud_note/share/load.do";
	var deeteUrl = "http://localhost:8080/cloud_note/note/load.do";


	// 发送ajax请求
	$.ajax({
		data:num == 1? shareJson : num == 2 ? deleteJson : deleteJson,
		dataType:"json",
		error:function() {
			altre('加载预览失败')
		},success:function(result) {
			if(result.status==0){
				// 切换显示区域
				$("#pc_part_3").hide();
				$("#pc_part_5").show();


//				$("#pc_part_5").show();
//				解析出标题和内容
				var title = num == 1 ? result.data.cn_share_title : num == 2 ? result.data.cn_note_title : '';

				var body = num == 1 ? result.data.cn_share_body : num == 2 ? result.data.cn_note_body : '';
				 //显示到预览区
				 $("#noput_note_title").html(title);

				 $("#noput_note_body").html(body);
//				 获取 data.cn_note_title 字段 写入笔记标题
//				$('#input_note_title').val(title);
//				// um 编辑器
//				um.setContent(body);
//				 showMsg(result.msg);
			}
		},
		type:"post",
		url:num == 1? shareUrl : num == 2 ? deeteUrl : deeteUrl
	});
}



// 为搜索添加回车事件 并监听键盘回车事件
function loadShareSearch(event) {

	if(event.keyCode == 13) {
		// 隐藏笔记 区
//		$("#pc_part_2").hide().hide();
		// 显示 分享区
//		$("#pc_part_6").show();

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
					if(notes.length > 0) {
						changeNoteList(6);
					} else {
						showMsg('没有对应记录!');
						return;
					}

					//清空原有搜索列表
					$("#search_ul").empty();
					//循环生成新搜索列表
					for(var i=0;i<notes.length;i++){
						//获取分享笔记的ID和标题
						var shareId = notes[i].cn_share_id;
						var title = notes[i].cn_share_title;
						var userID = notes[i].cn_user_id
//						console.log(noteID)

						//拼一个li
						var sli = '';
						sli+='<li class="online">';
						sli+='	<a>';
						sli+='		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> ';
						sli+= title;
						sli+='		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down" id="shareCollection"><i class="fa fa-star"></i></button>';
//						sli+='		<button type="button" class="btn btn-default btn-xs btn_delete but_share_delete title="删除"><i class="fa fa-times"></i></button>';
						sli+='	</a>';
						sli+='</li>';
						var $li = $(sli);
						$li.data("shareId",shareId);//绑定分享ID
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
