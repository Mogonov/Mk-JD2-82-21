<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Form</title>
</head>
<body>
<h1>Регистрация</h1>
<form action="rego" method="POST">
			<table>
				<tr>
					<td>Имя</td>
					<td><label>
						<input type="text" name="first_name" />
					</label></td>
				</tr>
				<tr>
					<td>Фамилия</td>
					<td><label>
						<input type="text" name="last_name" />
					</label></td>
				</tr>
				<tr>
					<td>Ник</td>
					<td><label>
						<input type="text" name="username" />
					</label></td>
				</tr>
					<tr>
					<td>Пароль</td>
					<td><label>
						<input type="password" name="password" />
					</label></td>
				</tr>
                 <tr>
                    <td>Дата:</td>
                  <td><label>
					  <input type="date" name="birthday">
				  </label></td>

				</tr></table>
			<input type="submit" value="Submit" /></form>



</body>
</html>