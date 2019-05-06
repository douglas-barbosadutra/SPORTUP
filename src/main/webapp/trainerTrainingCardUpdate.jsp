<%@ page import="it.contrader.dto.UserDTO"%>
<%@ page import="it.contrader.model.Training"%>
<%@ page import="it.contrader.model.TrainingCard"%>
<%@ page import="it.contrader.service.TrainingServiceDTO"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>

<head>

<%
		
		int id_training = Integer.parseInt(request.getParameter("id_training"));
		int id_training_card = Integer.parseInt(request.getParameter("id_training_card"));
		TrainingServiceDTO trainingServiceDTO = new TrainingServiceDTO();
		TrainingCard t_card = new TrainingCard();
		t_card.setId_training(id_training);
		t_card.setId_training_card(id_training_card);
		t_card = trainingServiceDTO.getTrainingCard(t_card);
		
%>

</head>
<body>

<h2><center>------- TRAINING CARD -------</center></h2>
<form action="CustomersServlet?richiesta=home" method="post">
	<input type="submit" value="HOME" name="richiesta">
</form>

     <h3>Update Training Card</h3>	
     	<form action="TrainingServlet?richiesta=updateTrainingCard" method="post">
			<h3>
				monday: <input type="text"  name="monday" value=<%=t_card.getMonday()%>>
			</h3>
			<h3>
				tuesday: <input type="text"  name="tuesday" value=<%=t_card.getTuesday()%>>
			</h3>
			<h3>
				wednesday: <input type="text"  name="wednesday" value=<%=t_card.getWednesday()%>>
			</h3>
			<h3>
				thursday: <input type="text"  name="thursday"value=<%=t_card.getThursday()%>>
			</h3>
			<h3>
				friday: <input type="text"  name="friday" value=<%=t_card.getFriday()%>>
			</h3>
			<h3>
				saturday: <input type="text"  name="saturday" value=<%=t_card.getSaturday()%>>
			</h3>
			<h3>
				sunday: <input type="text"  name="sunday" value=<%=t_card.getSunday()%>>
			</h3>
			<button type="submit" value="Insert" formaction="TrainingServlet?richiesta=updateTrainingCard&id_training=<%=id_training%>&id_training_card=<%=id_training_card%>" name="pulsante">UPDATE</button>
		</form>
     	     

</body>
</html>