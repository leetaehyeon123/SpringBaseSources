<%@page import="com.th.vo.Vo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%ArrayList<Vo> list=(ArrayList<Vo>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
window.onload=function(){
	document.getElementById('name').focus();
}
var val="";
var indx=-1;
var listSize=<%=list.size()%>
function goUpdate(i){
	var name=document.getElementById('name'+i).value;
	conAjax('update.do',name+'&searchName=<%=request.getParameter("name")%>',document.getElementById('idx'+i).value);
	
}
function goDelete(i){
	conAjax('delete.do','<%=request.getParameter("name")%>',document.getElementById('idx'+i).value);
}

function cancelUpdate(){
	if(document.getElementById('name'+indx)){
		
		document.getElementById('name'+indx).value=val;
	
		for(i=0;i<listSize;i++){
			document.getElementById('name'+i).disabled="disabled";
			document.getElementById('name'+i).style.border="0px";
			document.getElementById('btn1_'+i).value="수정";
			document.getElementById('btn1_'+i).setAttribute("onclick","update("+i+")");
			document.getElementById('btn2_'+i).value="삭제";
			document.getElementById('btn2_'+i).setAttribute("onclick","goDelete("+i+")");
			}
		
	}
}

function update(i){
	cancelUpdate();
	val=document.getElementById('name'+i).value;
	indx=i;
	document.getElementById('name'+i).disabled="";
	document.getElementById('name'+i).value="";
	document.getElementById('name'+i).setAttribute("placeholder",val);
	document.getElementById('name'+i).style.border="1px solid black";
	document.getElementById('name'+i).focus();
	document.getElementById('btn1_'+i).value="확인";
	document.getElementById('btn1_'+i).setAttribute("onclick","goUpdate("+i+")");
	document.getElementById('btn2_'+i).value="취소";
	document.getElementById('btn2_'+i).setAttribute("onclick","cancelUpdate()");
}
function updateEnterKey(i){
	if(event.keyCode==13){
	goUpdate(i);
	}
}

</script>
</head>
<style>
body,input{font-size: 30px;
}
</style>

<%for(int i=0;i<list.size(); i++){ %>

	번호:<%=list.get(i).getIdx()%> 이름:<input id='name<%=i%>' name="name" type="text"  value='<%=list.get(i).getName() %>' disabled="disabled" style="border:0px;width: 20%;" onkeydown='updateEnterKey(<%=i%>)'> 
	<input id='btn1_<%=i %>' type="button" value="수정"  onclick='update(<%=i%>)'>
	<input id='btn2_<%=i %>' type="button" value="삭제"  onclick='goDelete(<%=i%>)'><br>
	<input id='idx<%=i%>' type="hidden" value="<%=list.get(i).getIdx()%>">

<%} %>

</body>
</html>