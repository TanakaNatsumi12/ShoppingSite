<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
</head>
<jsp:include page="/views/admin-header.jsp" />

<h1>商品編集</h1>

<form action="<%= request.getContextPath() %>/productsEditUpdate" method="post" enctype="multipart/form-data" onsubmit="return confirmUpdate()">
    <input type="hidden" name="id" value="${product.id}">

    <p>商品名：
        <input type="text" name="name" value="${product.name}">
    </p>
    
    <p>説明：
    <textarea name="description">${product.description}</textarea>
	</p>

    <p>価格：
        <input type="number" name="price" value="${product.price}">
    </p>

    <p>在庫：
        <input type="number" name="stock" value="${product.stock}">
    </p>
    
	<select name="team_id" id="teamSelect">
    <c:forEach var="t" items="${teams}">
        <option value="${t.id}"
            <c:if test="${t.id == product.teamId}">selected</c:if>>
            ${t.name}
        </option>
    </c:forEach>
	</select>
	
	
	
	<input type="hidden" name="team_name" id="teamName">
	
	 <br><br>
    <input type="text"  id="playerSearch" placeholder="選手名を入力" value="${product.playerName}" required>
    <input type="hidden" name="player_id" id="playerId" value="${product.playerId}">
    <input type="hidden" name="player_name" id="playerName" value="${product.playerName}">

    <div id="playerSuggestions" class="suggestions"></div>

	<p>画像：
    <input type="file" name="image">
	</p>

<input type="hidden" name="current_image" value="${product.imageUrl}">

<p>現在の画像：<img src="${pageContext.request.contextPath}${product.imageUrl}" width="200"></p>



    <button type="submit">更新</button>
</form>

<p></p>
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

function confirmUpdate() {
    return confirm("本当に更新しますか？");
}

</script>

<jsp:include page="/views/footer.jsp" />
