<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<input type="hidden" name="id" value="${u.getId() }"><br>
NAME<input type="text" name="name" value="${u.getName() }"><br>
PHONE<input type="tel" name="phone" value="${u.getPhone() }"><br>
PASSWORD<input type="password" name="password" value="${u.getPassword() }"><br>
<input type="submit" value="update">


</form>
</body>
</html>