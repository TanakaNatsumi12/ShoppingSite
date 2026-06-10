<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>

<header class="site-header">

<div class="top-bar">
		<div class="top-links">
			<a href="<%= request.getContextPath() %>/views/logout-in.jsp">ログアウト</a>
		</div>
	</div>

	 <div class="middle-bar">
	 	<a href="<%= request.getContextPath() %>/views/admin-menu.jsp">
			<div class="logo">
				<img src="https://jesterball.jp/blog/wp-content/uploads/2021/05/NBA%E3%83%AD%E3%82%B4.jpg" alt="NBA logo">
				管理者サイト
			</div>
  		</a>
    </div>

</header>