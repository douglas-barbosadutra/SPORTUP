<%@ page import="javax.servlet.http.HttpUtils.*" %>  

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Menu Principale</title>




</head>


<body>
   
    <%
    
    //int id =(int)request.getAttribute("id");
     
    //String   notify=request.getParameter("notify");
    int id_player;
    
    if(request.getAttribute("id")!=null)
    	id_player = Integer.parseInt(request.getAttribute("id").toString());
    else 
    	id_player = Integer.parseInt(request.getParameter("id"));
    
    %>
  
     

	<h1>Benvenuto: ${utente}</h1>
	
	<h2>------- MENU PLAYER -------</h2>

	<h3>COSA VUOI FARE</h3>
	

	
<form action="playerTrainingView.jsp?id=<%=id_player%>" method="post" > 
	<button type="submit">
     VIEW TRAINING  </button>
	</form>

	
	<form action="playerBiomedicalDataView.jsp?id=<%=id_player%>" method="post" > 
	<button type="submit">
     VIEW BIOMEDICAL DATA CARD </button>
	</form>
	
	<form action="UsersServlet?richiesta=info&id=<%=id_player%>" method="post" >
	<button type="submit" value="esempioManager" name="info">ViewPersonalInfo</button>
	</form>
	

	<form action="UsersServlet?richiesta=add&id=<%=id_player %>" method="post" >
	
		<label for="name" >aggiungi info</label>
		 <input type="text" id="info" name="info" required><br>
			<button  type="submit" value="esempioManager" name="add_info">Add Info</button>
	</form>
	
	
	
	
	<p>${notify}<p>
		


	
		<button onclick="location.href ='LogoutServlet';"  type="submit" value="esempioManager">Exit</button>
	
	
	
	<!--  
     <h3>2. Badges</h3>
     <form action="BadgeServlet" method="post">
     <button type="submit" value="badgesManagement" name="richiesta"> Management badge</button>
     </form>
     
     <h3>3. Assegnazione Badges</h3>
     <form action="AssegnazioneServlet" method="post">
     <button type="submit" value="assegnazioneManagement" name="richiesta"> Management Assegnazione</button>
     </form>
     
     <h3>4. Indietro</h3>
     <form action="CustomersServlet" method="post">
     <input type="submit" value="indietro" name="richiesta">
     </form>
     
       <h3>5.logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>
-->


</body>
</html>