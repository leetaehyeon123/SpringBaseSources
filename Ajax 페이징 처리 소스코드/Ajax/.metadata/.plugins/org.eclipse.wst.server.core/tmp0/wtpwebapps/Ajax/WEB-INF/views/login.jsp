<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width: 100%; text-align: center; font-size: 20px;">
<br>
사용할 아이디 입력
<form action="loginSub">
<input id="idText" type="text" name="id" placeholder="아이디" style="font-size: 20px; margin: 20px;"><br>
<input type="submit" value="로그인" style="font-size: 20px;">
</form>
</div>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
window.onload=function (){
	$("#idText").focus();
}


</script>
</body>
</html>