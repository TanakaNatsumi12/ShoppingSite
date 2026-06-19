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
    <div class="toolbar">
      <div>${products.size()} 件</div>

      <select>
        <option>おすすめ順</option>
        <option>価格順</option>
      </select>
    </div>

    <!-- 商品グリッド -->
    <div class="grid">

      <c:forEach var="p" items="${products}">
        
        <div class="card">

          <!-- 画像 -->
          <c:if test="${p.imageUrl != null}">
            <img src="${pageContext.request.contextPath}${p.imageUrl}">
          </c:if>

          <!-- 名前 -->
          <h3>${p.name}</h3>

          <!-- 説明 -->
          <p>${p.description}</p>

          <!-- 価格 -->
          <p class="price">¥${p.price}</p>

        </div>

      </c:forEach>

    </div>

  </main>

</div>

<jsp:include page="/views/footer.jsp" />