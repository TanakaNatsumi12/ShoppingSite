<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<jsp:include page="/views/header.jsp" />
<body>

ようこそ、${customer.lastName}さん

<form action="" method="get">
<input type="submit" value="修正">
</form>

<form action="" method="get">
<input type="submit" value="削除">
</form>

<form action="/ShoppingSite/views/logout-in.jsp" method="post">
<input type="submit" value="ログアウト">
</form>



<jsp:include page="/views/footer.jsp" />