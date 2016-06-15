//注入口
$(function(){
	// 绑定登入事件
	$("#login").click(login);
	// 绑定注册相应事件
	$("#regist_button").click(regist);
});


// 处理注册请求
function regist() {
	// show(); 显示 hide();隐藏
	
	// 清空提示
	$('#warning_1').html('');
	$('#warning_2').html('');
	$('#warning_3').html('');
	
	// 隐藏提示
	$('#warning_1').hide();
	$('#warning_2').hide();
	$('#warning_3').hide();

	// 获取参数
	var username = $('#regist_username').val();
	var nickname = $('#nickname').val();
	var password = $('#regist_password').val();
	var final_password = $('#final_password').val();
	
	// 打桩
//	console.log(username);
	
	// 验证
	var check = true;
	if(username == "") {
		$('#warning_1').html('用户名不能为空').show();
		check = false;
	}
	
	// 判断密码不为空且长度大于6
	if(password == '') {
		$('#warning_2').html('密码不能为空').show();
		check = false;
	} else if(password.length < 6) {
		$('#warning_2').html('密码长度大于6位').show();
		check = false;
	}
	
	// 判断验证密码与密码一致
	if(final_password != password) {
		$('#warning_3').html('密码不一致').show();
		check = false;
	} else if(final_password == '') {
		$('#warning_3').html('确认密码不能为空').show();
		check = false;
	}
	
	// 发送ajax请求
	if(check) {
		$.ajax({
				data:{"username":username,"password":password,"nickname":nickname},
				dataType:"json",
				error:function() {
					alert("抱歉！发生错了！");
				},
				success:function(result) {
					if(result.status == 0) {
						//提示成功
						alert(result.msg);
						//切换到登录界面
						$("#back").click();//触发单击操作
					} else if(result.status == 1) {
						$('#warning_1').html(result.msg).show();
					}
				},
				type:"post",
				url:"http://localhost:8080/cloud_note/user/regist.do",
		});
	}
	
}



// 处理登入请求
function  login() {
	// 清空提示
	$('#count_span').html('');
	$('#passwore_span').html('');
	
	// 获取请求参数
	var username = $('#count').val().trim();
	var password = $('#password').val().trim();
	// 打桩
//	console.log(name + " : " + password)
	
	// 验证输入格式
	var check = true;
	if(username == '') {
		$('#count_span').html('账号不能为空');
		check = false;
	} 
	if(password == '') {
		$('#password_span').html('密码不能为空');
		check = false;
	}
	
	// 验证通过则发送ajax请求
	if(check) {
		$.ajax({
			url:"http://localhost:8080/cloud_note/user/login.do",
			type:"post",
			data:{"username":username,"password":password},
			dataType:"json",
			success: function(result) {
				if(result.status == 0) {
					// 将id 保存到 cookie中
					var userID = result.data;
					
					// 打桩
//					alert(userID);
					
					// key “userID” value userID 有效性 2H
					addCookie("userID",userID,2);
					
					// 登入成功跳转到主页
					window.location.href = "edit.html";
				}
				if(result.status == 1) {
					// 用户名错误
					$('#count_span').html(result.msg);
				}
				if(result.status == 2) {
					// 密码错误
					$('#password_span').html(result.msg);
				}
			},
			error:function() {
				alert('抱歉！出错了！');
			}
		});
	}
}