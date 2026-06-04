<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<jsp:include page="/views/header.jsp" />

<h1>新規会員登録</h1>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>


<form action="/ShoppingSite/userAddConfirmServlet" method="post" >
<p>ユーザーID： <input type="text" name="memberId" value="${memberId}" required pattern="[a-zA-Z0-9]+" title="半角英数字のみ">半角英数字</p>
<p>パスワード： <input type="text" name="password" value="${password}" required pattern="[a-zA-Z0-9]+" title="半角英数字のみ">半角英数字</p>
<p>名前（姓）： <input type="text" name="lastName" value="${lastName}" required></p>
<p>名前（名）： <input type="text" name="firstName" value="${firstName}" required></p>
<p>住所： <input type="text" name="address" value="${address}" required></p>
<p>メールアドレス： <input type="email" name="mailAddress" value="${mailAddress}" required></p>

<input type="submit" value="確認">
<input type="reset" value="リセット">
</form>





<jsp:include page="/views/footer.jsp" />