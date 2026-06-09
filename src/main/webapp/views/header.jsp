<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>


<header class="site-header">
	
	<div class="top-bar">
		<div class="top-links">
			<a href="<%= request.getContextPath() %>/views/login-in.jsp">ログイン</a>
			<a href="<%= request.getContextPath() %>/views/logout-in.jsp">ログアウト</a>
			<a href="">🛒</a>
		</div>
	</div>

	 <div class="middle-bar">
	 	<a href="<%= request.getContextPath() %>/views/user-menu.jsp">
			<div class="logo">
				<img src="https://jesterball.jp/blog/wp-content/uploads/2021/05/NBA%E3%83%AD%E3%82%B4.jpg" alt="NBA logo">
				Shopping Site
			</div>
  		</a>
    </div>
    
    
    <nav class="nav-bar">
    <a href="">新着商品</a>
    <a href="">ユニフォーム</a>
    <a href="">アパレル</a>
    <a href="">シューズ</a>
  </nav>
    
</header>





