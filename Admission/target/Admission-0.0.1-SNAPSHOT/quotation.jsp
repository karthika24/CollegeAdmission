<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<title>Quotation</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style>
	.center {
	margin: auto;
	width: 100%;
	border: 3px;
	padding-top: 150px;
	padding-right: 30px;
	padding-bottom: 50px;
	padding-left: 80px;
}
#paybtn {
width: 150px;
height:30px;
background-color: #4CAF50;
margin-left:400px;
}
h1 {
text-align: center;
font-family: 'Kaushan Script', cursive;
color:red;
}
	</style>
</head>
<body>
<h1>Admission Process</h1>
<h2> ${ERROR} </h2>
<form action="ViewQuoteServlet" method="post">
<div class="center">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Course</th>
					<th scope="col">Branch</th>
					<th scope="col">Department</th>
					<th scope="col">HSC Mark</th>
					<th scope="col">Quotation Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${USER}">
					<tr>
						<td>${user.name}</td>
						<td>${user.course}</td>
						<td>${user.departmentname}</td>
						<td>${user.branchname}</td>
						<td>${user.total_mark}</td>
						<td>${user.quote}</td>
						<input type="hidden" name="department" id="department" value="${user.departmentname}"> 
				</c:forEach>
			</tbody>
		</table>
	</div>
	<button type="submit" id="paybtn" value="calculate">Calculate</button>
	<h1>${result}</h1>
	</form>
</body>
</html>