<!-- NAVBAR -->
<nav class="navbar navbar-default">
	<div class="container-fluid">
	
		<div class="navbar-header">
			<a class="navbar-brand" href="/<%=application.getServletContextName()%>/home.jsp">GestioneCorsi</a>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="/<%=application.getServletContextName()%>/home.jsp">
					<span class="glyphicon glyphicon-home"></span> Home</a>
				</li>
				<li>
					<a href="/<%=application.getServletContextName()%>/index.jsp">
					<span class="glyphicon glyphicon-log-out"></span> Log-out</a>
				</li>
			</ul>
		</div>
	</div>
</nav>