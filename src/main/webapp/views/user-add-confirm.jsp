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

<h1>登録する内容はよろしいですか？</h1>

<p>ユーザーID： ${memberId}</p>
<p>パスワード： ${password}</p>
<p>名前（姓）： ${lastName} </p>
<p>名前（名）： ${firstName}
<p>メールアドレス： ${mailAddress}</p>

<form action="" method="post">
	<input type="submit" value="登録">
</form>

<form action="/ShoppingSite/views/user-add.jsp" method="post">
	<input type="submit" value="戻る">
</form>

<jsp:include page="/views/footer.jsp" />