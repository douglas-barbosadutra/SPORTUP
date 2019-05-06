<html>
<head>
<title>Login Trader</title>
</head>
<body>

	<h2 style="color: green; background=white;">------- LOGIN -------</h2>
	<div>
		<form action="LoginServlet" method="post">
			<h3 style="color:red; ">
				username: <input type="text" id="user" name="username"
					placeholder="inserisci username">
			</h3>
			<h3 style="color:red;">
				password: <input type="password" id="pass" name="password"
					placeholder="inserisci password">
			</h3>
			<button type="submit" value="Login" name="pulsante">Login</button>
			<br> <a href="register.jsp"> Registrati </a>
		</form>
	</div>

</body>
</html>