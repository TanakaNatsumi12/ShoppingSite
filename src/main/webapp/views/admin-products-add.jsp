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

<form action="<%= request.getContextPath() %>/productAddConfirm" method="post">
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
    <input type="text"  id="playerSearch" placeholder="選手名を入力">
    <input type="hidden" name="player_id" id="playerId"> 
    <input type="hidden" name="player_name" id="playerName">

	<div id="playerSuggestions" class="suggestions"></div>
    
    <br><br>
    画像：<input type="file" name="image"><br><br>
    
    
	
    <button type="submit">登録</button>
</form>

<form>
    <input type="button" value="戻る" onclick="history.back();">
</form>

<script>

document.getElementById("teamSelect").addEventListener("change", function() {
         const selectedText = this.options[this.selectedIndex].text;
         document.getElementById("teamName").value = selectedText; // ★チーム名を hidden に入れる
            });
                        
document.getElementById("playerSearch").addEventListener("input", function() {
    const keyword = this.value;

    if (keyword.length < 2) {
        document.getElementById("playerSuggestions").innerHTML = "";
        return;
    }

    fetch("<%= request.getContextPath() %>/searchPlayer?keyword=" + encodeURIComponent(keyword))
        .then(response => response.json())
        .then(players => {
            const box = document.getElementById("playerSuggestions");
            box.innerHTML = "";

            

            players.forEach(p => {
                const div = document.createElement("div");
                div.textContent = p.name;
                div.addEventListener("click", function() {
                    document.getElementById("playerSearch").value = p.name;
                    document.getElementById("playerId").value = p.id;
                    document.getElementById("playerName").value = p.name;
                    box.innerHTML = "";
                });
                box.appendChild(div);
            });
        });
});
</script>

<jsp:include page="/views/footer.jsp" />