package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaDAOTest {
	private static Corsista corsista;
	private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setId(4);
		corsista.setNome("Max");
		corsista.setCognome("Rossi");
		corsista.setPrecedentiFormativi(0);
	}
	
	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsistaDAO.getFactory().create(conn, corsista);
			System.out.println("Corsista creato");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testGetAll() {
		try {
			ArrayList<Corsista> corsisti = CorsistaDAO.getFactory().getAll(conn);
			for(Corsista c : corsisti)
				System.out.println(c);
			assertNotNull(corsisti);
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void testGetById() {
		try {
			Corsista c = CorsistaDAO.getFactory().getById(conn, 4);
			System.out.println(c.toString());
			assertNotNull(c);
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsistaDAO.getFactory().delete(conn, corsista.getId());
			System.out.println("Corsista eliminato");
			DBAccess.closeConnection();
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
}
