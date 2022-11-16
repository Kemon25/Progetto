package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsoCorsistaDAOTest {
	private static Connection conn;
	private static Corso corso;
	private static Corsista corsista;
	private static CorsoCorsista corsoCorsista;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corso();
		corso.setIdCorso(105);
		corso.setIdDocente(3);
		corso.setNomeCorso("Fisica");
		corso.setDataInizio(new GregorianCalendar(01,01,2020).getTime());
		corso.setDataFine(new GregorianCalendar(21, 01, 2020).getTime());
		corso.setCosto(1200.13);
		corso.setCommenti("commento");
		corso.setAula("C1A4");
		
		corsista = new Corsista();
		corsista.setId(107);
		corsista.setNome("Marco");
		corsista.setCognome("Rossi");
		corsista.setPrecedentiFormativi(0);
		
		
		corsoCorsista = new CorsoCorsista();
		corsoCorsista.setIdCorso(105);
		corsoCorsista.setIdCorsista(107);
	}
	
	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			CorsistaDAO.getFactory().create(conn, corsista);
			CorsoCorsistaDAO.getFactory().create(conn, corsoCorsista);
			System.out.println(corsoCorsista.toString());
		} catch (DAOException e) {
			e.printStackTrace();		
			fail("Motivo: "+ e.getMessage());
		}		
	}
	
	@Test
	@Order(2)
	void testGet() {
		ArrayList<Corso> corsi = new ArrayList<Corso>();
		int num = 0;
		try {
			corsi = CorsoCorsistaDAO.getFactory().getCorsiByIdCorsista(conn, 107);
			System.out.println();
			for (Corso corso : corsi) {
				System.out.println(corso.toString());
			}
			num = CorsoCorsistaDAO.getFactory().getNumCorsistaByIdCorso(conn, 105);
			System.out.println("Num corsisti: " + num);
		} catch (DAOException e) {
			e.printStackTrace();		
			fail("Motivo: "+ e.getMessage());
		}		
	}
	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsoDAO.getFactory().delete(conn, 105);
			CorsistaDAO.getFactory().delete(conn, 107);
			DBAccess.closeConnection();
			System.out.println("Delete done!");
		}	catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
}
