<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/user-products-list.css">
</head>
<jsp:include page="/views/header.jsp" />

<form action="" method="post">

<h1>新着商品</h1>
<div class="grid">
	
        <c:forEach var="p" items="${products}">
            <a class="card" href="${pageContext.request.contextPath}/productDetail?id=${p.id}">
                <img src="${pageContext.request.contextPath}${p.imageUrl}">
                <div class="name">${p.name}</div>
                <div class="price">¥${p.price}</div>
            </a>
        </c:forEach>
</div>

<br></br>

<h2>選手から探す</h2>
<div class="grid2">

	
	 <a class="player"
       href="${pageContext.request.contextPath}/productSerach?keyword=レブロン">
        <img src="https://basket-count.com/wp-content/uploads/2023/12/leb1230.jpg">
        <div class="name">レブロン・ジェームズ</div>
    </a>
    
    <a class="player"
       href="${pageContext.request.contextPath}/productSerach?keyword=カリー">
        <img src="https://library.sportingnews.com/styles/twitter_card_120x120/s3/2021-12/stephen-curry-golden-state-warriors_d384mr62b6yd1na36bvk3feio.jpg?itok=Xbo4bgma">
        <div class="name">ステフィン・カリー</div>
    </a>
    
    <a class="player"
       href="${pageContext.request.contextPath}/productSerach?keyword=八村">
        <img src="https://the-ans.jp/wp-content/uploads/2023/02/25100423/20230225_hachimura_Reuters-650x433.jpg">
        <div class="name">八村塁</div>
    </a>
    
    <a class="player"
       href="${pageContext.request.contextPath}/productSerach?keyword=ウェンバンヤマ">
        <img src="https://sportsbull.jp/_next/image/?url=https%3A%2F%2Fimg.sportsbull.jp%2Fraw%2F2025100911441429580400.jpg%3Fcrop%3D16%3A9%2Csmart&w=3840&q=75">
        <div class="name">ビクター・ウェンバンヤマ</div>
    </a>
    
    <a class="player"
       href="${pageContext.request.contextPath}/productSerach?keyword=エドワーズ">
        <img src="https://news-pctr.c.yimg.jp/uUzvQ3lML_bkIqyakc1vFhNrRI0RUQxg5aFkrX0xDg1_T0wXrbEJjtNGtrf1o9y3d4vLMGMfd_NMMX0njtvxgJiP4DQDFQwSewlwVtFnI6LrQ16oMPfnD5BIOuuOwYQiUu90jDFZe_NmJJIbTLwDw-lYquyDl1uPZM2haaSnWiiMmv2TMCYR57YRLIiya52zOgc6IkvzqFba4qdM5T52Hg==">
        <div class="name">アンソニー・エドワーズ</div>
    </a>
    
    <a class="player"
       href="${pageContext.request.contextPath}/productSerach?keyword=ブランソン">
        <img src="https://basket-count.com/wp-content/uploads/2025/06/brs0602.jpg">
        <div class="name">ジェイレン・ブランソン</div>
    </a>
    
    <a class="player"
       href="${pageContext.request.contextPath}/productSerach?keyword=ヨキッチ">
        <img src="https://basketballking.jp/wp-content/uploads/2020/12/GettyImages-1198674816-500x375.jpg">
        <div class="name">二コラ・ヨキッチ</div>
    </a>
    
	<a class="player"
       href="${pageContext.request.contextPath}/productSerach?keyword=キャッスル">
        <img src="https://s.yimg.com/ny/api/res/1.2/u5lPXuGouBJVVZdjpf51Gg--/YXBwaWQ9aGlnaGxhbmRlcjt3PTY0MDtoPTQyNztjZj13ZWJw/https://media.zenfs.com/en/san_antonio_express_news_hearst_574/1064230a4027ed9bd2ccb8762d3b5373">
        <div class="name">ステフォン・キャッスル</div>
    </a>
    
    <a class="player"
       href="${pageContext.request.contextPath}/productSerach?keyword=カニングハム">
        <img src="https://newsatcl-pctr.c.yimg.jp/t/amd-img/20260224-00010003-sporting-000-1-view.jpg?pri=l&w=640&h=359&exp=10800">
        <div class="name">ケイド・カニングハム</div>
    </a>
    
    <a class="player"
       href="${pageContext.request.contextPath}/productSerach?keyword=ハリバートン">
        <img src="https://i.redd.it/l1jabogay13g1.jpeg">
        <div class="name">タイリース・ハリバートン</div>
    </a>
	
</div>

<h3>チームから探す</h3>
<div class="grid-team">

	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ホークス">
		<img src="https://m.media-amazon.com/images/I/9159yu0WkoL.jpg">
        <div class="name">アトランタ・ホークス</div>
	</a>

	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=セルティックス">
		<img src="https://images.www.basketball-zine.com/media/article/116798/images/main_image_ebbd77f4cdaa3cbad6df50b4c6508182714cc64f.jpg?w=850">
        <div class="name">ボストン・セルティックス</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ネッツ">
		<img src="https://m.media-amazon.com/images/I/71ZMOBSFAsL._AC_UY1000_.jpg">
        <div class="name">ブルックリン・ネッツ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ホーネッツ">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/30/logos/dark_bg_primary/03ef8492-7b62-4981-a469-bf1ca6e881b7.svg">
        <div class="name">シャーロット・ホーネッツ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=	ブルズ">
		<img src="https://fuuuta.com/wp-content/uploads/2021/06/478604D5-3248-4145-90F0-108A24B7E90E_1_102_o.jpeg">
        <div class="name">シカゴ・ブルズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=キャバリアーズ">
		<img src="https://gbaike-image.cdn.bcebos.com/42a98226cffc1e178a822ca019cbe103738da9774354/42a98226cffc1e178a822ca019cbe103738da9774354_url?x-bce-process=image/format,f_auto/resize,m_lfit,w_400,limit_1">
        <div class="name">クリーブランド・キャバリアーズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ピストンズ">
		<img src="https://upload.wikimedia.org/wikipedia/commons/c/c9/Logo_of_the_Detroit_Pistons.svg">
        <div class="name">デトロイト・ピストンズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ペイサーズ">
		<img src="https://nba-ism.com/wp-content/uploads/2022/10/indiana_pacers_logo.png">
        <div class="name">インディアナ・ペイサーズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ヒート">
		<img src="https://nba-ism.com/wp-content/uploads/2022/10/miami_heat_logo.png">
        <div class="name">マイアミ・ヒート</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=バックス">
		<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSPabU1AdDBvAeJVpSalldseKsC8jUPxs3KA&s">
        <div class="name">ミルウォーキー・バックス</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ニックス">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/18/logos/dark_bg_primary/21c1ac8e-7d32-4916-aa19-6a6f724eabaf.svg">
        <div class="name">ニューヨーク・ニックス</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=マジック">
		<img src="https://gbaike-image.cdn.bcebos.com/a08b87d6277f9e2f07081b36d46afe24b899a90155c0/a08b87d6277f9e2f07081b36d46afe24b899a90155c0_3_2?x-bce-process=image/format,f_auto">
        <div class="name">オーランド・マジック</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=シクサーズ">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/20/logos/dark_bg_primary/cbb6389e-701d-4cf4-acdf-35ac303cc926.svg">
        <div class="name">フィラデルフィア・セブンティシクサーズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ラプターズ">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/28/logos/dark_bg_primary/cb3de629-8668-4ad9-8efa-70333398976b.svg">
        <div class="name">トロント・ラプターズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ウィザーズ">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/27/logos/dark_bg_primary/cec62c6e-c1f4-4a8b-a6dc-3e5499891e0f.svg">
        <div class="name">ワシントン・ウィザーズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=マーベリックス">
		<img src="https://nba-ism.com/wp-content/uploads/2022/10/dallas_mavericks_logo.png">
        <div class="name">ダラス・マーベリックス</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ナゲッツ">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/7/logos/dark_bg_primary/1070fe0e-36f9-4e92-8dd5-4338f3d7f11e.svg">
        <div class="name">デンバー・ナゲッツ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ウォリアーズ">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/9/logos/dark_bg_primary/018ec5cd-4eb2-4b63-8ab2-a8f82288725d.svg">
        <div class="name">ゴールデンステイト・ウォリアーズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ロケッツ">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/10/logos/dark_bg_primary/9cc80899-455a-47f6-8e5a-8f04c6facf03.svg">
        <div class="name">ヒューストン・ロケッツ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=クリッパーズ">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/12/logos/dark_bg_primary/9667ae32-bb72-462c-a71f-0c154d8196dd.svg">
        <div class="name">ロサンゼルス・クリッパーズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=レイカーズ">
		<img src="https://stat.nba.docomo.ne.jp/community-threads/13/comment-images/abc50c43-20a2-4b4b-819f-e4deee3535de.png">
        <div class="name">ロサンゼルス・レイカーズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=グリズリーズ">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/29/logos/dark_bg_primary/4dbe394d-e7df-46a9-8bc4-a1e24d40746f.svg">
        <div class="name">メンフィス・グリズリーズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ウルブズ">
		<img src="https://m.media-amazon.com/images/I/91UFommKtoL._AC_UF894,1000_QL80_.jpg">
        <div class="name">ミネソタ・ティンバーウルブズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ペリカンズ">
		<img src="https://cdn.iconscout.com/icon/free/png-256/free--logo-icon-svg-download-png-1593214.png?f=webp">
        <div class="name">ニューオリンズ・ペリカンズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=サンダー">
		<img src="https://f1world.net/wp/wp-content/uploads/2024/09/Nba_WesternConfarence_Emblem_2022-2023_OklahomaCity-Thunder2.jpg">
        <div class="name">オクラホマシティ・サンダー</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=サンズ">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/21/logos/dark_bg_primary/f1fdb8ae-d6eb-409a-a397-d2a0fc0f56f7.svg">
        <div class="name">フェニックス・サンズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ブレイザーズ">
		<img src="https://upload.wikimedia.org/wikipedia/commons/9/93/TrailBlazers.png">
        <div class="name">ポートランド・トレイルブレイザーズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=キングス">
		<img src="https://stat.nba.docomo.ne.jp/uploads/teams/23/logos/dark_bg_primary/2a63a325-3cfb-4aa9-a1d1-ed6bfa236544.svg">
        <div class="name">サクラメント・キングス</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=スパーズ">
		<img src="https://www.nbastore.jp/content/ws/61050/NBA_San_Antonio_Spurs_logo.png">
        <div class="name">サンアントニオ・スパーズ</div>
	</a>
	
	<a class="team-card"
	href="${pageContext.request.contextPath}/productSerach?keyword=ジャズ">
		<img src="https://i.namu.wiki/i/VU6Pwz-wGenIcWC8yo_VkrFQOZjghBg3WmE_7McxrcTdSxv759YSbfwKTkmID9PTarxGPBtsQYgtzLgBfi9dGg.svg">
        <div class="name">ユタ・ジャズ</div>
	</a>

</div>

<jsp:include page="/views/footer.jsp" />