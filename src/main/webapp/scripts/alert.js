

// 弹出移动 笔记本 对话框
function alertMoveNoteWindow() {
	// 添加点击事件
	$("#can").load("alert/alert_move.html",
			function() { // 加载页面后执行
				// 获取所有book
				var $books = $('#book_ul li');

				// 循环
				for (var i = 0; i < $books.length; i++) {
					// 转换jquery对象
					var $li = $($books[i]);
					var bookName = $li.text();
					var bookID = $li.data('bookId');

//					console.log(bookID);
//					console.log(bookName);

					// 拼接一个option
					var option = "<option value='" + bookID +"'>"
							+bookName+"</option>";

					$('#moveSelect').append(option);
				}

			}
	);
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
	// 点击 “+” 按钮弹出创建笔记本对话框  加载本地html文件
	$("#can").load("alert/alert_notebook.html");

	// 显示出对话框灰色背景
	// <div class="opacity_bg" style='display:none'></div> 点击添加后 页面变灰效果
	$(".opacity_bg").show();

}

// 弹出添加笔记 对话框
function alertAddNoteWindow() {
	// 验证是否选中 book
	var $li = $("#book_ul a.checked").parent();

	if($li.length == 0) {
		alert("请选择笔记本");
		return;
	}

	// 显示元素
	$("#can").load("alert/alert_note.html");
	// 显示灰色背景
	$(".opacity_bg").show();
}


// 关闭对话框，使用所有
function closeAlertWindow(){
	// 清空对话框 将上面方法 添加的 本地html 元素清空
	$("#can").empty();
	$(".opacity_bg").hide(); // 隐藏灰色效果
}
