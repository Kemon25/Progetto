package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.betacom.businesscomponent.model.Admin;

public class AdminDAO implements DAOConstants{

	// Costruttore AdminDAO
	private AdminDAO() {
	}
	
	public static AdminDAO getFactory() {
		return new AdminDAO();
	}
	
	public Admin getByUsername(Connection conn, String username) throws DAOException {
		
		Admin a = null;
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(SELECT_ADMIN_ID);
				ps.setString(1, username);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					a= new Admin();
					a.setUsername(rs.getString(1));
					a.setPassword(rs.getString(2));
					a.setNome(rs.getString(3));
					a.setCognome(rs.getString(4));
				}
				
			
			} catch(SQLException sql) {
				throw new DAOException(sql);
			}
			return a;
		
	}
}