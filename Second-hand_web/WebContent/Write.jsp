<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
</head>
<body>
		<h1 style="text-align:center">글 쓰기</h1>
		<form action="WriteServlet" method="post">
		<table border="1" style="margin-left:auto; margin-right:auto;">
		<tr>
				<td>제목 : <input type="text" name="title" placeholder="제목" maxlength="50"
				style="width:350px"/></td>
				<td>상품 분류
				<select name = "noticeClassification">
				<option>의류</option>
				<option>뷰티</option>
				<option>스포츠</option>
				<option>육아</option>
				<option>가구</option>
				<option>도서</option>
				<option>전자제품</option>
				<option>기타</option>
				</select>
		</tr>
		<tr>
				<td colspan="2">내용 : <input type="text" name="content" placeholder="내용"
				maxlength="2048" style="height:550px; width:550px"/>
				</td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" value="제출" style="width: 75px; height: 50px;">
		<input type="reset" value="뒤로" style="width: 75px; height: 50px;"> </td>
		</tr>
		</table>
		</form>
</body>
</html>