<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
img{
width: 310px;
height: 60px;
cursor: pointer;
margin: 5px;
}
div{
width: 70%;
margin: 100px auto;
text-align: center;
}
</style>

<script type="text/javascript">
function kakaoLogin(){
	location.href='<%=request.getAttribute("kakaoLoginUrl")%>'
}
function googleLogin(){
	location.href='<%=request.getAttribute("googleLoginUrl")%>'
}
function naverLogin(){
	location.href='<%=request.getAttribute("naverLoginUrl")%>'
}
function facebookLogin(){
	location.href='<%=request.getAttribute("faceLoginUrl")%>'
}

</script>

</head>
<body>

<div>
<img  src="resources/img/kakao.png" onclick="kakaoLogin()"><br>
<img  src="resources/img/google.png" onclick="googleLogin()"><br>
<img  src="resources/img/naver.png" onclick="naverLogin()"><br>
<img  src="resources/img/facebook.png" onclick="facebookLogin()">
</div>

</body>
</html>