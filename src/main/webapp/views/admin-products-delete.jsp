<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
</head>
<jsp:include page="/views/admin-header.jsp" />

<h1>この商品を削除しますか？</h1>

<form action="<%= request.getContextPath() %>/productDeleteSuccess" method="post">
    

    <p>商品名：${product.name}</p>
    
    <p>説明：${product.description}</p>

    <p>価格：${product.price}</p>

    <p>在庫：${product.stock}</p>
	

	<p>商品画像：<img src="${pageContext.request.contextPath}${product.imageUrl}" width="200"></p>
<input type="hidden" name="id" value="${product.id}">
    <button type="submit">削除</button>
</form>

<p></p>
<form>
    <input type="button" value="戻る" onclick="history.back();">
</form>

<script>
function confirmUpdate() {
    return confirm("本当に削除しますか？");
}
</script>


<jsp:include page="/views/footer.jsp" />