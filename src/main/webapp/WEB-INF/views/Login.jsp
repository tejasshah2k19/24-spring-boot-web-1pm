<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h3 class="text-center mb-4">Login</h3>
				<form action="saveuser" method="post"> 
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="text" class="form-control" id="email"
							placeholder="Enter your email">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							placeholder="Enter your password">
					</div>
					<button type="submit" class="btn btn-primary w-100">Sign
						In</button>
			
				</form>
			
			<a href="newuser">Signup?</a>
			</div>
			
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
