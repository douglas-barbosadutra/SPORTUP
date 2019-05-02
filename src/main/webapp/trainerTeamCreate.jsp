<html>
<head>
<title>Register Trader</title>
</head>
<body>
	<h2>------- INSERT NEW TEAM -------</h2>
	<div>
		<form action="TeamServlet?richiesta=createTeam" method="post">
			<h3>
				info: <input type="text" id="team" name="info"
					placeholder="inserisci info">
			</h3>
			
			<button type="submit" value="Create" name="pulsante">create</button>
		</form>
		
		<form action="trainerTeam.jsp" method="post">
		<button type="submit">INDIETRO</button>
	</form>
	
	</div>
</body>
</html>