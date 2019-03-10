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
				<c:choose>
					<c:when test="${content.image != '1'}">
						<img src="${content.image}" alt="">
					</c:when>
					<c:otherwise>
						<img src="./resources/${content.file}" alt="">
					</c:otherwise>
				</c:choose>
			</div>
			<div class="cnt">
				<h2>${content.title}</h2>
				<p class="summary">${content.summary}</p>
				<div class="price">
					<span class="v-unit">¥</span><span class="v-value">${content.price}</span>
				</div>
				<!-- <div class="num">
					购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span
						class="totalNum" id="allNum">1</span><span id="addNum"
						class="moreNum"><a>+</a></span>
				</div> -->
				<div class="oprt f-cb">
					<c:if test="${sessionScope.currentUser.getUsername()=='buyer'}">
						<c:choose>
							<c:when test="${content.sold}">
								<span class="u-btn u-btn-primary z-dis">已购买</span>
								<span class="buyprice">当时购买价格：¥120.88</span>
							</c:when>
							<c:otherwise>
								<button class="u-btn u-btn-primary" id="add" data-id="197"
									data-title="22" data-price="22">加入购物车</button>
							</c:otherwise>
						</c:choose>
					</c:if>
					<c:if test="${sessionScope.currentUser.getUsername()=='seller'}">
						<a href="./edit.do?id=${content.id}" class="u-btn u-btn-primary">编 辑</a>
					</c:if>
				</div>
			</div>
		</div>
		<div class="m-tab m-tab-fw m-tab-simple f-cb">
			<h2>详细信息</h2>
		</div>
		<div class="n-detail">${content.detail}</div>
	</div>
	<div class="n-foot">
		<p>作者：网易杭州研究院-质量保障部-董悠然</p>
	</div>
	<script type="text/javascript" src="./js/global.js"></script>
	<script type="text/javascript" src="./js/pageShow.js"></script>
</body>
</html>