<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<title>Application form</title>
<style>
*[role="form"] {
	max-width: 530px;
	padding: 15px;
	margin: 0 auto;
	border-radius: 0.3em;
}

*[role="form"] h2 {
	font-family: 'Open Sans', sans-serif;
	font-size: 40px;
	font-weight: 600;
	color: #000000;
	text-align: center;
	text-transform: uppercase;
	letter-spacing: 4px;
}

#flex-form {
    display: flex;
    max-width: 100vw !important;
    justify-content: space-around;
}
body {
	background-color:#d9e5f9;
}
form {
    max-width: 100vw !important;
}

.hieghtAdd {
	height: 34px !important;
}

.above {
	text-align: center;
	font-family: 'Kaushan Script', cursive;
	
}
.back {
font-size:30px;
}
.side {
	width: 30%;
}

#aply-btn {
	width: 80px;
	margin: 0 auto;
}
.error{
color:red;
padding-left:150px;
}
h2 {
	text-align: center;
	font-family: 'Kaushan Script', cursive;
	color:red;
}


</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>
	$(document)
			.ready(
					function() {

						$("#course")
								.change(
										function() {
											$('#departments').empty();
											$
													.ajax({
														url : 'CourseServlet',
														type : 'post',
														data : {
															course : $(
																	"#course")
																	.val()
														},
														success : function(data) {
															var x = JSON
																	.parse(data);
															/* var x=JSON.parse(data,(key,value)=>{
																 $('#departments').append('<option value='+key+'>'+value+'</option>');
															});
															 */
															$('#departments')
																	.append(
																			'<option value="">Select</option>');
															for ( var key in x) {
																if (x
																		.hasOwnProperty(key)) {
																	$(
																			'#departments')
																			.append(
																					'<option value='+key+'>'
																							+ x[key]
																							+ '</option>');
																}
															}
														}

													});
											//alert("hi");

										});

						$("#departments")
								.change(
										function() {
											//alert($("#departments").val());
											$
													.ajax({
														url : 'BranchServlet',
														type : 'post',
														data : {
															departments : $(
																	"#departments")
																	.val()
														},
														success : function(data) {
															console.log(data);
															var x = JSON
																	.parse(data);

															$('#branch')
																	.append(
																			'<option value="">Select</option>');
															for ( var key in x) {
																if (x
																		.hasOwnProperty(key)) {
																	$('#branch')
																			.append(
																					'<option value='+key+'>'
																							+ x[key]
																							+ '</option>');
																}
															}
														}

													});
											//alert("hi");

										});

					});
</script>

</head>
<body>
<div class="application">
	<div class="above">
		<h1><b>CHAINSYS UNIVERSITY</b></h1>
		<h3>ONLINE APPLICATION FORM</h3>
	</div>
<div class="back"><a href="homepage.jsp">Back</a></div>
	<h2>${RESULT} </h2>
	<h2>${error}</h2>
	
				<form class="form-horizontal" role="form" action="ApplyNowServlet"
					method="post">
					<div id="flex-form">
					<div class="side">
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">Name*</label>
						<div class="col-sm-9">
							<input type="text" name="name" placeholder="Name"
								pattern="[A-Za-z]+" maxlength="30" class="form-control" autofocus required>
						</div>
					</div>
					<div class="form-group">
						<label for="fathername" class="col-sm-3 control-label">Father's
							Name*</label>
						<div class="col-sm-9">
							<input type="text" name="fathername" placeholder="Father's  Name"
								pattern="[A-Za-z]+" maxlength="30" class="form-control" autofocus required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Gender</label>
						<div class="col-sm-6">
							<div class="row">
								<div class="col-sm-4">
									<label class="radio-inline"> <input type="radio"
										name="gender" value="Female">Female
									</label>
								</div>
								<div class="col-sm-4">
									<label class="radio-inline"> <input type="radio"
										name="gender" value="Male">Male
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="birthDate" class="col-sm-3 control-label">Date
							of Birth*</label>
						<div class="col-sm-9">
							<input type="date" name="dateofbirth" class="form-control"
								min="1995-01-01" max="2001-01-01" required>
						</div>
					</div>
					<div class="form-group">
						<label for="phoneNumber" class="col-sm-3 control-label">Phone
							number* </label>
						<div class="col-sm-9">
							<input type="text" pattern="[789][0-9]{9}" name="phoneNumber" maxlength="10" placeholder="Phone number"
								class="form-control" required> <span class="help-block">Your
								phone number won't be disclosed anywhere </span>
						</div>
							<div class="error">	<c:out value = "${phoneerror}"/></div>
					</div>
		
					<div class="form-group">
						<label for="Nationality" class="col-sm-3 control-label">Nationality*
						</label>
						<div class="col-sm-9">
							<input type="text" id="country" placeholder="Nationality"
								pattern="[A-Za-z]+" maxlength="30" class="form-control" name="country" required>
						</div>
					</div>
					</div>
					<div class="side">
					<div class="form-group">
						<label for="state" class="col-sm-3 control-label">State*</label>
						<div class="col-sm-9">
							<input type="text" name="state" placeholder="State"
								pattern="[A-Za-z]+" maxlength="30" class="form-control" required>
						</div>
					</div>
		
		
				<div class="form-group">
					<label for="district" class="col-sm-3 control-label">District*</label>
					<div class="col-sm-9">
						<input type="text" name="district" placeholder="District"
							pattern="[A-Za-z]+" maxlength="30" class="form-control" required>
					</div>
				</div>

				<div class="form-group">
					<label for="schoolname" class="col-sm-3 control-label">School
						Name* </label>
					<div class="col-sm-9">
						<input type="text" name="schoolname" placeholder="School name"
							pattern="[A-Za-z]+" maxlength="30" class="form-control" required>
					</div>
				</div>
				<div class="form-group">
					<label for="totalmark" class="col-sm-3 control-label">Total
						marks* </label>
					<div class="col-sm-9">
						<input type="number" name="totalmark" min="300" max="1200"
							placeholder="Total marks you scored in HSC" class="form-control"
							required>
					</div>
				</div>
				<div class="form-group">
					<label for="course" class="col-sm-3 control-label">Course</label>
					<div class="col-sm-9">
						<select class="browser-default custom-select hieghtAdd" name="course"
							id="course">
							<option value="engineering">Engineering</option>
							<option value="arts">Arts</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label for="course" class="col-sm-3 control-label">Branch</label>
					<div class="col-sm-9">
						<select class="browser-default custom-select hieghtAdd" name="departments"
							id="departments">
							<option value="">Select</option>
							<%-- <c:forEach items="${STREAM}" var="stream">
					<option value="${stream.id}">${stream.name}</option>
				</c:forEach> --%>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="course" class="col-sm-3 control-label">Department</label>
					<div class="col-sm-9">
						<select class="browser-default custom-select hieghtAdd" name="branch"
							id="branch">
							<%-- <c:forEach items="${STREAM}" var="stream">
					<option value="${stream.id}">${stream.name}</option>
				</c:forEach> --%>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="type" class="col-sm-3 control-label">Type</label>
					<div class="col-sm-9">
						<select class="browser-default custom-select hieghtAdd" name="type"
							id="type">
							<option value="merit">Merit</option>
							<option value="management">Management</option>
						</select>
					</div>
				</div>
				<!-- /.form-group -->
				<div class="form-group">
					<div class="col-sm-9 col-sm-offset-3">
						<span class="help-block">*Required fields</span>
					</div>
				</div>
				</div>
				</div>
				<button id="aply-btn" type="submit" class="btn btn-primary btn-block">Apply</button>
				</form>
				
			</div>	
</body>
</html>