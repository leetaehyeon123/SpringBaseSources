<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function mo(idx){
	var x=document.getElementsByClassName('modal'+idx);
	x[0].style.display='block';
}
function c(idx){
	var x=document.getElementsByClassName('modal'+idx);
	x[0].style.display='none';
}

</script>
</head>
<body>


<input type="button" value="모달 1" onclick="mo(1)">
<input type="button" value="모달 2" onclick="mo(2)">
<input type="button" value="모달 3" onclick="mo(3)">
<input type="button" value="모달 4" onclick="mo(4)">




	<!-- 모달 창 1 -->
	<div class="modal1 modal"  style="width: 100% ; height: 100vh ; background-color: black; position: fixed; left: 0px; top:0px; opacity: 0.3; display: none; ">
		<div class="modal1Div" style="width: 20%; height: 20vh; background-color: white; margin: 30vh auto; ">		
				<div	 style="height: 80%; width: 100%; text-align: center;">
							<p>모달창1입니다.</p>
				</div>
				<div 	style="width: 100%; text-align: right; ">
						<input type="button" value="닫기" style="margin-right: 10px;" onclick="c(1)">
				</div>		
		</div>
	</div>
	
	<!-- 모달 창 2 -->
	<div class="modal2 modal"  style="width: 100% ; height: 100vh ; background-color: green; position: fixed; left: 0px; top:0px; opacity: 0.3; display: none; ">
		<div class="modal1Div" style="width: 20%; height: 20vh; background-color: blue; margin: 30vh auto; ">		
				<div	 style="height: 80%; width: 100%; text-align: center;">
							<p>모달창 222222 입니다.</p>
				</div>
				<div 	style="width: 100%; text-align: right; ">
						<input type="button" value="닫기" style="margin-right: 10px;" onclick="c(2)">
				</div>		
		</div>
	</div>
	
	<!-- 모달 창 3 -->
	<div class="modal3 modal"  style="width: 100% ; height: 100vh ; background-color: blue; position: fixed; left: 0px; top:0px; opacity: 0.3; display: none; ">
		<div class="modal1Div" style="width: 20%; height: 20vh; background-color: orange; margin: 30vh auto; ">		
				<div	 style="height: 80%; width: 100%; text-align: center;">
							<p>모달창3333 입니다.</p>
				</div>
				<div 	style="width: 100%; text-align: right; ">
						<input type="button" value="닫기" style="margin-right: 10px;" onclick="c(3)">
				</div>		
		</div>
	</div>
	
	<!-- 모달 창 4 -->
	<div class="modal4 modal"  style="width: 100% ; height: 100vh ; background-color:purple; position: fixed; left: 0px; top:0px; opacity: 0.3; display: none; ">
		<div class="modal1Div" style="width: 20%; height: 20vh; background-color: red; margin: 30vh auto; ">		
				<div	 style="height: 80%; width: 100%; text-align: center;">
							<p>모달창 444444 입니다.</p>
				</div>
				<div 	style="width: 100%; text-align: right; ">
						<input type="button" value="닫기" style="margin-right: 10px;" onclick="c(4)">
				</div>		
		</div>
	</div>
</body>
</html>