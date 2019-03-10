<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Shopping-Town</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
</head>
<c:choose>
	<c:when test="${content.image != '1'}">
		<body>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			function clickFile() {
				document.getElementById("fileRadio").click();
			}
		</script>
		<body onload="clickFile()">
	</c:otherwise>
</c:choose>
<c:import url="./navigation.jsp"></c:import>

<div class="g-doc">
	<div class="m-tab m-tab-fw m-tab-simple f-cb">
		<h2>内容编辑</h2>
	</div>
	<div class="n-public">
		<form class="m-form m-form-ht" id="form" method="post"
			action="./edit.do" onsubmit="return false;" autocomplete="off">
			<div class="fmitem">
				<label class="fmlab">标题：</label>
				<div class="fmipt">
					<input class="u-ipt ipt" name="title" autofocus="autofocus"
						placeholder="2-80字符" value="${content.title}">
				</div>
			</div>
			<div class="fmitem">
				<label class="fmlab">摘要：</label>
				<div class="fmipt">
					<input class="u-ipt ipt" name="summary" placeholder="2-140字符"
						value="${content.summary}">
				</div>
			</div>

			<script type="text/javascript">
				function delAndDis() {
					var path = document.getElementById("path");
					path.parentNode.removeChild(path);
					var change = document.getElementById("change");
					change.parentNode.removeChild(change);
					document.getElementById("fileUp").style.visibility = "visible";
					document.getElementById("upload").style.visibility = "visible";
				}
				function dis() {
					document.getElementById("fileUp").style.visibility = "visible";
					document.getElementById("upload").style.visibility = "visible";
				}
			</script>

			<c:choose>
				<c:when test="${content.image != '1'}">
					<div class="fmitem">
						<label class="fmlab">图片：</label>
						<div class="fmipt" id="uploadType">
							<input name="pic" type="radio" value="url" checked="checked">图片地址
							<input name="pic" type="radio" value="file" onclick="dis()">本地上传
						</div>
					</div>
					<div class="fmitem">
						<label class="fmlab"></label>
						<div class="fmipt" id="urlUpload" style="display: block;">
							<input id="url" class="u-ipt ipt" name="image" placeholder="图片地址"
								value="${content.image}">
						</div>
						<div class="fmipt" id="fileUpload" style="display: none;">
							<input class="u-ipt ipt" name="file" type="file" id="fileUp"
								style="visibility: hidden;">
							<button class="u-btn u-btn-primary" id="upload"
								style="visibility: hidden;">上传</button>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="fmitem">
						<label class="fmlab">图片：</label>
						<div class="fmipt" id="uploadType">
							<input name="pic" type="radio" value="url">图片地址 <input
								id="fileRadio" name="pic" type="radio" value="file"
								checked="checked">本地上传
						</div>
					</div>
					<div class="fmitem">
						<label class="fmlab"></label>
						<div class="fmipt" id="urlUpload" style="display: block;">
							<input id="url" class="u-ipt ipt" name="image" placeholder="图片地址"
								value="${content.image}">
						</div>
						<div class="fmipt" id="fileUpload" style="display: none;">
							<input id="path" type="text" value="./resources/${content.file}"
								style="display: inline-block; box-sizing: border-box; width: 30%; padding: 6px 10px; height: 32px; line-height: 18px; border-radius: 4px; vertical-align: middle; border: 1px solid #d9d9d9; font-size: 14px; background-color: #fff;" />
							<button id="change" class="u-btn u-btn-primary"
								onclick="delAndDis()">更改</button>
							<input class="u-ipt ipt" name="file" type="file" id="fileUp"
								style="visibility: hidden;">
							<button class="u-btn u-btn-primary" id="upload"
								style="visibility: hidden;">上传</button>
						</div>
					</div>
				</c:otherwise>
			</c:choose>

			<div class="fmitem">
				<label class="fmlab">正文：</label>
				<div class="fmipt">
					<textarea class="u-ipt" name="detail" rows="10"
						placeholder="2-1000个字符">${content.detail}</textarea>
				</div>
			</div>
			<div class="fmitem">
				<label class="fmlab">价格：</label>
				<div class="fmipt">
					<input class="u-ipt price" name="price" value="${content.price}">元
				</div>
			</div>
			<div class="fmitem fmitem-nolab fmitem-btn">
				<div class="fmipt">
					<button type="submit" class="u-btn u-btn-primary u-btn-lg">保存</button>
				</div>
			</div>
		</form>
		<c:choose>
			<c:when test="${content.image != '1'}">
				<span class="imgpre"><img src="${content.image}" alt=""
					id="imgpre"></span>
			</c:when>
			<c:otherwise>
				<span class="imgpre"><img src="./resources/${content.file}"
					alt="" id="imgpre"></span>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="n-foot">
	<p>作者：网易杭州研究院-质量保障部-董悠然</p>
</div>
<script type="text/javascript" src="./js/global.js"></script>
<script type="text/javascript" src="./js/public.js"></script>
</body>
</html>