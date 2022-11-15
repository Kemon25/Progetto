package test.it.betacom.architecture.dbaccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;

class DBAccessTest {

	@Test
	void testConnection() {
		try {
			DBAccess.getConnection();
		} catch (DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("errore nel tentativo di apertura"+exc.getMessage());
		}finally {
			try {
				DBAccess.closeConnection();
			}catch (DAOException exc){
				exc.printStackTrace();
				fail("errore nel tentativo di chiusura"+exc.getMessage());
			}
		}
	}

}
