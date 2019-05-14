<%@page import="it.contrader.controller.PlayerController"%>
<%@page import="it.contrader.services.PlayerService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="it.contrader.model.TrainingCard"%>
<%@ page import="it.contrader.model.Player"%>
<%@ page import="it.contrader.dto.PlayerDTO"%>
<%@ page import="it.contrader.services.TrainingCardService"%>
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
ConverterTrainingCard converterTrainingCard = new ConverterTrainingCard();
TrainingCardDTO tCard= (TrainingCardDTO)request.getAttribute("tCard");
TrainingCard tC = converterTrainingCard.toEntity(tCard);
%>

<body>
<h1>TRAINING CARD MANAGEMENT</h1>

        <form action="/TrainingCard/update" method="get">
        
        	<h3>
				 <input type="hidden"  name="id"
					value=<%=tC.getIdTrainingCard() %>>
			</h3>
			
			<h3>
				MONDAY: <input type="text"  name="monday"
					value=<%=tC.getMonday() %>>
			</h3>
			
			<h3>
				THUESDAY: <input type="text"  name="thuesday"
					value=<%=tC.getTuesday() %>>
			</h3>
			<h3>
				WEDNESDAY: <input type="text"  name="wednesday"
					value=<%=tC.getWednesday()%>>
			</h3>
			<h3>
				FRIDAY: <input type="text"  name="friday"
					value=<%=tC.getFriday() %>>
			</h3>
			<h3>
				THURSDAY: <input type="text"  name="thursday"
					value=<%=tC.getThursday()%>>
			</h3>
			<h3>
				SATURDAY: <input type="text"  name="saturday"
					value=<%=tC.getSaturday()%>>
			</h3>
			<h3>
				SUNDAY: <input type="text"  name="sunday"
					value=<%=tC.getSunday()%>>
			</h3>
			<button formaction="/TrainingCard/update" type="submit">UPDATE</button>
		</form>
		
		    <li><a href="/Trainer/back/">back</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
    
   
</body>
</html>