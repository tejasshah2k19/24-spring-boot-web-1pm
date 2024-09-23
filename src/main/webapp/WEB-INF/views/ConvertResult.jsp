<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			Float usdAmount = (Float)request.getAttribute("usdAmount");
		%>


USD:  <%=usdAmount %>
<br><Br> 


USD: ${usdAmount}
</body>
</html>