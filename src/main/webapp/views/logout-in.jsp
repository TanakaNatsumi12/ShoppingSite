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
<body>

<p>ログアウトしますか？</p>
<p><a href="<%= request.getContextPath() %>/Logout.action">ログアウト</a></p>

<%
    String role = (String) session.getAttribute("role");
    String backPage = "views/user-menu.jsp";

    if ("admin".equals(role)) {
        backPage = "views/admin-menu.jsp";
    }
%>

<form action="<%= request.getContextPath() %>/<%= backPage %>" method="post">
    <input type="submit" value="いいえ">
</form>


<jsp:include page="/views/footer.jsp" />