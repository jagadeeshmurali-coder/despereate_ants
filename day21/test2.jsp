<%@ page import="day21.LoginForm"%>
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
		LoginForm lForm=(LoginForm)session.getAttribute("lForm");
	%>
<h1>	
	<%
		out.println(lForm.getUname()+":"+lForm.getUpass());
	%>
</h1>
</body>
</html>