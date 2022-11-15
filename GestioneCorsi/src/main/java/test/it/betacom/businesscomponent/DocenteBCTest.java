package test.it.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.DocenteBC;

class DocenteBCTest {
	private Connection conn;
	private DocenteBC dBC;
	
	@Test
	void testGetById() throws DAOException {
		try {
			conn = DBAccess.getConnection();
			dBC =  new DocenteBC();
			System.out.println(dBC.getById(4));
		} catch (ClassNotFoundException | DAOException | IOException exc) {
			try {
				conn.close();
			} catch (SQLException sql) {
				throw new DAOException(sql);
			}
			fail("Motivo: " + exc.getMessage());
		}
	}

}
