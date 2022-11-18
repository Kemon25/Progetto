package it.betacom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.businesscomponent.AdminBC;

@WebServlet("/controlloAccesso")
public class ControlloAccesso extends HttpServlet {

	private static final long serialVersionUID = -6441545525722074841L;
	private int hitCount = 1;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("hitCount", Integer.valueOf(hitCount));

		AdminBC aBC = new AdminBC();
		if (aBC.accesso(username, password)) {
			session.setAttribute("username", username);
			Cookie cookie = new Cookie("username", username);
			response.addCookie(cookie);
			response.sendRedirect("home.jsp");

		} else if (hitCount < 5) {
			System.out.println("dentro contatotre " + hitCount);
			response.sendRedirect("index.jsp");
			hitCount++;
		} else if (hitCount >= 5) {
			System.out.println("fine contatotre " + hitCount);
			response.sendRedirect("errorLogin.jsp");
			hitCount = 0;
			session.invalidate();
		}
	}

}
