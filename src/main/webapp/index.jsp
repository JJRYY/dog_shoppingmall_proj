<%@page import="dog_shoppingmall_proj.ds.JndiDS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
Hello!!<br>
<%=JndiDS.getConnection() %><br>
<a href="dogList.do">개 리스트 보기</a>
</body>
</html>