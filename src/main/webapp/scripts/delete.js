
// 处理笔记的还原
function deleteReplay(noteID,bookID) {
	$("#can").empty();
	$(".opacity_bg").hide();

	console.log(noteID);
	console.log(bookID);

	if('none' == bookID) {
		alert("请选择笔记本！");
		return ;
	}

	// 判断状态
	var flag = false;

	$.ajax({data:{"noteID":noteID,"bookID":bookID},
		dataType:"json",
		error:function() {
			showMsg('抱歉!出错了!');
		},
		success:function(result) {
			if(result.status == 0) {
				showMsg(result.msg);
				flag = true;
			}
		},
		type:"post",
		url:"http://localhost:8080/cloud_note/delete/deleteReplay.do"
		});
	return flag;
}



// 处理删除业务
function deleteByID(noteID) {

	$("#can").empty();
	$(".opacity_bg").hide();

//  // console.log(1);
//  $('#delete_ul a').removeClass('checked');
//  $(this).find('a').addClass('checked');
//
//  // 获取li 上两级元素
//  var $li = $(this).parent().parent();

  // 发送ajax 请求

  // 用于判断ajax 状态
	 var flag = false;
  $.ajax({
	  	data:{"noteID":noteID},
	  	dataType:"json",
	  	error:function() {
	  		showMsg('删除失败了');
	  	},
	  	success:function(result) {
	        if(result.status == 0) {
	            showMsg(result.msg);
	            // 修改变量 用于判断删除状态
	            flag = true;
	            // return 错误，在ajax中return function收不到参数
//	            return '1';
	        }
	  	},
	  	type:"post",
	  	url:"http://localhost:8080/cloud_note/delete/deleteByID.do"
	  	});

  		// 返回ajax 状态 true 表示删除成功
  		return true;
}


// 处理回收站笔记的加载
function findDeleteList(event) {

  // 切换回收站显示
  // console.log(event.data.num);
  changeNoteList(event.data.num);

  // 清空回收站 避免多次点击添加多余li元素
  $("#delete_ul").empty();

  // 获取用户ID
  var userID = getCookie('userID');
  // console.log(userID);

  // 发送ajax请求
  $.ajax({
	  	data:{"userID":userID},
	  	dataType:"json",
	  	error:function() {
        showMsg('发生错误了!');
	  	},
	  	success:function(result) {
        if(result.status == 0) {

          var notes = result.data;
          // 输出结果
          for (var i = 0; i < notes.length; i++) {
            var noteID = notes[i].cn_note_id;
            // console.log(noteID);
            var noteTitle = notes[i].cn_note_title;

            var sli = '';
            sli += '<li class="disable"><a> <i class="fa fa-file-text-o"';
            sli += '   title="online" rel="tooltip-bottom"></i>';
            sli += noteTitle;
            sli += '   <button type="button"'
            sli += '      class="btn btn-default btn-xs btn_position btn_delete" id="alertDelete">'
            sli += '      <i class="fa fa-times"></i>'
            sli += '    </button>'
            sli += '    <button type="button"'
            sli += '      class="btn btn-default btn-xs btn_position_2 btn_replay" id="deleteReplayBook">'
            sli += '      <i class="fa fa-reply"></i>'
            sli += '    </button>'
            sli += '</a></li>'
            // 转换jquery 对象
            $li = $(sli);
            $li.data('noteID',noteID);

            $('#delete_ul').append($li);

          }
        }
	  	},
	  	type:"post",
	  	url:"http://localhost:8080/cloud_note/delete/deleteList.do"
	  	});
}
