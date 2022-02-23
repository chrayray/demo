<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

			<form:form class="form" action="${contextRoot}/addProduct"
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
							<td><form:input path="product_id" disabled="true" />自動填寫</td>
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
				<input type="submit" name="submit" />
			</form:form>
		</div>
	</div>
</body>
</html>