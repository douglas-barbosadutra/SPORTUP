<%@ page import="it.contrader.model.BiomedicalData"%>
<%@ page import="it.contrader.model.Player"%>
<%@ page import="it.contrader.service.BiomedicalDataServiceDTO"%>

<%@ page import="javax.servlet.http.HttpUtils.*" %>  

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Register Trader</title>
</head>
<body>
	<h2>------- VIEW BIOMEDICALDATA -------</h2>
	<div>
	
	<%
	
	BiomedicalData bData = new BiomedicalData();
	BiomedicalDataServiceDTO bDataServiceDTO = new BiomedicalDataServiceDTO();
	
	int player_id = Integer.parseInt(request.getParameter("id_player"));
	System.out.println(player_id);
	Player player = new Player(player_id);
	
	bData = bDataServiceDTO.getPlayerBData(player);
	
	%>
	
		<form action="BiomedicalDataServlet" method="post">

		<table border="2">

			<tr>

				<th>Heartbeat</th>

				<th>Blood pressure</th>
		
				<th>Height</th>
				
				<th>Weight</th>
				
				<th>Fat mass</th>
				
				<th>Fat free mass</th>
				
			<tr>
			
			
			<tr>

				<td><%=bData.getHearthbeat()%></td>

				<td><%=bData.getBlood_pressure()%></td>
				
				<td><%=bData.getHeight()%></td>
				
				<td><%=bData.getWeight()%></td>
				
				<td><%=bData.getFat_mass()%></td>
				
				<td><%=bData.getFat_free_mass()%></td>



				

			</tr>

			

		</table>
	</form>
	
	 <form action="trainerBiomedicalData.jsp" method="post">
		<button type="submit">INDIETRO</button>
	</form>
	
		
	</div>
</body>
</html>