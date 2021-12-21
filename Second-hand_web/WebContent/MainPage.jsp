<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="mybean.db.noticeVO" %>

<% 
	List<noticeVO> noticeList = (List<noticeVO>)request.getAttribute("ListNotice");
%>

<%!
	public Integer toInt(String x){
		int a = 0;
		try{
			a = Integer.parseInt(x);
		}catch(Exception e){}
		return a;
	}
%>

<%
	int pageno = toInt(request.getParameter("pageno"));
	if(pageno<1){//현재 페이지
		pageno = 1;
	}
	int total_record = noticeList.size();		   //총 레코드 수
	int page_per_record_cnt = 10;  //페이지 당 레코드 수
	int group_per_page_cnt =5;     //페이지 당 보여줄 번호 수[1],[2],[3],[4],[5]// [6],[7],[8],[9],[10]											
	int record_cnt=0;
	
	if (pageno == 1) {
		record_cnt=0;
	} else{record_cnt = (pageno-1)*10; }
	
	int record_end_no = pageno*page_per_record_cnt;				
	int record_start_no = record_end_no-(page_per_record_cnt-1);
	if(record_end_no>total_record){
		record_end_no = total_record;
	}
										   
										   
	int total_page = total_record / page_per_record_cnt + (total_record % page_per_record_cnt>0 ? 1 : 0);
	if(pageno>total_page){
		pageno = total_page;
	}


	

// 	현재 페이지(정수) / 한페이지 당 보여줄 페지 번호 수(정수) + (그룹 번호는 현제 페이지(정수) % 한페이지 당 보여줄 페지 번호 수(정수)>0 ? 1 : 0)
	int group_no = pageno/group_per_page_cnt+( pageno%group_per_page_cnt>0 ? 1:0);
//		현재 그룹번호 = 현재페이지 / 페이지당 보여줄 번호수 (현재 페이지 % 페이지당 보여줄 번호 수 >0 ? 1:0)	
//	ex) 	14		=	13(몫)		=	 (66 / 5)		1	(1(나머지) =66 % 5)			  
	
	int page_eno = group_no*group_per_page_cnt;		
//		현재 그룹 끝 번호 = 현재 그룹번호 * 페이지당 보여줄 번호 
//	ex) 	70		=	14	*	5
	int page_sno = page_eno-(group_per_page_cnt-1);	
// 		현재 그룹 시작 번호 = 현재 그룹 끝 번호 - (페이지당 보여줄 번호 수 -1)
//	ex) 	66	=	70 - 	4 (5 -1)
	
	if(page_eno>total_page){
//	   현재 그룹 끝 번호가 전체페이지 수 보다 클 경우		
		page_eno=total_page;
//	   현재 그룹 끝 번호와 = 전체페이지 수를 같게
	}
	
	
	
	int prev_pageno = page_sno-group_per_page_cnt;  // <<  *[이전]* [21],[22],[23]... [30] [다음]  >>
//		이전 페이지 번호	= 현재 그룹 시작 번호 - 페이지당 보여줄 번호수	
//	ex)		46		=	51 - 5				
	int next_pageno = page_sno+group_per_page_cnt;	// <<  [이전] [21],[22],[23]... [30] *[다음]*  >>
//		다음 페이지 번호 = 현재 그룹 시작 번호 + 페이지당 보여줄 번호수
//	ex)		56		=	51 - 5
	if(prev_pageno<1){
//		이전 페이지 번호가 1보다 작을 경우		
		prev_pageno=1;
//		이전 페이지를 1로
	}
	if(next_pageno>total_page){
//		다음 페이지보다 전체페이지 수보가 클경우		
		next_pageno=total_page/group_per_page_cnt*group_per_page_cnt+1;
//		next_pageno=total_page
//		다음 페이지 = 전체페이지수 / 페이지당 보여줄 번호수 * 페이지당 보여줄 번호수 + 1 
//	ex)			   = 	76 / 5 * 5 + 1	???????? 		
	}
	
	// [1][2][3].[10]
	// [11][12]
%>
<!DOCTYPE html>

<style>
.div_h1{
	width:100%;
	float: left;
}

.div_mainImg{
	margin-top:5%;
	width:100%;
	float:left;
}

.div_Table{
	margin-top:5%;
	witdth:100%;
}

.td_btn{
	width:100%;
}

.td_btn img{
	width:100%
}

.div_textIn button{
	padding: 8px 15px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 500;
    transition: 0.25s;
    border: 3px solid #ff5f2e;
    color: #6e6e6e;
    margin-top: 40px;
}

.div_textIn button:hover {
    background-color: #ff5f2e;
    color: #e1eef6;
}

.div_paging{
	width:100%;
	margin-top: 25px;
}
  
</style>

<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>

<link rel="stylesheet" href="PageLayout.css">
</head>
<body>
	<div class="div_container">
	
		<div class="div_banner">
			<jsp:include page="BannerPage.jsp"></jsp:include> 
		</div>
		
		<div class=div_mainImg align="center">
			<img src="main_img.jpg" alt="mainImg" width=100%/>
		</div>
		
		<div class="div_h1">
			<h1> 최근 등록<% %>건</h1> <hr>
		</div>

		<div class ="div_Table" align="center" >
			<table>
				<form action='showNoticeServlet' method='post'>
			<% 	
				int n=0;
				int Totaltr= 0; 
				int col =5; //열의 갯 수
				String img="그림.3.png";
				int price =0;
				String title ="미제";
							
				
				// 출력할 갯수가 5개 이하일때 한줄만 출력
				if(total_record/col < 1) { Totaltr=1; }
				else { Totaltr= 2; }
						
				for (int i=0; i<Totaltr; i++){
					out.print("<tr>");
					
					
					// 한 줄에 출력할 갯수가 5개 이하일때 출력값 설정
					if ( (total_record-record_cnt)/col <1 ) {n = (total_record-record_cnt)%col ;}
					else {n=col;}
					
					// 게시글 출력
					for(int j=0; j<n; j++){%>
						<%if(noticeList.get(record_cnt).getNoticeImgfileRealName()!=null){
							img = noticeList.get(record_cnt).getNoticeImgfileRealName();	
						} 
						
						if(noticeList.get(record_cnt).getNoticeImgfileRealName()!=null){
							title = noticeList.get(record_cnt).getNoticeTitle();	
						}
						
						if(noticeList.get(record_cnt).getNoticeImgfileRealName()!=null){
							price = noticeList.get(record_cnt).getNoticeProductPrice();	
						} 
						%>
						
											
						<td> <button type='submit' class='td_btn'>
						<img src=<%=img%>/>
						<br><%=title%>
						<br>가격:<%=price%>
						<input type='hidden' name="noticeNumber" value= <%=noticeList.get(record_cnt).getNoticeNumber()%> />
						</button> </td>
						<% record_cnt++;
					}
					out.print("</tr>");
				}
			%>	
				</form>
			</table>
		</div>
		
		<div class ="div_textIn" align="right">
			<br>
			<button onClick="location.href='Write.jsp'">글 쓰기</button>	
		</div>

		<div class="div_paging" align="center">
			<a href="MainPage.jsp?pageno=1">[맨앞으로]</a>
			<a href="MainPage.jsp?pageno=<%=prev_pageno%>">[이전]</a> 
			<%for(int i =page_sno;i<=page_eno;i++){%>
				<a href="MainPage.jsp?pageno=<%=i %>">
					<%if(pageno == i){ %>
						[<%=i %>]
					<%}else{ %>
						<%=i %>
					<%} %>
				</a> 
			<%--	콤마	 --%>	
				<%if(i<page_eno){ %>
					,
				<%} 
			} %> 
			<a href="MainPage.jsp?pageno=<%=next_pageno%>">[다음]</a>
			<a href="MainPage.jsp?pageno=<%=total_page %>">[맨뒤로]</a>
		</div>

	</div>

</body>
</html>