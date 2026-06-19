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


<h1>商品登録確認</h1>

<p>商品名：${name}</p>
<p>説明：${description}</p>
<p>価格：${price}</p>
<p>在庫：${stock}</p>
<p>チーム名：${team_name}</p>
<p>選手名：${player_name}</p>
<p>商品画像</p>
<img src="<%= request.getContextPath() %>/img/confirm/${imageFileName}" 
     alt="商品画像" 
     style="max-width:300px;">



<form action="<%= request.getContextPath() %>/productAddSuccess" method="post">
	<input type="hidden" name="name" value="${name}">
    <input type="hidden" name="description" value="${description}">
    <input type="hidden" name="price" value="${price}">
    <input type="hidden" name="stock" value="${stock}">
    <input type="hidden" name="team_id" value="${team_id}">
    <input type="hidden" name="player_id" value="${player_id}">
    <input type="hidden" name="image_file" value="${imageFileName}">
    <button type="submit">この内容で登録</button>
</form>


<form>
    <input type="button" value="戻る" onclick="history.back();">
</form>


<jsp:include page="/views/footer.jsp" />