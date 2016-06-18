

// 弹出收藏按钮
function alertShareCollectionWindow() {
	
	// 切换book_ul 同步区域book 显示区域
    $("#BookFind").hide();
    $("#CollectionFind").show();
    // 修改状态
    $('#like_button').attr("value","5");
    loadUserBooks(6);
	
	$("#can").load("alert/alert_share.html",function() {
		var $books = $('#book_ul li');

		// 循环
		for (var i = 0; i < $books.length; i++) {
			// 转换jquery对象
			var $li = $($books[i]);
			var bookType = $li.data.bookType;
			var bookName = $li.text();
			var bookID = $li.data('bookId');

			// console.log(bookID);
			// console.log(bookName);

			// 拼接一个option
			var option = "<option value='" + bookID + "'>" + bookName
					+ "</option>";

			$('#ccc').append(option);
		}
	});
	$(".opacity_bg").show();
	
}


// 恢复删除的笔记
function alertReplayWindow() {
	// 修改状态
	loadUserBooks(5);
	
	// 获取li 上两级元素
	var $li = $(this).parent().parent();

	$('#delete_ul a').removeClass('checked');
	$li.find('a').addClass('checked');

	// 获取请求参数
	var noteID = $li.data('noteID');
	// 添加点击事件
	// 加载页面后执行
	$("#can").load("alert/alert_replay.html",function() {
		
				// 获取所有book
				var $books = $('#book_ul li');

				// 循环
				for (var i = 0; i < $books.length; i++) {
					// 转换jquery对象
					var $li = $($books[i]);
					var bookName = $li.text();
					var bookID = $li.data('bookId');

					// 拼接一个option
					var option = "<option value='" + bookID + "'>" + bookName
							+ "</option>";

					$('#replaySelect').append(option);
					
				}
				// 处理恢复
				$('#can').on('click', '#deleteReplayNoteByBook', function() {
					
					// 获取选中的option 的value 属性值
					
					var bookID = $('#replaySelect option:selected').attr('value');
					// 删除

					// this指向混乱 在deleteReplay(noteID,bookID); 方法中通过#delete_ul a.checked处理
//					$li.remove(); 
//					deleteReplay(noteID,bookID,$li);
					deleteReplay(noteID,bookID);
				});
	});
	$(".opacity_bg").show();
}

// 弹出彻底删除笔记本
function alertDeleteRollbackWindow() {
	// 获取li 上两级元素
	var $li = $(this).parent().parent();

	$('#delete_ul a').removeClass('checked');
	$li.find('a').addClass('checked');

//	console.log($li);
	// 获取请求参数
	var noteID = $li.data('noteID');
//	console.log(noteID);

	$("#can").load("alert/alert_delete_rollback.html", function() {
		$(".opacity_bg").show();

		// 处理删除
		$('#can').on('click', '#delete_li_btn', function() {

			// 接收删除状态
			var flag = deleteByID(noteID);
//			console.log(deleteByID(noteID));


		});

	});

}

// 弹出移动 笔记本 对话框
function alertMoveNoteWindow() {
	// 添加点击事件
	$("#can").load(
			"alert/alert_move.html",
			function() { // 加载页面后执行
				// 获取所有book
				var $books = $('#book_ul li');

				// 循环
				for (var i = 0; i < $books.length; i++) {
					// 转换jquery对象
					var $li = $($books[i]);
					var bookName = $li.text();
					var bookID = $li.data('bookId');

					// console.log(bookID);
					// console.log(bookName);

					// 拼接一个option
					var option = "<option value='" + bookID + "'>" + bookName
							+ "</option>";

					$('#moveSelect').append(option);
				}

			});
	$(".opacity_bg").show();
}

// 弹出修改 笔记本名 对话框
function alertRenameWindow() {
	$("#can").load("alert/alert_rename.html");
	$(".opacity_bg").show();
}

// 弹出删除笔记 对话框
function alertConfirmDeleteNoteWindow() {
	$("#can").load("alert/alert_delete_note.html");
	$(".opacity_bg").show();
}

// 弹出添加笔记本 对话框
function alertAddBookWindow() {
	$("#can").load("alert/alert_notebook.html");
	$(".opacity_bg").show();
}

// 弹出添加收藏笔记本 对话框
function alertAddCollectionBookWindow() {
	$("#can").load("alert/alert_collectionbook.html");
	$(".opacity_bg").show();
}


// 弹出添加笔记 对话框
function alertAddNoteWindow() {
	// 验证是否选中 book
	var $li = $("#book_ul a.checked").parent();

	if ($li.length == 0) {
		alert("请选择笔记本");
		return;
	}

	// 显示元素
	$("#can").load("alert/alert_note.html");
	// 显示灰色背景
	$(".opacity_bg").show();
}

// 关闭对话框，使用所有
function closeAlertWindow() {
	// 清空对话框 将上面方法 添加的 本地html 元素清空
	$("#can").empty();
	$(".opacity_bg").hide(); // 隐藏灰色效果
}
