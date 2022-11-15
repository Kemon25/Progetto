package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.AdminDAO;
import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Admin;

class AdminDAOTest implements DAOConstants {

	private static Connection conn;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		
	}

	@Test
	void testGetByUsername() {
		Admin a = null;
		try {
			a = AdminDAO.getFactory().getByUsername(conn, "admin");
			System.out.println(a.toString());
		} catch (Exception exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}

	}

}
