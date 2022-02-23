<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="${contextRoot}/">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/about">關於我們</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/addMessage">新增留言</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/viewMessage?p=1">查看留言</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/ajaxMessage">ajax + restful 版本</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/viewProducts">查看商品</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/addProduct">新增商品</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/list">購物區</a></li>
			</ul>
		</div>
	</nav>
	<script src="${contextRoot}/js/jquery-3.6.0.min.js"></script>
	<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
</body>
</html>