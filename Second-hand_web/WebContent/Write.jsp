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
					<input type="text" name="title" placeholder="제목" maxlength="50" style="width:350px"/></td>
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
					<input type="text" name="price"/>
				</td>
		</tr>
		<tr>
				<td colspan="4" >내용 : <input type="text" name="content" placeholder="내용"
				maxlength="2048" style="height:550px; width:90%"/>
				</td>
		</tr>
		<tr>
		<td><input type="file" name="file" accept=".jpg , .jpeg , .png" ></td>
		<td colspan="4"><input type="submit" value="제출" style="width: 75px; height: 50px;">
		<input type="reset" value="뒤로" style="width: 75px; height: 50px;"> </td>
		</tr>
		</table>
		</form>
</body>
</html>