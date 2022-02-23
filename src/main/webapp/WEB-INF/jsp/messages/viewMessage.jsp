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
<title>View Messages Page</title>
</head>
<body>
	<div class="container">
		<p />
		<c:forEach var="workMessages" items="${page.content}">
			<div class="row justify-content-center">
				<div class="col-9">
					<div class="card">
						<div class="card-header">
							第${workMessages.id}筆訊息 新增時間:
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE"
								value="${workMessages.added}" />
						</div>
						<div class="card-body">
							<div>
								<c:out value="${workMessages.text}" />
								<div class="deit-Link">
									<a href="${contextRoot}/editMessage?id=${workMessages.id}"><input
										type="button" value="編輯第${workMessages.id}筆"></a> <a
										href="${contextRoot}/deleteMessage?id=${workMessages.id}"><input
										type="button"
										onclick="return confirm('確認刪除第${workMessages.id}筆資料?')"
										value="刪除第${workMessages.id}筆"></a>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</c:forEach>
		<div class="row justify-content-center">
			<div class="col-9">
				<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">

					<c:choose>
						<c:when test="${pageNumber-1==page.number}">
							<!--page.number:取的當前頁面的頁碼-->
							<c:out value="${pageNumber}" />
						</c:when>
						<c:otherwise>
							<a href="${contextRoot}/viewMessage?p=${pageNumber}"><c:out
									value="${pageNumber}" /> </a>
						</c:otherwise>
					</c:choose>


					<c:if test="${pageNumber != page.totalPages}">
						<!--顯示|的條件:如果是最後一頁，後面就不顯示-->
						|
					</c:if>


				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>