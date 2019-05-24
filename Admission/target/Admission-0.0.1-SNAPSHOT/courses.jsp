<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<title>courses</title>

<style>
h1 {
 text-align:center;
font-family: 'Kaushan Script', cursive;

}
body {
	background-color:#d9e5f9;
}
.course {
 
  width: 500px;
 padding-left:400px;
  margin: 20px;
  hight:100px;
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
  text-decoration:none;
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
  background-color:#f7f78f;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
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
 padding-left:900px;
}
.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body>
<h1>CHAINSYS UNIVERSITY</h1>
<div class="navbar">
<a href="homepage.jsp"><b>Home</b></a>
    <div class="dropdown">
    <button class="dropbtn"><b>Academic</b>
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="courses.jsp">Programmes</a>
      <a href="placement.jsp">Placement</a>
     </div>
    </div> 
   <div class="dropdown">
    <button class="dropbtn"><b>Admission</b>
      <i class="fa fa-caret-down"></i>
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
<div class="course">
<h1>Courses offered</h1>
<h2>Engineering</h2>
<ul style="list-style-type:disc;">
  <li>B.E</li>
  <ul style="list-style-type:disc;">
  <li>Computer Science Engineering</li>
  <li>Mechanical Engineering</li>
  <li>Electrical and electronics Engineering</li>
  <li>Aeronautical Engineering</li>
  </ul>
  <li>B.TECH</li>
  <ul style="list-style-type:disc;">
  <li>Information Technology</li>
  <li>Bio Technology</li>
  </ul>
</ul>  
<h2>Arts</h2>
<ul style="list-style-type:disc;">
  <li>B.SC</li>
  <ul style="list-style-type:disc;">
  <li>Physics</li>
  <li>Chemistry</li>
  <li>Maths</li>
  </ul>
  <li>B.A</li>
  <ul style="list-style-type:disc;">
  <li>Tamil</li>
  <li>English</li>
  <li>History</li>
  </ul>
</ul>  
</div>
</body>
</html>