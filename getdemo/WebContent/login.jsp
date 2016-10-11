<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
	<form action="Login" method="get">

		GetDemo.com.cn邮箱<input type="text" name="email" /><br> 密码<input
			type="text" name="pwd" /> <input type="submit" value="登录" />
	</form>
</body>

<script>
	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}

	var email = GetQueryString("email");

	if (email != null) {

		alert(email + "  已经注册，请直接登录！");

	}
</script>
</html>