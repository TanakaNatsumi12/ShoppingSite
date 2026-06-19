<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/user-products-list.css">
</head>
<jsp:include page="/views/header.jsp" />

<form action="" method="post">

<p>新着商品</p>
<div class="grid">
	
        <c:forEach var="p" items="${products}">
            <div class="card">
                <img src="${pageContext.request.contextPath}${p.imageUrl}">
                <div class="name">${p.name}</div>
                <div class="price">¥${p.price}</div>
            </div>
        </c:forEach>
</div>



<jsp:include page="/views/footer.jsp" />