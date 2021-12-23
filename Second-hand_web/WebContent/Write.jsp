<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String[] cla = {"의류", "뷰티", "스포츠", "육아", "가구","도서","전자제품","기타"};
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
<style>
tr, td{
border:none;
}
</style>
<script type="text/javascript">

function checkValue(){
	
	var title = document.getElementById("title");
	var price = document.getElementById("price");
	var content = document.getElementById("content");
	var file = document.getElementById("file");
	
	let check = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]$/;
	
	if(title.value==""){
		alert('제목을 입력하세요!');
		title.focus();
		return false;
	}
	if(price.value==""){
		alert('가격을 입력 하세요!');
		price.focus();
		return false;
	}
	if(isNaN(price.value)){
		alert('숫자만 입력 하세요!');
		price.focus();
		return false;
	}
	if(content.value==""){
		alert('내용을 입력해주세요!');
		content.focus();
		return false;
	}
	if(file.value!="" && file.value.match(check)==null){
		alert("파일 이름은 영어,특수문자,숫자만 가능합니다.");
		file.focus();
		return false;
	}
}

</script>
</head>
<body>
		<div class="div_container">
		<div class="div_banner">
			<jsp:include page="BannerPage.jsp"></jsp:include> 
		</div>
		</div>
		<form action="writeServlet" method="post" enctype="multipart/form-data">
		<table border="1" style="margin-left:auto; margin-right:auto;">
		<tr>
				<td border="0">제목 : 
					<input type="text" id="title" name="title" placeholder="제목" maxlength="50" style="width:350px"/></td>
				<td>
				상품 분류
				<td>
					<select name = "noticeClassification"> 
					<%for (int i=0;i<cla.length;i++){ %>
						<option><%=cla[i]%></option>
					<%
					}
					%>
					</select>
				</td>
				<td> 가격
					<input type="text" id="price" name="price"/>
				</td>
		</tr>
		<tr>
				<td colspan="4" >내용 : <input type="text" id="content" name="content" placeholder="내용"
				maxlength="2048" style="height:550px; width:90%"/>
				</td>
		</tr>
		<tr>
		<td><input type="file" id="file" name="file" accept=".jpg , .jpeg , .png" ></td>
		<td colspan="4"><input type="submit" value="제출" onclick="return checkValue()" style="width: 75px; height: 50px;">
		<input type="reset" value="리셋" style="width: 75px; height: 50px;"> </td>
		</tr>
		</table>
		</form>
</body>
</html>