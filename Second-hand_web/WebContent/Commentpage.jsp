<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="mybean.db.commentVO" %>

<% 
	List<commentVO> commentList = (List<commentVO>)request.getAttribute("commentList");
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 댓글 부분 -->
	<div id="comment">
		<table border="1" bordercolor="lightgray">
	<!-- 댓글 목록 -->	
	<c:if test="${commentList != null}">
		<c:forEach var="comment" items="${requestScope.commentList}">
		
			<tr>
				<!-- 아이디, 작성날짜 -->
				<td width="150">
					<div>
						${comment.getUserId()}<br>
						<font size="2" color="lightgray">${comment.getCommentRegistrationDate()}</font>
					</div>
				</td>
				<!-- 본문내용 -->
				<td width="550">
					<div class="text_wrapper">
						${comment.getCommentInfo()}
					</div>
				</td>
				<!-- 버튼 -->
				<td width="100">
					<div id="btn" style="text-align:center;">
						
					<!-- 댓글 작성자만 수정, 삭제 가능하도록 -->	
					<c:if test="${comment.getUserId() == id}">
						<form action="commentChangeServlet" method="post">
							<input type="submit" value="수정">
						</form>
						
						<form action="commentDeleteServlet" method="post">
							<input type="submit" value="삭제">
						</form>
							
					</c:if>		
					</div>
				</td>
			</tr>
			
		</c:forEach>
	</c:if>
			<!-- 로그인 했을 경우만 댓글 작성가능 -->
			<c:if test="${sessionScope.sessionID !=null}">
			<tr bgcolor="#F5F5F5">
			<form action= "commentAddServlet" method="POST">
				<input type="hidden" name="noticeNumber" value="${comment.getNoticeNumber()}">
				<input type="hidden" name="userId" value="${id}">
				<!-- 아이디-->
				<td width="150">
					<div>
						id
					</div>
				</td>
				<!-- 본문 작성-->
				<td width="550">
					<div>
						<textarea name="commentInfo" rows="4" cols="70" ></textarea>
					</div>
				</td>
				<!-- 댓글 등록 버튼 -->
				<td width="100">
					<div id="btn" style="text-align:center;">
						<input type="submit" value="댓글 등록">
							
					</div>
				</td>
			</form>
			</tr>
			</c:if>
	
		</table>
	</div>
</body>
</html>