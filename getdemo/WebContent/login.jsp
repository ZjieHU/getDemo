<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<title>登录</title>
</head>
<body>
	<div id="thediv">
		<div id="ipt">
			<div id="title" style="align:center; margin-left:10px;font-size:30px;">
			GetDemo.com.cn
		</div>
			<br>
			<span>用户名邮箱</span>
			<br>
			<form action="Login" method="get">
			<input type="text" name="email" class="form-control"/><br>
			<span>密码</span><br>
			<input type="password" name="pwd" class="form-control"/><br>
		 	<input type="submit" value="登录" style="width:250px;color:#fff; background:#6CBD50" class="btn btn-default" />
			</form>
		</div>
		<div style="margin-top:60px; background-color: transparent;">
			<button type="button" onclick="linktoregister();" style="width:320px; color:#666; background-color: transparent;" class="btn btn-default">创建账号</button>
		</div>
	</div>
	<script type="text/javascript">
		localhost = "http://localhost";
		function linktoregister() {
			window.location.href = localhost+":8080/getdemo/register.jsp";
		}
	</script>
</body>
</html>