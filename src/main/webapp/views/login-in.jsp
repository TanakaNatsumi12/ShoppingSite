<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/login-in.css">

</head>


<jsp:include page="/views/header.jsp" />


<body class="login-center">



<div class="login-box">
<h1>ログイン画面</h1>

	<form action="/ShoppingSite/loginServlet" method="post" >
		<p>　　　　ID <input type="text" name="memberId" required pattern="[a-zA-Z0-9]+" title="半角英数字のみ"></p>
		
		
		<div class="password-wrapper">
			<p>パスワード  
			<input type="password" name="password" id="password" required pattern="[a-zA-Z0-9]+" title="半角英数字のみ">
		 	<span class="password-toggle" id="togglePassword" >👁</span>
		 	</p> 
		</div>
		<p><input type="submit" value="ログイン"></p>
	</form>

	<form action="/ShoppingSite/views/user-add.jsp" method="post">
  		<p><input type="submit" value="新規登録"></p>
	</form>
</div>

<script>
document.getElementById("togglePassword").addEventListener("click", function() {
    const pw = document.getElementById("password");
    const isText = pw.type === "text";
    pw.type = isText ? "password" : "text";
});
</script>
<jsp:include page="/views/footer.jsp" />