package it.betacom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.businesscomponent.AdminBC;

@WebServlet("/controlloAccesso")
public class ControlloAccesso extends HttpServlet {

	private static final long serialVersionUID = -6441545525722074841L;
	private int hitCount=1;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("hitCount", Integer.valueOf(hitCount));

		AdminBC aBC = new AdminBC();

		if (aBC.accesso(username, password)) {
			response.sendRedirect("home.jsp");
			session.setAttribute("username", username);
			session.setAttribute("password", password);
		} else if(hitCount < 5) { 
			response.sendRedirect("index.jsp");
			hitCount++;
		} else if(hitCount > 5) {
			response.sendRedirect("errorLogin.jsp");
			session.invalidate();
		}
	}

}
