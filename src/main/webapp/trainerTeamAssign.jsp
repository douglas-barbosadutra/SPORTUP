<%@ page import="it.contrader.dto.UserDTO"%>
<%@ page import="it.contrader.service.UsersServiceDTO"%>
<%@ page import="it.contrader.model.Player"%>


<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%

		UsersServiceDTO userServiceDTO = new UsersServiceDTO();
		List<Player> playerList = userServiceDTO.getAllPlayerTraining();
		
%>


<body>

<h2><center>------- ASSIGN TEAM -------</center></h2>


     <h3>Assegna il team</h3>
     
     <table border="2">

			<tr>

				<th>ID</th>

				<th>Name</th>
				
				<th>Role</th>

				<th>Training Info</th>
				
				<th>Player Info</th>
		
			</tr>

			<%

				for (int i = 0; i < playerList.size(); i++) {
					
			%>

			<tr>

				<td><%=playerList.get(i).getUserId()%></td>

				<td><%=playerList.get(i).getUsername()%></td>
				
				<td><%=playerList.get(i).getPlayerRole()%></td>

				<td><%=playerList.get(i).getTrainingInfo()%></td>
				
				<td><%=playerList.get(i).getPlayerInfo()%></td>				
	
			</tr>

			<%

				}

			%>

		</table>
     
     
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