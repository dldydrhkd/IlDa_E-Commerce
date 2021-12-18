<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<form method="post" action=signUpServlet.java>
<table>
<tr>
<td> 아이디: </td>
<td> <input type="text" name="id" size="40"></td>
</tr>
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
</tr>
<tr>
<td><input type="submit" value="가입"> </td>
<td><input type="reset" value="뒤로"> </td>
</tr>
</table>
</form>
</body>
</html>