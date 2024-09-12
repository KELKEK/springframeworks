<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
HELLO!
<h1>이름은 ${myname }</h1>
<h1>점수는 ${myscore }</h1>
<h2>GET방식 요청(요청주소에 param이용:값동일,field존재,존재안함)</h2>
<form action="${pageContext.servletContext.contextPath}/sample/hello6.do">
	email : <input type="email" name="email" value="ljk52589@naver.com"><br>
	password : <input type="password" name="pwd" value="1234"><br>
	phone : <input type="text" name="phone" value="010-1234-1234"><br>
	<input type="submit" value="서버전송(get)"><br>
</form>

<h2>POST방식 요청</h2>
<form method="post"
 action="${pageContext.servletContext.contextPath}/sample/hello6.do">
	email : <input type="email" name="email" value="ljk52589@naver.com"><br>
	password : <input type="password" name="pwd" value="1234"><br>
	phone : <input type="text" name="phone" value="010-1234-1234"><br>
	<input type="submit" value="서버전송(get)"><br>
</form>
</body>
</html>