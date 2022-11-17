package it.betacom.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.businesscomponent.facade.AdminFacade;
import it.betacom.businesscomponent.model.Corso;

@WebServlet("/controlloCorso")
public class ControlloCorso extends HttpServlet {
	private static final long serialVersionUID = -8658254541913631673L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corso corso = getCorso(request);
		Corso c = AdminFacade.getInstance().createCorso(corso);

		if(c != null) {
			response.sendRedirect("corsiDisponibili.jsp");
		}else {
			response.sendRedirect("errorCorso.jsp");
			
		}
	}
	
	private Corso getCorso(HttpServletRequest request) {
		Corso corso = null;
		DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		try {
			long idDocente = Long.valueOf(request.getParameter("idDocente"));
			String nomeCorso = request.getParameter("nomeCorso");
			Date dataInzio = d.parse(request.getParameter("dataInizio"));
			Date dataFine = d.parse(request.getParameter("dataFine"));
			double costo = Double.valueOf(request.getParameter("costo"));
			String commenti = request.getParameter("commenti");
			String aula = request.getParameter("aula");
			corso = new Corso();
			corso.setIdDocente(idDocente);
			corso.setNomeCorso(nomeCorso);
			corso.setDataInizio(dataInzio);
			corso.setDataFine(dataFine);
			corso.setCosto(costo);
			corso.setCommenti(commenti);
			corso.setAula(aula);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return corso;
	}

}
