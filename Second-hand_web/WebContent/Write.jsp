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
</head>
<body>
		<h1 style="text-align:center">글 쓰기</h1>
		<form action="writeServlet" method="post">
		<table border="1" style="margin-left:auto; margin-right:auto;">
		<tr>
				<td>제목 : <input type="text" name="title" placeholder="제목" maxlength="50"
				style="width:350px"/></td>
				<td>상품 분류
				<select name = "noticeClassification"> 
				<%for (int i=0;i<cla.length;i++){ %>
					<option><%=cla[i]%></option>
				<%}%>
				</select>
		</tr>
		<tr>
				<td colspan="2">내용 : <input type="text" name="content" placeholder="내용"
				maxlength="2048" style="height:550px; width:550px"/>
				</td>
		</tr>
		<tr>
		<td><input type="file" accept=".jpg , jpeg , .png" ></td>
		<td colspan="2"><input type="submit" value="제출" style="width: 75px; height: 50px;">
		<input type="reset" value="뒤로" style="width: 75px; height: 50px;"> </td>
		</tr>
		</table>
		</form>
</body>
</html>