package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.model.Corsista;

public class CorsistaDAO implements DAOConstants {
	private CachedRowSet rowSet;

	public static CorsistaDAO getFactory() throws DAOException {
		return new CorsistaDAO();
	}

	private CorsistaDAO() throws DAOException {
		try {

			rowSet = RowSetProvider.newFactory().createCachedRowSet();

		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
	}

	public void create(Connection conn, Corsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getId());
			rowSet.updateString(2, entity.getNome());
			rowSet.updateString(3, entity.getCognome());
			rowSet.updateInt(4, entity.getPrecedentiFormativi());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();

		} catch (SQLException exc) {
			throw new DAOException(exc);
		}

	}

	public void delete(Connection conn, Corsista entity) throws DAOException{
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSISTA);
			ps.setLong(1, entity.getId());
			ps.execute();
			conn.commit();
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}

	}

	public Corsista getById(Connection conn, long id) throws DAOException {
		Corsista corsista = null;
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(SELECT_CORSISTA_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corsista = new Corsista();
				corsista.setId(rs.getLong(1));
				corsista.setNome(rs.getString(2));
				corsista.setCognome(rs.getString(3));
				corsista.setPrecedentiFormativi(rs.getInt(4));
			}

		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
		return corsista;
	}

	public ArrayList<Corsista> getAll(Connection conn) throws DAOException {
		ArrayList<Corsista> corsisti = null;

		try {
			Statement stmt = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);
			rs.last();
			corsisti = new ArrayList<Corsista>(rs.getRow());
			rs.beforeFirst();
			
			while(rs.next()) {
				Corsista c = new Corsista();
				c.setId(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setCognome(rs.getString(3));
				c.setPrecedentiFormativi(rs.getInt(4));
				corsisti.add(c);
			}
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
		return corsisti;
	}
}