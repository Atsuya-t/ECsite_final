<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page isELIgnored="false"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>
	<h1>検索</h1>
	<form action="/EC_fin/search" method="post">
		<input type="text" name="keyword"> <select name="category">
			<option value="-1">すべて</option>
			<c:forEach var="category" items="${catList}">
				<option value="${category.catId}">${category.catName}</option>
			</c:forEach>
		</select> <input type="submit" value="検索">
	</form>

	<c:if test="${searchResult != null}">
		<table>
			<tr>
				<td>商品名</td>
				<td>単価</td>
				<td>在庫数</td>
			</tr>

			<c:forEach var="product" items="${searchResult}">
				<tr>
					<td><a href="/EC_fin/search?procd=${product.proCd}">${product.proName}</a></td>
					<td>${product.proPrice}</td>
					<td>${product.stockNo}</td>
				</tr>
			</c:forEach>
		</table>
		<p>${errmsg}</p>
	</c:if>
</body>
</html>