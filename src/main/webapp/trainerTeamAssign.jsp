<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2><center>------- ASSIGN TEAM -------</center></h2>


     <h3>Assegna il team</h3>
     
     <form action="TeamServlet?richiesta=assignTeam" method="post">
     <h4>id_player: <input type = "text" id = "player" name ="id_player" placeholder = "inserisci id_player"></h4>
     	
     <h4>id_team: <input type = "text" id = "team" name ="id_team" placeholder = "inserisci id_team"></h4>
     	
     	
       <button type="submit" value="Conferma" name="pulsante">Conferma</button>
      
            	
     </form>
     
     <form action="homeTrainer.jsp" method="post">
		<button type="submit">INDIETRO</button>
	</form>
     
 
     	
     

     

</body>
</html>