<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/product-page.css">
</head>
<jsp:include page="/views/header.jsp" />

<div class="product-detail">

  <div class="product-image">
    <img src="${pageContext.request.contextPath}${product.imageUrl}">
  </div>

  <div class="product-info">

    <p>商品名：${product.name}</p>

    <p>${product.description}</p>

    <p>価格：${product.price}</p>

    <p>在庫：${product.stock}</p>

    <div class="cart">
      <form action="${pageContext.request.contextPath}/cart/add" method="post">
        <input type="hidden" name="productId" value="${product.id}">
        <button type="submit">カートに入れる</button>
      </form>
    </div>

  </div>

</div>
	



<jsp:include page="/views/footer.jsp" />