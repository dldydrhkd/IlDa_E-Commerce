<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>

.banner_container{
	width:100%;
	height:200px;
 	background-color: white;
 	margin: 0;
}
.div_logo{
	width:30%;
	height:200px;
	float:left;
	background-color: white;
}

.div_search{
	float:left;
	margin-top: 10%;
	width: 40%;
	background-color: white;
}

.div_sign{
	background-color: white;
	width:30%;
	height:200px;
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
    margin: 5px;
}

.div_sign button:hover {
    background-color: #ff5f2e;
    color: #e1eef6;
}

.Search_icon{
	border: 3px solid aliceblue;
    color: orange;
}

.div_search{
	position:relative;
	text-align:center;
	
}
.div_search input{
	
	position : relative;
	width:95%;
	border-color: #bbb;
	border-radius: 16px;
	border-width: 1px solid #bbb;
	padding: 12px 20px 12px 20px;
	margin: 6px;
	font-family: fontAwesome;
}

.fa-search {
  position:absolute;
  right: 1%;
  top: 15px;
  margin:0;
}

.div_search button{
	padding: 0;
	border: 0;
	outline: 0;
}

.div_search button:hover{
	background-color: #ff5f2e;
    color: #e1eef6;
}
.login_btn{
	padding-left: 30px;
}


  

</style>
<head>
<meta charset="UTF-8">
<title>Banner Page</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>
	<% 
	String id = (String)session.getAttribute("id");
	%>
	<!-- 로고 영역 -->
	
	<div class="banner_container">
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
      		<div>
      		<button class="Search_icon" id="Search" ><i class="fas fa-search fa-2x"></i></button>
			</div>      	
      	</form>
    </div>
	
	
	<!-- 로그인/회원가입 영역 -->
	<div class= "div_sign">
		<!-- 버튼 누르면 로그인페이지로 이동 -->
		<%
		if(id != null) {
			out.print("<button type='button' >로그아웃</button>");
			out.print("<button type='button' onClick="+"location.href='DibsPage.jsp'"+">회원정보 수정</button>");
			out.print("<button type='button' >찜 목록</button>");
		}
		else { out.print("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;");
			out.print("<button class='login_btn' type='button' id ='Sign' onClick="+
						"location.href='LoginPage.jsp'"+"> 로그인/회원가입  </button>"); }
		%>
	
	</div>
	</div>
	
</body>
</html>