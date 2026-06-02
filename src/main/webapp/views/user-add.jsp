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

<h1>新規会員登録</h1>

<form action="/ShoppingSite/userAddConfirmServlet" method="post" >
<p>ユーザーID： <input type="text" name="memberId">半角英数字</p>
<p>パスワード： <input type="text" name="password">半角英数字</p>
<p>名前（姓）： <input type="text" name="lastName"></p>
<p>名前（名）： <input type="text" name="firstName"></p>
<p>メールアドレス： <input type="text" name="mailAddress"></p>

<input type="submit" value="確認">
<input type="reset" value="リセット">
</form>





<jsp:include page="/views/footer.jsp" />