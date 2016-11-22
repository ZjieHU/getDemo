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
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/unslider.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" />

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

#nav { 
	width:150px; 
	height: 400px; 
	border: 1px solid #D4CD49; 
	position:fixed;
	left:1000px;
	top:20% 
}

ul, ol { padding: 0;}
.banner { position: relative; overflow: auto; text-align: center;}
.banner li { list-style: none; }
.banner ul li { float: left; }
#b04 { width: 640px;}
#b04 .dots { position: absolute; left: 0; right: 0; bottom: 20px;}
#b04 .dots li 
{ 
    display: inline-block; 
    width: 10px; 
    height: 10px; 
    margin: 0 4px; 
    text-indent: -999em; 
    border: 2px solid #fff; 
    border-radius: 6px; 
    cursor: pointer; 
    opacity: .4; 
    -webkit-transition: background .5s, opacity .5s; 
    -moz-transition: background .5s, opacity .5s; 
    transition: background .5s, opacity .5s;
}
#b04 .dots li.active 
{
    background: #fff;
    opacity: 1;
}
#b04 .arrow { position: absolute; top: 200px;}
#b04 #al { left: 15px;}
#b04 #ar { right: 15px;}
</style>
</head>
<body onload="getInfo()">
	<script type="text/javascript">
		var info = "";
		var pic_id;
		var pic_id2;
		var display_pic;
		var localhost = "http://localhost";
		
		function getInfo() {
			var cookie = null;
			cookie = document.cookie.split(";");
			var count = cookie.length;
			for(i = 0; i < count; i++) {
				if(cookie[i].split("=")[0] == "cookie") {
					info = cookie[i].split("=")[1];
				}
			}
			
			url = window.location+"";
			$("#search_text").val(url.split("=")[1]);
			
			if(info != '') {
				$("#login").hide();
				$("#register").hide();
			}
		}
		
		function download(i) {
			$.post(localhost + ":8080/getdemo/DownloadDemo",
			{
				id : i,
				email : info
			},
			function(data,status) {

				if(data == 0) {
					alert("抱歉，您请成为会员，才能下载本站所有资源。");
				}else if(data == 1) {
					alert("抱歉，资源被移位，您请通知管理员。");
				}else {
					
					downloadFile(data);
				}
			});		
		}
		
		function PictureDivCreate(id,url) {
			if(url == null) {
				return;
			}
			if($("#display_pic"+id).text() == '查看图片') {
				$("#display_pic"+id).text("收起图片");
				if(id != display_pic)
					$("#display_pic"+display_pic).text("查看图片");
			}else if($("#display_pic"+id).text() == '收起图片'){
				hideit(id);
				return;
			}
			
			$("#pic_id2"+pic_id2).css("display","none");
			$("#pic_id"+pic_id).css("display","none");
			$("#b04").remove();
			pic_id = id;
			pic_id2 = id;
			display_pic = id;
			var urls = url.split(";");
			var head = "<div class='banner' id='b04' style='margin: auto; '><ul>";
			var end = "</ul><a href='javascript:void(0);' class='unslider-arrow04 prev'><img class='arrow' id='al' src='img/arrowl.png' alt='prev' width='20' height='35'></a><a href='javascript:void(0);' class='unslider-arrow04 next'><img class='arrow' id='ar' src='img/arrowr.png' alt='next' width='20' height='37'></a></div>";

			for(i = 0; i < urls.length - 1; i++) {
				head += "<li><img src='";
				head += urls[i];
				head += "' alt='' width='640' height='480' ></li>";
			}
			//var div1 = "<div class='banner' id='b04' style='margin: auto; '><ul><li><img src='http://assets.jq22.com/plugin/2016-10-26-16-10-02.png' alt='' width='640' height='480' ></li><li><img src='http://assets.jq22.com/plugin/2016-10-26-16-10-02.png' alt='' width='640' height='480' ></li></ul><a href='javascript:void(0);' class='unslider-arrow04 prev'><img class='arrow' id='al' src='img/arrowl.png' alt='prev' width='20' height='35'></a><a href='javascript:void(0);' class='unslider-arrow04 next'><img class='arrow' id='ar' src='img/arrowr.png' alt='next' width='20' height='37'></a></div>";
			var div1 = head + end;
			
			$("#id"+id).append(div1);
			$("#pic_id2"+pic_id2).css("display","inline");
			$("#pic_id"+pic_id).css("display","inline");
			
			var unslider04 = $("#b04").unslider({
		        dots: true
		    }),
		    data04 = unslider04.data('unslider');
		    
		    $('.unslider-arrow04').click(function() {
		        var fn = this.className.split(' ')[1];
		        data04[fn]();
		    });
		}
		
		/*
		*
		*搜索功能
		**/
		function search(data) {
			if(data.length <= 0) {
				return;
			}
			window.location = localhost + ":8080/getdemo?keyword="+data;
			
		}
		
		$(document).ready(function () {
			$("#search").click(function () {
				data = $("#search_text").val();
				search(data);
			});
		});
		
		$(document).keyup(function(e){

		 var curKey = e.which; 
		 var isFocus=$("#search_text").is(":focus"); 
		  if(curKey==13 && isFocus){
				
			data = $("#search_text").val();
				
			search(data);
		  }
		
		});
		
	</script>
	<!-- <div id="nav">
	
	</div> -->
	<div style="width: 100%; height: 77px; border-bottom: #ccc solid 1px;">
		<div style="font-family:'黑体'; margin-top:15px; margin-left:70px; font-size:30px; font-weight:bold; width:100px; float:left;">
			GetDemo
		</div>
		<div style="width:500px; float:left; margin-top:12px;margin-left:10px;">
			<div style="padding: 10px 10px 10px;">
				<form class="bs-example bs-example-form" role="form">
					<div class="row">
						<div class="col-lg-6">
							<div class="input-group">
								<input id="search_text" type="text" style="width:400px;" class="form-control">
								<span class="input-group-btn">
									<button id="search" class="btn btn-default" type="button">
										搜索
									</button>
								</span>
							</div><!-- /input-group -->
						</div><!-- /.col-lg-6 -->
					</div><!-- /.row -->
				</form>
			</div>
		</div>
		<div id="right_head" style="margin-top:23px;">
			<button id="login" type="button" class="btn btn-default" style="font-family:"
				YaHei"; onclick="window.open('login.jsp')">登录</button>

			<button id="register" type="button" class="btn btn-default"
				style="margin-left: 20px; background: #6CBD50; color: #FFF;"
				style="font-family:" YaHei"; onclick="window.open('register.jsp')">注册</button>

			<button type="button" class="btn btn-default"
				style="margin-left: 20px; background: #6CBD50; color: #FFF;"
				style="font-family:" YaHei"; onclick="window.open('recharge.jsp')">充值</button>

		</div>
	</div>
	<%
		List<Demo> list = (List<Demo>) request.getAttribute("list");
		if(list != null)
		for (Demo p : list) {
	%>
	<div
		style="width: 650px; margin-top: 30px; margin-left: 180px; border-bottom: #CCC solid 1px;">
		<div style=" color: #000;" >
			<span style="font-family:'黑体'; font-size: 16px;">
				<%=p.getName()%> —— <%=p.getType()%>
			</span>
		</div>
		<div style="margin-top: 10px; width: 650px;  color: #666;">
			<span style="font-family:'黑体'; font-size: 14px;">
				<%=p.getDescribe()%>
			</span>
		</div>
		<div style="margin-top: 10px; width: 400px; float: left; color: #666;">
			<div style="font-family: '黑体'; font-size: 13px; float:left;width: 100px;">
				下载：<%=p.getDownCount()%>次 
			</div>
			<div align="right" style="cursor: pointer; float: left; font-family: '黑体'; font-weight:bold; font-size: 13px; color:#666;width: 100px;"
				 id="download<%=p.getDownName()%>" onclick="download(<%=p.getDownName()%>);">立即下载
			</div>
			<div style="cursor: pointer; color: #666; float: left;width: 90px; font-family: '黑体'; font-weight:bold; font-size: 13px;" 
				 onclick="PictureDivCreate('<%=p.getDownName()%>','<%=p.getPrictureurl()%>');">
				 &nbsp;&nbsp;&nbsp;<span id="display_pic<%=p.getDownName()%>">查看图片</span>
			</div>
		</div>
		<div align="right" style="margin-top: 10px; margin-bottom:10px; color:#666;">
			<span style="font-family: :'黑体'; font-size: 13px;">
				<%=p.getAuthor()%>&nbsp;@&nbsp;<%=p.getUpdateTime()%>
			</span>
		</div>
		<div onclick="hideit('<%=p.getDownName()%>')" id="pic_id2<%=p.getDownName()%>"
		 style=" cursor: pointer; display:none; margin-left: 590px; font-family: '黑体'; font-weight:bold; font-size: 13px;">
			收起图片
		</div>
		<div id="id<%=p.getDownName()%>" style="width: 100%; background-color: black; margin-top:10px; margin-bottom:10px;">
			
		</div>
		<div onclick="hideit('<%=p.getDownName()%>')" id="pic_id<%=p.getDownName()%>"
		 style="cursor: pointer;  display:none; margin-left: 590px; font-family: '黑体'; font-weight:bold; font-size: 13px;">
			收起图片
		</div>
		<script type="text/javascript">
			function hideit(id) {
				$("#display_pic"+id).text("查看图片");
				$("#pic_id"+id).css("display","none");
				$("#pic_id2"+id).css("display","none");
				$("#b04").remove();
			}
		</script>
	</div>
	<%
		}
	%>
	<div align="center" style="width: 650px; margin-top: 30px; margin-left: 180px;">
		<ul class="pagination">
			<li><a href="#">&laquo;</a></li>
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>
	<hr>
	<div style="width:100%; margin-right: auto; margin-left: auto; height:20px;
	width:400px; vertical-align:middle;	line-height:20px;">
	&copy; 2016 GetDemo.com.cn
	</div>
	<script type="text/javascript">
	function downloadFile(url) { 
		  
        window.location = url;
    }
	</script>
</body>
</html>