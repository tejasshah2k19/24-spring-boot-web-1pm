<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Signup Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h3 class="text-center mb-4">Signup Form</h3>
				<form action="saveuser" method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<label for="firstname" class="form-label">First Name</label> <input
							type="text" class="form-control" id="firstname" name="firstName"
							placeholder="Enter your first name">
						${result.getFieldError("firstName").getDefaultMessage()}
					</div>
					<div class="mb-3">
						<label for="lastname" class="form-label">Last Name</label> <input
							type="text" class="form-control" id="lastname" name="lastName"
							placeholder="Enter your last name">
						${result.getFieldError("lastName").getDefaultMessage()}

					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="text" class="form-control" id="email" name="email"
							placeholder="Enter your email">
						${result.getFieldError("email").getDefaultMessage()}

					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password" name="password"
							placeholder="Enter your password">
						${result.getFieldError("password").getDefaultMessage()}

					</div>
					
					<div class="mb-3">
						<label for="profilePic" class="form-label">Profile Pic</label> <input
							type="file" class="form-control"   name="profilePic"
							placeholder="Select Profile pic">
					</div>
										
					
					<button type="submit" class="btn btn-primary w-100">Sign
						Up</button>
				</form>

				<a href="login">Login</a>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
