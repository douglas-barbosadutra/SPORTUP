<%@page import="it.contrader.controller.PlayerController"%>
<%@page import="it.contrader.services.PlayerService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="it.contrader.model.Performance"%>
<%@ page import="it.contrader.model.Player"%>
<%@ page import="it.contrader.dto.PlayerDTO"%>
<%@ page import="it.contrader.services.PerformanceService"%>
<%@ page import="it.contrader.dto.PerformanceDTO"%>
<%@ page import="it.contrader.dao.PerformanceRepository"%>
<%@ page import="it.contrader.converter.ConverterPerformance" %>

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
ConverterPerformance converterPerformance = new ConverterPerformance();
PerformanceDTO perfDTO = (PerformanceDTO)request.getAttribute("perfDTO");
Performance perf = converterPerformance.toEntity(perfDTO);
int idPerf = perf.getIdPerformance();
%>

<body>
<h1>PERFORMANCE MANAGEMENT</h1>

        <form action="/BiomedicalData/update" method="get">
        
        	<h3>
				Max Corsa (min): <input type="text"  name="maxCorsaMin"
					value=<%=perf.getMaxCorsaMin() %>>
			</h3>
			
			<h3>
				Max Flessioni: <input type="text"  name="maxFlessioni"
					value=<%=perf.getMaxFlessioni()%>>
			</h3>
			<h3>
				Max Addominali: <input type="text"  name="maxAddominali"
					value=<%=perf.getMaxAddominali()%>>
			</h3>
			<input type="hidden" name="idPerf" value=<%=idPerf%>>
			<button formaction="/Performance/update" type="submit">UPDATE</button>
		</form>
		    
            <li><a href="/Performance/back/">back</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
    
   
</body>
</html>