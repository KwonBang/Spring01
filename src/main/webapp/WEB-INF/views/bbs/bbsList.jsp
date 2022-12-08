<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/shopping.css">
</head>
<body>
   <hr>
   <div id="wrap" align="center">
      <h1>게시글 리스트</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border: white; text-align: right"><a
               href="wrForm">게시글 등록</a></td>
         </tr>
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회</th>
            <th>수정/삭제</th>
         </tr>
         <!-- 아래 Tr 이 게시글 수 만큼 반복.. -->
         <c:forEach items="${bList }" var="bvo">         
               <tr class='record'>
               <td><a href="bbsView?vno=${bvo.num}">${bvo.num }</a></td>   
               <td><a href=''>${bvo.title }</td>
               <td>${bvo.name }</td>
               <td>${bvo.indate }</td>
               <td>${bvo.cnt }</td>
               <td><a href="bbsMod?vno=${bvo.num}">M</a>/
               <a href="bbsDel?vno=${bvo.num}">D</a></td>
               </tr>      
         </c:forEach>
         <!-- paging -->
         <tr>
         	<td colspan="6">
         		<c:if test="${pageVO.prev }">
         			<a href="bbsList?page=${pageVO.startPage -1 }">[이전페이지그룹]</a>
         		</c:if>
         	<!-- forEach 리스트 순회, 아래처럼 시작과 끝을 지정하여 반복하는 사용것. -->
         	<c:forEach begin="${pageVO.startPage}" end="${pageVO.endPage }" var="idx">
         		<c:if test="${pageVO.page == idx }">*</c:if>
         		<a href="bbsList?page=${idx }">${idx}</a>
         	</c:forEach>
         	<c:if test="${pageVO.next }">
         			<a href="bbsList?page=${pageVO.endPage + 1 }">[다음페이지그룹]</a>
         		</c:if>
         	</td>
         </tr>
      </table>
   </div>
</body>
</html>