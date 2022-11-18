<%
if (session.getAttribute("username") != null) {
	Cookie[] cookies = request.getCookies();
	for (Cookie cookie : cookies) {
	    cookie.setValue("");
	    cookie.setMaxAge(0);
	    response.addCookie(cookie);
	}
	session.invalidate();
	response.sendRedirect("index.jsp");
	} else {
	response.sendRedirect("index.jsp");
}
%>