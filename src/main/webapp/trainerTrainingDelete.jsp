<%@ page import="it.contrader.dto.UserDTO"%>
<%@ page import="it.contrader.model.User"%>
<%@ page import="it.contrader.service.UsersServiceDTO"%>


<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>

<head>

<%

		UsersServiceDTO userServiceDTO = new UsersServiceDTO();
		List<User> userList = userServiceDTO.getAllUser();

%>

</head>

<body>

	<h1>

		LISTA UTENTI

	</h1>

	

	



	<form action="UsersServlet" method="post">

		<table border="2">

			<tr>

				<th>ID</th>

				<th>Name</th>
		
				<th>Type</th>

			</tr>

			<%

				for (int i = 0; i < userList.size(); i++) {
					
			%>

			<tr>

				<td><%=userList.get(i).getUserId()%></td>

				<td><%=userList.get(i).getUsername()%></td>
				
				<td><%=userList.get(i).getUsertype()%></td>



				

			</tr>

			<%

				}

			%>

		</table>
	</form>
	
	<form action="UsersServlet?richiesta=deleteUser" method="post">
			<h3>
				ID: <input type="text" id="user" name="id_user"
					placeholder="inserisci id dell'utente">
			</h3>
			
			<button type="submit" value="Delete" name="pulsante">DELETE</button>
			
		</form>

	<form action="adminUsers.jsp" method="post">
		<button type="submit">INDIETRO</button>
	</form>





</body>

</html>