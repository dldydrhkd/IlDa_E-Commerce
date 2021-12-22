<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="mybean.db.noticeVO" %>

<%@ page import="java.text.DecimalFormat" %>
<%
	noticeVO current_info = (noticeVO)request.getAttribute("noticeView");
	DecimalFormat formatter = new DecimalFormat("###,###");
	
%>


<!DOCTYPE html>
<style>
.banner{
	text-align: center;
	padding: 10px 0px;
	width: 100%;
	top: 0;	
}

.div_table table{
	border-collapse: collapse;
	width: 800px;
}
</style>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 내용</title>
</head>
<body>
		<div class="div_container" >
		<div class="banner">
			<jsp:include page="BannerPage.jsp"></jsp:include> 
		</div>
		
		<div class="div_table" align="center">
			<table border="2" >
				<tr>
					<% 
						String imgName ="noImg.jpg";
						if(current_info.getNoticeImgfileRealName()!=null){
							imgName = (String)current_info.getNoticeImgfileRealName();
						}
					%>
						<td rowspan="6"  style="height:350px; width:370px"><img src="upload/<%=imgName%>"  width="100%" alt="<%=current_info.getNoticeImgfileRealName()%>"%></td>
				</tr>
				<tr>
					<td>&nbsp; <%= current_info.getNoticeTitle() %></td>
				
						
				</tr>
				<tr>

						<td>&nbsp; - 가격 : <%=formatter.format(current_info.getNoticeProductPrice())+ "원"%></td>

				</tr>
				<tr>
						<td>&nbsp; - 거래상태 : <%= current_info.getNoticeState()%> </td>
				</tr>
				<tr>
						<td>&nbsp; - 공개여부 : <%= current_info.isNoticeCondition()%> </td>
				</tr>
				<tr>
						<td>&nbsp; - 작성일자 : <%= current_info.getNoticeRegistrationDate()%> </td>
				</tr>
				<tr>
					<form action="basketAddServlet" method="post">
						
						<input type="submit" value="찜" style="width: 50px; height: 50px; float: right;"></td>
					</form>
				</tr>
				<tr>
						<td colspan="3" maxlength="2048" style="height:550px; width:550px">내용 : <%=current_info.getNoticeInfo()%></td>
				</tr>
			<form action="writeChangeServlet" method="post">
				<tr>
				
				<%if(session.getAttribute("userNumber")==(Integer)current_info.getUserNumber()) {%>
				<td colspan="3"><input type="submit" value="수정" style="width: 75px; height: 50px; float:right;">
				<% }%>

				<input type="reset" value="목록" style="width: 75px; height: 50px; float:right;" onclick="location.href='MainPage.jsp'"> </td>

				</tr>
			</form>
			</table>
		</div>
		<%-- <div class="comment" align="center">
			<jsp:include page="Commentpage.jsp"></jsp:include>
		</div> --%>
	</div>
</body>
</html>