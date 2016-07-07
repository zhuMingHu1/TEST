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

<title>登录成功</title>


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

<script>
	function deleteOrder(param) {
		document.getElementById("od").action = "DeleteOrder.action?orderNo="
				+ param;
		document.getElementById("od").submit();
	}
</script>

<script>
	function chooseAddr() {
		//alert(document.all.testchb.display);
		if (document.all.address.style.display == 'block') {
			document.all.address.style.display = "none";
		} else {
			document.all.address.style.display = "block";
		}
	}
</script>

<style>
.center {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	width: 600px;
	height: auto;
	border: 0px;
	overflow: hidden;
}
</style>

</head>

<body onload="editAddr.action">
	<div class="container">
		<header>
			<!-- 应该有个判断是否登录 -->
			<s:if test="#session.userName != null">
				<h5 style="float:right;">
					Welcome,
					<s:property value="#session.userName" />
					&emsp;<a href="logout.action">退出</a>
				</h5>
			</s:if>
			<s:else>
				<h5>
					未登录，请<a href="index.jsp">登录</a>
				</h5>
			</s:else>
		</header>
		<div class="page-header">
			<div class="text-success">
				<h1 algin="center">
					我的信息<small><em>用户信息管理</em></small>
				</h1>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span2"></div>
					<div class="span7"></div>
					<div class="span3">
						<div id="order-widget"
							class="panel panel-basic panel-narrow order-summary">
							<div class="panel-heading">
								<h3 class="text-center">我的订单</h3>
							</div>
							<div class="panel-section-group">
								<section id="addr"
									class="panel-section section-delivery-address">
									<table class="table-default table-delivery-address">
										<tbody>
											<tr>
												<th scope="row">送餐至:
													<div>
														<a href="#cgAddr" role="button" class="btn"
															data-toggle="modal">编辑</a>
													</div>


												</th>
												<td>

													<div>${request.userAddr}</div>

												</td>
											</tr>
										</tbody>
									</table>
								</section>

								<section id="time"
									class="panel-section section-delivery-datetime">
									<table class="table-default table-delivery-datetime">
										<tbody>
											<tr>
												<th scope="row">送餐时间:
													
												</th>
												<td>
													<div class="when-to-deliver"></div>
													<div class="how-long-to-deliver">
														<b>预计送餐时间:</b>

														<div>${request.planSendTime}</div>


													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</section>

								<section id="price" class="panel-section section-cost-breakdown">
									<table class="table-default table-cost">
										<tfoot class="total">
											<tr>
												<th scope="row">总计:</th>
												<td>￥${request.totalPrice}</td>
											</tr>
										</tfoot>
										<tbody></tbody>
									</table>


									<div class="form-group">


										<form action="PayCart" method="post">
											<s:if test="#request.totalPrice != 0">
												<button class="btn btn-danger btn-block btn-xl"
													type="submit">立即结账</button>
											</s:if>
										</form>
										<s:else>
											<button herf="#" class="btn btn-block btn-xl"
												disabled="disabled">立即结账</button>
										</s:else>


									</div>

								</section>

								<section id="orderDetail"
									class="panel-section section-order-items">
									<h3>订单明细</h3>

									<form id="od" class="order-items item-list"
										action="DeleteOrder" method="post">

										<div class="order-item list-item">
											<div>
												<div>
													<s:iterator id="cart" value="#request.cartList">
														<s:iterator id="price" value="#request.priceList">
														
															<div class="item-heading clearfix">
																<div class="quantity">${cart.amount}</div>
																<div class="picture">
																	<img alt="" class="img-block"
																		src="images/${cart.foodName}.jpg">
																</div>
																<div class="details">
																	<h5 class="product-name">${cart.foodName}</h5>
																	<ul>


																	</ul>
																</div>
															</div>
															<div class="item-body clearfix">

																<div class="controls">

																	<a class="action-delete action-delete-order"
																		data-orderid="88"
																		href="javascript:deleteOrder('${cart.orderNo}')"
																		title="删除"> <img alt="24x24" src="icon/delete.ico"/></a>

																</div>

																<div class="cost">
																	￥
																	<s:property></s:property>
																</div>

															</div>
														</s:iterator>
													</s:iterator>
												</div>
											</div>
										</div>
									</form>
								</section>
							</div>


						</div>
					</div>


				</div>
			</div>
		</div>



	</div>

	<div id="cgAddr" class="modal fade center" role="dialog"
		aria-hidden="false" tabindex="-1" style="display: none;z-index:99999;">
		<div class="modal-backdrop fade in" style="height: 521px;"></div>

		<div class="modal-content" style="z-index:99999">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">
					<img alt="24x24" src="icon/close.ico" />
				</button>
			</div>
			<div class="fieldset-heading">
				<h2>请选择送餐地址</h2>
			</div>

			<form action="ChangeAddr" method="post">
				<div>
					<a
						class="ui-selectmenu ui-widget ui-state-default ui-selectmenu-dropdown ui-corner-all"
						id="form_deliveryoptions_address-button" role="button"
						href="javascript:chooseAddr()" tabindex="0" aria-haspopup="true"
						aria-owns="form_deliveryoptions_address-menu"
						aria-disabled="false" style="width: 538px;"> 
						<select
							class="hide-default-error" name="userAddr"
							id="form_deliveryoptions_address" tabindex="0"
							style="display: block;" aria-disabled="false">
							<s:iterator id="addrs" value="#request.userAddrList">
								<option >${addrs.userAddr}</option>
							</s:iterator>
						</select>
					</a>
				</div>

				<table style="width:370px">
				<thead>
				<tr><td>
				
					<a  style="float:left;font-size:20px;padding-left:30px" href="">
					<img src="icon/right.ico"/>添加送餐地址</a>
					</td></tr>
				</thead>
				<tbody>
				<tr><td>

					<input type="submit" value="更改地址"
						class="btn btn-danger btn-xl btn-submit" style="float:right" />

				</td></tr>
				</tbody>
				</table>
			</form>

		</div>

	</div>


</body>
</html>