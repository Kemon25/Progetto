<%
if (session.getAttribute("username") != null) {
	session.invalidate();
	response.sendRedirect("index.jsp");
	} else {
	response.sendRedirect("index.jsp");
}
%>