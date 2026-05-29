<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

ようこそ、${customer.lastName}さん

<form action="" method="get">
<input type="submit" value="修正">
</form>

<form action="" method="get">
<input type="submit" value="削除">
</form>

<form action="/ShoppingSite/login-in.jsp" method="post">
<input type="submit" value="ログアウト">
</form>





</body>
</html>