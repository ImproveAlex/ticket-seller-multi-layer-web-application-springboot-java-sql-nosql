<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error page</title>
</head>
<body>
	<h1>Error page</h1>
	<%
	if (exception != null) {
	%>

	<%=exception.getClass()%>
	<%=exception.getMessage()%>
	<%
	}
	%>

	<%
	if (response.getStatus() != response.SC_OK) {
	%>

	ERROR
	<%=response.getStatus()%>

	<%
	}
	%>

	<%=request.getAttribute("message")%>
</body>
</html>