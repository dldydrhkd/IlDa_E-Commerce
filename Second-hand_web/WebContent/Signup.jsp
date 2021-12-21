<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원 가입 페이지</title>
	<link rel="stylesheet" href="PageLayout.css">
	<link rel="stylesheet" href="Signup.css">
</head>
<script type="text/javascript">
function isSame(){	
	var pwd1=document.getElementById("pwd1").value;
	var pwd2=document.getElementById("pwd2").value;
	if(pwd1.length<6 || pwd1.length >16){
		document.getElementById("check_pwd1").innerHTML='비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.';
		document.getElementById("check_pwd1").style.color='red'
	}
	else{
		document.getElementById("check_pwd1").innerHTML='';
	}
	if(pwd1!='' && pwd2!=''){
		if(pwd1==pwd2){
			document.getElementById("check_pwd2").innerHTML='비밀번호가 일치합니다.';
			document.getElementById("check_pwd2").style.color="green";
		}
		else{
			document.getElementById("check_pwd2").innerHTML='비밀번호가 일치하지 않습니다.';
			document.getElementById("check_pwd2").style.color='red';
		}
	}
}

function check_value(){
	
	var form = document.userInfo;
	
	var userId = document.getElementById("id");
	var userPwd1 = document.getElementById("pwd1");
	var userPwd2 = document.getElementById("pwd2");
	var userName = document.getElementById("name");
	var userPhoneNumber = document.getElementById("phone");
	var userAddr = document.getElementById("address");
	var userEmail = document.getElementById("email");
	var isDuplication = document.getElementById("idDuplication");
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(userId.value==''){
		alert('아이디를 입력해주세요!')
		userId.focus();
		return false;
	}
	if(userPwd1.value==''){
		alert('비밀번호를 입력해주세요!');
		userPwd1.focus();
		return false;
	}
	if(userPwd2.value==''){
		alert('비밀번호를 입력해주세요!');
		userPwd2.focus();
		return false;
	}
	if(userPwd1.value!='' && userPwd2.value!='' && userPwd1.value!=userPwd2.value){
		alert('비밀번호를 동일하게 입력해주세요!');
		userPwd1.focus();
		return false;
	}
	if(userPhoneNumber.value==''){
		alert('핸드폰 번호를 입력해주세요!');
		userPhoneNumber.focus();
		return false;
	}
	if(userAddr.value==''){
		alert('주소를 입력해주세요!');
		userAddr.focus();
		return false;
	}
	if(idDuplication.value != "idCheck"){
		alert('아이디 중복체크를 해주세요!');
		userId.focus();
		return false;
	}
	if(isNaN(userPhoneNumber.value)){
		alert('핸드폰 번호를 제대로 입력해주세요!');
		userPhoneNumber.focus();
		return false;
	}
	if(userPhoneNumber.value.length!=11){
		alert('핸드폰 번호가 올바르지 않습니다!');
		userPhoneNumber.focus();
		return false;
	}
	if(userEmail.value!='' && email.value.match(regExp)==null){
		alert('잘못된 메일 주소 입니다!');
		userEmail.focus();
		return false;
	}
}

function goFirstForm() {
	location.href="MainPage.jsp";
}	

function openIdChk(){
	window.name = "parentForm";
	window.open("IdCheckForm.jsp", "chkForm", "width=500, height=300, resizable=no, scrollbars=no");
}

function inputIdChk(){
	document.getElementById("idDuplication").value="idUncheck";
}
	
</script>
<body>
	<header>
		<h1 style="text-align:center">회원가입</h1>
	</header>
	<div class="div_container">
		<form method="post" action="signUpServlet" onsubmit="return checkValue()">
		<div id="content"> 
			<h3>
				<label for="id">아이디 *</label>
			</h3>
			<span>
				<input type="text" id="id" name="id" placeholder="아이디" onkeydown="inputIdChk()">
			</span>
			<span>
				<input type="button" value="중복확인" onclick="openIdChk()">
			</span>
			<span>
				<input type="hidden" id="idDuplication" name="idDuplication" value="idUncheck">
			</span>
			<h3>
				<label for="password1">비밀번호 *</label>
			</h3>
			<span>
				<input type="password" id="pwd1" name="pwd1" placeholder="비밀번호" onChange="isSame()">
				<span id="check_pwd1"></span>
			</span>
			<h3>
				<label for="password2">비밀번호 재확인 *</label>
			</h3>
			<span>
				<input type="password" id="pwd2" name="pwd2" onChange="isSame()">
				<span id="check_pwd2"></span>
			</span>
			<h3>
				<label for="name">이름 *</label>
			</h3>
			<span>
				<input type="text" id="name" name="name">
			</span>
			<h3>
				<label for="date">생년월일</label>
			</h3>
			<span>
				<input type="date" id="date" name="date">
			</span>
			<h3>
				<label for="gender">성별</label>
			</h3>
			<span>
				<input style="width:4%" type="radio" name="gender" value="남" checked="checked" size="40">남자
				<input style="width:4%" type="radio" name="gender" value="녀" size="40">여자
			</span>
			<h3>
				<label for="address">주소 *</label>
			</h3>
			<span>
				<input type="text" id="address" name="address">
			</span>
			<h3>
				<label for="email">이메일</label>
			</h3>
			<span>
				<input type="email" name="email">
			</span>
			<h3>
				<label for="phone">핸드폰 번호 ('-'는 빼주세요.) *</label>
			</h3>
			<span>
				<input type="tel" name="phone">
			</span>
			<h3>
			<br>
			</h3>
			<div align="center">
				<input type="submit" value="가입하기">
				<input type="button" value="취소" onclick="goMainPage()">
			</div>
		</div>
		</form>
	</div>
</body>
</html>

