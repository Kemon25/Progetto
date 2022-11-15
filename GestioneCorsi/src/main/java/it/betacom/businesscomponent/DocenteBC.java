package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Docente;

public class DocenteBC {
	
	private Connection conn;
	
	public DocenteBC() {
			try {
				conn = DBAccess.getConnection();
			} catch (ClassNotFoundException | DAOException | IOException exc) {
					exc.printStackTrace();
					System.err.println(exc.getMessage());
				}	
	}

	public Docente getById(long id){
		Docente docente = new Docente();
		try {
			docente = DocenteDAO.getFactory().getById(conn, id);
		}catch (DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return docente;
		
	}
}
