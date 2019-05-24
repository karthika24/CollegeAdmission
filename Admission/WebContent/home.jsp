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
	background-color: blue;
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

.dropdown-content a:hover {
	background-color: #709fea;
}

.logout {
	padding-left: 900px;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.image {
	background-image: url("image/clg.jpg");
	background-repeat:no-repeat;
	padding-top: 470px;
	
}
</style>
</head>
<body>
<body>
	<h1>CHAINSYS UNIVERSITY</h1>
	<div class="navbar">
		<a href="home.jsp"><b>Home</b></a> 
		<div class="dropdown">
			<button class="dropbtn">
				<b>Department</b> <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="ComputerServlet">Computer Science Engineering</a> 
				<a href="MechanicalServlet">Mechanical Engineering</a>
				<a href="ElectricalServlet">Electrical and Electronics Engineering</a>
				<a href="AeroServlet">Aeronautical Engineering</a>
				<a href="ITServlet">Information Technology</a>
				<a href="MathsServlet">Maths</a>
			</div>
		</div>
		<div class="logout">
			<a href="admin.jsp"><b>Logout</b></a>
		</div>
	</div>
	<div class="image">.</div>
</body>
</html>