<html>
<head>
<title>Menu Principale</title>
</head>
<body>
	<h1>Benvenuto: ${utente}</h1>
	<h2>------- MENU ADMIN -------</h2>

	<h3>1. COSA VUOI GESTIRE</h3>
	<form action="adminUsers.jsp" method="post">
		<button type="submit">Utenti</button>
	</form>
	

	<form action="index.jsp" method="post">
		<button type="submit" value="esempioManager" name="richiesta">
			Exit</button>
	</form>
	

</body>
</html>