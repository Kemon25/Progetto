package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Docente;

public class DocenteBC {
	
	private Connection conn;
	
	public DocenteBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public Docente getById(long id) throws DAOException {
		return DocenteDAO.getFactory().getById(conn, id);
	}
}
