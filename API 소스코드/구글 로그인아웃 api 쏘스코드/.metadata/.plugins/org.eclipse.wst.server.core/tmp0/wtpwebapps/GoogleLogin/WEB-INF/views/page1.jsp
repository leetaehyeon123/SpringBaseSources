<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function goLogin(){

	location.href="https://accounts.google.com/o/oauth2/auth?client_id="+
		"420375394905-l10l1bm0oshs9oogmn90c187d73jl9e6.apps.googleusercontent.com"+
		"&redirect_uri="+
		"http://localhost:4520/google/login.do" +
		"&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email&approval_prompt=force&access_type=offline";
	
}

</script>
</head>
<body>

<img alt="" src="https://developers.google.com/identity/images/btn_google_signin_dark_normal_web.png?hl=ko" onclick="goLogin()">
</body>
</html>