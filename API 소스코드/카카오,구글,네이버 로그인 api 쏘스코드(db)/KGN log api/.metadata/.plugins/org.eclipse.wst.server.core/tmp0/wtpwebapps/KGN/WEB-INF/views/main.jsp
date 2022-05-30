<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function logout(){
	location.href='logout.do'
}

</script>
<div style="width: 100%; text-align: center;">
<h1>메인 화면</h1>
<input type="button" value=" 로 그 아 웃 " onclick="logout()">

<h1>아이디 인덱스 번호 : <%=session.getAttribute("IdIdx")%></h1>

</div>
</body>
</html>