<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>View Members</h2>
<table border="1">

	<tr>
		<th>Member Name</th>
		<th>Age</th>
		<th>Profile Photo</th>
		
	</tr>
	<tr>
		<td>${member.memberName}</td>
		<td>${member.age}</td>
		<td>${member.profilePhoto}</td>
		
	</tr>

</table>

</body>
</html>