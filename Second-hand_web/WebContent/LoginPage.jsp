<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
.div_h1{ line-height: 200px; }

button{
	width: 120px;
	height: 40px;
	margin-left: 80px;
	border-radius: 20px;
}

input{
	width:350px;
	height: 40px;
}

table{	
	border-spacing: 20px; 
	margin-bottom: 20px;
}

td{
	height: 40px;
	font-size: large;
}


</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="div_h1">
		<h1 align="center"> 환영합니다.</h1>
	</div>


	<!-- 로그인 양식 -->	
	<div id="div_table" align="center">
		<table>
		<form action="loginServlet"  method="POST">
			<tr>
				<td><img src="login.png" alt="id" width="50" height="50"/> </td>
				<td><input type="text" name="userId" id="userId" placeholder="아이디를 입력하세요"></td>
			</tr>
			
			<tr>
				<td><img src="pwd.png" alt="id" width="50" height="50"/> </td>
				<td><input type="password" name="userPwd" id="userPwd" placeholder="비밀번호를 입력하세요"></td>
			</tr>
		</table>
	</div>
	
		<div class="div_button" align="center">
			<!-- 로그인 서블릿으로 아이디, 패스워드 보냄 -->	
			<button type="submit"> 로그인 </button>
			</form>
			
			<!-- 회원가입 페이지로 이동 -->                     
			<button type="button" onClick="location.href='Signup.jsp'"> 회원가입</button>
		</div>
	
</body>
</html>