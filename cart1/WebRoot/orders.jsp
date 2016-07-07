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

<title>订餐记录</title>


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

</head>

<body>
	<div class="col-xs-10 type-flama">
		<div class="page-title">
			<h1>订餐记录</h1>
		</div>
		
		<div class="page-content">
			<div class="panel panel-default panel">
				<div class="panel-body">
					<table class="table" contenteditable="true">
						<thead>
							<tr>
								<th>订单号</th>
								<th>食品名称</th>
								<th>数量</th>
								<th>总价</th>
								<th>订餐时间</th>
								<th>送餐地址</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator id="orders" value="#request.orderList">
							<tr>
								<td>${orders.orderNo}</td>
								<td>${orders.foodName}</td>
								<td>${orders.amount}</td>
								<td>${orders.userNo}</td>
								<td>${orders.orderTime}</td>
								<td>${orders.address}</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>

			<div class="panel-group type-flama order-history accordion"></div>

		</div>
	</div>
</body>
</html>
