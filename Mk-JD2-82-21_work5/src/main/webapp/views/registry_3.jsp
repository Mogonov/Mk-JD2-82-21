<%@page language="java"
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<html lang="en">
<head>
	<meta content="text/html; charset=utf-8" />
<title>Здрасьте!!!</title>
</head>
<body>
	 <table>
	<tr><td>
	<% String username = request.getParameter("username"); %>
<a>Добро пожаловать!!!!   Вы авторизованы!.</a></td></tr>
<tr></tr><tr><td></td><td></td><td><a href="registry_2.jsp"><b>Logout</b></a></td></tr>
</table>
</body>
</html>