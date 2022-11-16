package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.betacom.businesscomponent.model.Admin;

public class AdminDAO implements DAOConstants {

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
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				a = new Admin();
				a.setUsername(rs.getString("username"));
				a.setNome(rs.getString("nome_admin"));
				a.setCognome(rs.getString("cognome_admin"));
				a.setPassword(rs.getString("password"));
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return a;

	}
}