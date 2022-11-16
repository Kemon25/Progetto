package test.it.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.CorsoCorsistaBC;
import it.betacom.businesscomponent.model.Corso;

class CorsoCorsistaBCTest {
	private static Connection conn;
	private static CorsoCorsistaBC ccBC;
	
	@BeforeAll
	static void setUpBeforeClass() throws DAOException {
		try {
			conn = DBAccess.getConnection();
		} catch (ClassNotFoundException | DAOException | IOException exc) {
			fail("Motivo: " + exc.getMessage());
		}
	}


	@Test
	void test() {
		try {
			ccBC = new CorsoCorsistaBC();
			ArrayList<Corso> corsi = new ArrayList<>();
			corsi = ccBC.getCorsoMaxfreq();
			for(Corso corso : corsi) {
				System.out.println(corso.toString());
			}
		} catch (DAOException | IOException | ClassNotFoundException exc) {
			fail("Motivo: " + exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		conn.close();
	}
}
