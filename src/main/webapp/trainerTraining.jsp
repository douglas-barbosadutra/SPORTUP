<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="it.contrader.dto.TrainingDTO" %>
<%@ page import="it.contrader.model.Training" %>
<%@ page import="it.contrader.converter.ConverterTraining" %>
<%@ page import="java.util.*" %>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Home</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/navbar.css" rel="stylesheet">
</head>

<%
		
		ConverterTraining converterTraining = new ConverterTraining();
		List<TrainingDTO> trainingListDTO = (List<TrainingDTO>)request.getAttribute("allTrainingDTO");
		List<Training> trainingList = converterTraining.toListEntity(trainingListDTO);
		
		
%>

<body>
<h1>

		LISTA UTENTI

	</h1>
	
	<table>

			<tr>

				<th>ID</th>

				<th>Info</th>
		

			</tr>

			<%

				for (int i = 0; i < trainingList.size(); i++) {
					
			%>

			<tr>

				<td><%=trainingList.get(i).getIdTraining()%></td>

				<td><%=trainingList.get(i).getInfo()%></td>
								

			</tr>

			<%

				}

			%>
		</table>
		
		<form action="/Training/update" method="get">
         	<h4>INSERISCI ID ALLENAMENTO<input type="text" id = "training" name ="id" placeholder = "inserisci id_training"> INSERISCI INFO NUOVA <input type="text" id = "training" name ="info" placeholder = "inserisci modifica"> <button formaction="/Training/update" type="submit">MODIFICA</button></h4>    
		</form>

        <form action="/Training/creaTraining" method="get">    
            <h4>INSERISCI ALLENAMENTO<input type="text" id = "training" name ="info" placeholder = "inserisci info"><button formaction="/Training/creaTraining" type="submit">CREATE TRAINING PROGRAMS</button></h4>
        </form>
        
         <form action="/Training/delete" method="get">    
            <h4>ELIMINA ALLENAMENTO<input type="text" id = "training" name ="id" placeholder = "inserisci id_training"><button formaction="/Training/delete" type="submit">DELETE TRAINING PROGRAMS</button></h4>
        </form>
        
        <form action="/TrainingCard/view" method="get">    
            <h4>VISUALIZZA SCHEDA<input type="text" id = "training" name ="id" placeholder = "inserisci id_training"><button formaction="/TrainingCard/view" type="submit">VIEW TRAINING CARD</button></h4>
        </form>
        
            <li><a href="/Trainer/back/">back</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
        

</body>
</html>