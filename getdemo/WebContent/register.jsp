<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body{ 
  margin:0px; 
  padding:0px; 
  background:#eee;
} 
#thediv{
  width:320px;
  height:260px;
  background:#fff;
  position:absolute;
  left:50%;
  top:50%;
  margin-left:-180px;
  margin-top:-150px;
}
#ipt{
	width:250px;
	height:210px;
	background:#fff;
	margin-left:30px;
}
div span button {font-family:'微软雅黑';color:#666; font-size:18px;}
</style>
<title>注册</title>
</head>
<body>
	<div id="thediv">
		<div id="ipt">
			<div id="title" align="center" style="align:center; margin-left:10px;font-size:30px;font-family: '黑体';">
			创建邮箱账号
			</div>
			<br>
			<span>邮箱</span>
			<br>
			<input type="text" id="email" class="form-control"/><br>
			<span>密码</span><br>
			<input type="password" id="pwd" class="form-control"/><br>
		 	<input type="submit" id="sub" value="注册" style="width:250px;color:#fff; background:#6CBD50" class="btn btn-default" />
		</div>
		<div style="margin-top:60px; background-color: transparent;">
			<button onclick="linktogetdemo();" type="button" style="width:320px; color:#666; background-color: transparent;" class="btn btn-default">进入首页</button>
		</div>
	</div>
	<script type="text/javascript">
		localhost = "http://localhost";
		$(document).ready(function(){
			$("#sub").click(function() {
				var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
				
				if($("#pwd").val().length == 0 || $("#email").val().length == 0) {
					alert("请输入用户名和密码!");
				} else if(!myreg.test($("#email").val()) || $("#pwd").val().length < 6 || $("#pwd").val().length > 18) {
					alert("您的输入不合规范!");
					return;
				} else {
					$.post(localhost+":8080/getdemo/Register",{
					email : $("#email").val(),
					pwd : $("#pwd").val()
					},function(data,status) {
						if(data == 0) {
							alert('用户已存在');
						}else if(data == 1) {
							alert('注册成功');
							window.location.href = localhost+":8080/getdemo";
						}
					});
				}
			});
		});
		function linktogetdemo() {
			window.location.href = localhost+":8080/getdemo";
		}
	</script>
</body>
</html>