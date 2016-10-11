<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.getdemo.bean.Demo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="Keywords" content="Demo,GetDemo,Java" />
<meta name="Description" content="找Demo就上GetDemo" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>找Demo就上GetDemo</title>
<style>
bode {
	background: #FFF;
}

h2 {
	margin-left: 20px;
	float: left;
	width: 150px;
}

#search_div {
	padding-top: 20px;
	margin-left: 0px;
}

#right_head {
	margin-left: 60px;
	float: left;
}
</style>
</head>
<body>
	<div style="width: 100%; height: 77px; border-bottom: #ccc solid 1px;">
		<h2 style="font-family:"YaHei"; font-weight:bold;">GetDemo</h2>
		<div id="search_div">
			<div class="col-lg-6">
				<div class="input-group">
					<form action="GetDemo" method="get">
						<input type="text" class="form-control" name="keyword"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button"
								style="font-family:"YaHei";">搜索</button>
						</span>
					</form>
				</div>
			</div>
		</div>
		<div id="right_head">
			<button type="button" class="btn btn-default" style="font-family:"
				YaHei"; onclick="window.open('login.jsp')">登录</button>

			<button type="button" class="btn btn-default"
				style="margin-left: 20px; background: #6CBD50; color: #FFF;"
				style="font-family:" YaHei"; onclick="window.open('register.jsp')">注册</button>

			<button type="button" class="btn btn-default"
				style="margin-left: 20px; background: #6CBD50; color: #FFF;"
				style="font-family:" YaHei"; onclick="window.open('recharge.jsp')">充值</button>

		</div>
	</div>
	<%
		List<Demo> list = (List<Demo>) request.getAttribute("list");
		for (Demo p : list) {
	%>
	<div
		style="width: 650px; margin-top: 30px; margin-left: 180px; border-bottom: #CCC solid 1px;">
		<div>
			<span style="font-family:"YaHei"; color: #000; font-size: 16px;">
				<%=p.getName()%> —— <%=p.getType()%>
			</span>
		</div>
		<div style="margin-top: 20px; width: 650px;">
			<span style="font-family:"YaHei";; color: #666; font-size: 14px;">
				<%=p.getDescribe()%></span>
		</div>
		<div style="margin-top: 20px; width: 400px; float: left;">
			<span style="font-family: :"YaHei"; color: #666; font-size: 8px;">
				下载：<%=p.getDownCount()%>次 <a href="/demo/<%=p.getDownName()%>"
				target="_blank"><%=p.getDownOK()%></a>
			</span>
		</div>
		<div style="margin-top: 20px;">
			<span style="font-family: :"YaHei"; color: #666; font-size: 8px;">
				<%=p.getAuthor()%>@<%=p.getUpdateTime()%>
			</span>
		</div>
	</div>
	<%
		}
	%>

	<div style="width: 650px; margin-top: 30px; margin-left: 180px;">
		<ul class="pagination">
			<%=request.getAttribute("bar")%>
		</ul>
	</div>
	<hr />
	&copy; 2016 GetDemo.com.cn
</body>
</html>