package it.betacom.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/autodistruzione")
public class Autodistruzione extends HttpServlet {
	private static final long serialVersionUID = -154792031843008944L;
	private int contoRovescia = 3;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>Errore login</title></head>");
		out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
		if (contoRovescia > 0) {
			out.println("<meta http-equiv=\"refresh\" content=\"1; url=/GestioneCorsi/autodistruzione\" >");

			out.println("<body>");

			out.println("<div class=\"container\" style=\"text-align: center\">");
			out.println("<header class=\"page.header\">");
			out.println("<h1>Mi spiace, il computer si autodistruggerà in " + contoRovescia + " secondi</h1>");
			contoRovescia--;
			out.println("</header>");
			out.println("</div>");

			out.println("</body>");
			out.println("</html>");
			
		} else {

			out.println("<style>");
			out.println("body, html {");
			out.println("height: 100%;");
			out.println("width: 100%;");
			out.println("}");
			out.println("body {");
			out.println("background-image: url('img/explosion.gif');");
			out.println("background-position: center;");
			out.println("background-repeat: no-repeat;");
			out.println("background-size: cover;");
			out.println("}");
			out.println("</style>");
			out.println("<script>");
			out.println("setTimeout(function() {");
			out.println(" window.close()");
			out.println(" }, 1700);");
			out.println("</script>");
			out.println("</html>");
			
			contoRovescia=3;
		}

		out.close();
	}
}
