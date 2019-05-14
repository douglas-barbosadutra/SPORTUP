<%@page import="it.contrader.dto.PerformanceDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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

<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%

String abdominal=request.getParameter("abdominal");
String run=request.getParameter("run");
String pushups=request.getParameter("pushups");   
%>

</head>
<body>
<table>
  <tr>
    <th>addominali</th>
    <th>corsa</th>
         <th>flessioni</th>
  </tr>
  
  <tr>
<td>${abdominal}</td>
<td>${run} </td>
<td>${pushups} </td>
  </tr>
 
</table>

</body>
</html>