<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New Area</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
		<h2 class="text-center mb-4">Add New Area</h2>

		<form>
			<div class="mb-3">
				<label for="areaName" class="form-label">Area Name</label> <input
					type="text" class="form-control" id="areaName"
					placeholder="Enter area name" required>
			</div>



			<div class="mb-3">
				<label for="cityName" class="form-label">City Name</label> <select
					class="form-select" name="cityName" required>

					<option value="" selected disabled>Select a city</option>
					<c:forEach items="${cities}" var="c">
						<option value="${c.cityId}">${c.cityName}</option>
					</c:forEach>

				</select>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
