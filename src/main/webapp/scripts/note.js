
// 成功提示框
// 淡入淡出效果
function showMsg(msg) {
//	 console.log(msg);
	$("#can").load("alert/msg.html",{"msg":msg},function() {
		 $('#msg_alter').html(msg);
//		 console.log(msg);
		 $("#msg_alter").hide(1300,function() {
			 $("#showMsg").hide();
		 });
		 

//	show(2000,function(){
//		 $("#showMsg").

	});
	
  
   }

//click(data,fn)中的data其实是json对象,取的时候,只能通过当前的事件源来取,
//data是默认放在event中的,所以这里的data是eventdata,引用的时候也使用event.data.name
// 切换显示区域
function show (event) {
//	console.log(event.data.num);
	changeNoteList(event.data.num);	
} 

//切换显示笔记列表区
function changeNoteList(index){
	$("#pc_part_6").hide();//搜索结果列表
	$("#pc_part_2").hide();//全部笔记列表
	$("#pc_part_4").hide();//回收站列表
	$("#pc_part_7").hide();//收藏列表
	$("#pc_part_8").hide();//活动列表
	//控制某个列表显示
	$("#pc_part_" + index).show();
}




// 移动笔记
function sureMoveNote() {
	// option:selected 获取选中的 option
	// attr('value') 获取指定属性名的值
	var bookID = $('#moveSelect option:selected').attr('value');
//  	console.log(bookID);

	// 判断是否有选中的 笔记本 none 为默认选项（未选中）
	if('none' == bookID) {
		$('#cam').empty();
		$(".opacity_bg").hide();
		alert("请选择笔记本！");
		return ;
	}

	// 获取当前li
	var $li = $('#note_ul a.checked').parent();
	// console.log($li);
	// 获取笔记id
	var noteID = $li.data('noteId');
//	console.log(noteID);

	// 获取当前笔记本 id
	var nowBookID = $('#book_ul a.checked').parent().data('bookId');
	// console.log(nowBookID);

	// 检查是否是原来的笔记本
	if (nowBookID == bookID) {
		$('#cam').empty();
		$(".opacity_bg").hide();
		alert("不能移动到原来的笔记本！");
		return ;
	}

	// 发送ajax请求
	$.ajax({data:{"noteID":noteID,"bookID":bookID},
					dataType:"json",
					error:function() {

					},
					success:function(result) {
						
						if(result.status == 0) {
							$li.remove();
							// 关闭对话框
							$("#can").empty();
							// 隐藏灰色效果
							$(".opacity_bg").hide();

							showMsg(result.msg);

						}
					},
					type:"post",
					url:"http://localhost:8080/cloud_note/note/move.do"
	});



}



// 笔记分享
// 测试用sql
// UPDATE cn_note set cn_note_type_id = '1' where cn_note_type_id = '2';
// DELETE from cn_share where cn_note_id='09648d9e-f684-4845-b047-1ece4907dcc9';
function sureShareNote() {
	// 获取发送参数
	var $li = $("#note_ul a.checked").parent();
	var noteID = $li.data("noteId");
	
	var noteTypeID = $li.data("noteTypeId");
	var noteTitle = $li.find('a').text();
	console.log(noteTitle);
//	console.log(noteID);

	// 发送ajax请求
	$.ajax({
		data:{"noteID":noteID,"noteTypeID":noteTypeID},
		dataType:"json",
		error:function() {
			alert("分享笔记失败");
		},
		success:function(result) {
			if(result.status == 0) {
				// TODO 隐藏分享
//				var $titles = $li.find("button[title='分享']");
//				$titles.hide();
//				console.log($titles);
				
				// 分享图标 2 时为以分享
				// $li.data("noteTypeId","1"); 修改状态避免重复点击 出现状态不变的bug
				if(noteTypeID == 2) {
					$li.data("noteTypeId","1");
					var sli='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> ';
					sli+= noteTitle;
					sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
					
					$li.find("a").html(sli);
					
				} else {
					$li.data("noteTypeId","2");
					var sli='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> ';
					sli+= noteTitle;
					sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
					sli+='		<i class="fa fa-sitemap"></i>';
					$li.find("a").html(sli);
				}
				
				showMsg(result.msg);

			} else if(result.status == 2) {
				showMsg(result.msg);
			}
		},
		type:"post",
		url:"http://localhost:8080/cloud_note/share/share.do"
		});


}


// 笔记的删除
function sureDeleteNote() {

//	console.log(1);

	// 获取li 元素
	var $li = $("#note_ul a.checked").parent();
	var $noteID = $li.data("noteId");

	$("#can").empty();
	$(".opacity_bg").hide();

	// 发送ajax请求
	$.ajax({
		data:{"noteID":$noteID},
		dataType:"json",
		error:function() {
			alert("删除异常")
		},
		success:function(result) {
			// 删除li
			$li.remove();
			// 清空标题
			$("#input_note_title").val("");
			// 清空内容
			um.setContent("");
			showMsg(result.msg);
		},
		type:"post",
		url:"http://localhost:8080/cloud_note/note/delete.do"
		});


}


//笔记菜单处理
function noteMenu(){
	// 点击菜单按钮,弹出菜单
	// <button type="button" class="btn btn-default btn-xs btn_position btn_slide_down">
	$("#note_ul").on("click",".btn_slide_down",function() {

		// 设置选中效果
		$("#note_ul a").removeClass("checked");
		$(this).parent().addClass("checked");

		// 隐藏所有下拉菜单
		// <div class="note_menu" tabindex="-1">';
		$("#note_ul .note_menu").hide();

		// 选中点击笔记的菜单 元素
		var $menu = $(this).parents("li")
				.find(".note_menu");

		// 以下拉动画特效显示 ，时间为1s
		$menu.slideDown(500);

		//取消body的click冒泡
		// 不取消，则会触发li 的单击 与body的单击
		return false;
	});
	//点击整个页面,隐藏菜单
	$("body").click(function(){
		//隐藏所有菜单
		$("#note_ul .note_menu").hide();
	});
};



// 新建笔记处理
function sureAddNote() {
	// 获取请求参数
	// 笔记名
	var noteName = $("#input_note").val();
	// 笔记本id
	var bookID = $("#book_ul a.checked").parent().data("bookId");
	// 用户id
	var userID = getCookie("userID");

	// 防止空笔记名
	if("" == noteName) {
		$('#can').empty();
		$(".opacity_bg").hide();
		alert('笔记名不能为空');
		return;
	}

	// 发送ajax请求
	$.ajax({
			data:{"userID":userID,"noteName":noteName,"bookID":bookID},
			dataType:"json",
			error:function() {
				alert("创建笔记失败");
			},
			success:function(result) {
				if(result.status == 0) {
					// 关闭对话框
					$("#can").empty();
					// 隐藏灰色效果
					$(".opacity_bg").hide();

					// 将新建笔记挂到 笔记列表中
					createNoteLi(result.noteID, noteName);
					$('#input_note_title').val(noteName);


					showMsg(result.msg);

				}
			},
			type:"post",
			url:"http://localhost:8080/cloud_note/note/add.do"
			});
}




//保存笔记按钮的处理
function updateNote(){
	// 为保存添加单击事件
//	$("#save_note").click(function() {
		// 获取请求参数
		// checked <a  class='checked'> parent(); 以jquery返回指定元素的父元素
		var $li =
			$("#note_ul a.checked").parent();
		var $noteID = $li.data("noteId");

		// 获取笔记id 标题 内容
//		var $noteID = $('#input_note_title').data("noteId");
//		console.log($noteID);

		var $noteTitle = $('#input_note_title').val().trim();
		var noteBody = um.getContent();

		// 如果没有noteID 代表没有选择 向用户发出错误提示
		if($li.length == 0){
			alert("请选择要保存的笔记");
			return;
		}
		// 防止笔记下拉 选中后点击保存按钮
		if("" == $noteTitle) {
			alert("标题不能为空");
			return;
	  }
		// 发送ajax请求
		$.ajax({
			url:"http://localhost:8080/cloud_note/note/update.do",
			type:"post",
			data:{"noteID":$noteID,
				"noteTitle":$noteTitle,
				"noteBody":noteBody},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					//更新列表中li的标题信息
					var sli='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> ';
					sli+= $noteTitle;
					sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';

					$li.find("a").html(sli);

//					// 获取 note_ul 下的li列表
//					var $lis = $("#note_ul li");
//					for(var i = 0; i < $lis.length; i++) {
//						var li = $lis[i];
//						// 转换成jquery 对象
//						var $li = $(li);
//
//						var $id =$li.data("noteId");
//						if($noteID == $id) {
//							// 打桩
////							console.log($id);
////							console.log($noteID);
//							//获取选中li中的<a>,将内容替换成sli
//							$li.find("a").html(sli);
//						}
//					}

					//提示保存成功
					showMsg(result.msg);
				}
			},
			error:function(){
				alert("保存笔记异常");
			}
		});
//	});

}

// 处理笔记内容 与 标题
function loadNote() {
	// 为 note_ul 的子元素 li 添加（on函数配合ajax动态添加）单击事件
//	$('#note_ul').on('click','li',function() {
		// 获取请求参数
		var noteID = $(this).data("noteId");
		console.log($('note_ul .checked'));
		// 为选中的笔记增加样式（当前笔记）
		// 触发单击事件时 移除所有同级元素的class 为单击元素增加 class
		$("#note_ul a").removeClass("checked");
		$(this).find("a").addClass("checked");

		// 打桩
		// alert(noteID);

		// 发送ajax请求
		$.ajax({
			url:'http://localhost:8080/cloud_note/note/load.do',
			type:'post',
			data:{'noteID':noteID},
			dataType:'json',
			success:function(result) {

				if(result.status == 0) {

					// 清除 "#note_ul" 下原有的li 避免重复 empty() 删除所有子节点

					// 获取 data.cn_note_title 字段 写入笔记标题
					$('#input_note_title').val(result.data.cn_note_title);
					// um 编辑器
					um.setContent(result.data.cn_note_body);

					$('#input_note_title').data("noteId", result.data.cn_note_id);
				}
			},
			error:function() {
				showMsg('抱歉！出错了！');
			}
		});

//	});

}





// 处理笔记
function loadBookNotes() {
	
	// 点击笔记本切换到笔记区
	changeNoteList(2);
	
	
	// 点击笔记本加载笔记列表
	// 为li 增加单击事件，使用父元素选择子元素
	// ajax 异步处理处理完ajax后，直接调用该函数，这时候回调还没执行，li并没有生成
	// 使用动态绑定解决on函数  xxx.on("事件类型"，子元素选择器,fn)
//	$('#book_ul').on('click','li',
//		function() {

			$('#book_ul a').removeClass('checked');
			$(this).find('a').addClass('checked');

			// 获取点击笔记本的ID值
			var bookId = $(this).data("bookId");

			// 发送ajax请求
			$.ajax({
				url:'http://localhost:8080/cloud_note/note/loadnotes.do',
				type:'post',
				data:{'bookId':bookId},
				dataType:'json',
				success:function(result) {

					if(result.status == 0) {

						// 清除 "#note_ul" 下原有的li 避免重复 empty() 删除所有子节点
						$("#note_ul").empty();

						// 获取list集合
						var notes = result.data;

						// 遍历
						for(var i = 0; i < notes.length; i++) {
							var noteId = notes[i].cn_note_id;
							var noteTitle = notes[i].cn_note_title;
							var noteTypeID = notes[i].cn_note_type_id;
//							console.log(noteTypeID);
							//创建笔记列表li
							createNoteLi(noteId,noteTitle,noteTypeID);

						}
					}
				},
				error:function() {
					showMsg('抱歉！出错了！');
				}
			});
//		});
}

// 处理笔记的li
//创建一个笔记li列表项
function createNoteLi(noteId,noteTitle,noteTypeID) {
	
	//拼一个笔记li元素
	var sli = '';
	sli+='<li>';
	sli+='	<a>';
	sli+='		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> ';
	sli+= noteTitle;
	sli+='		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	// 判断是否分享
	if(noteTypeID == 2) {
		sli+='		<i class="fa fa-sitemap"></i>';
	} 
	sli+='	</a>';
	sli+='	<div class="note_menu" tabindex="-1">';
	sli+='		<dl>';
	sli+='			<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	sli+='			<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	sli+='			<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	sli+='		</dl>';
	sli+='	</div>';
	sli+='</li>';
	var $li = $(sli);
	$li.data("noteId",noteId);//绑定笔记ID
	$li.data("noteTypeId",noteTypeID);//绑定笔记ID
	//添加到笔记列表ul中
	$("#note_ul").append($li);
};
