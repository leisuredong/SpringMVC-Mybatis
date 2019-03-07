<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Shopping-Town</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<c:import url="./navigation.jsp"></c:import>

	<div class="g-doc">
		<div class="n-show f-cb" id="showContent">
			<div class="img">
				<img
					src="http://t2.hddhhn.com/uploads/tu/201610/198/1oei3krh4ix.jpg"
					alt="">
			</div>
			<div class="cnt">
				<h2>Flower</h2>
				<p class="summary">flower</p>
				<div class="price">
					<span class="v-unit">¥</span><span class="v-value">1</span>
				</div>
				<div class="num">
					购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span
						class="totalNum" id="allNum">1</span><span id="addNum"
						class="moreNum"><a>+</a></span>
				</div>
				<div class="oprt f-cb"></div>
			</div>
		</div>
		<div class="m-tab m-tab-fw m-tab-simple f-cb">
			<h2>详细信息</h2>
		</div>
		<div class="n-detail">flower pic</div>
	</div>
	<div class="n-foot">
		<p>作者：网易杭州研究院-质量保障部-董悠然</p>
	</div>
	<script type="text/javascript" src="./js/global.js"></script>
	<script type="text/javascript" src="./js/pageShow.js"></script>
</body>
</html>