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
				<h3 class="text-center mb-4">Edit</h3>
				<form action="updateuser" method="post">
					<div class="mb-3">
						<label for="firstname" class="form-label">First Name</label> <input
							type="text" class="form-control" id="firstname" name="firstName"
							placeholder="Enter your first name" value="${user.firstName}">
						${result.getFieldError("firstName").getDefaultMessage()}
					</div>
					<div class="mb-3">
						<label for="lastname" class="form-label">Last Name</label> <input
							type="text" class="form-control" id="lastname" name="lastName"
							placeholder="Enter your last name" value="${user.lastName}">
						${result.getFieldError("lastName").getDefaultMessage()}

					</div>
					
					<input type="hidden" value="${user.userId }" name="userId"/>
				 
					<button type="submit" class="btn btn-primary w-100">Update</button>
				</form>

				<a href="users">Cancel</a>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
