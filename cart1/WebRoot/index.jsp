<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/style5.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/local.css">
<script type="text/javascript" src="js/jquery-1.9.0.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/jquery.cxselect.min.js"></script>

<script Language="JavaScript">
	function changedisplay() {
		//alert(document.all.testchb.display);
		if (document.all.c1.style.display == 'block') {
			document.all.c1.style.display = "none";

			document.all.btnchange.innerText = ' 显 示 ';
		} else {
			document.all.c1.style.display = "block";

			document.all.btnchange.innerText = ' 隐 藏 ';
		}
	}
</script>
</head>

<body>
	<form action="ShowCart" method="post">
		<button type="submit">菜单</button>
	</form>
	<form action="ShowOrder" method="post">
		<button type="submit">订单</button>
	</form>

	<!-- <p align="center" name="c1">
	<div class="radio">
		<label> <input type="radio" name="optionsRadios"
			id="optionsRadios1" value="option1" checked> 选项 1
		</label>
	</div>
	<div class="radio">
		<label> <input type="radio" name="optionsRadios"
			id="optionsRadios2" value="option2"> 选项 2 - 选择它将会取消选择选项 1
		</label>
	</div>
	 <input type="checkbox" name="c1" value="地址1" style="display:block">
	<outputText value="地址1" />
	<input type="checkbox" name="c2" style="display:block">
	<input type="checkbox" name="c3" style="display:block">
	<input type="button" value=" 隐 藏 " name="btnchange"
		onclick="changedisplay();">
	<br> 其中：display: none 使其隐藏;display: block 显示
	</p>
	 -->

</body>
</html>

