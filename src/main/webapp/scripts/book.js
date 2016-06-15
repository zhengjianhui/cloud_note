// 创建笔记本
function sureAddBook() {
	// 获取请求参数
	var bookName = $('#input_notebook').val();
	// 获取用户的id
	var userID = getCookie('userID');

	console.log(bookName);

	// 发送ajax请求
	$.ajax({
		url : "http://localhost:8080/cloud_note/book/add.do",
		type : "post",
		dataType : "json",
		data : {
			"bookName" : bookName,
			"userID" : userID
		},
		success : function(result) {
			if (result.status == 0) {
				// 关闭对话框
				$("#can").empty();
				// 隐藏灰色效果
				$(".opacity_bg").hide();
				createBookLi(result.bookID, bookName);
				alert(result.msg);
			}
		},
		error : function() {
			$("#can").empty();
			$(".opacity_bg").hide(); // 隐藏灰色效果
			alert("创建笔记本异常")
		}
	});
}

// 加载用户笔记本
function loadUserBooks() {
	// 发送ajax 请求
	$.ajax({
		url : "http://localhost:8080/cloud_note/book/loadbooks.do",
		type : "post",
		data : {
			"userID" : userID
		},
		dataType : "json",
		success : function(result) {
			// 打桩
			// console.log(result.data[0].cn_notebook_name);

			// 遍历输出result.data
			if (result.status == 0) {
				var books = result.data;// 笔记本集合
				// 循环生成笔记本列表
				for (var i = 0; i < books.length; i++) {
					var bookId = books[i].cn_notebook_id;
					var bookName = books[i].cn_notebook_name;
					// 创建笔记本列表li
					createBookLi(bookId, bookName);
				}
			}
		},
		error : function() {
			alert("抱歉~！出错了！！")
		}
	});

}

// 将数据绑定到li元素上
function createBookLi(bookId, bookName) {
	// 拼一个li字符串
	// <i></i> 必须双标签使用，一般用来做标签
	var sli = '<li class="online">';
	sli += '	<a>';
	sli += '		<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>';
	sli += bookName;
	sli += '	</a>';
	sli += '</li>';
	var $li = $(sli);// 将sli字符串转成jQuery对象

	// data 给元素绑定属性
	// 取出时 $("bookId") 返回value
	// 详情参考 http://www.w3school.com.cn/jquery/data_jquery_data.asp
	$li.data("bookId", bookId);// 将bookId绑定在li元素上

	// 添加到笔记本列表ul中
	$("#book_ul").append($li);
};

// 处理笔记本双击事件
function rename() {
	// console.log(1);
	// 获取请求参数
	var bookName = $('#input_notebook_rename').val();

	var $li = $('#book_ul a.checked').parent();
	var bookID = $li.data("bookId");

	if ("" == bookName) {
		$('#can').empty();
		$(".opacity_bg").hide();
		alert('笔记本名不能为空');
	}
	// console.log(bookID);
	// console.log(bookName);
	// 发送ajax请求
	$.ajax({
		data : {
			"bookName" : bookName,
			"bookID" : bookID
		},
		dataType : "json",
		error : function() {

		},
		success : function(result) {
			if (result.status == 0) {
				$('#can').empty();
				$(".opacity_bg").hide();
				alert(result.msg);

				$li.find('a').html(
						'<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>'
								+ bookName);
			}
		},
		type : "post",
		url : "http://localhost:8080/cloud_note/book/rename.do"
	});
}
