<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>

<%
    List<Map<String, Object>> cart = 
        (List<Map<String, Object>>) request.getAttribute("cart");

    int total = 0;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/cart.css">
</head>

<jsp:include page="/views/header.jsp" />

<div class="cart-container">

    <div class="left">
        <h2>カート</h2>

        <% if (cart != null && !cart.isEmpty()) { %>

            <% for (Map<String, Object> item : cart) { 
                int price = (int) item.get("price");
                int quantity = (int) item.get("quantity");
                total += price * quantity;
            %>

            <div class="item">

                <img src="<%= request.getContextPath() + item.get("image") %>" class="img"/>

                <div class="info">
                    <div class="name"><%= item.get("name") %></div>
                    

                    <form action="<%= request.getContextPath() %>/cartUpdate" method="post">
                        <input type="hidden" name="id" value="<%= item.get("product_id") %>"/>

                        <select name="quantity" onchange="this.form.submit()">
    						<% 
        						int stock = (int) item.get("stock");
    							int currentQty = (int) item.get("quantity");
        						for (int i = 1; i <= stock; i++) { 
    						%>
        						<option value="<%= i %>" <%= (i == quantity) ? "selected" : "" %>>
            						<%= i %>
        						</option>
    						<% } %>
						</select>
                    </form>

                    <form action="<%= request.getContextPath() %>/cartDelete" method="post">
                        <input type="hidden" name="id" value="<%= item.get("product_id") %>"/>
                        <button class="delete" type="submit">削除</button>
                    </form>
                </div>


                <div class="price">
                    ¥<%= price * quantity %>
                </div>

            </div>

            <% } %>

        <% } else { %>

            <p>カートは空です。</p>

        <% } %>

    </div>

    <div class="right">
        <h3>注文サマリー</h3>

        <div class="row">
            <span>小計</span>
            <span>¥<%= total %></span>
        </div>


        <hr>

        <div class="total">
            <span>合計</span>
            <span>¥<%= total %></span>
        </div>

        <form action="checkout" method="post">
            <button class="btn">お会計に進む</button>
        </form>
    </div>

</div>


<jsp:include page="/views/footer.jsp" />