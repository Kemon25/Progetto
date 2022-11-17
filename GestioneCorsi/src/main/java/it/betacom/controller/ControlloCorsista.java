package it.betacom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.businesscomponent.facade.AdminFacade;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.CorsoCorsista;

@WebServlet("controlloCorsista")
public class ControlloCorsista extends HttpServlet {

	private static final long serialVersionUID = 4538690454132379945L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corsista cors =getCorsista(request);
		CorsoCorsista corsoCorsista = null;
		long idCorsista=0;
		long idCorso = 0;
		
		if(cors != null) {
			idCorsista=cors.getId();
				for(int i=0;i<AdminFacade.getInstance().getCorsiIscrivibili().size();i++){
					if(request.getAttribute("idCorso"+i)!=null) {
						System.out.println("idCorso"+i);
						idCorso=Long.parseLong((String) request.getAttribute("idCorso"+i));
						corsoCorsista = new CorsoCorsista();
						corsoCorsista.setIdCorsista(idCorsista);
						corsoCorsista.setIdCorso(idCorso);
						
						AdminFacade.getInstance().create(corsoCorsista);
					}
				}
				
				response.sendRedirect("listaCorsisisti.jsp");
				request.setAttribute("idCorsista", idCorsista);
			
			}else {
				request.setAttribute("errore", 2);
				response.sendRedirect("errorCreate.jsp");
			}
	
	}

	private Corsista getCorsista(HttpServletRequest request) {
		Corsista cor = null;
		try {
			String nome = request.getParameter("nomeCorsista");
			String cognome = request.getParameter("cognomeCorsista");
			int precedenti = Integer.parseInt(request.getParameter("PrecedentiFormativi"));
			
			cor = new Corsista();
			cor.setNome(nome);
			cor.setCognome(cognome);
			cor.setPrecedentiFormativi(precedenti);
			
			cor = AdminFacade.getInstance().createCorsista(cor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cor;
	}

}
