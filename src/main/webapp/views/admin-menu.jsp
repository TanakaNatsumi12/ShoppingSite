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

<h1>管理者画面</h1>






<form action="/ShoppingSite/views/logout-in.jsp" method="post">
<input type="submit" value="ログアウト">
</form>


<jsp:include page="/views/footer.jsp" />
