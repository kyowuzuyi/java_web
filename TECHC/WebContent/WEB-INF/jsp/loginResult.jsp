<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% Boolean megResult=(Boolean)request.getAttribute("megResult"); %>
<% User user = (User) session.getAttribute("user"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<h1>TECH.C掲示板ログイン</h1>


<% if(megResult==true) { %>
<p>
ログインに成功しました
</p>
<p>
ようこそ<%=user.getName() %>さん
</p>
<a href="/TECHC/Main">記事投稿閲覧へ</a>
<% }else { %>

<p>
ログインに失敗しました
</p>
<a href="/TECHC/index.jsp">トップへ</a>
<% }%>

</body>
</html>