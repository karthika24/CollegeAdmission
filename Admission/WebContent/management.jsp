<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<title>Insert title here</title>
<style>
h1 {
	text-align: center;
	font-family: 'Kaushan Script', cursive;
	
}

.navbar {
	overflow: hidden;
	background-color: white;
	border: 1px solid;
	padding: 10px;
	box-shadow: 5px 10px 18px #888888;
}

.navbar a {
	float: left;
	text-align: center;
	font-size: 16px;
	border: none;
	outline: none;
	color: black;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: black;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: #f7f78f;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}
body {
	background-color:#d9e5f9;
}
.dropdown-content a:hover {
	background-color: #f9f9a9;
}

.logout {
	padding-left: 900px;
}

.dropdown:hover .dropdown-content {
	display: block;
}

b {
	font-color: red;
}

#input{
width:200px;
height:30px;
}
}

.drop {
	width: 100px;
	height: 100px;
}
table, th, td {
  border: 1px solid black;
   padding: 15px;
  text-align: left;
}
table {
  border-collapse: collapse;

}
tr:hover {background-color: #f5f5f5;}

b{
font-size:20px;
}
.action {
margin-left: 500px;
}
table {
 text-align: left;
  width: 50%;
  font-size:20px;
}

#paybtn {
width: 150px;
height:30px;
background-color: #4CAF50;
}
.h2
{
	margin-left: 20px;
}
</style>
</head>
<body>
<h1>CHAINSYS UNIVERSITY</h1>
	<div class="navbar">
		<a href="homepage.jsp"><b>Home</b></a> 
				
		<div class="dropdown">
			<button class="dropbtn">
				<b>Academic</b> <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="courses.jsp">Programmes</a> <a href="placement.jsp">Placement</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				<b>Admission</b> <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="procedures.jsp">Procedure</a> 
				 <a href="OnlineApplicationServlet">Apply
					online</a>
					 <a href="AdmissionType">Admission type</a>
					<a href="viewapplication.jsp">View Application</a> <a
					href="ViewResultServlet">View Result</a>
			</div>
		</div>
		<div class="logout">
			<a href="index.jsp"><b>Logout</b></a>
		</div>
	</div>
	<div id="management">
		<form action="TypeSelectServlet" method="post">
			<h2>Management</h2>
			 <table>
			 <c:forEach var="user" items="${USER}">
			 <tr><th>	 Course </th><td> ${user.course}</td></tr>
		<tr><th>	  Department </th><td> ${user.departmentname}</td></tr>
			<tr><th> Branch </th><td> ${user.branchname}</td></tr>
			</c:forEach>
			 </table>
			<br> <b>Enter your quotation :</b> <input type="number" id="input" min="50000" value="quote"
				name="quote" required>  (Minimum Quotation should be greater than 50000)<br> <br>
			<button type="submit" id="paybtn" name="pay" value="management">Quote</button>
		</form>
	</div>
</body>
</html>