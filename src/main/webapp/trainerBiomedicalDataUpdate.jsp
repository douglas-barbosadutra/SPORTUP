
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
	<h2>------- UPDATE BIOMEDICALDATA -------</h2>
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
			<h3>
				heartbeat: <input type="text"  name="heartbeat"
					value=<%=bData.getHearthbeat() %>>
			</h3>
			
			<h3>
				blood pressure: <input type="text"  name="blood_pressure"
					value=<%=bData.getBlood_pressure() %>>
			</h3>
			<h3>
				height: <input type="text"  name="height"
					value=<%=bData.getHeight()%>>
			</h3>
			<h3>
				weight: <input type="text"  name="weight"
					value=<%=bData.getWeight() %>>
			</h3>
			<h3>
				fat mass: <input type="text"  name="fat_mass"
					value=<%=bData.getFat_mass()%>>
			</h3>
			<h3>
				fat free mass: <input type="text"  name="fat_free_mass"
					value=<%=bData.getFat_free_mass()%>>
			</h3>
			<button type="submit" value="Update" formaction=BiomedicalDataServlet?richiesta=updateBiomedicalData&id_player=<%=player_id%> name="pulsante">UPDATE</button>
		</form>
	</div>
</body>
</html>