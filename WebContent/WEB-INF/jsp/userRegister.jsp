<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.Mutter" %>
<%
//リクエストスコープに保存されたメッセージを取得
String message = (String) request.getAttribute("message");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<form action="/docoTsubu/Register" method = "post">
ユーザー名：<input type = "text" name = "newuser"><br>
パスワード：<input type = "text" name = "newpw"><br>
<input type ="submit" value="登録">
</form>
<%
if (message != null){ %>
	<p><%= message %></p>
<% }%>
<a href= "/docoTsubu/">戻る</a>
</body>
</html>