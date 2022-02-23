<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="layout/navbar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<p />
		<div class="row justify-content-center">
			<h3>請修改資料</h3>

			<form:form class="form" action="${contextRoot}/editProduct"
				modelAttribute="P" method="post">
				<table class="table">
					<thead class="table table-light	">
						<tr>
							<th>編號</th>
							<th>名稱</th>
							<th>價錢</th>
							<th>類型</th>
							<th>最小遊玩人數</th>
							<th>最大遊玩人數</th>
							<th>最適年齡</th>
							<th>庫存</th>
							<th>上下架</th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<td><form:input path="product_id" readonly="true" /></td>
							<td><form:input path="product_name" /></td>
							<td><form:input path="price" /></td>
							<td><form:input path="gametype" /></td>
							<td><form:input path="minplayer" /></td>
							<td><form:input path="maxplayer" /></td>
							<td><form:input path="low_age" /></td>
							<td><form:input path="stock" /></td>
							<td><form:select path="sellstatus">狀態
							<form:option value="上架中">上架中</form:option>
									<form:option value="下架中">下架中</form:option>
								</form:select></td>
							<form:input path="photourl" type="hidden" />
						</tr>
					</tbody>
				</table>
				<input class="btn btn-secondary btn-lg btn-block" type="submit"
					name="submit" id="submitBtn" />
				<form:errors path="price" />
				<br>
				<form:errors path="maxplayer" />
				<br>
				<form:errors path="minplayer" />
				<br>
				<form:errors path="low_age" />
				<br>
				<form:errors path="stock" />
				<br>
				<h6>${a}</h6>
			</form:form>
		</div>
	</div>
</body>
<script>
	// 	$(document).ready(function() {
	// 		$('#submitBtn').click(function() {
	// 			let flag1 = false;
	// 			let flag2 = false;
	// 			let flag3 = false;
	// 			let flag4 = false;
	// 			let flag5 = false;

	// 			var min = document.getElementById('minplayer').value;
	// 			var max = document.getElementById('maxplayer').value;
	// 			var price = document.getElementById('price').value;
	// 			var low_age = document.getElementById('low_age').value;

	// 			var error1 = '';
	// 			var error2 = '';
	// 			var error3 = '';
	// 			var error4 = '';
	// 			var error5 = '';

	// 			$('#error p').remove();

	// 			if (max > min) {
	// 				return true;
	// 			} else {
	// 				error1 += "<p>";
	// 				error1 += "最大人數需大於最小人數";
	// 				error1 += "</p>"
	// 				$('#error').append(error1);
	// 				return false;
	// 			}

	// 			if (price >= 0) {
	// 				flag2 = true;
	// 			} else {
	// 				error2 += "<p>";
	// 				error2 += "價格不可小於0";
	// 				error2 += "</p>"
	// 				$('#error').append(error2);
	// 			}

	// 			if (low_age >= 0) {
	// 				flag3 = true;
	// 			} else {
	// 				error3 += "<p>";
	// 				error3 += "最小年齡不可小於0";
	// 				error3 += "</p>"
	// 				$('#error').append(error3);
	// 			}

	// 			if (max >= 1) {
	// 				flag4 = true;
	// 			} else {
	// 				error4 += "<p>";
	// 				error4 += "最大人數不可小於1";
	// 				error4 += "</p>"
	// 				$('#error').append(error4);
	// 			}

	// 			if (min >= 1) {
	// 				flag5 = true;
	// 			} else {
	// 				error5 += "<p>";
	// 				error5 += "最小人數不可小於1";
	// 				error5 += "</p>"
	// 				$('#error').append(error5);
	// 			}

	// 			if (flag1 == flag2 == flag3 == flag4 == flag5 == true) {
	// 				return true;
	// 			} else {
	// 				return false;
	// 			}

	// })
	// 	});
</script>
</html>