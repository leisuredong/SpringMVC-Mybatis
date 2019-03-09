<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Shopping-Town</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<c:import url="./navigation.jsp"></c:import>

	<div class="g-doc">
		<div class="m-tab m-tab-fw m-tab-simple f-cb">
			<h2>内容发布</h2>
		</div>
		<div class="n-public">
			<form class="m-form m-form-ht" id="form" method="post"
				action="./public.do" onsubmit="return false;" autocomplete="off">
				<div class="fmitem">
					<label class="fmlab">标题：</label>
					<div class="fmipt">
						<input class="u-ipt ipt" name="title" autofocus="autofocus"
							placeholder="2-80字符">
					</div>
				</div>
				<div class="fmitem">
					<label class="fmlab">摘要：</label>
					<div class="fmipt">
						<input class="u-ipt ipt" name="summary" placeholder="2-140字符">
					</div>
				</div>
				<div class="fmitem">
					<label class="fmlab">图片：</label>
					<div class="fmipt" id="uploadType">
						<input name="pic" type="radio" value="url" checked="checked">图片地址
						<input name="pic" type="radio" value="file">本地上传
					</div>
				</div>
				<div class="fmitem">
					<label class="fmlab"></label>
					<div class="fmipt" id="urlUpload" style="display: block;">
						<input class="u-ipt ipt" name="image" placeholder="图片地址">
					</div>
					<div class="fmipt" id="fileUpload" style="display: none;">
						<input class="u-ipt ipt" name="file" type="file" id="fileUp">
						<button class="u-btn u-btn-primary" id="upload">上传</button>
					</div>
				</div>
				<div class="fmitem">
					<label class="fmlab">正文：</label>
					<div class="fmipt">
						<textarea class="u-ipt" name="detail" rows="10"
							placeholder="2-1000个字符"></textarea>
					</div>
				</div>
				<div class="fmitem">
					<label class="fmlab">价格：</label>
					<div class="fmipt">
						<input class="u-ipt price" name="price">元
					</div>
				</div>
				<div class="fmitem fmitem-nolab fmitem-btn">
					<div class="fmipt">
						<button type="submit" class="u-btn u-btn-primary u-btn-lg">发布</button>
					</div>
				</div>
			</form>
			<c:if test="${sessionScope.result == 1}">
				<c:set var="filepath" value="./resources/${sessionScope.file}"></c:set>
				<% session.removeAttribute("file"); %>
			</c:if>
			<span class="imgpre"><img src="${filepath}" alt="" id="imgpre"></span>
		</div>
	</div>
	<div class="n-foot">
		<p>作者：网易杭州研究院-质量保障部-董悠然</p>
	</div>
	<script type="text/javascript" src="./js/global.js"></script>
	<script type="text/javascript" src="./js/public.js"></script>
	<div style="display: none;"></div>
</body>
</html>