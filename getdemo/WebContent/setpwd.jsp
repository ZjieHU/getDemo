<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设置密码</title>
</head>
<body>
	<form action="SetPWD" method="get">
		GetDemo.com.cn 邮箱隐藏<input type="hidden" name="email" value="设置"
			id="email" /><br> 密码<input type="text" name="pwd" /> <input
			type="submit" value="确定" />
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

	window.onload = function() {
		document.getElementById("email").value = GetQueryString("email");
	}
</script>
</html>