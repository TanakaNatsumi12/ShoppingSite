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

<h1>新規会員登録完了</h1>

<p><a href="<%= request.getContextPath() %>/views/login-in.jsp">ログイン画面へ戻る</a></p>


<jsp:include page="/views/footer.jsp" />