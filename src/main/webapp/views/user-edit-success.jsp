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

<h1>修正登録完了</h1>

<form action="<%= request.getContextPath() %>/views/user-menu.jsp" method="post">
	<input type="submit" value="メニュー画面へ戻る">
</form>


<jsp:include page="/views/footer.jsp" />