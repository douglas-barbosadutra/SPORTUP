<%@ page import="it.contrader.dto.UserDTO"%>
<%@ page import="it.contrader.model.User"%>
<%@ page import="it.contrader.service.TrainingServiceDTO"%>
<%@ page import="it.contrader.dto.TrainingCardDTO"%>
<%@ page import="it.contrader.dao.TrainingCardDAO"%>
<%@ page import="it.contrader.model.Player"%>
<%@ page import="it.contrader.model.TrainingCard"%>



<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>

<head>

<%

		TrainingServiceDTO trainingServiceDTO = new TrainingServiceDTO();
        Player player=new Player();
        player.setUserId(Integer.parseInt(request.getParameter("id")));
        int id_player = Integer.parseInt(request.getParameter("id"));
		List<TrainingCard> trainingcardList = trainingServiceDTO.getAllTrainingCardPlayer(player);

%>

</head>

<body>

	<h1>

		LISTA TRAINING CARD

	</h1>

	

	



	<form action="TrainingServlet" method="post">

		<table border="2">

			<tr>

				<th>IDTRAININGCARD</th>

				<th>MONDAY</th>
				<th>TUESDAY</th>
				<th>WEDNESDAY</th>
				<th>THURSDAY</th>
				<th>FRIDAY</th>
				<th>SATURDAY</th>
				<th>SUNDAY</th>
				

			</tr>

			<%

				for (int i = 0; i < trainingcardList.size(); i++) {
					
			%>

			<tr>

				<td><%=trainingcardList.get(i).getId_training_card()%></td>

				<td><%=trainingcardList.get(i).getMonday()%></td>
				
				<td><%=trainingcardList.get(i).getTuesday()%></td>
				
				<td><%=trainingcardList.get(i).getWednesday()%></td>
				
				<td><%=trainingcardList.get(i).getThursday()%></td>
				
				<td><%=trainingcardList.get(i).getFriday()%></td>
				
				<td><%=trainingcardList.get(i).getSaturday()%></td>
				
				<td><%=trainingcardList.get(i).getSunday()%></td>



				

			</tr>

			<%

				}

			%>

		</table>
	</form>

	<form action="homePlayer.jsp?id=<%=id_player%>" method="post" >
		<button type="submit">INDIETRO</button>
	</form>





</body>

</html>