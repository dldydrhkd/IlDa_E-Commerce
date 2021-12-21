<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@ page import="mybean.db.basketListVO" %>
<%@ page import="mybean.db.basketVO" %>
<%@ page import="mybean.db.basketDAO" %>
<%@ page import="java.util.*" %>
<%
	List<basketListVO> li = (List<basketListVO>)request.getAttribute("basketList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
<header>
	<jsp:include page="BannerPage.jsp"></jsp:include> 
</header>
<center>
	<table>
	<%
		if(li!=null){
			for(int i=0; i<li.size(); i++){
	%>
		<tr>
			<td><%=i+1%>.</td>
			<td> 제목 : <%=li.get(i).getNoticeTitle()%></td>
		</tr>
	<%
			}
		}
	%>
</table>
</center>

</body>
</html>