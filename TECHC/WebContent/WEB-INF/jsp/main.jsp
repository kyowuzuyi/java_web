<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.Article" %>
  <%@ page import="model.User" %>
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="java.util.List" %>
 <% User user = (User) session.getAttribute("user"); %>
 <% List<Article> showMeg = (List<Article>) request.getAttribute("ShowMeg"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>TECHC掲示板メイン</h1>
<%= user.getName() %>さん、ログイン中
<br>
<a href="/TECHC/Logout">ログアウト</a>
<br>
<a href="/TECHC/Main">更新</a>
<form action="/TECHC/Main" method="post">
<input type="text" name="putMessage">
<input type="submit" value="投稿する">
</form>


<p>
<%for(Article ListElem: showMeg){ %>
<%=ListElem.getUserName() %>
<%=ListElem.getText() %>
<br>
<%} %>
</p>


</body>
</html>