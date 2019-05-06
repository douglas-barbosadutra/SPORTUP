<%@ page import="it.contrader.model.Training"%>
<%@ page import="it.contrader.model.TrainingCard"%>
<%@ page import="it.contrader.service.TrainingServiceDTO"%>


<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>

<head>

<%
		
		int id_training = Integer.parseInt(request.getParameter("id_training"));
		TrainingCard t_card = new TrainingCard();
		t_card.setId_training(id_training);
		TrainingServiceDTO trainingServiceDTO = new TrainingServiceDTO();
		List<TrainingCard> t_CardList = trainingServiceDTO.getAllTrainingCardTrainer(t_card);

%>

</head>

<body>

	<h1>

		TRAINING CARDS

	</h1>

	
	<form action="TrainingServlet" method="post">

		<table border="2">

			<tr>

				<th>Period</th>

				<th>Monday</th>
				
				<th>Tuesday</th>
				
				<th>Wednesday</th>
				
				<th>Thursday</th>
				
				<th>Friday</th>
				
				<th>Saturday</th>
				
				<th>Sunday</th>
		
			</tr>

			<%

				for (int i = 0; i < t_CardList.size(); i++) {
					
			%>

			<tr>

				<td><%=t_CardList.get(i).getId_training_card()%></td>

				<td><%=t_CardList.get(i).getMonday()%></td>
				
				<td><%=t_CardList.get(i).getTuesday()%></td>
				
				<td><%=t_CardList.get(i).getWednesday()%></td>
				
				<td><%=t_CardList.get(i).getThursday()%></td>
				
				<td><%=t_CardList.get(i).getFriday()%></td>
				
				<td><%=t_CardList.get(i).getSaturday()%></td>
				
				<td><%=t_CardList.get(i).getSunday()%></td>
	
			</tr>

			<%

				}

			%>

		</table>
	</form>

	<form action="trainerTraining.jsp" method="post">
	
		<h3>
			ID: <input type="text" id="id_training_card" name="id_training_card"
				placeholder="inserisci id della scheda">
		</h3>
		
		<button type="submit" formaction=trainerTrainingCardUpdate.jsp?id_training=<%=id_training%> >
			UPDATE TRAINING CARD</button>
	
	
		<button type="submit" formaction=TrainingServlet?richiesta=deleteTrainingCard&id_training=<%=id_training%> >
			DELETE TRAINING CARD</button>
	
	</form>

	
	<form action="trainerTraining.jsp" method="post">
		<button type="submit">INDIETRO</button>
	</form>





</body>

</html>