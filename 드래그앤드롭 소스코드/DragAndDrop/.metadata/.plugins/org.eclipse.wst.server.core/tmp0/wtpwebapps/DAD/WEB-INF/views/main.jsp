<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ondragstart에서 ondragover로 이동한다. 이동할 아이는 draggable="true" 를 해줘야한다. -->
<style>
/* 드래그해 놓을 상자의 모양을 정합니다. 지금은 신경쓰지 않으셔도 됩니다. */
#div1,#div2 {width:100%;height:135px;padding:10px;border:1px solid #999;}
</style>
<script>
function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    ev.target.appendChild(document.getElementById(data));
    /*  */
    var div1Ch=document.getElementById("div1").childNodes;
    var div2Ch=document.getElementById("div2").childNodes;
    if(div1Ch[0].id.indexOf('dog')!=-1&&div1Ch[1].id.indexOf('dog')!=-1&&div1Ch[2].id.indexOf('dog')!=-1&&div1Ch[3].id.indexOf('dog')!=-1
    	    &&div2Ch[0].id.indexOf('cat')!=-1&&div2Ch[1].id.indexOf('cat')!=-1&&div2Ch[2].id.indexOf('cat')!=-1&&div2Ch[3].id.indexOf('cat')!=-1){
		location.href='page2';
        }
}
</script>
</head>
<body>
<h1>알 맞은 위치에 넣어 주세요</h1>
<br>강아지 사진
<div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<br>고양이 사진
<div id="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<br>
<div id="div3" ondrop="drop(event)" ondragover="allowDrop(event)">
<img id="dog2" src="resources/img/dog2.jpg" draggable="true" ondragstart="drag(event)" width="128" height="128">
<img id="dog1" src="resources/img/dog1.jpg" draggable="true" ondragstart="drag(event)" width="128" height="128">
<img id="cat3" src="resources/img/cat3.jpg" draggable="true" ondragstart="drag(event)" width="128" height="128">
<img id="cat4" src="resources/img/cat4.jpg" draggable="true" ondragstart="drag(event)" width="128" height="128">
<img id="cat2" src="resources/img/cat2.jpg" draggable="true" ondragstart="drag(event)" width="128" height="128">
<img id="dog3" src="resources/img/dog3.jpg" draggable="true" ondragstart="drag(event)" width="128" height="128">
<img id="dog4" src="resources/img/dog4.jpg" draggable="true" ondragstart="drag(event)" width="128" height="128">
<img id="cat1" src="resources/img/cat1.jpg" draggable="true" ondragstart="drag(event)" width="128" height="128">
</div>
</body>
</html>
