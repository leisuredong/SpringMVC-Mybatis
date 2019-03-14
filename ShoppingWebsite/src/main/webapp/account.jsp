<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Shopping-Town</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<c:import url="./navigation.jsp"></c:import>
	<div class="g-doc">
		<div class="m-tab m-tab-fw m-tab-simple f-cb">
			<h2>已购买的内容</h2>
		</div>
		<table class="m-table m-table-row n-table g-b3">
			<colgroup>
				<col class="img">
				<col class="time">
				<col class="num">
				<col class="price">
			</colgroup>
			<thead>
				<tr>
					<th>内容图片</th>
					<th>内容名称</th>
					<th>购买时间</th>
					<th>购买数量</th>
					<th>购买价格</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orderItems}" var="orderItem">
					<c:set var="total" value='${total+orderItem.get("price")}' />
					<tr>
						<td><a href='./show.do?id=${orderItem.get("id")}'> <c:choose>
									<c:when test='${!orderItem.get("image").equals("")}'>
										<img src='${orderItem.get("image")}' alt="">
									</c:when>
									<c:otherwise>
										<img src='./resources/${orderItem.get("file")}' alt="">
									</c:otherwise>
								</c:choose>
						</a></td>
						<td><h4>
								<a href='./show.do?id=${orderItem.get("id")}'>${orderItem.get("title")}</a>
							</h4></td>
						<td><span class="v-time">${orderItem.get("time")}</span></td>
						<td><span class="v-num">${orderItem.get("number")}</span></td>
						<td><span class="v-unit">¥</span><span class="value">${orderItem.get("price")}</span></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4"><div class="total">总计：</div></td>
					<td><span class="v-unit">¥</span><span class="value">${total}</span></td>
				</tr>
			</tfoot>
		</table>
	</div>
	<div class="n-foot">
		<p>作者：网易杭州研究院-质量保障部-董悠然</p>
	</div>
</body>
</html>