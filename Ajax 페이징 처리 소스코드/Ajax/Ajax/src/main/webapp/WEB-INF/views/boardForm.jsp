<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%String id=(String)session.getAttribute("id"); %>
    <%
    ArrayList<HashMap<String,String>> list=(ArrayList<HashMap<String,String>>)request.getAttribute("list"); 
    int pageNum=Integer.parseInt((String)request.getParameter("pageNum"));
    int pageIdx=0;
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function insertReview(mode,i){	
		$.ajax({ 
		type: 'get' , 
		url: 'review?mode='+mode+'&reviewCon='+$('#reviewText'+i).val()+'&reviewId=<%=id%>&boardNum='+i ,
		success: function(data) { 
			$("#reviewDiv"+i).html(data); 
			} 
		}); 
		if(mode=='insert'){
		$('#reviewText'+i).val('');
		$('#reviewText'+i).focus();
		}
}
function enterKey(i){
	   if (window.event.keyCode == 13) {
			insertReview('insert',i);
      }
}



</script>
</head>
<body>
<input id="isLoadAll" type="hidden" value="false"> 
<%for(int i=list.size()-1; i>=0;i--) {pageIdx++;%>
	<% if(pageIdx<=pageNum*10) {%>
	<div style="width: 100%; border: 1px gray solid; margin-bottom: 5px; background-color: white;">
	<div style="border-bottom: 1px gray solid;margin: 3px;"><%=i%> . 작성자 : <%=list.get(i).get("boardId")%></div><!-- id -->
	<div style="border-bottom: 0.5px solid gray; width: 99%; margin: 0px auto;">
	<div style="margin: 3px;">[ 사 진 부 ]</div><!-- 사진  -->
	<div style="margin: 3px;"><%=list.get(i).get("boardCon")%></div><!-- 내용  -->
	</div>
	<div id='reviewDiv<%=i%>'></div><!-- 댓글 -->
	<div><!-- 댓글 달기 상자  -->
	<input id='reviewText<%=i%>' type="text" style="border:0px; border-top:1px solid black;" placeholder="댓글을 입력하세요" onkeydown="enterKey(<%=i%>)">
	<input id="reviewBtn" type="button" style="" value="작성" onclick="insertReview('insert','<%=i%>')">
	</div>
	</div>
	<script type="text/javascript">insertReview('select','<%=i%>')</script>
		<%if(i==0){%>
			<script type="text/javascript">$('#isLoadAll').val('true')</script>
			<div style="width: 100%; margin-bottom: 5px; text-align: center; ">마지막 게시글 입니다.</div>
		<%} %>
	<%}else{%>
	<script type="text/javascript">$('#isLoadAll').val('false')</script>
		<div style="width: 100%;  margin-bottom: 5px;text-align: center; "> <img src="resources/img/loadding.gif" alt="this slowpoke moves"  width=50/> </div>
	<%break;}%>
<%} %>

</body>
</html>