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
		<div class="n-result">
			<h3>编辑成功！</h3>
			<p>
				<a href="./show.do?id=${content.id}">[查看内容]</a><a href="./index.do">[返回首页]</a>
			</p>
		</div>
	</div>
</body>
</html>