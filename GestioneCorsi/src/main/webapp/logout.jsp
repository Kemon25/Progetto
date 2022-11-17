<% 
	if(session.getAttribute("username") != null) {
		session.invalidate();

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container">
	<header class="page-header">
		<h3>Non puoi accedere a questa pagina</h3>
	</header>
	
	
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3>Hai appena effetuato il logout</h3>
		</div>
		<div class="panel-body">
			<p>Per procere con gli acquisti accedere di nuovo</p>
			<p><a href="index.jsp">Log in</a></p>
		</div>
	</div>
</div>
</body>
</html>
<% 
} else {
	response.sendRedirect("index.jsp");
}
%>