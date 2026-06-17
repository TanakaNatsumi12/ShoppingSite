<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
</head>

<jsp:include page="/views/admin-header.jsp" />



<h1>管理者メニュー</h1>

ようこそ、${customer.lastName}さん


<form action="<%= request.getContextPath() %>/productsListServlet" method="post">
<input type="submit" value="商品一覧">
</form>




<form action="/ShoppingSite/views/admin-logout.jsp" method="post">
<input type="submit" value="ログアウト">
</form>


<jsp:include page="/views/footer.jsp" />
