<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<title></title>
<style>
h1 {
 text-align:center;
font-family: 'Kaushan Script', cursive;

}
body {
	background-color:#d9e5f9;
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
  background-color: #f7f78f;
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
b{
font-color:red;
}
.rules {
font-size:15px;
}
.scroll {
font-size:30px;
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
  <br>
  <div class="scroll">
  <marquee width="100%" direction="right" height="130%">
<b>Admission open 2019-2020</b>
</marquee>
</div>
<div class="rules">
<p>1. All applicants should sign up and register their application thro online; if required assistance approach the College office or send mail to admission@chainsys university</p>
<p>2. Only successfully registered applications will be considered for selection process. Use the Application No. for further reference.</p>
<p>3. Applicants should submit separate applications for each course.</p>
<p>4. Selection process is based on the Eligibility criteria. Eligibility criteria depend on the Programme applied for. Hence specification of subjects in the qualifying examination is mandatory.</p>
<p>5. Approach the College office after the publication of +2 results along with the copy of both +1 and +2 mark statements, community certificate and other supporting documents based on which admission is made. </p>
<p>6. Selection of admission is confirmed on verification of original mark sheet and community certificate. Admission of the candidate is subject to the approval of Bharathiar University.</p>
<p>7. Equivalence certificate should be produced by the candidates other than Tamilnadu Higher Secondary Examination Board, Kerala Board and CBSE Board.</p>
</div>
</body>
</html>