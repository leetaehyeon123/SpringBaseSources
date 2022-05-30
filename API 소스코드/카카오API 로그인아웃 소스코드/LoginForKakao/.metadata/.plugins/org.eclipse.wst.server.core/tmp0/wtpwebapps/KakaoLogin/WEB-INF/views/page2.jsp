<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%HashMap<String,Object> map=(HashMap<String,Object>)request.getAttribute("map"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>회원정보 가져오기 성공 화면</h1>
  <hr />
  <h1>이름 : <%=map.get("nickname") %></h1>
  <h1 >이메일 : <%=map.get("email") %></h1>
  <h1  >생일 : <%=map.get("birthday") %></h1>
  <h1  >성별 : <%=map.get("gender") %></h1>

<input type="button" value=" 로 그 아 웃 " onclick="goo()" style="background-color: yellow; width: 50% ; margin: 0px auto;">
</body>
<script type="text/javascript">
function goo(){
	location.href='${logoutUrl}';
}

</script>
</html>