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



<h1>商品登録に失敗しました。</h1>

<p><a href="<%= request.getContextPath() %>/views/admon-products-add.jsp">商品追加画面に戻る</a></p>


<jsp:include page="/views/footer.jsp" />