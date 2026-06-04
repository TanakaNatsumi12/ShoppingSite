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

<h1>会員情報編集登録</h1>

<form action="<%= request.getContextPath() %>/userEditConfirmServlet" method="post">

<p>名前（姓）： <input type="text" name="lastName" value="${customer.lastName}" required></p>
<p>名前（名）： <input type="text" name="firstName" value="${customer.firstName}" required></p>
<p>住所： <input type="text" name="address" value="${customer.address}" required></p>
<p>メールアドレス： <input type="email" name="mailAddress" value="${customer.mailAddress}" required ></p>

<input type="submit" value="確認">
</form>

<form action="<%= request.getContextPath() %>/views/user-menu.jsp" method="post">
	<input type="submit" value="メニュー画面へ戻る">
</form>



<jsp:include page="/views/footer.jsp" />