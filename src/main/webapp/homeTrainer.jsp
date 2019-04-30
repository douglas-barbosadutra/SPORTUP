<html>
<head>
<title>Menu Principale</title>
</head>
<body>
	<h1>Benvenuto: ${utente}</h1>
	<h2>------- MENU TRAINER -------</h2>

	<h3>1. COSA VUOI GESTIRE</h3>
	<form action="MenuServlet" method="post">
		<button type="submit" value="esempioManager" name="richiesta">
			Training</button>
	</form>
	

	<form action="MenuServlet" method="post">
		<button type="submit" value="esempioManager" name="richiesta">
			Team</button>
	</form>
	
	<form action="LoginServlet" method="post">
		<button type="submit" value="esempioManager" name="richiesta">
			Exit</button>
	</form>
	
	<!--  
     <h3>2. Badges</h3>
     <form action="BadgeServlet" method="post">
     <button type="submit" value="badgesManagement" name="richiesta"> Management badge</button>
     </form>
     
     <h3>3. Assegnazione Badges</h3>
     <form action="AssegnazioneServlet" method="post">
     <button type="submit" value="assegnazioneManagement" name="richiesta"> Management Assegnazione</button>
     </form>
     
     <h3>4. Indietro</h3>
     <form action="CustomersServlet" method="post">
     <input type="submit" value="indietro" name="richiesta">
     </form>
     
       <h3>5.logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>
-->


</body>
</html>