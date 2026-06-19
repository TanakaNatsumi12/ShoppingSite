<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
</head>
<jsp:include page="/views/admin-header.jsp" />

<h1>商品一覧</h1>

<a href="<%= request.getContextPath() %>/productAdd">
    <button>商品追加</button>
</a>


<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>商品名</th>
        <th>価格</th>
        <th>在庫</th>
        <th>編集</th>
        <th>削除</th>
    </tr>

    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.stock}</td>

            <td>
                <a href="<%= request.getContextPath() %>/productEdit?id=${p.id}">
                    <button>編集</button>
                </a>
            </td>

            <td>
                <a href="<%= request.getContextPath() %>/productDelete?id=${p.id}">
                    <button>削除</button>
                </a>
            </td>
        </tr>
    </c:forEach>

</table>

<jsp:include page="/views/footer.jsp" />