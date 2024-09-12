<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ pageContext.servletContext.contextPath}/board/boardDetail.do" method="post">
	
	bno : <input type="hidden" name="bno" value="${board.bno }"><br>
	title : <input type="text" name="title" value="${board.title }"><br>
	content : <input type="text" name="content" value="${board.content }"><br>
	writer : <input type="text" name="writer" value="${board.writer }"><br>
	create_date : <input type="date" name="create_date" value="${board.create_date }"><br>
	pic : <input type="text" name="pic" value="${board.pic }" readonly="readonly"><br>
	<input type="submit" value="수정">
	</form>
</body>
</html>