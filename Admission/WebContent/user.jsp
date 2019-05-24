<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
<title>Details</title>
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
h3 {
 padding-left:150px;
}
table {

 text-align: left;
  width: 50%;
  
}
table {
  border-collapse: collapse;
}

table, th, td {
  border: 1px solid black;
}
tr:hover {background-color:#f5f5f5;}
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
					 <a href="viewapplication.jsp">View Application</a>
					<a href="ViewResultServlet">View Result</a>
			</div>
		</div>
		<div class="logout">
			<a href="index.jsp"><b>Logout</b></a>
		</div>
	</div>
	<h3>Application Details</h3>
<table>
<tbody>
	<c:forEach var="apply" items="${USER}">
		<tr><th>Application Id </th><td> ${apply.application_id} </td></tr>
		<tr><th>Name           </th><td> ${apply.name} </td></tr>
		<tr><th>Father name    </th><td> ${apply.father_name}  </td></tr>
		<tr><th>Gender         </th><td> ${apply.gender}  </td></tr>
		<tr><th>Date of birth  </th><td> ${apply.date_of_birth} </td></tr>
		<tr><th>Phone Number   </th><td> ${apply.phone_number}  </td></tr>
		<tr><th>Country        </th><td> ${apply.country}  </td></tr>
		<tr><th>State          </th><td> ${apply.state}  </td></tr>
		<tr><th>District       </th><td> ${apply.district}  </td></tr>
		<tr><th>School Name    </th><td> ${apply.school_name} </td></tr>
		<tr><th>Total Marks    </th><td> ${apply.total_mark}  </td></tr>
		<tr><th>Course         </th><td> ${apply.course}  </td></tr>
		<tr><th>Department     </th><td> ${apply.departmentname}  </td></tr>
		<tr><th>Branch         </th><td> ${apply.branchname}  </td></tr>

	</c:forEach>
	</tbody>
	</table>
</body>
</html>