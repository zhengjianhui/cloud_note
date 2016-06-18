// 收藏界面

// 处理收藏与book页面的切换
function findCollectionList(num) {



  // 控制笔记本切换状态
  var v = $(this).attr("value");
//  console.log(v);


  if(v == '6') {
    $("#BookFind").hide();
    $("#CollectionFind").show();

    // 修改状态
    $(this).attr("value","5");
  }
  if(v == '5') {
    $("#BookFind").show();
    $("#CollectionFind").hide();

    // 修改状态
    $(this).attr("value","6");
  }
  loadUserBooks(v);
}


// 点击收藏
function shareCollection(event) {
	var $li = null;
	var num = event.data.num;
	
	if(num == 2) {
		$li = $('#note_ul a.checked').parent();
	} else {
		$li = $('#search_ul a.checked').parent();
	}
	
	// 获取请求参数
	var shareID = $li.data('shareId');
	var userID = getCookie('userID');
	
	var favors = $li.data('favors');
	var bookID = $('#ccc option:selected').attr('value');
	
	var data = null;
	var data2 = null;
	if(num == 2) {
		var stutasType = "2";
		data = {"shareID":shareID,"userID":userID,"favors":favors,"bookID":bookID,"stutasType":stutasType}
		console.log(stutasType);
	} else {
		var stutasType = "1";
		data2 = {"shareID":shareID,"userID":userID,"favors":null,"bookID":bookID, "stutasType":stutasType}
	}
	
	
	$("#can").empty();
	$(".opacity_bg").hide();


	// 验证保存是否为空
	if('none' == bookID) {
		showMsg('笔记本不能为空');
		return;
	}

	

	// 发送ajax请求
	$.ajax({data:num == 2? data : data2 ,
		dataType:"json",
		error:function() {
			showMsg("操作失败了！");
		},
		success:function(result) {
			// 为2 时判断取消
			if(num == 2) {
				$li.remove();
			}
			showMsg(result.msg);
		},
		type:"post",
		url:"http://localhost:8080/cloud_note/favors/insert.do"
	});
	



}
