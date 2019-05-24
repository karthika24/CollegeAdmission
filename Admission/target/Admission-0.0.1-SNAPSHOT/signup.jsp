<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

<title>Sign Up</title>
<style>
body {
	 background-image: url("image/clg.jpg");
	background-size: 1700px 700px; 
	padding-top: 100px;
	padding-left: 270px;
}

a {
	text-decoration: none !important;
}

h1, h2, h3 {
	font-family: 'Kaushan Script', cursive;
}

.myform {
	position: relative;
	display: -ms-flexbox;
	display: flex;
	padding: 1rem;
	-ms-flex-direction: column;
	flex-direction: column;
	width: 100%;
	pointer-events: auto;
	outline: 0;
	max-width: 500px;
}

.tx-tfm {
	text-transform: uppercase;
}

.mybtn {
	border-radius: 50px;
}

form .error {
	color: #ff0000;
}
</style>
</head>
<body>
 
	 <div class="container">
		<div class="row">
			<div class="col-md-5 mx-auto">
				<div id="second">
					<div class="myform form ">
						<div class="logo mb-3">
							<div class="col-md-12 text-center">
								<h1><b>Signup</b></h1>
							</div>
						</div>
						
						<form action="SignupServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1"><b>Name</b></label> <input type="text"
									name="name" pattern="[A-Za-z]+" maxlength="30" class="form-control" id="name"
									required placeholder="Enter Name">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1"><b>Email address</b></label> <input
									type="email" name="email" class="form-control" id="email"
									required placeholder="Enter email">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1"><b>Password</b></label> <input
									type="password" name="password" id="password" maxlength="30"
									class="form-control" required
									placeholder="Enter Password">
							</div>
							<br>
							<div class="col-md-12 text-center mb-3">
								<button type="submit"
									class=" btn btn-block mybtn btn-primary tx-tfm">Sign
									Up</button>
							</div>
							<div class="col-md-12 ">
								<div class="form-group">
									<p class="text-center">
										<a href="index.jsp" id="signin">Already have an account?</a>
									</p>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div> 

</body>
</html>