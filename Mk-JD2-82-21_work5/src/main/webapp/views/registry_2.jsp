<%@ page language="java"
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<html lang="en">
<head>
<title>Авторизация</title>
	<meta content="text/html; charset=utf-8" />
</head>
<body>
<form action="rega" method="post">
		<table>

			<tr>
				<th scope="col">UserName</th>
				<th scope="col"><label>
					<input type="text" name="username" />
				</label></th>
			</tr>
				<tr>
				<th scope="col">Password</th>
				<th scope="col"><label>
					<input type="password" name="password" />
				</label></th>
			</tr>
		</table>
		<input type="submit" value="Login" /></form>
</body>
</html>