<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 표준action은 각각을 컴파일해서 합친다. -->
<%-- <jsp:include page="../common/header.jsp"></jsp:include> --%>
<!-- include지시자는 합쳐서 컴파일한다. -->
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input[readonly]{
	background-color: gray;
}
</style>
</head>
<body>
<h1>부서 상세보기</h1>
<p>${deptInfo.department_id}</p>
<p>${deptInfo.department_name}</p>
<p>${deptInfo.manager_id}</p>
<p>${deptInfo.location_id}</p>
<form action="${path}/dept/deptDetail.do" method="post">
	부서번호:<input type="number" name="department_id" value="${deptInfo.department_id}" readonly="readonly"><br>
	부서이름:<input type="text" name="department_name" value="${deptInfo.department_name}" readonly="readonly"><br>
	매니저:<input type="text" name="manager_id" value="${deptInfo.manager_id}" readonly="readonly"><br>
	지역코드:<input type="number" name="location_id" value="${deptInfo.location_id}" readonly><br>
	<input type="submit" value="수정하러가기">
</form>
</body>
</html>