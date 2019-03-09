<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="utf-8"%>
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
			<div class="tab">
				<ul>
					<c:choose>
						<c:when test="${no_buy != 1}">
							<li class="z-sel"><a href="./index.do">所有内容</a></li>
							<c:if test="${sessionScope.currentUser.getUsername()=='buyer'}">
								<li><a href="./index.do?no-buy=1">未购买的内容</a></li>
							</c:if>
						</c:when>
						<c:otherwise>
							<li><a href="./index.do">所有内容</a></li>
							<c:if test="${sessionScope.currentUser.getUsername()=='buyer'}">
								<li class="z-sel"><a href="./index.do?no-buy=1">未购买的内容</a></li>
							</c:if>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>

		<div class="n-plist">
			<ul class="f-cb" id="plist">
				<c:forEach items="${contents}" var="content">
					<li id="p-${content.id}">
						<div onclick="window.location.href='./show.do?id=${content.id}'"
							style='cursor: pointer' class="link">
							<div class="img">
								<c:choose>
									<c:when test="${content.image != '1'}">
										<img src="${content.image}" alt="${content.title}">
									</c:when>
									<c:otherwise>
										<c:set var="filepath" value="./resources/${content.file}"></c:set>
										<img src="${filepath}" alt="${content.title}">
									</c:otherwise>
								</c:choose>
							</div>
							<h3>${content.title}</h3>
							<div class="price">
								<span class="v-unit">¥</span><span class="v-value">${content.price}</span>
							</div>
							<c:if test="${sessionScope.currentUser.getUsername()=='buyer'}">
								<c:if test="${content.sold}">
									<span class="had"><b>已购买</b></span>
								</c:if>
							</c:if>
							<c:if test="${sessionScope.currentUser.getUsername()=='seller'}">
								<c:if test="${content.sold}">
									<span class="had"><b>已售出</b></span>
								</c:if>
							</c:if>
						</div> <c:if
							test="${sessionScope.currentUser.getUsername()=='seller' && !content.sold}">
							<span class="u-btn u-btn-normal u-btn-xs del"
								data-del="${content.id}">删除</span>
						</c:if>
					</li>
				</c:forEach>
			</ul>
		</div>

	</div>
	<div class="n-foot">
		<p>作者：网易杭州研究院-质量保障部-董悠然</p>
	</div>
	<script type="text/javascript" src="./js/global.js"></script>
	<script type="text/javascript" src="./js/pageIndex.js"></script>
</body>
</html>