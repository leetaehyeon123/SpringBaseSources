<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%HashMap<String,String> map =(HashMap<String,String>)request.getAttribute("map"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function logout(){

location.href='logout.do';

}
</script>
</head>
<body>
<img src='<%=map.get("profile_image")%>' height="100" width="100"/>
<p>닉네임 : <%=map.get("nickname") %></p>
<p>성별 : <%=map.get("gender") %></p>
<p>이메일 : <%=map.get("email") %></p>
<p>이름 : <%=map.get("name") %></p>
<p>생일 : <%=map.get("birthday") %></p>

<input type="button" value="로그아웃" onclick="logout()">
</body>
</html>