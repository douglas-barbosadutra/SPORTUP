<%@page import="it.contrader.model.Player"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<% 
int idBio=(int)request.getAttribute("idBio");  
int idTraining=(int)request.getAttribute("idTraining");  
String ruolo=request.getAttribute("type").toString();  
String info=request.getAttribute("info").toString(); 


%>

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
<table>
  <tr>
    <th>idBio</th>
    <th>idTraining</th>
         <th>Role</th>
     
     <th>infoPlayer</th>
  </tr>
  
  <tr>
<td><%=idBio %></td>
<td><%=idTraining %> </td>
<td><%=ruolo %> </td>
<td> <%=info %></td>

  </tr>
 
</table>


</body>
</html>