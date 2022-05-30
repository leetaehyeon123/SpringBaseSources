<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%HashMap<String,String> map =(HashMap<String,String>)request.getAttribute("map"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="" src='<%=map.get("picture")%>' width="300" height="300">
<h1>Email : <%=map.get("email") %></h1>

</body>
</html>