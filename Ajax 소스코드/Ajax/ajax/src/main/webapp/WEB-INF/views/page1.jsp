<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Insert title here</title>
</head>
<body>
<h1>hi</h1>

<%for(int i=0;i<10;i++){ %><!-- 임의로 10개의 개시글을 생성한다.  -->
<div style="margin: 10px; background-color: gray; height: 300px; width: 100%;">
<h1><%=i+1 %>번째 게시글 내용</h1>
<div id='listDiv<%=i%>'></div><!-- ajax 통신을 통해 댓글이 들어갈 div의 id값에 i를 넣어 준다. 밑에 스크립트에서 찾아올 수 있기 위해 -->
<input type="button" id='listButton' onclick='getR(<%=i%>)' value="댓글 작성" /><!-- onclick시 인자로 게시글번호를 넣어준다. -->
</div>
<%}%>

</body>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function getR(num){	/* 버튼 클릭시 호출된다.  */
		$.ajax({ 
		type: 'get' , 
		url: 'page2?boardNum='+num ,  /* num을 page2에 파라미터로 넣어서 page2에서 해당 댓글을 가져오도록 한다. */
		success: function(data) { 
			$("#listDiv"+num).html(data); /*  num을 div id에 넣어서 검색해서 버튼이 눌린 해당 게시글의 댓글div와 통신한다. */
			} 
		}); 
}
</script>


</html>