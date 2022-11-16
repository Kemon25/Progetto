package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.validate.Validazione;

public class CorsistaBC {
	private Connection conn;
	
	public CorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public boolean create(Corsista corsista) throws DAOException, ClassNotFoundException, IOException {
		boolean valido = false;
		
		corsista.setId(CorsistaIdGenerator.getInstance().getNextId());
		
		if((Validazione.getFactory().nomeCorsista(corsista.getNome())) &&
				(Validazione.getFactory().cognomeCorsista(corsista.getCognome()))) {
				//&& (Validazione.getFactory().precedentiFormativi(corsista.getPrecedentiFormativi())))
			valido = true;
			System.out.println("Nome e cognome nel formato corretto");
		} else {
			System.out.println("Nome o cognome non nel formato corretto");
		}
		
		if(valido) {
			CorsistaDAO.getFactory().create(conn, corsista);
			System.out.println("Corsista creato!");
		} else {
			System.out.println("Corsista non creato!");
		}
		
		return valido;
	}
	
	public ArrayList<Corsista> getAll() throws DAOException{
		return CorsistaDAO.getFactory().getAll(conn);
	}
	
	public Corsista getById(long id) throws DAOException {
		return CorsistaDAO.getFactory().getById(conn, id);
	}
	
	public void delete(long id) throws DAOException {
		CorsistaDAO.getFactory().delete(conn, id);
	}
}
