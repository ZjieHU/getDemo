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
	text-align: center;
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
	margin-top: 10px;
	margin-left: 60px;
	float: left;
}
</style>
</head>
<body>
	<div style="width: 100%; height: 77px; border-bottom: #ccc solid 1px;">
		<div style="font-family:'YaHei'; font-size:30px; font-weight:bold; width:100px; float:left;">
			GetDemo
		</div>
		<div style="width:500px; float:left; margin-left:80px;">
			<div style="padding: 10px 10px 10px;">
				<form class="bs-example bs-example-form" role="form">
					<div class="row">
						<div class="col-lg-6">
							<div class="input-group">
								<input type="text" style="width:400px;" class="form-control">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										搜索
									</button>
								</span>
							</div><!-- /input-group -->
						</div><!-- /.col-lg-6 -->
					</div><!-- /.row -->
				</form>
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
	<hr>
	<div style="width:100%; margin-right: auto; margin-left: auto; height:20px;
	width:400px; vertical-align:middle;	line-height:20px;">
	&copy; 2016 GetDemo.com.cn
	</div>
</body>
</html>