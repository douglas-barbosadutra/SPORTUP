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
String info=request.getAttribute("info").toString();  
int idTraining=(int)request.getAttribute("id") ; 
%>

</head>
<body>

<table>
  <tr>
    <th>idTraining</th>
    <th>info</th>
  </tr>
  <tr>
<td><%=idTraining %></td>
<td><%=info %> </td>
  </tr>
 
</table>

</body>
</html>