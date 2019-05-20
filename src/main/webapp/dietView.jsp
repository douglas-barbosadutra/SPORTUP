<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="it.contrader.dto.DietDTO" %>
<%@ page import="it.contrader.model.Diet" %>
<%@ page import="it.contrader.converter.ConverterDiet" %>
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
</head>

<%
		
		ConverterDiet converterDiet = new ConverterDiet();
		DietDTO dietDTO = (DietDTO) request.getAttribute("dietDTO");
		Diet diet = converterDiet.toEntity(dietDTO);
		int idPlayer = (int) request.getAttribute("idPlayer");
		request.setAttribute("idPlayer", idPlayer);
		int idDiet = (int) request.getAttribute("idDiet");
		
		request.setAttribute("idDiet", idDiet);
		
%>

<body>
<h1>

		DIET

	</h1>
	
	<form action="/Diet" method=get>
			<h3>
				Monday: <input type="text"  name="monday"
					value=<%=diet.getMonday() %>>
			</h3>
			
			<h3>
				Tuesday: <input type="text"  name="tuesday"
					value=<%=diet.getTuesday() %>>
			</h3>
			<h3>
				Wednesday: <input type="text"  name="wednesday"
					value=<%=diet.getWednesday() %>>
			</h3>
			<h3>
				Thursday: <input type="text"  name="thursday"
					value=<%=diet.getThursday() %>>
			</h3>
			<h3>
				Friday: <input type="text"  name="friday"
					value=<%=diet.getFriday() %>>
			</h3>
			<h3>
				Saturday: <input type="text"  name="saturday"
					value=<%=diet.getSaturday() %>>
			</h3>
			<h3>
				Sunday: <input type="text"  name="sunday"
					value=<%=diet.getSunday()%>>
			</h3>
		
			<input type="hidden" name="idDiet" value=<%=idDiet%>>
			<button formaction="/Diet/update" type="submit">MODIFICA</button>
			
			<button formaction="/Diet/noDiet" type="submit">ANNULLA DIETA</button>
			
       </form>
            <li><a href="/Diet/back/">back</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
        

</body>
</html>