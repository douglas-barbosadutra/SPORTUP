<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="it.contrader.dto.UserDTO" %>
<%@ page import="it.contrader.model.User" %>
<%@ page import="it.contrader.converter.ConverterUser" %>
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
		
		ConverterUser converterUser = new ConverterUser();
		List<UserDTO> userListDTO = (List<UserDTO>)request.getAttribute("allUserDTO");
		List<User> userList = converterUser.toListEntity(userListDTO);
		
		
%>

<body>

	<h1>

		LISTA UTENTI

	</h1>
	
	<table>

			<tr>

				<th>ID</th>

				<th>Username</th>
		
				<th>Type</th>

			</tr>

			<%

				for (int i = 0; i < userList.size(); i++) {
					
			%>

			<tr>

				<td><%=userList.get(i).getIdUser()%></td>

				<td><%=userList.get(i).getUsername()%></td>
				
				<td><%=userList.get(i).getType()%></td>



				

			</tr>

			<%

				}

			%>
		</table>
<form action="/User/assign/" method="get">
	<h4>id_user: <input type = "text" id = "user" name ="id" placeholder = "inserisci id_user">type: <input type = "text" id = "user" name ="type" placeholder = "inserisci il tipo"></h4>
	
	<h4><button formaction="/User/delete" type="submit">ELIMINA</button>
	<button formaction="/User/assignType" type="submit">ASSEGNA TIPO</button></h4>
</form>	

            <a href="/Home/logout/">Logout</a>
         
<h1>GESTIONE USER</h1>
</body>
</html>