<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String loginUrl=(String)request.getAttribute("loginUrl"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.logBtn {
width: 50%;
margin: 50px auto;
text-align: center;
}
</style>
</head>
<body>
<div class="logBtn">
 <a href='<%=loginUrl%>'><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
</div>
</body>
</html>