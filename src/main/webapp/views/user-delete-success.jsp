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

<h1>会員情報削除完了</h1>

<p>会員情報を削除しました。</p>

<form action="views/login-in.jsp" method="post">
	<input type="submit" value="ログイン画面へ戻る">
</form>
<jsp:include page="/views/footer.jsp" />