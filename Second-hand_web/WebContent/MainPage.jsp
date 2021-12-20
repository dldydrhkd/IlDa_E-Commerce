<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
.div_h1{
	width:80%;
	float: left;

}
.div_mainImg{
	margin-top:5%;
	width:80%;
	float:left;
}

.div_table table{
	margin-top:5%;
	witdth:80%;
	float:left;
	
}

.td_btn{
	width:100%;
}
.td_btn img{
	width:100%
}

.div_textIn button{
	padding: 8px 15px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 500;
    transition: 0.25s;
    border: 3px solid #ff5f2e;
    color: #6e6e6e;
    margin-top: 50px;
}

.div_textIn button:hover {
    background-color: #ff5f2e;
    color: #e1eef6;
}


</style>

<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>

<link rel="stylesheet" href="PageLayout.css">
</head>
<body>


	<div class="div_container">
	
	
		<div class="div_banner">
			<jsp:include page="BannerPage.jsp"></jsp:include> 
		</div>
		
		
		<div class=div_mainImg align="center">
			<img src="main_img.jpg" alt="mainImg" width=100%/>
		</div>
		
		
		<div class="div_basket"> sticky box</div>
		
		
		
		<div class="div_h1">
			<h1> 최근 등록<% %>건</h1> <hr>
		</div>
		<%
		String[] img = {"그림3.jpg","그림3.jpg","그림3.jpg","그림3.jpg","그림3.jpg","그림3.jpg","그림3.jpg"}; //request.getParameterValues("img"); 
		String[] title = {"바지","모자","악기","산삼","라면","피자","멘보샤"}; //request.getParameterValues("title");
		String[] price = {"10000","10000","10000","10000","10000","10000","10000"};//request.getParameterValues("price");ti
		int count =1;
		int n=0;
		int Totaltr= 0; 
		int col =5; //열의 갯 수
		%>
		
		
		<div class ="div_mainTable" al>
			<table>
			<% 	
				 
				if(img.length/col < 1) { Totaltr=1; }
				else { Totaltr=img.length/col +1; }
							
				for (int i=0; i<(Totaltr); i++){
					out.print("<tr>");
					
					// 열의 갯수 고정
					if ( (img.length-count)/col < 1 ) {n= count%col;}
					else {n=col;}
					
					// 열 출력
					for(int j=0; j<n; j++){
						out.print("<td> <button class= td_btn><img src="+img[count-1]+"><br>"+
								title[count-1] +"<br>가격:"+price[count-1]+"</button> </td>");
						count++;
					}
					out.print("</tr>");
				}
			%>		
			</table>
		</div>
		
		<div class ="div_textIn" align="center">
			<br>
			<button onClick="location.href='Write.jsp'">글 쓰기</button>	
		</div>
		
	</div>
</body>
</html>