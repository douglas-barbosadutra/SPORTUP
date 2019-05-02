<html>
<head>
<title>Menu Principale</title>
</head>
<body>
	
	<h2>------- GESTIONE UTENTI -------</h2>

	<h3>1. COSA VUOI FARE</h3>
	
	<form action="adminUsersDelete.jsp" method="post">
		<button type="submit" value="esempioManager" name="richiesta">
			DELETE USER</button>
	</form>
	
	<form action="adminAssignType.jsp" method="post">
		<button type="submit" value="esempioManager" name="richiesta">
			ASSIGN TYPE</button>
	</form>
	
	<form action="adminUsersView.jsp" method="post">
		<button type="submit">VIEW USERS</button>
	</form>

	<form action="index.jsp" method="post">
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