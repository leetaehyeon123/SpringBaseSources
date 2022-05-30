<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><%=session.getAttribute("id") %>님 로그인 중</h1>
<input type="button" value="로그아웃" onclick="location.href='logout.do'">
</body>
</html>