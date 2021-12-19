<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<style>

.div_root{
	margin:auto;
	width:800px;
}
.div_logo{
	width:30%;
	
	float:left;
	text-align: left;
}
.div_search{
	float:left;
	margin-top: 15%;
	width: 40%;
}

.div_sign{

	width:15%;
	float: right;
}

.div_sign button{
	padding: 8px 15px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 500;
    transition: 0.25s;
    border: 3px solid #ff5f2e;
    color: #6e6e6e;
}

.div_sign button:hover {
    background-color: #ff5f2e;
    color: #e1eef6;
}

.Search_btn{
	border: 3px solid aliceblue;
    color: orange;
}


input {
  width:100%;
  border-color: #bbb;
  border-radius: 16px;
  border-width: 1px;
  padding: 12px 20px 12px 20px;
  margin: 6px;
  font-family: fontAwesome;
}

.fa-search {
  position:absolute;
  right: 360px;
  top: 215px;
  margin:0;
}

.div_search button{
	padding: 0;
	border: 0;
	outline: 0;
}

  

</style>
<head>
<meta charset="UTF-8">
<title>BannerPage</title>
</head>
<body>
	<!-- 로고 영역 -->
	<div class="div_root"></div>
	
	<div class="div_logo">
		<h1 class ="log-title">
			<a href = MainPage.jsp > <!-- 로고 누르면 메인으로 이동 -->
				<img id="Logo_img" src="Logo.png" alt = "logo" width ="250"/>
			</a>
		</h1>
	</div>
	
	<!-- 검색창 영역 -->
	<div class="div_search" >
    	<form method="get" action ="Search"> 	 
      		<input type="text" name="Search" id="Search" placeholder="검색어를 입력해 주세요.">
      		<button class="Search_btn" id="Search" ><i class="fas fa-search fa-2x"></i></button>
      	</form>
    </div>
	
	<!-- 로그인/회원가입 영역 -->
	<div class= "div_sign">
		<!-- 버튼 누르면 로그인페이지로 이동 -->
		<button type="button" id ="Sign" onClick="location.href='LoginPage.jsp'"> 로그인/회원가입  </button>
	</div>
	
	
</body>
</html>