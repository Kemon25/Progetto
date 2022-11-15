package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;


import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;


public class CorsoCorsistaDAO implements DAOConstants{
	private CachedRowSet rowSet;
	
	private CorsoCorsistaDAO() throws DAOException{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static CorsoCorsistaDAO getFactory() throws DAOException {
		return new CorsoCorsistaDAO();
	}
	
	public void create(Connection conn, CorsoCorsista entity) throws DAOException{
		
		try {
			rowSet.setCommand(SELECT_CORSOCORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateDouble(1, entity.getIdCorsista());
			rowSet.updateDouble(2, entity.getIdCorso());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public ArrayList<Corso> getCorsiBYIdCorsista(Connection conn, long id) throws DAOException {
		Corso corso = null;
		ArrayList<Corso> corsi = new ArrayList<Corso>();
				
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_CORSISTA_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				corso = new Corso();
				corso.setIdCorso(rs.getLong(1));
				corso.setIdDocente(rs.getLong(2));
				corso.setNomeCorso(rs.getString(3));
				corso.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
				corso.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
				corso.setCosto(rs.getDouble(6));
				corso.setCommenti(rs.getString(7));
				corso.setAula(rs.getString(8));
				corsi.add(corso);
				
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		return corsi;
	}
	
	public int getNumCorsistaBYId(Connection conn, long id) throws DAOException {
		int n = 0;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_NCORSISTA_CORSO_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				n=rs.getInt(1);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		return n;
	}
}
