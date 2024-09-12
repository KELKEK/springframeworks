<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 표준action은 각각을 컴파일해서 합친다. -->
<%-- <jsp:include page="../common/header.jsp"></jsp:include> --%>
<!-- include지시자는 합쳐서 컴파일한다. -->
<%@ include file="../common/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input[readonly] {
	background-color: gray;
}
</style>
</head>
<body>
	<h1>부서정보 수정</h1>
	<form id="updateForm" action="${path}/dept/deptDBUpdate.do"
		method="post">
		부서번호:<input type="number" name="department_id" id="department_id"
			value="${dept.department_id}" readonly="readonly"><br>
		부서이름:<input type="text" name="department_name"
			value="${dept.department_name}"><br> 매니저: <select
			name="manager_id">
			<c:forEach var="manager" items="${mlist}">
				<option value="${dept.manager_id }"
					${dept.manager_id==manager.employee_id?"selected":""}>${manager.fullname}/${manager.employee_id}</option>
			</c:forEach>
		</select><br> 지역코드:<input type="number" name="location_id"
			value="${dept.location_id}"><br> <input type="submit"
			value="DB저장">

	</form>
	<hr>
	<p>Ajax연습</p>
	<button onclick="f_deptUpdate()">Restful API를 이용해서 수정하기</button>
	<button onclick="f_deptDelete(${dept.department_id})">Restful API를 이용해서 삭제하기</button>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		function f_deptUpdate() {
			var arr = $("#updateForm").serializeArray();
			var obj = {};
			//obj.score = 100;
			//console.log(arr);
			$.each(arr, function(index, item) {
				obj[item.name] = item.value;
			})
			console.log(obj);

			$.ajax({//페이지 이동 안하려고 ajax쓰는것
				url : "${path}/dept/api/update",
				type : "put",
				data : JSON.stringify(obj), //@RequestBody
				contentType : "application/json;charset=utf-8",
				success : function(responseStr) { //변수 이름은 그냥 맘대로 적어도 됨
					alert(responseStr);
				}
			});
		}
		
		function f_deptDelete(deptid){
			$.ajax({
				url : "${path}/dept/api/delete/" + deptid,
				type : "delete",
				success:function(responseResult){
					alert(responseResult);
				}
			});
		}
	</script>
</body>
</html>