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

<h1>削除してよろしいですか？</h1>

<p>${customer.lastName}${customer.firstName}さん</p>

<form action="<%= request.getContextPath() %>/userDeleteServlet" method="post">
	<input type="submit" value="はい">
</form>

<form action="<%= request.getContextPath() %>/views/user-menu.jsp" method="post">
	<input type="submit" value="いいえ">
</form>

<jsp:include page="/views/footer.jsp" />