<!-- NAVBAR -->
<nav class="navbar navbar-primary">
	<div class="container-fluid">
	
		<div class="navbar-header">
			<a class="navbar-brand" href="/<%=application.getServletContextName()%>/home.jsp" id="colorLabel">GestioneCorsi</a>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li id="colorLabel">
					<a href="/<%=application.getServletContextName()%>/home.jsp">
					<span class="glyphicon glyphicon-home"></span> Home</a>
				</li>
				
				<li id="colorLabel">
					<a href="/<%=application.getServletContextName()%>/error.jsp">
					<span class="glyphicon glyphicon-gift"></span> Mi sento Fortunato</a>
				</li>
				
				<li id="colorLabel">
					<a href="/<%=application.getServletContextName()%>/logout.jsp">
					<span class="glyphicon glyphicon-log-out"></span> Log-out</a>
				</li>
				
				
				
			</ul>
		</div>
	</div>
</nav>