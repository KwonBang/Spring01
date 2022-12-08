<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/shopping.css">
</head>
<script>
   //비동기로
   //서버에게 요청 작성자를 파라미터로 보낼 테니 중복여부 확인해줘
   // 응답을 받아서
   // 등록된 사용자라면 vlaue=1로 바꾸는 코드를 짠다. 

</script>
<body>
   <div id="wrap" align="center">
      <h1>게시글 등록</h1>
      <form name="frm" method="POST" action="wrAction" encType="multipart/form-data">
      									<!-- encType을 적어 줘야만 첨부파일이 서버로 전송된다. -->
         <table>
            <tr>
               <th>작성자</th>
               <td>${boardVO.name }</td>
            </tr>
            <tr>
               <th>이메일</th>
               <td>${boardVO.email }</td>
            </tr>
            <tr>
               <th>제목</th>
               <td>${boardVO.title}</td>
            </tr>
             <tr>
               <th>조회수</th>
               <td>${boardVO.cnt}</td>
            </tr>
             <tr>
               <th>게시일</th>
               <td>${boardVO.indate}</td>
            </tr>
            <tr>
               <th>내용</th>
               <td>${boardVO.content}</td>
            </tr>
            <tr>
            	<th>첨부파일</th>
            	<td>
            		<c:forEach items="${attachList }" var="fname">
            			<a href="download?filename=${fname}">${fname}</a><br>
            			<img src="download?filename=${fname}">
            		</c:forEach>
            	</td><!-- 파일한개만 올리는 샘플. -->
            </tr>
         </table>
         <br>
         <br> <input type="button" value="등록-히스토리백" onclick="history.go(-1)">
         <input type="button" value="목록-컨트롤러호출" onclick="location.href='bbsList'">
      </form>
   </div>
   <script type="text/javascript">

   
   </script>
</body>
</html>