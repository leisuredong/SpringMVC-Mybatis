<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Shopping-Town</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
<body>
	<c:import url="./navigation.jsp"></c:import>
	
	<form class="m-form m-form-ht n-login" id="loginForm"
		onsubmit="return false;" autocomplete="off">
		<div class="fmitem">
			<label class="fmlab">用户名：</label>
			<div class="fmipt">
				<input class="u-ipt" name="userName" autofocus />
			</div>
		</div>
		<div class="fmitem">
			<label class="fmlab">密码：</label>
			<div class="fmipt">
				<input class="u-ipt" type="password" name="password" />
			</div>
		</div>
		<div class="fmitem fmitem-nolab fmitem-btn">
			<div class="fmipt">
				<button type="submit"
					class="u-btn u-btn-primary u-btn-lg u-btn-block">登 录</button>
			</div>
		</div>
	</form>
	<div class="n-foot">
		<p>作者：网易杭州研究院-质量保障部-董悠然</p>
	</div>
	<script type="text/javascript" src="./js/md5.js"></script>
	<script type="text/javascript" src="./js/global.js"></script>
	<script type="text/javascript" src="./js/pageLogin.js"></script>
</body>
</html>