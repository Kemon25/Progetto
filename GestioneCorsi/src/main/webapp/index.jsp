<%
Cookie[] cookies = request.getCookies();
if (session.getAttribute("username") != null) {
	response.sendRedirect("home.jsp");
} else if (cookies!= null) {
	if(cookies.length > 0){
	session.setAttribute("username", cookies[0]);
	response.sendRedirect("home.jsp");
	}
} else {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="index noScrollbar">
	<div class="container">
		<header class="page-header" id="whiteHeader">
			<h3 id="colorLabel">Inserire i dati d'accesso</h3>
		</header>

		
		<div>
		<%
			if(request.getParameter("hitCount") != null && (Integer.parseInt(request.getParameter("hitCount"))) > 0) {
		%>
			<p style="color:red;">
				tentativi di accesso rimanenti: <strong> <%=5  - (Integer.parseInt(request.getParameter("hitCount")))%>
				</strong>
			</p>
		<%
			}
		%>
		</div>
		

		<form
			action="/<%=application.getServletContextName()%>/controlloAccesso"
			method="post" class="form-horizontal">
			<div class="form-group">
				<label class="col-md-1 control-label"  id="colorLabel">Username</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" maxlength="10" name="username" id="username"
							placeholder="Username..." class="form-control">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label" id="colorLabel" >Password</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-lock"></i>
						</span> <input type="password" name="password" id="password"
							placeholder="Password..." class="form-control">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md4 col-md-offset-1" >
					<button type="submit" class="btn btn-warning">
						Login&nbsp;&nbsp;<span class="glyphicon glyphicon-log-in"></span>
					</button>

				</div>
			</div>
		</form>
	</div>
	<img  src="img/razzoLogin.png" align="right">
	
</body>
</html>
<%
}
%>