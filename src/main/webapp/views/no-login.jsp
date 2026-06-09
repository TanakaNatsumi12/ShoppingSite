<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<jsp:include page="/views/header.jsp" />

<p>ログインされていません。</p>

<form action="/ShoppingSite/views/login-in.jsp" method="post">
<input type="submit" value="ログイン画面へ戻る">
</form>

<jsp:include page="/views/footer.jsp" />
