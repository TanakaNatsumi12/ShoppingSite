<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/ShoppingSite/loginServlet" method="post">
<p>ID  <input type="text" name="memberId"></p>
<p>パスワード  <input type="password" name="password"></p>
<p><input type="submit" value="ログイン"></p>
</form>

<form action="" method="get">
  <p><input type="submit" value="新規登録"></p>
</form>

</body>
</html>