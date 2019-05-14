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


<%
String bloodPressure=request.getParameter("bloodPressure");
String deleted=request.getParameter("deleted");
String fatFreeMass=request.getParameter("fatFreeMass");
String fatMass=request.getParameter("fatMass");
String hearthBeat=request.getParameter("hearthBeat");
String height=request.getParameter("height");
String weight=request.getParameter("weight");
%>

</head>
<body>

<table>
  <tr>
    <th>pressione sanguigna</th>
    <th>cancellato</th>
    <th>Massa magra</th>
         <th>Massa grassa</th>
    <th>battito cardiaco</th>
    <th>altezza</th>
         <th>peso</th>
      
  </tr>
  
  <tr>
<td>${bloodPressure}</td>
<td>${deleted} </td>
<td>${fatFreeMass} </td>
<td>${fatMass} </td>
    <td>${hearthBeat}</td>
      <td>${height}</td>
        <td>${ weight}</td>
  </tr>
 
</table>



</body>
</html>