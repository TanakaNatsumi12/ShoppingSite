<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
List<Map<String, Object>> cart = (List<Map<String, Object>>) 
request.getAttribute("cart");
int total = 0; 
int shipping = 800; // 固定送料
%> 

<%@ page import="java.util.List" %> 
<%@ page import="java.util.Map" %> 

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>Insert title here</title> 
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/purchase-header.css"> 
</head>

<jsp:include page="/views/purchase-header.jsp" />
  
<h2>購入内容の確認</h2>

<div class="section">
    <h3>■ 商品情報</h3>
    <table>
        <tr><th>商品名</th><th>数量</th><th>金額</th></tr>

        <% for (Map<String, Object> item : cart) {
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
</div>

<div class="section">
    <h3>■ 支払い方法</h3>
    <select>
    	<option>クレジットカード</option>
    	<option>スマホ決済</option>
    	<option>コンビニ決済</option>
    	<option>銀行振込</option>
    	<option>代引き</option>
    </select>
</div>

<div class="section">
    <h3>■ お届け先</h3>
    <p><%= request.getAttribute("customerAddress") %></p>
    <p><%= request.getAttribute("customerName") %>さん</p>
</div>



<div class="btn-area">
    <form action="<%= request.getContextPath() %>/purchaseSuccess" method="post">
        <button type="submit">注文を確定する</button>
    </form>
    
    <p></p>
    
    <form>
    <input name="back" type="button" value="戻る" onclick="history.back();" >
	</form>
</div>
  
  
<jsp:include page="/views/footer.jsp" />