<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%
List<Map<String, Object>> orderItems =
    (List<Map<String, Object>>) request.getAttribute("orderItems");

int total = 0;
int shipping = 800;
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/purchase-success.css">
</head>
<jsp:include page="/views/header.jsp" />

<h1>ご購入ありがとうございました。</h1>

<table>
    <tr><th>商品名</th><th>数量</th><th>金額</th></tr>

    <% for (Map<String, Object> item : orderItems) {
        int price = (int) item.get("price");
        int qty = (int) item.get("quantity");
        total += price * qty;
    %>
    <tr>
        <td><%= item.get("name") %></td>
        <td><%= qty %></td>
        <td>¥<%= price * qty %></td>
    </tr>
    <% } %>
</table>

<p>商品合計：¥<%= total %></p>
<p>送料：¥<%= shipping %></p>
<hr>
<p><strong>お支払い金額：¥<%= total + shipping %></strong></p>

<form action="<%= request.getContextPath() %>/productAction" method="post">
	<input type="submit" value="お買い物を続ける" name="shopping">
</form>

<jsp:include page="/views/footer.jsp" />