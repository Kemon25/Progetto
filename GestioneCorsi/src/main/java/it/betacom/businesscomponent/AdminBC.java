	package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.AdminDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Admin;
import it.betacom.businesscomponent.security.Algoritmo;

public class AdminBC {
	
	private Connection conn;
	
	public AdminBC() throws  ClassNotFoundException, IOException, DAOException{
		conn=DBAccess.getConnection();
	}
	
	public boolean accesso(String username, String password) throws DAOException {
		
		Admin a = null;
		
		try {
			
			a = new Admin();
			a=AdminDAO.getFactory().getByUsername(conn, username);
			
			if(a.getPassword().equals(Algoritmo.convertiMD5(password)))
				return true;
			return false;
		}catch(SQLException sql) {
			
			throw new DAOException(sql);
			
		}
	}
	
	public Admin getAdmin(String username) throws DAOException {
		
		Admin a = null;
		
		try {
			
			a = new Admin();
			a=AdminDAO.getFactory().getByUsername(conn, username);
			
		}catch(SQLException sql) {
			
			throw new DAOException(sql);
			
		}
		return a;
	}
}