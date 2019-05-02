<html>
<head>
<title>Menu Principale</title>
</head>
<body>
	
	<h2>------- GESTIONE ALLENAMENTI -------</h2>

	<h3>1. COSA VUOI FARE</h3>
	
	<form action="trainerTrainingView.jsp" method="post">
		<button type="submit">
			VIEW TRAININGS CARD</button>
	</form>
	
	<form action="trainerTrainingCreate.jsp" method="post">
		<button type="submit">
			CREATE TRAININGS CARD</button>
	</form>
	
	<form action="trainerTrainingUpdate.jsp" method="post">
		<button type="submit">
			UPDATE TRAININGS CARD</button>
	</form>
	
	<form action="trainerTrainingDelete.jsp" method="post">
		<button type="submit">
			DELETE TRAININGS CARD</button>
	</form>
	
	<form action="trainerBiomedicalDataDelete.jsp" method="post">
		<button type="submit">
			CREATE TRAININGS PROGRAM</button>
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