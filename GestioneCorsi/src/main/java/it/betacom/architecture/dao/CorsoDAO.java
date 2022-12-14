package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.model.Corso;

public class CorsoDAO implements DAOConstants {

	public static CorsoDAO getFactory() throws DAOException {
		return new CorsoDAO();
	}

	private CachedRowSet rowSet;

	private CorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void create(Connection conn, Corso corso) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, corso.getIdCorso());
			rowSet.updateLong(2, corso.getIdDocente());
			rowSet.updateString(3, corso.getNomeCorso());
			rowSet.updateDate(4, new java.sql.Date(corso.getDataInizio().getTime()));
			rowSet.updateDate(5, new java.sql.Date(corso.getDataFine().getTime()));
			rowSet.updateDouble(6, corso.getCosto());
			rowSet.updateString(7, corso.getCommenti());
			rowSet.updateString(8, corso.getAula());
			
			

			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(Connection conn, long idCorso) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, idCorso);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Corso getById(Connection conn, long idCorso) throws DAOException {
		Corso corso = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_ID);
			ps.setLong(1, idCorso);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				corso = new Corso();
				corso.setIdCorso(rs.getLong(1));
				corso.setIdDocente(rs.getLong(2));
				corso.setNomeCorso(rs.getString(3));
				corso.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
				corso.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
				corso.setCosto(rs.getDouble(6));
				corso.setCommenti(rs.getString(7));
				corso.setAula(rs.getString(8));

			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corso;
	}

	public ArrayList<Corso> getAll(Connection conn) throws DAOException {
		ArrayList<Corso> corsi = new ArrayList<Corso>();
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_CORSO);

			while (rs.next()) {
				Corso c = new Corso();
				c.setIdCorso(rs.getLong(1));
				c.setIdDocente(rs.getLong(2));
				c.setNomeCorso(rs.getString(3));
				c.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
				c.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
				c.setCosto(rs.getDouble(6));
				c.setCommenti(rs.getString(7));
				c.setAula(rs.getString(8));
				corsi.add(c);
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return corsi;
	}

	public ArrayList<Corso> getCorsiByIdDocente(Connection conn, long idDocente) throws DAOException {
		ArrayList<Corso> corsi = new ArrayList<Corso>();
		ResultSet rs;
		PreparedStatement pstmt;
		try {

			pstmt = conn.prepareStatement(SELECT_CORSO_DOCENTE_ID);
			pstmt.setLong(1, idDocente);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Corso c = new Corso();
				c.setIdCorso(rs.getLong(1));
				c.setIdDocente(rs.getLong(2));
				c.setNomeCorso(rs.getString(3));
				c.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
				c.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
				c.setCosto(rs.getDouble(6));
				c.setCommenti(rs.getString(7));
				c.setAula(rs.getString(8));
				corsi.add(c);
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return corsi;
	}
}