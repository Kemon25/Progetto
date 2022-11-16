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
			rowSet.updateLong(1, entity.getIdCorso());
			rowSet.updateLong(2, entity.getIdCorsista());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public ArrayList<Corso> getCorsiByIdCorsista(Connection conn, long id) throws DAOException {
		Corso corso = null;
		ArrayList<Corso> corsi = new ArrayList<Corso>();
				
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_CORSISTA_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			long idCorso;
			while(rs.next()) {
				idCorso = rs.getLong(1);
				
				corso = CorsoDAO.getFactory().getById(conn, idCorso);
				
				corsi.add(corso);
				
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		return corsi;
	}
	
	public int getNumCorsistaByIdCorso(Connection conn, long id) throws DAOException {
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
