package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;
import it.betacom.businesscomponent.model.Corsista;

public class CorsistaBC {
	private Connection conn;
	
	public CorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(Corsista corsista) throws DAOException, ClassNotFoundException, IOException {
		corsista.setId(CorsistaIdGenerator.getInstance().getNextId());
		CorsistaDAO.getFactory().create(conn, corsista);
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
