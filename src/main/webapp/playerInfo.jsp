<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 50%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>



 <%
 String name=request.getParameter("name");  
 String password=request.getParameter("password");  
 String role=request.getParameter("role");  
 String info_training=request.getParameter("info_training");  
 String info_player=request.getParameter("info_player"); 
 %>

</head>
<body>
<table>
  <tr>
    <th>Nome</th>
    <th>Password</th>
         <th>Ruolo</th>
     <th>Training</th>
     <th>Info</th>
  </tr>
  
  <tr>
<td>${name}</td>
<td>${password} </td>
<td>${role} </td>
<td> ${info_training}</td>
<td> ${info_player}</td>
  </tr>
 
</table>
<form action="homePlayer.jsp?id=<%=request.getParameter("id") %>" method="post">
		<button type="submit">INDIETRO</button>
	</form>
</body>
</html>