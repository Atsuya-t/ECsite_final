<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page isELIgnored="false"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細画面</title>
</head>
<body>
	<h1>商品詳細</h1>
	<img src="${product.proImg}" style="width: 300px;">
	<table>
		<tr>
			<td>商品名</td>
			<td>${product.proName}</td>
		</tr>
		<tr>
			<td>カテゴリー名</td>
			<td>${catName}</td>
		</tr>
		<tr>
			<td>価格</td>
			<td>${product.proPrice}</td>
		</tr>
		<tr>
			<td>在庫</td>
			<td>${product.stockNo}</td>
		</tr>
		<tr>
			<td>商品説明</td>
			<td>${product.proMsg }</td>
		</tr>
	</table>

個数
<form action="/EC_fin/productDetail" method="post">
<input type="number" name="quantity" min="1" max="${product.stockNo}" value="0">
<input type="submit" value="購入">
</form>
<form action="/EC_fin/search" method="post">
<input type="submit" value="戻る">
</form>
</body>
</html>