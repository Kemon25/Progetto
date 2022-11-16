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
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;

@WebServlet("/controlloCorsista")
public class ControlloCorsista extends HttpServlet {
	
	private static final long serialVersionUID = 4538690454132379945L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corsista corsista = getCorsista(request);
		Corso corso = getCorso(request);
		Corso cor = null;
		CorsoCorsista corsoCorsista = null;
		
		cor = AdminFacade.getInstance().getByIdCorso(corso.getIdCorso());
		
		if(cor != null) {
			if(AdminFacade.getInstance().createCorsista(corsista)) {
				corsoCorsista = new CorsoCorsista();
				corsoCorsista.setIdCorsista(corsista.getId());
				corsoCorsista.setIdCorso(corso.getIdCorso());
				
				AdminFacade.getInstance().create(corsoCorsista);
				
				response.sendRedirect("listaCorsisisti.jsp");
			}else {
				request.setAttribute("errore", 2);
				response.sendRedirect("errorCreate.jsp");
			}
		}else if(AdminFacade.getInstance().createCorso(corso)) {
			if(AdminFacade.getInstance().createCorsista(corsista)) {
				corsoCorsista = new CorsoCorsista();
				corsoCorsista.setIdCorsista(corsista.getId());
				corsoCorsista.setIdCorso(corso.getIdCorso());
				
				AdminFacade.getInstance().create(corsoCorsista);
				response.sendRedirect("listaCorsisisti.jsp");
			}else {
				request.setAttribute("errore", 2);
				AdminFacade.getInstance().deleteCorso(corso.getIdCorso());
				response.sendRedirect("errorCreate.jsp");
			}
		}else {
			request.setAttribute("errore",1);
			response.sendRedirect("errorCreate.jsp");
		}
	}
	
	private Corsista getCorsista(HttpServletRequest request) {
		Corsista cor = null;
		try {
			long id = Long.valueOf(request.getParameter("idCorsista"));
			String nome = request.getParameter("nomeCorsista");
			String cognome = request.getParameter("cognomeCorsista");
			cor = new Corsista();
			cor.setId(id);
			cor.setNome(nome);
			cor.setCognome(cognome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cor;
	}
	
	private Corso getCorso(HttpServletRequest request) {
		Corso corso = null;
		DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		try {
			long idCorso = Long.valueOf(request.getParameter("idCorso"));
			long idDocente = Long.valueOf(request.getParameter("idDocente"));
			String nomeCorso = request.getParameter("nomeCorso");
			d.parse(request.getParameter("data"));
			Date dataInzio = d.parse(request.getParameter("dataInizio"));
			Date dataFine = d.parse(request.getParameter("dataFine"));
			double costo = Double.valueOf(request.getParameter("costo"));
			String commenti = request.getParameter("commenti");
			String aula = request.getParameter("aula");
			corso = new Corso();
			corso.setIdCorso(idCorso);
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
