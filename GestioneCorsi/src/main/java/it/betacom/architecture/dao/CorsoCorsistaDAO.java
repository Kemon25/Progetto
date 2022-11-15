package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;


import it.betacom.businesscomponent.model.CorsoCorsista;


public class CorsoCorsistaDAO {
	private CachedRowSet rowSet;
	
	private CorsoCorsistaDAO() throws DAOException{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void create(Connection conn, CorsoCorsista entity){
		
		try {
			rowSet.setCommand(SELECT_CORSOCORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateInt(1, entity.getIdCorsista());
			rowSet.updateInt(2, entity.getIdCorso());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public ArrayList<CorsoCorsista> getBYIdCorsista(Connection conn, long id) throws DAOException {
		CorsoCorsista corsoCorsista = null;
		ArrayList<CorsoCorsista> corsoCorsisti = null;
				
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSIBYIDCORSISTA);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				corsoCorsista = new CorsoCorsista();
				corsoCorsista.setIdCorsista(rs.getInt(1));
				corsoCorsista.setIdCorso(rs.getInt(2));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		return corsoCorsista;
	}
}
