<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TECH.C.掲示板</title>
</head>
<body>
<h1>TECH.C.掲示板メイン</h1>
<p>
<c:out value="${loginUser.name}" />さん、ログイン中
<a href="/TECHC/Logout">ログアウト</a>
</p>
<p><a href="/TECHC/Main">更新</a></p>
<form action="/TECHC/Main" method="post">
<input type="text" name="text">
<input type="submit" value="投稿する">
</form>

<c:if test="${not empty errorMsg}">
	<p>${errorMsg}</p>
</c:if>
<c:forEach var="article" items="${articleList}">
	<p><c:out value="${article.userName}" />
	   <c:out value="${article.text}" /></p>
</c:forEach>
</body>
</html>