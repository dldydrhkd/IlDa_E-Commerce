<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="mybean.db.noticeVO" %>
<%
	noticeVO current_info = (noticeVO)request.getAttribute("noticeView");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 내용</title>
</head>
<body>
		<div class="div_container">
		<div class="div_banner">
			<jsp:include page="BannerPage.jsp"></jsp:include> 
		</div>
		</div>
		<table border="1" style="margin-left:auto; margin-right:auto;">
		<tr>
		<form action="basketAddServlet" method="post">
				<td colspan="2">제목 : <%-- <%= current_info.getNoticeTitle() %> --%>
				<input type="submit" align="right" value="찜" style="width: 50px; height: 50px;"></td>
		</form>
		</tr>
		<tr>
				<td rowspan="6" style="height:200px; width:200px"><img src=<%-- <%= current_info.getNoticeSource()%> --%>/></td>
		</tr>
		<tr>
				<td>작성일자 : <%-- <%= current_info.getNoticeRegistrationDate()%> --%></td>
		</tr>
		<tr>
				<td>거래상태 : <%-- <%= current_info.getNoticeState()%> --%></td>
		</tr>
		<tr>
				<td>공개여부: <%-- <%= current_info.isNoticeCondition()%> --%></td>
		</tr>
		<tr>
				<td>가격: <%-- <%= current_info.getNoticeProductPrice()%> --%></td>
		</tr>
		<tr>
				<td colspan="3" maxlength="2048" style="height:550px; width:550px">내용 : <%-- <%=current_info.getNoticeInfo()%> --%></td>
		</tr>
		<form action="writeChangeServlet" method="post">
			<tr>
			<td colspan="3"><input type="submit" value="수정" style="width: 75px; height: 50px;">
			<input type="reset" value="뒤로" style="width: 75px; height: 50px;"> </td>
			</tr>
		</form>
		</table>
		<div class="comment" align="center">
			<jsp:include page="Commentpage.jsp"></jsp:include> 
		</div>
</body>
</html>