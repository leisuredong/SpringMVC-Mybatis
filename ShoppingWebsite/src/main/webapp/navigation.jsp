<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>

<c:if test="${not empty sessionScope.currentUser }">
	<%-- <c:set var="username" scope="session"
			value="${sessionScope.currentUser.getUsername() }" /> --%>
	<div class="n-head">
		<div class="g-doc f-cb">
			<div class="user">
				${sessionScope.currentUser.getUsername()}，你好！ <a href="./logout.do">[退出]</a>
			</div>
			<c:if test="${sessionScope.currentUser.getUsername()=='buyer'}">
				<ul class="nav">
					<li><a href="./index.jsp">首页</a></li>
					<li><a href="./account.jsp">账务</a></li>
					<li><a href="./settleAccount.jsp">购物车</a></li>
				</ul>
			</c:if>
			<c:if test="${sessionScope.currentUser.getUsername()=='seller'}">
				<ul class="nav">
					<li><a href="./index.jsp">首页</a></li>
					<li><a href="./public.jsp">发布</a></li>
				</ul>
			</c:if>
		</div>
	</div>
</c:if>
<c:if test="${empty sessionScope.currentUser}">
	<div class="n-head">
		<div class="g-doc f-cb">
			<div class="user">
				请<a href="./login.jsp">[登录]</a>
			</div>
			<ul class="nav">
				<li><a href="./index.jsp">首页</a></li>
			</ul>
		</div>
	</div>
</c:if>