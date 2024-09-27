<%@page import="com.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>List Users</h2>

	<%
	List<UserBean> users = (List<UserBean>) request.getAttribute("users");
	%>
	<a href="newuser">New User</a>
	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Action</th>
		</tr>

		<%
		for (UserBean u : users) {
		%>
		<tr>

			<td><%=u.getUserId()%></td>
			<td><%=u.getFirstName()%></td>
			<td><%=u.getEmail()%></td>
			<td><a href="deleteuser?userId=<%=u.getUserId()%>">Delete</a> | 
				<a href="viewuser?userId=<%=u.getUserId()%>">View</a> |
				<a href="edituser?userId=<%=u.getUserId() %>">Edit</a>
			</td>
		</tr>

		<%
		}
		%>


	</table>
	<br><br> 
	<a href="search">Search</a>
</body>
</html>