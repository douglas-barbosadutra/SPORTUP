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

<!-- Custom styles for this template -->
<link href="/css/navbar.css" rel="stylesheet">
</head>

<body>
<h1>HOME TRAINER</h1>

<form action="/Trainer/training" method="get">
         	<a href="/Trainer/training"><button>TRAINING</button></a>
</form>
         
<form action="/Team/view" method="get">
         	<a href="/Team/visualteam"><button>TEAM</button></a>
</form>
<form action="/Trainer/Training" method="get">
         	<h4>INSERISCI ID ATLETA<input type="text" id = "biomedicalData" name ="id" placeholder = "inserisci id_player">
         	<button formaction="/Trainer/biomedicalData" type="submit">BIOMEDICAL DATA</button></h4>
         	<button formaction="/Trainer/performance" type="submit">PERFORMANCE</button></h4>
        
            <li><a href="/Home/logout/">Logout</a></li>
    
</form>
</body>
</html>