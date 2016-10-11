<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传Demo</title>
</head>
<body>
	<form action="UpdateDemo" method="get">
		类型<input type="text" name="type" /><br> <br> 名称<input
			type="text" name="name" /><br> <br> 功能<input type="text"
			name="function" /><br> <br>详细描述<input type="text"
			name="describe" /><br> <br>下载量<input type="text"
			name="downcount" /><br> <br>作者<input type="text"
			name="author" /><br> <br> <input type="submit" value="上传" />
	</form>
</body>
</html>