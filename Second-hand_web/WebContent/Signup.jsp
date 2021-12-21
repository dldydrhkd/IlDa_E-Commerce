<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원 가입 페이지</title>
	<link rel="stylesheet" href="PageLayout.css">
	<style>
		header{
			background-color:#ff5f2e;
			padding:10px;
			font-family: Arial, "Trebuchet MS", sans-serif;
		}
		input{
			width: 100%;
			height: 51px;
			position: relative;
			border: solid 1px;
			padiding: 21px 0 17px;
		}
		#content{
			width:460px;
			margin:0 auto;
		}
		#container{
			margin: 0 auto;
			max-width: 768px;
		}
		button{
		
		width:30%;
		height:50px;
		padding: 8px 15px;
	    border-radius: 15px;
	    font-family: "paybooc-Light", sans-serif;
	    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
	    text-decoration: none;
	    font-weight: 500;
	    transition: 0.25s;
	    border: 3px solid #ff5f2e;
	    color: #6e6e6e;
	    margin-top: 20px;
		}
		
		button:hover {
		    background-color: #ff5f2e;
		    color: #e1eef6;
		}
	</style>
</head>
<script>
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
</script>
<body>
	<header>
		<h1 style="text-align:center">회원가입</h1>
	</header>
	<div class="div_container">
		<form method="post" action="signUpServlet">
		<div id="content">
			<h3>
				<label for="id">아이디</label>
			</h3>
			<span>
				<input type="text" id="id" name="id" placeholder="아이디">
			</span>
			<h3>
				<label for="password1">비밀번호</label>
			</h3>
			<span>
				<input type="password" id="pwd1" name="pwd1" placeholder="비밀번호" onChange="isSame()">
				<span id="check_pwd1"></span>
			</span>
			<h3>
				<label for="password2">비밀번호 재확인</label>
			</h3>
			<span>
				<input type="password" id="pwd2" name="pwd2" onChange="isSame()">
				<span id="check_pwd2"></span>
			</span>
			<h3>
				<label for="name">이름</label>
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
				<label for="address">주소</label>
			</h3>
			<span>
				<input type="text" name="address">
			</span>
			<h3>
				<label for="email">이메일</label>
			</h3>
			<span>
				<input type="email" name="email">
			</span>
			<h3>
				<label for="phone">핸드폰 번호</label>
			</h3>
			<span>
				<input type="tel" name="phone">
			</span>
			<h3>
			<br>
			</h3>
			<div align="center">
				<button class="submit" >탈퇴하기</button>
			</div>
		</div>
		</form>
	</div>
</body>
</html>

