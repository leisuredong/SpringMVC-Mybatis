<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Shopping-Town</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<c:import url="./navigation.jsp"></c:import>
	<div class="g-doc" id="settleAccount">
		<div class="m-tab m-tab-fw m-tab-simple f-cb">
			<h2>已添加到购物车的内容</h2>
		</div>
		<table id="newTable" class="m-table m-table-row n-table g-b3">
		</table>
		<div id="act-btn">
			<button class="u-btn u-btn-primary" id="back" type="reset">退出</button>
			<button class="u-btn u-btn-primary" id="Account">购买</button>
		</div>
	</div>
	<div class="n-foot">
		<p>作者：网易杭州研究院-质量保障部-董悠然</p>
	</div>
	<script type="text/javascript" src="./js/global.js"></script>
	<script type="text/javascript" src="./js/settleAccount.js"></script>
</body>
</html>