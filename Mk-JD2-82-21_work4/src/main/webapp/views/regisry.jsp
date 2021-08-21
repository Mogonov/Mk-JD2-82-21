<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Form</title>
</head>
<body>
<h1>Регистрация</h1>
<form action="rego" method="POST">
			<table style="with: 50%">
				<tr>
					<td>Имя</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Фамилия</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td>Ник</td>
					<td><input type="text" name="username" /></td>
				</tr>
					<tr>
					<td>Пароль</td>
					<td><input type="password" name="password" /></td>
				</tr>
                 <tr>
                    <td>Дата:</td>
                  <td><input type="date" name="birthday"></td>

				</tr></table>
			<input type="submit" value="Submit" /></form>

</body>
</html>