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
//ConverterBiomedicalData converterBiomedicalData = new ConverterBiomedicalData();
PlayerDTO p= (PlayerDTO)request.getAttribute("playerDTO");
//BiomedicalData bD = converterBiomedicalData.toEntity(bData);
%>

<body>
<h1>BIOMEDICAL DATA MANAGEMENT</h1>

            

	
		

		<table border="2">

			<tr>

				<th>ID</th>

				<th>INFO</th>
		
				<th>RUOLO</th>
				
				
			</tr>
			
			<%

				//for (int i = 0; i < bData.size(); i++) {
					
			%>
			
			<tr>

				<td><%=p.getIdPlayer()%></td>

				<td><%=p.getInfo()%></td>
				
				<td><%=p.getRuolo()%></td>
				
				

				

			</tr>
			<%
			//}
			%>
			

		</table>            	
            
     
        <form action="/Player/updateInfo/" method="get">
            <button formaction="/Player/updateInfo" type="submit">UPDATE INFO</button>
        </form>
        
        
        <form action="/Player/updateInfo" method="get">
        
        	<h3>
				 <input type="hidden"  name="id"
					value=<%=p.getIdPlayer() %>>
			</h3>
			
			<h3>
				info: <input type="text"  name="info"
					value=<%=p.getInfo() %>>
			</h3>
			
			<h3>
				ruolo: <input type="text"  name="ruolo"
					value=<%=p.getRuolo() %>>
			</h3>
			
			<button formaction="/Player/updateInfo" type="submit">UPDATE</button>
		</form>
		
		
		    
            <li><a href="/Trainer/back/">back</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
    
   
</body>
</html>