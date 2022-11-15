package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.betacom.businesscomponent.model.Docente;

public class DocenteDAO implements DAOConstants{

	private DocenteDAO() {
	}
	
	public static DocenteDAO getFactory() {
		return new DocenteDAO();
	}
	
	public Docente getById(Connection conn, long id) throws DAOException {
		PreparedStatement ps;
		Docente docente;
		try {
			docente = new Docente();
			ps = conn.prepareStatement(SELECT_DOCENTE_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			docente.setId(id);
			docente.setNome(rs.getString("nome_docente"));
			docente.setCognome(rs.getString("cognome_docente"));
			docente.setCv(rs.getString("cv"));
			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docente;
	}
	
}
