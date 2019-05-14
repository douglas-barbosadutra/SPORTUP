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

<style>

body {
background-color:#0066cc;
    text-align: center;

}


button {
border-radius:5px;
	background-color:#BEBEBE;
	display:inline-block;
	border:none;
	color:black;
	font-family:Arial;
	padding:16px 31px;
	text-decoration:none;

}
button:hover {
	background-color:white;
}
button:active {
	position:relative;
	top:1px;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
 
}

li {
  float: left;

}



li button{
  display: inline-block;
  text-align: center;
  padding: 14px 19px;
  text-decoration: none;
  margin-right: 3px;
}

p{

color:white;
 font-size: 15;

}


</style>



<%String id=request.getAttribute("id").toString(); %>
</head>

<body>

	<h1>Welcome: ${utente}</h1>
	
	<h2> HOME PLAYER</h2>
	
	<ul>
	 <li>
	<form action="/Player/getTraining" method="post" >
	 <input type="hidden" name="id" value=<%=id %>>
		<button type="submit" value="esempioManager" name="training">Training</button>
	</form>
 </li>
  <li>
	<form action="/Player/getInfo" method="post">
	 <input type="hidden" name="id" value="${id}" />
		<button type="submit" value="esempioManager" name="print_info"  value="${id}" >Info</button>
	</form>
   </li>
    <li>
	<form action="/Player/addInfo" method="post" >
	<label for="name" >aggiungi info</label>
	 <input type="hidden" name="id" value="${id}" />
     <input type="text" id="name" name="info" required>
		<button  type="submit" value="esempioManager" name="add_info">Add Info</button>
	</form>
	 </li>

<li>
	<form action="/Player/logOut" method="post" >
		<button type="submit">Exit</button>
			</form>
		</li>
		
		<li>
		<form action="/Performance/getPerformance" method="post" >
		 <input type="hidden" name="id" value="${id}"/>
		<button type="submit">Performance</button>
			</form>
		</li>
		
			<li>
		<form action="/BiomedicalData/getBiomedical" method="post" >
		 <input type="hidden" name="id" value="${id}"/>
		<button type="submit">Biomedical</button>
			</form>
		</li>
		
		
	</ul>

</body>
</html>