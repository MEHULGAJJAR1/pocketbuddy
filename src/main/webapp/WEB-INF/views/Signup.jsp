
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>
  <body>
  	<h1>Signup</h1>
	
	<form action="saveuser" method="post">
	FirstName: <input type="text" name="firstName"/><br><br>
	LastName: <input type="text" name="lastName"/><br><br>
	Gender: Male <input type="radio" name="gender" value="male">
	       Female<input type="radio" name="gender" value="female"><br><br>
	       
	Email:<input type="text" name="email"/><br><br>
	PassWord:<input type="password" name="password"/><br><br>
	<input type="submit" value="Signup"/>       
	       
	
	</form>
	<br><br>
	<a href="login">Login</a>
</body>
</html>
