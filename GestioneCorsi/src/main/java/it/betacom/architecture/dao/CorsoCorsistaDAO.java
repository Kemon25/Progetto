package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;


import it.betacom.businesscomponent.model.CorsoCorsista;


public class CorsoCorsistaDAO {
	private CachedRowSet rowSet;
	
	private CorsoCorsistaDAO() throws DAOException{
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}
	
	public void create(Connection conn, CorsoCorsista entity){
		
			rowSet.setCommand(SELECT_UTENTE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, entity.getNome());
			rowSet.updateString(2, entity.getCognome());
			rowSet.updateString(3, entity.getIndirizzo());
			rowSet.updateString(4, entity.getCap());
			rowSet.updateDate(5, new java.sql.Date(entity.getNascita().getTime()));
			rowSet.updateString(6, entity.getUsername());
			rowSet.updateString(7,Algoritmo.convertiMD5(entity.getPassword()));
			rowSet.updateString(8, entity.getEmail());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
