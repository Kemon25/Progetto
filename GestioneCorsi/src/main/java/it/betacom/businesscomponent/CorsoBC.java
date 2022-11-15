package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corso;

public class CorsoBC {

	public static CorsoBC getFactory(Connection conn) throws ClassNotFoundException, DAOException, IOException {
		return new CorsoBC(conn);
	}

	private Connection conn;
	
	private CorsoBC(Connection conn) throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
		
	public void create(Corso corso) throws DAOException {
		CorsoDAO.getFactory().create(conn, corso);
	}
	
	public void delete(long idCorso) throws SQLException {
		CorsoDAO.getFactory().delete(conn,idCorso);
	}
	
	public Date getUltimoCorso() throws SQLException {
		Date DataMagg=null;
		ArrayList <Corso> corsi=CorsoDAO.getFactory().getAll(conn);
		for(int i=0;i<corsi.size();i++) {
			if(i==0) {
				DataMagg=corsi.get(i).getDataInizio();
			}
			else {
				if(corsi.get(i).getDataInizio().compareTo(DataMagg)>0) {
					DataMagg=corsi.get(i).getDataInizio();
				}
			}
		}
		return DataMagg;	
	}
	
}

