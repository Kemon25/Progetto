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
	
	public CorsistaBC() {
		try {
			conn = DBAccess.getConnection();
		} catch(ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
	}
	
	public Corsista create(Corsista corsista) {
		try {
			corsista.setId(CorsistaIdGenerator.getInstance().getNextId());
		
			if((Validazione.getFactory().nomeCorsista(corsista.getNome())) &&
					(Validazione.getFactory().cognomeCorsista(corsista.getCognome()))) {
				//&& (Validazione.getFactory().precedentiFormativi(corsista.getPrecedentiFormativi())))
				
				CorsistaDAO.getFactory().create(conn, corsista);
				return corsista;
			}
					
		} catch(ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return null;
	}
	
	public ArrayList<Corsista> getAll() {
		ArrayList<Corsista> corsisti = new ArrayList<Corsista>();
		try {
			corsisti = CorsistaDAO.getFactory().getAll(conn);
		} catch(DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return corsisti;
	}
	
	public Corsista getById(long id) {
		Corsista c = new Corsista();
		try {
			c = CorsistaDAO.getFactory().getById(conn, id);
		} catch(DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return c;
	}
	
	public void delete(long id) {
		try {
			CorsistaDAO.getFactory().delete(conn, id);
		} catch(DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
	}
}
