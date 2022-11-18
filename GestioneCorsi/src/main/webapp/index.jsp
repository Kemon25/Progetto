<%
Cookie[] cookies = request.getCookies();
if (session.getAttribute("username") != null) {
	System.out.println("1");
	response.sendRedirect("home.jsp");
} else if (cookies!= null) {
	if(cookies.length >0){
	System.out.println("2");
	session.setAttribute("username", cookies[0]);
	response.sendRedirect("home.jsp");
	}
} else {
	System.out.println("3");
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
<body>
	<div class="container">
		<header class="page-header">
			<h3>Inserire i dati d'accesso</h3>
		</header>

		
		<div>
			<p>
				tentativi di accesso rimanenti: <strong> <%=5 - ((int) session.getAttribute("hitCount"))%>
				</strong>
			</p>
		</div>
		

		<form
			action="/<%=application.getServletContextName()%>/controlloAccesso"
			method="post" class="form-horizontal">
			<div class="form-group">
				<label class="col-md-1 control-label">Username</label>
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
				<label class="col-md-1 control-label">Password</label>
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
				<div class="col-md4 col-md-offset-1">
					<button type="submit" class="btn btn-warning">
						Login&nbsp;&nbsp;<span class="glyphicon glyphicon-log-in"></span>
					</button>

				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%
}
%>