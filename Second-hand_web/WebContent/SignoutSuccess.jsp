<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.invalidate();
%>
<script>
alert('회원탈퇴 되었습니다.');
location.href="MainPage.jsp";	//해결법
</script>