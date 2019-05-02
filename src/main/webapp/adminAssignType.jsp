<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2><center>------- ASSIGN TYPE -------</center></h2>


     <h3>Assegna il tipo</h3>
     
     <form action="UsersServlet" method="post">
     <h4>id_user: <input type = "text" id = "user" name ="id_user" placeholder = "inserisci id_user"></h4>
     	
       <button type="submit" value="Trainer" formaction=UsersServlet?richiesta=assignTypeTrainer name="pulsante">Trainer</button>
       <button type="submit" value="Player" formaction=UsersServlet?richiesta=assignTypePlayer name="pulsante">Player</button>

            	
     </form>
     
     <form action="adminUsers.jsp" method="post">
		<button type="submit">INDIETRO</button>
	</form>
     
 
     	
     

     

</body>
</html>