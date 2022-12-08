<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
      <h1>회원가입</h1>
      <form name="frm" method="post" action="joinAction">
         <table>
            <tr>
               <th>아이디</th>
               <td><input type="text" name="id"> * 필수
                  <input type="button" value="등록여부확인">
                  <input type="hidden" name="duplexChk" vlaue="0">
               
               </td>
            </tr>
            <tr>
               <th>이름</th>
               <td><input type="text" name="name"></td>
            </tr>
            <tr>
               <th>비밀번호</th>
               <td><input type="password" name="pass"> * 필수 (게시물 수정
                  삭제시 필요합니다.)</td>
            </tr>
         </table>
         <br>
         <br> <input type="submit" value="등록"> <input type="reset"
            value="다시 작성"> <input type="button" value="목록"">
      </form>
   </div>
</body>
</html>