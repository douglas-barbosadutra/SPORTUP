<%@page import="it.contrader.controller.PlayerController"%>
<%@page import="it.contrader.services.PlayerService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="it.contrader.model.TrainingCard"%>
<%@ page import="it.contrader.model.Player"%>
<%@ page import="it.contrader.model.Training"%>
<%@ page import="it.contrader.dto.PlayerDTO"%>
<%@ page import="it.contrader.services.TrainingCardService"%>
<%@ page import="it.contrader.services.TrainingService"%>
<%@ page import="it.contrader.dto.TrainingDTO"%>
<%@ page import="it.contrader.dto.TrainingCardDTO"%>
<%@ page import="it.contrader.dao.PlayerRepository"%>
<%@ page import="it.contrader.converter.ConverterTrainingCard" %>

<%@ page import="java.util.*"%>


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
List<TrainingCardDTO> trainingCardListDTO = (List<TrainingCardDTO>)request.getAttribute("allTrainingCardDTO");
%>

<body>
<h1>TRAINING CARD MANAGEMENT</h1>

            

	
		

		
            
     
       <table>

			<tr>

				<th>ID</th>

				<th>lunedi</th>
				
				<th>martedi</th>
				
				<th>mercoledi</th>
				
				<th>giovedi</th>
				
				<th>venerdi</th>
				
				<th>sabato</th>
				
				<th>domenica</th>
		

			</tr>

			<%
				//System.out.println(request.getParameter("id"));
				TrainingDTO tr = (TrainingDTO)request.getAttribute("tr");
				
				for (int i = 0; i < trainingCardListDTO.size(); i++) {
					
					System.out.println(tr.getIdTraining());
					if (trainingCardListDTO.get(i).getDeleted()==0 && trainingCardListDTO.get(i).getTraining().getIdTraining()==tr.getIdTraining()){
					
			%>

			<tr>

				<td><%=trainingCardListDTO.get(i).getIdTrainingCard()%></td>

				<td><%=trainingCardListDTO.get(i).getMonday()%></td>
				
				<td><%=trainingCardListDTO.get(i).getTuesday()%></td>
				
				<td><%=trainingCardListDTO.get(i).getWednesday()%></td>
				
				<td><%=trainingCardListDTO.get(i).getThursday()%></td>
				
				<td><%=trainingCardListDTO.get(i).getFriday()%></td>
				
				<td><%=trainingCardListDTO.get(i).getSaturday()%></td>
				
				<td><%=trainingCardListDTO.get(i).getSunday()%></td>
								

			</tr>

			<%
					}
				}

			%>
		</table>
		
			
			<form action="/TrainingCard/update" method="get">
         	<h4>INSERISCI ID SCHEDA<input type="text" id = "trainingCard" name ="id" placeholder = "inserisci id_trainingCard"><input type="hidden" id = "trainingCard" name ="idTraining" value=<%=tr.getIdTraining() %>> <button formaction="/TrainingCard/update" type="submit">MODIFICA</button></h4>    
			</form>
		    
            <li><a href="/Training/back/">back</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
    
   
</body>
</html>