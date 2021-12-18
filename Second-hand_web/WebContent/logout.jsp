<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 및 탈퇴</title>
</head>
<body>
<form method="post" action=logoutServlet.java>
<table>
<tr>
<td> 비밀번호: </td>
<td> <input type="password" name="pwd" size="40"></td>
</tr>
<tr>
<td> 이름: </td>
<td> <input type="text" name="name" size="40"></td>
</tr>
<tr>
<td> 나이: </td>
<td> <input type="text" name="age" size="40"></td>
</tr>
<tr>
<td> 성별: </td>
<td><input type="radio" name="gender" value="male"
					checked="checked" size="40"> 남자 <input type="radio" name="gender"
					value="female" size="40"> 여자</td>
</tr>
<tr>
<td> 주소: </td>
<td> <input type="text" name="address" size="40"></td>
</tr>
<tr>
<td>이메일:</td>
<td> <input type="url" name="phone" size="40"></td>
</tr>
<tr>
<td> 핸드폰 번호: </td>
<td> <input type="tel" name="phone" size="40"></td>
<td><input type="submit" value="수정"> </td>
</tr>
<tr>
<td>회원탈퇴(비밀번호 입력): </td>
<td> <input type="password" name="pwd" size="40"></td>
<td><input type="submit" value="탈퇴"> </td>
</tr>
</table>
</form>
</body>
</html>