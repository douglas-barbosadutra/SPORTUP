<%@ page import="it.contrader.dto.TeamDTO"%>
<%@ page import="it.contrader.model.Team"%>
<%@ page import="it.contrader.service.TeamServiceDTO"%>


<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>

<head>

<%

		TeamServiceDTO teamServiceDTO = new TeamServiceDTO();
		List<Team> teamList = teamServiceDTO.getAllTeam();

%>

</head>

<body>

	<h1>

		LISTA TEAM

	</h1>

	

	



	<form action="TeamServlet" method="post">

		<table border="2">

			<tr>

				<th>ID</th>

				<th>Info</th>

			</tr>

			<%

				for (int i = 0; i < teamList.size(); i++) {
					
			%>

			<tr>

				<td><%=teamList.get(i).getTeamId()%></td>

				<td><%=teamList.get(i).getInfo()%></td>



				

			</tr>

			<%

				}

			%>

		</table>
	</form>

	<form action="trainerTeam.jsp" method="post">
		<button type="submit">INDIETRO</button>
	</form>





</body>

</html>