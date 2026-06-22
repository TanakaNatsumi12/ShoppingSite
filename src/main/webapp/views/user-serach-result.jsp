<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/user-serach-result.css">

</head>
<jsp:include page="/views/header.jsp" />


  <main class="main">

    <!-- 上部ツールバー -->
    <form method="get" action="${pageContext.request.contextPath}/productSerach">
  <div class="toolbar">
  <input type="hidden" name="keyword" value="${param.keyword}">
  
    <div>${products.size()} 件</div>

    <select name="order" onchange="this.form.submit()">
      <option value="name_desc" ${param.order == 'name_desc' ? 'selected' : ''}>五十音順 昇順</option>
      <option value="name_asc"  ${param.order == 'name_asc' ? 'selected' : ''}>五十音順 降順</option>
      <option value="price_desc" ${param.order == 'price_desc' ? 'selected' : ''}>価格高い順</option>
      <option value="price_asc" ${param.order == 'price_asc' ? 'selected' : ''}>価格低い順</option>
      
    </select>
  </div>
</form>

    <!-- 商品グリッド -->
    <div class="grid">

      <c:forEach var="p" items="${products}">
        
        <a class="card" href="${pageContext.request.contextPath}/productDetail?id=${p.id}">

          <!-- 画像 -->
          <c:if test="${p.imageUrl != null}">
            <img src="${pageContext.request.contextPath}${p.imageUrl}">
          </c:if>

          <!-- 名前 -->
          <div class="name">${p.name}</div>


          <!-- 価格 -->
          <div class="price">¥${p.price}</div>

        </a>

      </c:forEach>

    </div>

  </main>

</div>

<jsp:include page="/views/footer.jsp" />