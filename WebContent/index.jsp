<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.Map" %>
<%
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>
<form action="/docoTsubu/Login" method = "post">
ユーザー名：<input type = "text" name = "name"><br>
パスワード：<input type = "password" name = "pw"><br>
<input type ="submit" value="ログイン">
</form>
<a href= "/docoTsubu/Register">ユーザー登録</a>
</body>
</html>