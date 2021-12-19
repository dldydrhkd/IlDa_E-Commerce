<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
</head>
<body>
		<h1 style="align:left">글 쓰기</h1>
		<form action="WriteServlet" method="post">
		<table border="1">
		<tr>
				<td>제목 : <input type="text" name="title" placeholder="제목" maxlength="50"
				style="width:350px"/></td>
		</tr>
		<tr>
				<td>내용 : <input type="text" name="content" placeholder="내용"
				maxlength="2048" style="height:550px; width:350px"/>
				</td>
		</tr>
		<tr>
		<td><input type="submit" value="제출">
		<input type="reset" value="뒤로"> </td>
		</tr>
		</table>
		</form>
</body>
</html>