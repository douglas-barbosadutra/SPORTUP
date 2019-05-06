<%@ page import="it.contrader.dto.UserDTO"%>
<%@ page import="it.contrader.model.Training"%>
<%@ page import="it.contrader.service.TrainingServiceDTO"%>


<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>

<head>

<%

		TrainingServiceDTO trainingServiceDTO = new TrainingServiceDTO();
		List<Training> trainingList = trainingServiceDTO.getAllTraining();

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
	</form>

	<form action="trainerTraining.jsp" method="post">
	
		<h3>
			ID: <input type="text" id="id_training" name="id_training" value=<%=request.getParameter("id_training") %>
				placeholder="inserisci id del training">
		</h3>
		
		<h3>
			Info: <input type="text" id="info_training" name="info_training"
				placeholder="insert info training">
		</h3>
		
		<button type="submit" formaction=TrainingServlet?richiesta=updateTraining> 
			UPDATE INFO TRAINING PROGRAM</button>
	
		<button type="submit"> DELETE TRAINING PROGRAM</button>
		
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