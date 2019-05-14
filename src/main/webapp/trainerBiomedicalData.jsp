<%@page import="it.contrader.controller.PlayerController"%>
<%@page import="it.contrader.services.PlayerService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="it.contrader.model.BiomedicalData"%>
<%@ page import="it.contrader.model.Player"%>
<%@ page import="it.contrader.dto.PlayerDTO"%>
<%@ page import="it.contrader.services.BiomedicalDataService"%>
<%@ page import="it.contrader.dto.BiomedicalDataDTO"%>
<%@ page import="it.contrader.dao.PlayerRepository"%>
<%@ page import="it.contrader.converter.ConverterBiomedicalData" %>

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
ConverterBiomedicalData converterBiomedicalData = new ConverterBiomedicalData();
BiomedicalDataDTO bData= (BiomedicalDataDTO)request.getAttribute("bDATA");
BiomedicalData bD = converterBiomedicalData.toEntity(bData);
%>

<body>
<h1>BIOMEDICAL DATA MANAGEMENT</h1>

        <form action="/BiomedicalData/update" method="get">
        
        	<h3>
				 <input type="hidden"  name="id"
					value=<%=bD.getIdBiomedicalData() %>>
			</h3>
			
			<h3>
				heartbeat: <input type="text"  name="heartbeat"
					value=<%=bD.getHearthbeat() %>>
			</h3>
			
			<h3>
				blood pressure: <input type="text"  name="blood_pressure"
					value=<%=bD.getBloodPressure() %>>
			</h3>
			<h3>
				height: <input type="text"  name="height"
					value=<%=bD.getHeight()%>>
			</h3>
			<h3>
				weight: <input type="text"  name="weight"
					value=<%=bD.getWeight() %>>
			</h3>
			<h3>
				fat mass: <input type="text"  name="fat_mass"
					value=<%=bD.getFatMass()%>>
			</h3>
			<h3>
				fat free mass: <input type="text"  name="fat_free_mass"
					value=<%=bD.getFatFreeMass()%>>
			</h3>
			<button formaction="/BiomedicalData/update" type="submit">UPDATE</button>
		</form>
		
		
		    
            <li><a href="/Trainer/back/">back</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
    
   
</body>
</html>