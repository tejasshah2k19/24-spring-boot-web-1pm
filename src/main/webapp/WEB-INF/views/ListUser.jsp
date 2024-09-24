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
	List<UserBean> users = (List<UserBean>)request.getAttribute("users");
	%>


	<%for(UserBean u:users){ %>
		<%=u.getFirstName() %><br>
	
	<%}%>

</body>
</html>