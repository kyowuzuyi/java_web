<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User,model.Article,java.util.List" %>
<%
// セッションスコープに保存されたユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
// リクエストスコープに保存された記事リストを取得
List<Article> articleList = (List<Article>) request.getAttribute("articleList");
// リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TECH.C.掲示板</title>
</head>
<body>
<h1>TECH.C.掲示板メイン</h1>
<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="/TECHC/Logout">ログアウト</a>
</p>
<p><a href="/TECHC/Main">更新</a></p>
<form action="/TECHC/Main" method="post">
<input type="text" name="text">
<input type="submit" value="投稿する">
</form>
<% if(errorMsg != null) { %>
<p><%= errorMsg %></p>
<% } %>
<% for(Article article : articleList) { %>
<p><%= article.getUserName() %>:<%= article.getText() %></p>
<% } %>
</body>
</html>