<%@ page import="it.contrader.dto.UserDTO"%>
<%@ page import="it.contrader.model.Training"%>
<%@ page import="it.contrader.service.TrainingServiceDTO"%>
<%@ page import="it.contrader.service.UsersServiceDTO"%>
<%@ page import="it.contrader.model.Player"%>


<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>

<head>

<%

		TrainingServiceDTO trainingServiceDTO = new TrainingServiceDTO();
		UsersServiceDTO userServiceDTO = new UsersServiceDTO();
		List<Training> trainingList = trainingServiceDTO.getAllTraining();
		List<Player> playerList = userServiceDTO.getAllPlayerTraining();
		
%>

</head>

<body>

	<h1>

		TRAINING PROGRAMS

	</h1>

	<form action="TrainingServlet" method="post">

		<table border="2">

			<tr>

				<th>ID</th>

				<th>Info</th>
		
			</tr>

			<%

				for (int i = 0; i < trainingList.size(); i++) {
					
			%>

			<tr>

				<td><%=trainingList.get(i).getTrainingId()%></td>

				<td><%=trainingList.get(i).getInfo()%></td>
	
			</tr>

			<%

				}

			%>

		</table>
		
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
		
	</form>

	<form action="trainerTraining.jsp" method="post">
	
		<h3>
			ID: <input type="text" id="id_training" name="id_training" value=<%=request.getParameter("id_training") %>
				placeholder="inserisci id del training">
		</h3>
		
		<h3>
			User ID: <input type="text" id="id_player" name="id_player"
				placeholder="inserisci id del player">
		</h3>
	
		<button type="submit" formaction=trainerTrainingUpdate.jsp> 
			UPDATE INFO TRAINING PROGRAM</button>
		
		<button type="submit" formaction=TrainingServlet?richiesta=assignTraining> 
			ASSIGN TRAINING PROGRAM</button>
	
		<button type="submit" formaction=TrainingServlet?richiesta=deleteTraining> 
			DELETE TRAINING PROGRAM</button>
		
		<h4>Training Card Menu</h4>
		
		<button type="submit" formaction=trainerTrainingCardView.jsp>
			VIEW TRAINING CARDS</button>	
	
		<button type="submit" formaction=trainerTrainingCardCreate.jsp>
			CREATE TRAINING CARD</button>
		
	</form>

	
	<form action="trainerTraining.jsp" method="post">
		<button type="submit">INDIETRO</button>
	</form>





</body>

</html>