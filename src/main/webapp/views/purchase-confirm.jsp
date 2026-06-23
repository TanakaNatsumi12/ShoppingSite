<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
List<Map<String, Object>> cart = (List<Map<String, Object>>) 
request.getAttribute("cart");
int total = 0; 
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


 <h3>合計：¥<%= total %></h3>
  
 <form action="purchase" method="post">
 	<button type="submit">購入確定</button> 
 </form> 
  
  
  
<jsp:include page="/views/footer.jsp" />