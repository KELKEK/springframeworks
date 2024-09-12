<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<a href="${path }/board/boardinsert.do">게시글등록</a>
	<hr>
	<h1>Board목록</h1>

	<button id="btnJSON">JSON보내기(list->)</button>
	<button id="btnJSON2">JSON받기(list<-)</button>
	<div id="here">여기</div>
	<a href="boardInsert.do">게시판등록</a>
	<h1>Board목록</h1>
	<form action="${path }/board/selectDelete.do">
		<table border="1">
			<tr>
				<th>선택</th>
				<th>bno</th>
				<th>title</th>
				<th>content</th>
				<th>writer</th>
				<th>pic</th>
				<th>작성일</th>
				<th></th>
			</tr>
			<c:forEach var="board" items="${blist}">
				<tr>
					<td><input type="checkbox" value="${board.bno}" name="checkBno">
					<td><a href="${path}/board/boardDetail.do?bno=${board.bno}">${board.bno }</a></td>
					<td>${board.title }</td>
					<td>${board.content }</td>
					<td>${board.writer }</td>
					<td><img alt="${board.title }" width="50" height="50" src="${path}/resources/uploads/${board.pic}"><a href="${path }/board/download.do?filename=${board.pic}">${board.pic }내려받기</a></td>
					<td>${board.create_date}</td>
<%-- 					<td><button onclick="location.href='${path}/board/boardDelete.do?bno=${board.bno}'">삭제</button></td> --%>
					<td><input type="button" value="삭제하기" onclick="location.href='${path}/board/boardDelete.do?bno=${board.bno}'"></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" >
	</form>

</body>
</html>

<!-- form tag 내의 <button>은 submit으로 수행한다. -->