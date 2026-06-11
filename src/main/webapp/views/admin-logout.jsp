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


<p>ログアウトしますか？</p>
<p><a href="<%= request.getContextPath() %>/Logout.action">ログアウト</a></p>


<form>
    <input type="button" value="いいえ" onclick="history.back();">
</form>

<jsp:include page="/views/footer.jsp" />