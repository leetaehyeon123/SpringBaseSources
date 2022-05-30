<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String id=(String)session.getAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
var pageNum=1;
var isLoadAll=false;
function loadBoard(mode){
	
	var con=$('#boardText').val();
	$.ajax({ 
	type: 'get' , 
	url: 'board?mode='+mode+'&boardCon='+con.replace(/\n/gi, '<br>')+'&boardId=<%=id%>&pageNum='+pageNum ,  /* num을 page2에 파라미터로 넣어서 page2에서 해당 댓글을 가져오도록 한다. */
	success: function(data) { 
		$("#boardDiv").html(data); /*  num을 div id에 넣어서 검색해서 버튼이 눌린 해당 게시글의 댓글div와 통신한다. */
		if($('#isLoadAll').val()=='true'){
			isLoadAll=true;
			}else{isLoadAll=false;}
		} 
	}); 	
	
}
function insertBoard(mode){
		loadBoard('insert');
		focusReset();	
}
window.onload = function () {
	loadBoard('select');
	focusReset();
	}
function focusReset(){
	$('#boardText').focus();
	$('#boardText').val("");
}
function shiftEnter(){
	if (event.which === 13 && event.shiftKey){
		insertBoard('insert');		
		}
}
$(document).ready(function(){ 
    $("#boardText").keydown(function (key) {
    	if (event.which === 13 && event.shiftKey){
    		insertBoard();		
    		return false;
    		}	
    });
});
$(window).scroll(function() {
    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
        if(!isLoadAll){
    	 	setTimeout(function() { 
       			 pageNum++;
    		 	loadBoard('select');
    		}, 500); 
        } 
   
    }
});


</script>

<div style=" margin: 0px auto; width: 60%;  "><!-- 전체 div -->

	<div style="width: 100%; text-align: right ;">
	<input type="button" value="모든 데이터 초기화 로그아웃" onclick="location.href='/ajax/'"><input type="button" value="모든 데이터 유지 로그아웃" onclick="location.href='login'">
	현제 로그인 id : <%=session.getAttribute("id")%></div>


	<div style="border: black 1px solid; width: 100%; height: 200px; margin:1vh 0px;  text-align: center;"><!-- 글작성 div  -->
	<span style="font-size: 20px;">게시글 작성</span><span style="font-size: 15px; color: gray"><br>( Shift+Enter 클릭시 게시 )</span>

		<textarea id="boardText"  style="border: black 1px solid; width: 90%; height: 100px;resize: none;" ></textarea><!-- 글 작성 text  -->
		<br>
		<input id="boardButton" type="button" value=" 작 성 " onclick="insertBoard()"  style=" font-size: 20px;" >
		

</div>

<div>

<div id="boardDiv" style="margin-bottom: 50px; "><!-- 게시글 div -->

</div>

</div>




</div>


</body>
</html>