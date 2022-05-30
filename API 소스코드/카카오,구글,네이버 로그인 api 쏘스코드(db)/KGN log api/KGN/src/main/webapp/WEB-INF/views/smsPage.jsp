<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
input{
	margin: 5px;
	font-size: 20px;
	
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function smsDo(t){
	var tt=t.form;
	
		$.ajax({ 
			type: 'get' , 
			url: 'smsPage.do?to='+t.form.phoneNum.value		
		});

		tt.phoneNum.setAttribute('readonly','readonly');
		tt.phoneNumBtn.setAttribute('disabled','disabled');
		tt.code.focus();
		
}

function isCode(t){
	var tt=t.form;
		$.ajax({ 
			type: 'get' , 
			url: 'smsIsCode.do?code='+tt.code.value	,
			success: function(data) { 
				if(data=='true'){
					tt.code.setAttribute('readonly','readonly');
					tt.codeBtn.setAttribute('disabled','disabled');
					tt.nextBtn.removeAttribute('disabled')
					tt.nextBtn.style.backgroundColor="#61e5ff";
					tt.codeBtn.value='인증완료'
					}else if(data=='false'){
						alert("인증 코드 틀림");
						tt.phoneNumBtn.removeAttribute('disabled');
						tt.phoneNumBtn.value="인증번호 재전송"
					}
				} 	
		});
}


</script>
</head>
<body>

<div style="width: 100%; text-align: center;">
<h1>본인인증</h1>
<p>처음 소셜 로그인시 휴대폰 인증 합니다.</p>
<p>같은 휴대폰 번호로 인증한 계정은 자동 연동 됩니다.</p>
<form action="signIn.do">
	<input name="platform" type="hidden" value='<%=session.getAttribute("platform") %>'>
	<input name="email" type="hidden" value='<%=session.getAttribute("email") %>'>
	<input name="phoneNum" type="text" placeholder="전화 번호"  ><br>
	<input name="phoneNumBtn" type="button" value="인증번호 전송"  onclick="smsDo(this)"><br>

	<input name="code" type="text" placeholder="인증번호 입력"><br>
	<input name="codeBtn" type="button" value="인증번호 확인"  onclick="isCode(this)"><br>
	<input name="nextBtn" type="submit" value="다음" disabled="disabled" >
</form>
</div>

</body>
</html>