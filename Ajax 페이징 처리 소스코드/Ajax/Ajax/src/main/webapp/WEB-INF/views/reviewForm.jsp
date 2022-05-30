<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%ArrayList<HashMap<String,String>> list=(ArrayList <HashMap<String,String>>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
댓글(<%=list.size() %>)
<%for(int i=0;i<list.size();i++){ %>
<br><%=list.get(i).get("reviewId")%> : <%=list.get(i).get("reviewCon") %>
<%} %>
</body>
</html>