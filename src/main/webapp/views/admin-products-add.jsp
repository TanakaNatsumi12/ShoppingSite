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

<h1>商品追加フォーム</h1>

<form action="<%= request.getContextPath() %>/productAddConfirm" method="post" enctype="multipart/form-data">
	商品名：<input type="text" name="name" required><br><br>
    説明：<textarea name="description"></textarea><br><br>
    価格：<input type="number" name="price" required><br><br>
    在庫：<input type="number" name="stock" required><br><br>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<select name="team_id" id="teamSelect">
    	<c:forEach var="t" items="${teams}">
        	<option value="${t.id}">${t.name}</option>
    	</c:forEach>
	</select>
	
	<input type="hidden" name="team_name" id="teamName">
    
    <br><br>
    <input type="text"  id="playerSearch" placeholder="選手名を入力" required>
    <input type="hidden" name="player_id" id="playerId"> 
    <input type="hidden" name="player_name" id="playerName">

	<div id="playerSuggestions" class="suggestions"></div>
    
    <br><br>
    画像：<input type="file" name="image" required><br><br>
    
    
	
    <button type="submit">確認</button>
</form>

<form>
    <input type="button" value="戻る" onclick="history.back();">
</form>

<script>

document.addEventListener("DOMContentLoaded", function () {

    // =========================
    // ① チーム名（初期値も必ず入れる）
    // =========================
    const teamSelect = document.getElementById("teamSelect");
    const teamName = document.getElementById("teamName");

    function setTeamName() {
        teamName.value = teamSelect.options[teamSelect.selectedIndex].text;
    }

    // 初期表示でも必ずセット
    setTeamName();

    // 変更時も更新
    teamSelect.addEventListener("change", setTeamName);


    // =========================
    // ② 選手検索（履歴入力対策込み）
    // =========================
    const playerSearch = document.getElementById("playerSearch");
    const playerId = document.getElementById("playerId");
    const playerName = document.getElementById("playerName");
    const box = document.getElementById("playerSuggestions");

    playerSearch.addEventListener("input", function () {
        const keyword = this.value;

        // 手入力・履歴入力のたびに一旦リセット
        playerId.value = "";
        playerName.value = keyword;

        if (keyword.length < 2) {
            box.innerHTML = "";
            return;
        }

        fetch("<%= request.getContextPath() %>/searchPlayer?keyword=" + encodeURIComponent(keyword))
            .then(response => response.json())
            .then(players => {
                box.innerHTML = "";

                players.forEach(p => {
                    const div = document.createElement("div");
                    div.textContent = p.name;

                    div.addEventListener("click", function () {
                        playerSearch.value = p.name;
                        playerId.value = p.id;
                        playerName.value = p.name;
                        box.innerHTML = "";
                    });

                    box.appendChild(div);
                });
            });
    });

});
</script>

<jsp:include page="/views/footer.jsp" />