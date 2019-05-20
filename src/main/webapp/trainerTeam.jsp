<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="it.contrader.dto.TeamDTO" %>
<%@ page import="it.contrader.model.Team" %>
<%@ page import="it.contrader.converter.ConverterTeam" %>
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

<%
	
%>
</head>

<%
		
		ConverterTeam converterTeam = new ConverterTeam();
		List<TeamDTO> teamListDTO = (List<TeamDTO>)request.getAttribute("allTeamDTO");
		List<Team> teamList = converterTeam.toListEntity(teamListDTO);
		
		
%>

<body>

	<h1>

		LISTA TEAM

	</h1>
	
	<table>

			<tr>

				<th>ID</th>

				<th>Info</th>
		

			</tr>

			<%

				for (int i = 0; i < teamList.size(); i++) {
					
			%>

			<tr>

				<td><%=teamList.get(i).getIdTeam()%></td>

				<td><%=teamList.get(i).getInfo()%></td>
				

			</tr>

			<%

				}

			%>
		</table>
		
<form action="/Team/assign/" method="get">
	<h4>ID TEAM: <input type = "text" id = "team" name ="idTeam" placeholder = "inserisci id_team">ID PLAYER: <input type = "text" id = "team" name ="idPlayer" placeholder = "inserisci id_player">
	<button formaction="/Team/assign" type="submit">ASSEGNA TEAM</button></h4>
</form>	

<form action="/Team/creaTeam/" method="get">
	<h4>INFO TEAM: <input type = "text" id = "team" name ="info" placeholder = "inserisci info team">
	<button formaction="/Team/creaTeam" type="submit">CREA TEAM</button></h4>
</form>

<form action="/User/assign/" method="get">
	<h4>ID TEAM: <input type = "text" id = "team" name ="id" placeholder = "inserisci id_team">INFO NUOVA: <input type = "text" id = "team" name ="info" placeholder = "inserisci info">
	<button formaction="/Team/update" type="submit">MODIFICA TEAM</button></h4>
</form>	

<form action="/Team/delete/" method="get">
	<h4>ID TEAM: <input type = "text" id = "team" name ="id" placeholder = "inserisci id_team">
	<button formaction="/Team/delete" type="submit">ELIMINA</button></h4>
</form>

			<li><a href="/Trainer/back/">back</a></li>
            <a href="/Home/logout/">Logout</a>
         
<h1>GESTIONE USER</h1>
</body>
</html>