<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="static/js/jquery-2.2.4.min.js"></script>
<link href="static/css/style.css" rel="stylesheet" type="text/css" media="all">
	<script src="static/layui/layui.js"></script>
	<script type="text/javascript">
		$(function () {
			$('.toggle').click(function(){
				$(this).children('i').toggleClass('fa-pencil');
				$('.form').animate({height: "toggle",'padding-top': 'toggle','padding-bottom': 'toggle',opacity: "toggle"}, "slow");
			});
			var newpass = $("input[name='lnewpassword']");
			var username;
			var password ;
			var newpassword;
			var num = $("input[name='num']").val();
			$("#submit").click(function () {
				 username = $("input[name='username']").val();
				 password = $("input[name='password']").val();
				 if(username == ""){
				 	layui.use('layer', function(){
						var layer = layui.layer;
						layer.alert("账号不能为空");
					});
				 }else if(password == ""){
				 	layui.use('layer', function(){
						var layer = layui.layer;
						layer.alert("密码不能为空");
					});
				 }else{
				 	var data = '{"bsAdminlogin":"'+username+'",' +
						'"bsAdminpass":"'+password+'"}';
					console.log(data);
					$.ajax({
						url:"bsAdmin/selectBybsAdminlogin",
						contentType:"application/json;charset=UTF-8",
						data:data,
						dataType:"json",
						type:"post",
						success:function (data) {
							console.log(data)
						   if(data >0){
						   	layui.use('layer', function(){
									var layer = layui.layer;
									layer.alert("登录成功");
								});
						   		setTimeout(function () { window.location = 'bsBooks/selectAll'; },
										2000);

						   }else{
								layui.use('layer', function(){
									var layer = layui.layer;
									layer.alert("用户名或密码错误，请重新输入");
								});
						   }
						},
						error:function () {
							layui.use('layer', function(){
								var layer = layui.layer;
								layer.alert("数据错误");
							});
						}
					});
				 }

				return false;
			});
			newpass.blur(function () {
				password = $("input[name='lpassword']").val();
				newpassword = newpass.val();
				if(password != newpassword){
					layui.use('layer', function(){
						var layer = layui.layer;
						layer.alert("请确保两次输入密码一致");
						return;
					});
				}
				});
			$("#submit1").click(function () {
				username =  $("input[name='loginname']").val();
				password = $("input[name='lpassword']").val();
				newpassword = newpass.val();
				num = $("input[name='num']").val();
				console.log(username);
				console.log(password);
				console.log(newpass);
				console.log(num);
				if(username == ""){
					alert("账号不能为空");
				}else if(password == ""){
					alert("密码不能为空");
				}else if(newpassword == ""){
					alert("请确认密码");
				}else{
					var data = '{"bsAdminlogin":"'+username+'",' +
						'"bsAdminpass":"'+password+'",' +
						'"bsAdminnum":"'+num+'"}';
					console.log(data);
					$.ajax({
						url:"bsAdmin/insertOne",
						contentType:"application/json;charset=UTF-8",
						data:data,
						dataType:"json",
						type:"post",
						success:function (data) {
							console.log(data)
						   if(data >0){
								 window.location = 'index.jsp';
						   }else{
								layui.use('layer', function(){
									var layer = layui.layer;
									layer.alert("该用户以存在");
								});
						   }
						},
						error:function () {
							layui.use('layer', function(){
								var layer = layui.layer;
								layer.alert("数据错误");
							});
						}
					});
				}
				return false;
			});
		});
	</script>
</head>
<body>

<div class="main">
	<div class="w3_login">
		<div class="w3_login_module">
			<div class="module form-module">
				<div class="toggle">
					<i class="fa fa-times"></i>
					<div class="tooltip">点击切换</div>
				</div>
				<div class="form" style="display: block;" class="layui-form" lay-filter="login">
					<h2>登录账号</h2>
					<form action="" method="post">
						<input type="text" name="username" placeholder="用户名">
						<input type="password" name="password" placeholder="密码">
						<input type="submit" id="submit" lay-filter="*" value="登录">
					</form>
				</div>
				<div class="form" style="display: none;">
					<h2>创建一个账号</h2>
					<form action="" method="post" class="layui-form" lay-filter="login">
						<input type="text" name="loginname" placeholder="账号">
						<input type="password" name="lpassword" placeholder="密码">
						<input type="password" name="lnewpassword" placeholder="再次输入">
						<input type="text" name="num" placeholder="职工编号">
						<input type="submit" id="submit1" value="注册">
					</form>
				</div>
				<div class="cta"><a href="">忘记密码?</a></div>
			</div>
		</div>
	</div>
</div>
</body></html>