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
import it.betacom.businesscomponent.facade.AdminFacade;

@WebServlet("/controlloAccesso")
public class ControlloAccesso extends HttpServlet {

	private static final long serialVersionUID = -6441545525722074841L;
	private int hitCount = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		

		if (AdminFacade.getInstance().accesso(username, password)) {
			session.setAttribute("username", username);
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(5000);
			response.addCookie(cookie);
			hitCount = 0;
			response.sendRedirect("home.jsp");

		} else {
			Cookie[] cookies = request.getCookies();

			for (Cookie cookie : cookies) {
				cookie.setValue("");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}

			if (hitCount < 5) {

				System.out.println("dentro contatore " + hitCount);
				hitCount++;
				response.sendRedirect("index.jsp?hitCount="+hitCount);
				
			} else if (hitCount >= 5) {
				System.out.println("fine contatore " + hitCount);
				response.sendRedirect("errorLogin.jsp");
				hitCount = 0;
				session.invalidate();
			}
		}
	}

}
