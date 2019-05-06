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
 String username=request.getParameter("username");  
 String role=request.getParameter("role");  
 String pass=request.getParameter("pass");  
 String info=request.getParameter("info");  
 
 %>

</head>
<body>
<table>
  <tr>
    <th>Nome</th>
    <th>Ruolo</th>
    <th>Password</th>
     <th>info</th>
  </tr>
  
  <tr>
<td>${username}</td>
<td>${role} </td>
<td>${pass} </td>
<td> ${info}</td>
  </tr>
 
</table>
</body>
</html>