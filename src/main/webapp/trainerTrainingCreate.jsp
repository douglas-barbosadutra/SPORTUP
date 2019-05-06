<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2><center>------- TRAININGS -------</center></h2>
<form action="CustomersServlet?richiesta=home" method="post">
	<input type="submit" value="HOME" name="richiesta">
</form>

     <h3>Create Training Program</h3>
     <form action="TrainingServlet?richiesta=createTraining" method="post">
     	
     	<h4>Info: <input type = "text" id = "info" name ="info" placeholder = "Add Info"></h4>
     	
     	<input type="submit" value="create training" name="richiesta">
     	
     </form>

     

</body>
</html>