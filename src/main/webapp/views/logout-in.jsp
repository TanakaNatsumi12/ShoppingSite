<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
    String role = (String) session.getAttribute("role");
    boolean isAdmin = "admin".equals(role);
%>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<% if (isAdmin) { %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
<% } else { %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<% } %>
<body>

<p>ログアウトしますか？</p>
<p><a href="<%= request.getContextPath() %>/Logout.action">ログアウト</a></p>

<% if (isAdmin) { %>
    <jsp:include page="/views/admin-header.jsp" />
<% } else { %>
    <jsp:include page="/views/header.jsp" />
<% } %>

<form>
    <input type="button" value="いいえ" onclick="history.back();">
</form>



<jsp:include page="/views/footer.jsp" />