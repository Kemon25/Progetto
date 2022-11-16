package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import it.betacom.architecture.dao.AdminDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Admin;
import it.betacom.businesscomponent.security.Algoritmo;

public class AdminBC {

	private Connection conn;

	public AdminBC()  {
		
		try {
			conn = DBAccess.getConnection();
			
		}catch (DAOException|ClassNotFoundException| IOException exc) {

			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		
	}

	public boolean accesso(String username, String password) {

		Admin a = null;

		try {

			a = new Admin();
			a = AdminDAO.getFactory().getByUsername(conn, username);
			if (a == null)
				return false;
			if (a.getPassword().equals(Algoritmo.convertiMD5(password)))
				return true;

		} catch (DAOException exc) {

			exc.printStackTrace();
			System.err.println(exc.getMessage());

		}
		return false;
	}

	public Admin getAdmin(String username) {

		Admin a = null;

		try {

			a = new Admin();
			a = AdminDAO.getFactory().getByUsername(conn, username);

		} catch (DAOException exc) {

			exc.printStackTrace();
			System.err.println(exc.getMessage());

		}
		return a;
	}
}