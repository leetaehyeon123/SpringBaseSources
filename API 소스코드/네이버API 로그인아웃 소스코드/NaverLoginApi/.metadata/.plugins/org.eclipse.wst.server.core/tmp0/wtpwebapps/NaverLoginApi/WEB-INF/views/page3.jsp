<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%		 Cookie[] cookies = request.getCookies() ;
    
	    if(cookies != null){
	        for(int i=0; i < cookies.length; i++){
	             
	            // 쿠키의 유효시간을 0으로 설정하여 만료시킨다
	            cookies[i].setMaxAge(0) ;
	             
	            // 응답 헤더에 추가한다
	            response.addCookie(cookies[i]) ;
	        }
	    } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  window.onload= function(){
	location.href='http://localhost:4520/Naver/';
}  
</script>
</head>
<body>


</body>
</html>