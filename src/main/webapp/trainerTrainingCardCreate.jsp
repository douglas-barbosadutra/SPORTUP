<%@ page import="it.contrader.dto.UserDTO"%>
<%@ page import="it.contrader.model.Training"%>
<%@ page import="it.contrader.service.TrainingServiceDTO"%>


<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>

<head>

<%
		
		int id_training = Integer.parseInt(request.getParameter("id_training"));
		TrainingServiceDTO trainingServiceDTO = new TrainingServiceDTO();
		
%>

</head>
<body>

<h2><center>------- TRAININGS -------</center></h2>
<form action="CustomersServlet?richiesta=home" method="post">
	<input type="submit" value="HOME" name="richiesta">
</form>

     <h3>Create Training Card</h3>
     <form action="TrainingServlet?richiesta=createTrainingCard" method="post">
     	
     	<form action="TrainingServlet" method="post">
			<h3>
				monday: <input type="text"  name="monday">
			</h3>
			<h3>
				tuesday: <input type="text"  name="tuesday">
			</h3>
			<h3>
				wednesday: <input type="text"  name="wednesday">
			</h3>
			<h3>
				thursday: <input type="text"  name="thursday">
			</h3>
			<h3>
				friday: <input type="text"  name="friday">
			</h3>
			<h3>
				saturday: <input type="text"  name="saturday">
			</h3>
			<h3>
				sunday: <input type="text"  name="sunday">
			</h3>
			<button type="submit" value="Insert" formaction=TrainingServlet?richiesta=createTrainingCard&id_training=<%=id_training%> name="pulsante">CREATE</button>
		</form>
     	
     </form>

     

</body>
</html>