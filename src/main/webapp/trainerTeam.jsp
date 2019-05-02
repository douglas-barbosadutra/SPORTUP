<html>
<head>
<title>Menu Principale</title>
</head>
<body>
	
	<h2>------- GESTIONE TEAM -------</h2>

	<h3>1. COSA VUOI FARE</h3>
	
	<form action="trainerTeamView.jsp" method="post">
		<button type="submit">
			VIEW TEAM</button>
	</form>
	
	<form action="trainerTeamCreate.jsp" method="post">
		<button type="submit">
			CREATE TEAM</button>
	</form>
	
	<form action="trainerTeamUpdate.jsp" method="post">
		<button type="submit">
			UPDATE TEAM</button>
	</form>
	
	<form action="trainerTeamDelete.jsp" method="post">
		<button type="submit">
			DELETE TEAM</button>
	</form>
	
	<form action="trainerTeamAssign.jsp" method="post">
		<button type="submit">
			ASSIGN TEAM</button>
	</form>

	<form action="homeTrainer.jsp" method="post">
		<button type="submit">
			Back</button>
	</form>
	
	<form action="index.jsp" method="post">
		<button type="submit">
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