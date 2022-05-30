<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Insert title here</title>
</head>
<body>
<div style="margin: 0px auto; width:50%;">
<form action=${kakao_url} method="get">
<input type="button" onclick="location.href='${kakao_url}'" value=" 카 카 오 로 그 인 "  style="width: 100%; padding: 10px; background-color: yellow;"></form>
</div>
</body>
</html>