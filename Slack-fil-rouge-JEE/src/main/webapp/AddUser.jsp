<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register new user</title>
</head>
<body>
	<h1>New user</h1>
	<form method="post">
		<ul>
			<li><label for="login">Login:</label><input type="text" id="login" name="login" /></li>
			<li><label for="email">E-mail:</label><input type="email" id="email" name="email" /></li>
			<li><label for="password">Password:</label><input type="password" id="password" name="password" /></li>
			<li><label for="passwordConfirm">Confirm password:</label><input type="password" id="passwordConfirm" name="passwordConfirm" /></li>
			<li><input type="submit" value="Create user" />
		</ul>	
	</form>
</body>
</html>