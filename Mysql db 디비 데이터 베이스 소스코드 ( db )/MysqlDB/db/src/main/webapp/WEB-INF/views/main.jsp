<%@page import="com.th.vo.Vo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
window.onload=function(){
	document.getElementById('name').focus();
	conAjax('page1','','');
}

function conAjax(url,name,idx){	
	$.ajax({ 
	type: 'get' , 
	url: url+'?name='+name+"&idx="+idx ,
	success: function(data) { 
		$("#ajaxDiv").html(data); 
		} 
	});
}
function insert(){

	conAjax('insert.do',document.getElementById('name').value,'');


}
function insertKey(){
	if(event.keyCode==13){
		insert();
		}else{
		conAjax('page1',document.getElementById('name').value,'');
	}
}
</script>
</head>
<style>
body,input{font-size: 30px;
}
</style>
<body>
<div style="width: 70%; margin: 0px auto; text-align: center;">


<input type="text" id="name" name="name" placeholder="검색 (Enter클릭시 추가)" onkeyup="insertKey()" autocomplete="off"><input type="button" value="홈" onclick="location.href='/db/'">


<div id='ajaxDiv'></div>

</div>
</body>
</html>