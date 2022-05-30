<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
 <%ArrayList<String> review=(ArrayList<String>)request.getAttribute("review"); %>
 <!-- 댓글 정보 가져와서 뿌려주기만 한다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Insert title here</title>
</head>
<body>
<%for (int i=0; i<review.size();i++){ %>
<h3><%=review.get(i) %></h3>
<%} %>
</body>
</html>