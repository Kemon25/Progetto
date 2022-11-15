package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Docente;

class DocenteDAOTest {
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		try {
			conn = DBAccess.getConnection();
		} catch (ClassNotFoundException | IOException | DAOException exc) {
			System.out.println("Motivo: " + exc.getMessage());
			exc.printStackTrace();
		}
	}


	@Test
	void test() {
		try {
			Docente docente = new Docente();
			docente = DocenteDAO.getFactory().getById(conn, 4);
			assertNotNull(docente);
			
		} catch (DAOException exc) {
			System.out.println("Motivo: " + exc.getMessage());
			exc.printStackTrace();
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		DBAccess.closeConnection();
	}
}
