<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<p>${errmsg}</p>
	<h1>ログイン</h1>
	<form action="/EC_fin/login" method="post">
		<table>
			<tr>
				<td>ログイン名</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="pass"></td>
			</tr>
		</table>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>