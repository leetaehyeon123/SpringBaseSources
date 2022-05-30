<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
    <%
    String id=(String)session.getAttribute("id");
    String roomId=request.getParameter("roomId");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Insert title here</title>
</head>
<body>

<div style="border: black 1px solid;width: 50%; height: 7vh;margin: 20px auto 0px auto; ">
<h1>id:<%=id %></h1>
</div>

<div id="chatDiv" style="border: black 1px solid; border-bottom: 0px; border-top: 0px;width: 50%;  height: 70vh; margin: 0px auto 0px auto;  overflow: auto;">
<!-- 
여기서 컨트롤러에서 넘겨준 db데이터를 찍어주면 됨 
 -->

</div>

<div style="border: black 1px solid;border-top: 0px; width: 50%;height: 5vh; margin: 0px auto;text-align: center;">
<input id="message" type="text" onkeydown="enterKey()"><input id="sendBtn" type="submit" value="전송">
</div>

</body>


<!--(제이쿼리 사용,웹소켓 사용 <script/>) -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"   src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>

<!-- 스크립트부  -->
<script type="text/javascript">

//웹소켓 연결부
let sock = new SockJS("echo");/* 웹소켓 객체생성 (생성자에 만들어둔 Echohandler클래스의 매핑 url을 작성)*/
sock.onmessage = onMessage;/*상대 또는 본인  메시지 전송 감지시 자동 실행 메서드*/
sock.onclose = onClose;/* 메시지 연결 끊고 싶을때 실행하는 메서드 */


$("#sendBtn").click(function(){ /* 전송 버튼 눌렸을 시 */
   	 sendMessage();/* sendMessage메서드 호출 */
	 $('#message').val('')/* 메시지 입력상자 지우기 */
 });

function sendMessage() {/* 소켓을 통한 Echohandler에게 메시지 전송 */
	
	/* sock.send()를 통해 EchoHandler에게 값을 전달할 때
	 파라미터로 String 타입 하나를 받는다.
	하지만 우린 입력한 사람의 id와 방번호를 같이 보내서 디비에 저장할거다.
	그래서 필자는 json형태의 string으로 정보를 담아 보내기로 하였다 */
	var json={ "message" : $('#message').val() , "id" : '<%=id%>' , "roomId" : '<%=roomId%>'}; /* 우선 필요한 정보를 담은 json을 만들었고*/
    sock.send(JSON.stringify(json));/* 그 json을 String으로 변환 하여 보냈다. EchoHandler에서 받을때 json형태로 받아 값을 추출해서 디비에 저장할 것이다. */
    focusMe();
 }
function onMessage(msg){
		var json=JSON.parse(msg.data);//msg로 오는 데이터가 json형태의 문자열이 온다. 그문자열을  json 타입으로 바꾸어 roomId,id,message를 추출한다.
		
		  if(json.roomId == '<%=roomId%>'){ //이방이 맞다면
		         if(json.id != '<%=id%>'){//본인이 아니면 왼쪽 출력
		         $("#chatDiv").append("<p style='text-align:left'>" +json.id+" : "+ json.message + "</p>");
		         
		         } else if(json.id == '<%=id %>'){//본인이면 오른쪽 출력
		            $("#chatDiv").append("<p style='text-align:right'>" + json.message + "</p>");   
		         }
		      }
	      
		  scrollDrop();
}
function onClose(evt) {
   
 }

//편의기능 메서드 구현부
window.onload= windowLoaded();
function windowLoaded(){
   focusMe();
   scrollDrop();
}
function scrollDrop(){
   document.getElementById('chatDiv').scrollTop = document.getElementById('chatDiv').scrollHeight;
}
function focusMe(){
   document.getElementById('message').focus();
}

function enterKey() {
    if (window.event.keyCode == 13) {
   	sendMessage();
      $('#message').val('');
   
    }
}


</script>


</html>