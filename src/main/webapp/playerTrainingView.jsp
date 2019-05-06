<%@ page import="it.contrader.model.BiomedicalData"%>
<%@ page import="it.contrader.model.Player"%>
<%@ page import="it.contrader.service.TrainingServiceDTO"%>
<%@ page import="it.contrader.service.UsersServiceDTO"%>

<%@ page import="javax.servlet.http.HttpUtils.*" %>  

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Register Trader</title>
</head>
<body>
	<h2>------- Program Assigned -------</h2>
	<div>
	
	<%
	
	
	UsersServiceDTO tServiceDTO = new UsersServiceDTO();
	
	int player_id = Integer.parseInt(request.getParameter("id"));
	
	Player player = new Player();
	
	player = tServiceDTO.getTrainingInfo(player_id);
	
	String info = player.getTrainingInfo();

	
	%>
	
	<h5> <%=info%>   </h5>
	
	 <form action="playerTrainingCardView.jsp?id=<%=player_id%>" method="post" >
		<button type="submit">VIEW TRAINING CARD </button>
	</form>
	
		
	</div>
</body>
</html>