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

<h1>修正する内容はよろしいですか？</h1>

<p>名前（姓）： ${lastName} </p>
<p>名前（名）： ${firstName}</p>
<p>住所： ${address}</p>
<p>メールアドレス： ${mailAddress}</p>

<form action="/ShoppingSite/userEditServlet" method="post">
	<input type="hidden" name="memberId" value="${memberId}">
    <input type="hidden" name="password" value="${password}">
    <input type="hidden" name="lastName" value="${lastName}">
    <input type="hidden" name="firstName" value="${firstName}">
    <input type="hidden" name="address" value="${address}">
    <input type="hidden" name="mailAddress" value="${mailAddress}">
	<input type="submit" value="登録">
</form>

<form>
    <input type="button" value="戻る" onclick="history.back();">
</form>
<jsp:include page="/views/footer.jsp" />