<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="it.contrader.dto.UserDTO" %>
<%@ page import="it.contrader.model.User" %>
<%@ page import="it.contrader.converter.ConverterUser" %>
<%@ page import="it.contrader.services.UserService" %>
<%@ page import="java.util.*" %>
<!-- Custom styles for this template -->
<link href="/css/navbar.css" rel="stylesheet">
</head>

<%
		ConverterUser converterUser = new ConverterUser();
		List<UserDTO> userListDTO = (List<UserDTO>) request.getAttribute("userListDTO");
		List<User> userList = converterUser.toListEntity(userListDTO);
		
		
%>


<body>
<h1>HOME NUTRITIONIST</h1>

<h1>

		LISTA ATLETI

	</h1>
	
	<table>

			<tr>

				<th>ID</th>

				<th>Username</th>
		
			</tr>

			<%

				for (int i = 0; i < userList.size(); i++) {
					if(userList.get(i).getType().equals("player")){
					
			%>

			<tr>

				<td><%=userList.get(i).getIdUser()%></td>

				<td><%=userList.get(i).getUsername()%></td>
				
			</tr>

			<%
					}
				}

			%>
		</table>


<form action="/Diet" method="get">
         	<h4>INSERISCI ID ATLETA<input type="text" id = "diet" name ="id" placeholder = "inserisci id_player"></h4>

         	<button formaction="/Diet/view" type="submit">VIEW DIET</button>
         	<li><a href="/Home/logout/">Logout</a></li>
    
</form>
</body>
</html>