<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 표준action은 각각을 컴파일해서 합친다. -->
<%-- <jsp:include page="../common/header.jsp"></jsp:include> --%>
<!-- include지시자는 합쳐서 컴파일한다. -->
<%@ include file="../common/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<img alt="opop" src="${path }/resources/image/tree-4.jpg" width="100" height="100">
<h1>부서등록</h1>
<form id="insertForm" action="${path }/dept/deptInsert.do" method="post">
	부서번호:<input type="number" name="department_id" value=""><br>
	부서이름:<input type="text" name="department_name" value=""><br>
	매니저:
	<select name="manager_id">
		<c:forEach var="manager" items="${mlist}">
			<option value="${manager.employee_id }">${manager.fullname}</option>
		</c:forEach>
	</select><br>
	지역코드:<input type="number" name="location_id" value=""><br>
	<input type="submit" value="부서저장">
</form>
<button onclick="f_deptInsert()">입력(ajax)</button>
</body>
<script>
	function f_deptInsert(){
		var arr = $("#insertForm").serializeArray();
		var obj = {};
		//obj.score = 100;
		console.log(arr);
		$.each(arr, function(index, item){
			obj[item.name] = item.value;
		})
		console.log(obj);
		
		$.ajax({//페이지 이동 안하려고 ajax쓰는것
			url:"${path}/dept/api/insert",
			type:"post",
			data:JSON.stringify(obj), //@RequestBody
			contentType:"application/json;charset=utf-8",
			success:function(responseStr){ //변수 이름은 그냥 맘대로 적어도 됨
				alert(responseStr);
			}
		});
	}
</script>
</html>