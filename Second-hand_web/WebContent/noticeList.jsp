<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="mybean.db.noticeVO" %>
<%
	List<noticeVO> noticeList = (List<noticeVO>)request.getAttribute("noticeList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>게시글</h1>
		<c:forEach var="name" items="${noticeList}">
			<table border="2">
			<tr>
				<td colspan="5" style="border:white;text-align:right;"><a href="Write.jsp">글 작성하기</a></td>
			</tr>
			<tr>
				<th>글번호 ${name.getNoticeNumber()}</th>
    			<td>글제목</td>
    			<td>작성자</td>
    			<td>작성날짜</td>
    			<td>거래 상태</td>
    		</tr>
    		<tr>
    		</tr>
			</table>
		</c:forEach>
</body>
</html>