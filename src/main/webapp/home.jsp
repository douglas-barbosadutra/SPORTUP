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
<h1>HOME ADMIN</h1>
<h3>Cosa vuoi gestire?</h3>
<nav class='navbar navbar-inverse'>
     <div class='container-fluid'>
         <ul class='nav navbar-nav navbar-inverse navbar-custom'>
            <li><a href="/Home/userManagement/">User</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
         </ul>
    </div>
</nav>

</body>
</html>