package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;
import it.betacom.businesscomponent.idgenerator.CorsoIdGenerator;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private Connection conn;
	
	public CorsoCorsistaBC() 
			throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();	
	}
	
	public boolean create(CorsoCorsista corsoCorsista) 
			throws ClassNotFoundException, IOException, DAOException {
		
		boolean b = false;
		try {
			corsoCorsista.setIdCorsista(CorsistaIdGenerator.getInstance().getNextId());
			corsoCorsista.setIdCorso(CorsoIdGenerator.getIstance().getNextId());
			CorsoCorsistaDAO.getFactory().create(conn, corsoCorsista);
			
			b = true;
			return b;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
		
	public ArrayList<Corso> getCorsiByIdCorsista(long idCorsista) throws DAOException{
		
		return CorsoCorsistaDAO.getFactory().getCorsiBYIdCorsista(conn, idCorsista);
	}
	
	public ArrayList<Corso> getCorsoMaxfreq() throws DAOException{
		
		
		
		
		return null;
	}
	
	public int getNumCorsistaByIdCorso(long idCorso) throws DAOException{
		
		return CorsoCorsistaDAO.getFactory().getNumCorsistaBYIdCorso(conn, idCorso);
	}
		
	
}
